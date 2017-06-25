package mailboxTests;

import basic.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobject.pages.abstractpage.Page;

public class MailboxTestSuite extends TestBase {

    @Parameters({ "login", "password" })
    @Test
    public void MailCheckerTest(String login, String password) throws InterruptedException {
        homePage.moveOnLoginPage();
        loginPage.performLogin(login, password);
        homePage.moveToMailbox();
        mailboxPage.clickOnLastMailFromApple();
        Assert.assertEquals(mailboxPage.isAppleOfficial(), true);
    }

}
