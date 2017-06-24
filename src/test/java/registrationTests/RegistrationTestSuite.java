package registrationTests;

import basic.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTestSuite extends TestBase{

    @Test(priority = 1)
    public void TestRegistrationValidators() throws InterruptedException {
        registrationPage.goOnRegistrationPage();
        registrationPage.wrongRegistrationProcedure();
        Assert.assertEquals(registrationPage.isValidatorAppear(), true);
    }

    @Test(priority = 2)
    public void TestRegistration() throws InterruptedException {
        registrationPage.goOnRegistrationPage();
        registrationPage.registrationProcedure();
    }
}
