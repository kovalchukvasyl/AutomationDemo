package loginTests;

import basic.TestBase;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTestSuite extends TestBase{

    @Test(dependsOnMethods = {"CorrectLoginTest"})
    public void UnexistingLoginTest() {
        homePage.moveOnLoginPage();
        loginPage.enterUsername(registrationPage.getRandomMailName());
        loginPage.clickNextButton();
        Assert.assertEquals(loginPage.isLoginWrong(), true);
    }

    @Parameters({ "login" })
    @Test
    public void CorrectLoginTest(String login) {
        homePage.moveOnLoginPage();
        loginPage.enterUsername(login);
        loginPage.clickNextButton();
        Assert.assertEquals(loginPage.checkUsername(), true);
    }

}
