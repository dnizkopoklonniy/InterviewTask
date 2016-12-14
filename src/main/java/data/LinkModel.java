package data;

/**
 * Model for link.
 */
public class LinkModel {

    /**
     * Root node name for link.
     */
    public static final String LINK_ROOT_NODE = "Link";

    /**
     * Id node for link.
     */
    public static final String LINK_NODE_ID = "Id";

    /**
     * Path node for link.
     */
    public static final String LINK_NODE_PATH = "Path";

    /**
     * Name node for link.
     */
    public static final String LINK_NODE_NAME = "Name";

    /**
     * Id of link for data store.
     */
    private String id;

    /**
     * XPath of link.
     */
    private String xpath;

    /**
     * Text of link.
     */
    private String text;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public String getXpath() {
        return xpath;
    }
}
