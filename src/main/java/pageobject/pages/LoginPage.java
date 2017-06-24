package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageobject.pages.abstractpage.Page;

public class LoginPage extends Page {

    @FindBy(how = How.XPATH, using = ".//*[@id='uh-signin']")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@name='username']")
    private WebElement usernameTextfield;

    @FindBy(how = How.XPATH, using = "//*[@name='signin']")
    private WebElement goToPasswordButton;

    @FindBy(how = How.XPATH, using = "//*[@class='username']")
    private WebElement greetingText;

    @FindBy(how = How.XPATH, using = "//*[@name='password']")
    private WebElement passwordTextfield;

    @FindBy(how = How.XPATH, using = "//*[@name='verifyPassword']")
    private WebElement verifyPasswordButton;

    @FindBy(how = How.XPATH, using = "//*[@id='username-error']")
    private WebElement wrongUsernameMessage;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterUsername(String username) {
        usernameTextfield.clear();
        usernameTextfield.sendKeys(username);
    }

    public void clickNextButton() {
        goToPasswordButton.click();
    }

    public void enterPassword(String password) {
        passwordTextfield.clear();
        passwordTextfield.sendKeys(password);
    }

    public boolean checkUsername() {
       return isElementPresent(greetingText);
    }

    public void performLogin(String username, String password) {
        enterUsername(username);
        clickNextButton();
        waitForElement(passwordTextfield);
        enterPassword(password);
        verifyPasswordButton.click();
    }

    public boolean isLoginWrong() {
        waitForElement(goToPasswordButton);
        return wrongUsernameMessage.isDisplayed();
    }
}