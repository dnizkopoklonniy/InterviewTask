package core;

import data.LinkModel;
import data.LinkWrapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Repository class for gets data from data store.
 * Data store represents in xml file.
 */
public class Repository {

    /**
     * File path for links xml data.
     */
    private static final String LINKS_FILE_PATH = "src/main/resources/links.xml";

    /**
     * Repository instance.
     */
    private static Repository repository = null;

    /**
     * List of node links for cache data.
     */
    private NodeList links;

    /**
     * Gets repository instance.
     * @return Repository instance.
     */
    public static Repository getInstance() {
        if (repository == null) {
            repository = new Repository();
        }

        return repository;
    }

    private Repository() {
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

            File file = new File(LINKS_FILE_PATH);
            Document doc = docBuilder.parse (file);

            doc.getDocumentElement().normalize();
            links = doc.getElementsByTagName(LinkModel.LINK_ROOT_NODE);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * Gets link model by id.
     * @param id Data store id.
     * @return Null if link model was not found, link model another.
     */
    public LinkModel getLinkById(String id) {
        LinkModel link = null;

        for (int i = 0; i < links.getLength(); i++) {
            Node linkNode = links.item(i);

            if (linkNode.getNodeType() == Node.ELEMENT_NODE) {
                Element linkElement = (Element) linkNode;
                String linkId = linkElement
                        .getElementsByTagName(LinkModel.LINK_NODE_ID)
                        .item(0)
                        .getTextContent();

                if (id.equals(linkId)) {
                    link = LinkWrapper.transform(linkNode);
                    break;
                }
            }
        }

        return link;
    }
}
