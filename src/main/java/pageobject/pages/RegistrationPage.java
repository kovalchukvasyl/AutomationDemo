package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageobject.pages.abstractpage.Page;

import java.util.Date;


public class RegistrationPage extends Page{

    @FindBy(how = How.XPATH, using = "//select[@id='usernamereg-month']//*[@value='9']")
    private WebElement chooseSeptemberFromDropdown;

    @FindBy(how = How.XPATH, using = "//*[@name='firstName']")
    private WebElement firstnameRegistration;

    @FindBy(how = How.XPATH, using = "//*[@name='lastName']")
    private WebElement lastnameRegistration;

    @FindBy(how = How.XPATH, using = "//*[@name='yid']")
    private WebElement idRegistration;

    @FindBy(how = How.XPATH, using = "//*[@name='password']")
    private WebElement passwordField;

    @FindBy(how = How.XPATH, using = "//*[@name='phone']")
    private WebElement mobileNumber;

    @FindBy(how = How.XPATH, using = "//*[@name='dd']")
    private WebElement dayOfBirthField;

    @FindBy(how = How.XPATH, using = "//*[@name='yyyy']")
    private WebElement yearOfBirthField;

    @FindBy(how = How.XPATH, using = "//*[@id='reg-submit-button']")
    private WebElement continueButton;

    @FindBy(how = How.XPATH, using = "//*[@name='sendCode']")
    private WebElement sendcodeButton;

    @FindBy(how = How.XPATH, using = "//*[@class='oneid-error-message']")
    private WebElement validatorError;




    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getRandomMailName() {
        Date dataAsName = new Date();
        Long dateValue = dataAsName.getTime();
        return "A" + dateValue.toString();
    }

    public void chooseMonth() {
        chooseSeptemberFromDropdown.click();
    }

    public void goOnRegistrationPage() {
        webDriver.get("https://login.yahoo.com/account/create");
    }

    public boolean isValidatorAppear() {
        return validatorError.isDisplayed();
    }

    public void wrongRegistrationProcedure() {
        firstnameRegistration.sendKeys("Vasyl");
        lastnameRegistration.sendKeys("Kovalchuk");
        idRegistration.sendKeys(getRandomMailName());
        passwordField.sendKeys("Emisare1996");
        continueButton.click();

    }

    public void registrationProcedure() {
        firstnameRegistration.sendKeys("Vasyl");
        lastnameRegistration.sendKeys("Kovalchuk");
        idRegistration.sendKeys(getRandomMailName());
        passwordField.sendKeys("Emisare1996");
        mobileNumber.sendKeys("0931249224");
        chooseMonth();
        dayOfBirthField.sendKeys("7");
        yearOfBirthField.sendKeys("1996");
        continueButton.click();
        waitForElement(sendcodeButton);
        sendcodeButton.click();
    }

}
