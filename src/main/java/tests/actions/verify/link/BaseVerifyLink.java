package tests.actions.verify.link;

import tests.BaseTest;

/**
 * Abstract class for verify one link.
 */
public abstract class BaseVerifyLink extends BaseTest {
    /**
     * Id of link for check from data store.
     */
    private String id = null;

    @Override
    public final void runTest() {
        checkElement(id);
        doTest();
    }

    public abstract void doTest();

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
