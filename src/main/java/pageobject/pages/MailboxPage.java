package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageobject.pages.abstractpage.Page;


public class MailboxPage extends Page {

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Apple ID') and @role='gridcell'][1]")
    private WebElement mailFromAppleFinder;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'https://appleid.apple.com')]")
    private WebElement bodyValueFinder;

    @FindBy(how = How.XPATH, using = "//*[@id='my-home']")
    private WebElement mainPageButton;

    @FindBy(how = How.XPATH, using = "//*[@role='checkbox']")
    private WebElement checkbox;


    public MailboxPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isMainPageButtonDisplayed() {
        return mainPageButton.isDisplayed();
    }

    public void clickMainPageButton() {
        mainPageButton.click();
    }

    public void clickOnLastMailFromApple() {
        waitForElement(mailFromAppleFinder);
        mailFromAppleFinder.click();
    }

    public boolean isAppleOfficial() {
        return bodyValueFinder.isDisplayed();
    }



}