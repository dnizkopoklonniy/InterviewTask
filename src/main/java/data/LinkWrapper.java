package data;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Wrapped Node to LinkModel.
 */
public class LinkWrapper {

    /**
     * Transformed Node to LinkModel.
     * @param node Node.
     * @return LinkModel.
     */
    public static LinkModel transform(Node node) {
        Element linkElement = (Element) node;
        LinkModel link = new LinkModel();

        String id = linkElement
                .getElementsByTagName(LinkModel.LINK_NODE_ID)
                .item(0)
                .getTextContent();

        String path = linkElement
                .getElementsByTagName(LinkModel.LINK_NODE_PATH)
                .item(0)
                .getTextContent();

        String name = linkElement
                .getElementsByTagName(LinkModel.LINK_NODE_NAME)
                .item(0)
                .getTextContent();

        link.setId(id);
        link.setXpath(path);
        link.setText(name);

        return link;
    }
}
