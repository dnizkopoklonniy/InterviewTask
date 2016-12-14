package tests;

import core.Browser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import tests.actions.EnterInvalidEmail;
import tests.actions.EnterSearchText;
import tests.actions.click.*;
import tests.actions.verify.*;
import tests.actions.verify.link.VerifyStudentsActiveLink;
import tests.actions.verify.section.VerifyHomePageResourcesSubHeader;
import tests.actions.verify.section.VerifyHomePageTopNavMenu;
import tests.actions.verify.section.VerifyStudentsPageResourcesFor;
import tests.actions.verify.url.VerifyStudentsUrl;
import tests.page.OpenHomePage;

/**
 * Interview test task.
 */
public class InterviewTest {

    /**
     * Error alert message for empty email address.
     */
    private static final String EMPTY_EMAIL_ADDRESS_ERROR_MESSAGE = "Please enter email address";

    /**
     * Error alert message for invalid email address
     */
    private static final String INVALID_EMAIL_ADDRESS_ERROR_MESSAGE = "Invalid email address.";

    @Test
    private void doTest() {
        new OpenHomePage().runTest();
        new VerifyHomePageTopNavMenu().runTest();
        new VerifyHomePageResourcesSubHeader().runTest();

        new ClickOnStudentsLink().runTest();
        new VerifyStudentsUrl().runTest();
        new VerifyStudentsHeader().runTest();
        new VerifyResourcesForOnLeft().runTest();
        new VerifyStudentsPageResourcesFor().runTest();
        new VerifyStudentsActiveLink().runTest();
        new ClickOnActiveStudentsLink().runTest();

        new ClickOnHomeTab().runTest();
        new ClickOnReceiveWileyArrowButton().runTest();
        new VerifyAlertBodyMessage(EMPTY_EMAIL_ADDRESS_ERROR_MESSAGE).runTest();

        new EnterInvalidEmail().runTest();
        new ClickOnReceiveWileyArrowButton().runTest();
        new VerifyAlertBodyMessage(INVALID_EMAIL_ADDRESS_ERROR_MESSAGE).runTest();

        new EnterSearchText().runTest();
        new ClickOnSearchIcon().runTest();
        new VerifySearchResultAppeared().runTest();

        new ClickOnHomeTab().runTest();
        new ClickOnInstitutionsLink().runTest();
        new VerifyInstitutionsWindow().runTest();
    }

    @AfterClass
    public void doAfterTest() {
        Browser.close();
    }
}
