package registrationTests;

import basic.TestBase;
import org.testng.annotations.Test;

public class RegistrationTestSuite extends TestBase{

    @Test
    public void TestRegistration() throws InterruptedException {
        registrationPage.goOnRegistrationPage();
        registrationPage.registrationProcedure();
    }
}
