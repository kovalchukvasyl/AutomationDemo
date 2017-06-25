package registrationTests;

import basic.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RegistrationTestSuite extends TestBase implements IRetryAnalyzer{

    private int retryCount = 0;
    private int maxRetryCount = 2;

    public boolean retry(ITestResult result) {

        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    @Test(priority = 1, retryAnalyzer = RegistrationTestSuite.class)
    public void TestRegistrationValidators() throws InterruptedException {
        homePage.goOnRegistrationPage();
        registrationPage.wrongRegistrationProcedure();
        Assert.assertEquals(registrationPage.isValidatorAppear(), true);
    }

 //   @Test(priority = 2, retryAnalyzer = RegistrationTestSuite.class)
 //   public void TestRegistration() throws InterruptedException {
 //       homePage.goOnRegistrationPage();
 //      registrationPage.registrationProcedure();
 //   }

}
