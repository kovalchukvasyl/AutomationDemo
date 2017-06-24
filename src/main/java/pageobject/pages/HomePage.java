package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pageobject.pages.abstractpage.Page;

import static java.lang.Thread.sleep;

public class HomePage extends Page {

	@FindBy(how = How.XPATH, using = ".//*[@id='uh-signin']")
	private WebElement loginButton;

	@FindBy(how = How.XPATH, using = "//*[@id='uh-logo']")
	private WebElement logo;

	@FindBy(how = How.XPATH, using = "//*[@href='https://www.yahoo.com/']")
	private WebElement homeLink;

	@FindBy(how = How.XPATH, using = "//*[@id='uh-mail-link']")
	private WebElement mailboxLink;

	@FindBy(how = How.XPATH, using = "//*[@id='uh-search-box']")
	private WebElement searchBoxField;

	@FindBy(how = How.XPATH, using = "//*[@id='uh-search-button']")
	private WebElement searchButton;


	public HomePage(WebDriver webDriver) {
		super(webDriver);
	}

	public void moveOnLoginPage() {
		loginButton.click();
	}

	public void moveToMailbox() {
		waitForElement(mailboxLink);
		mailboxLink.click();
	}

	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}

	public boolean isHomeLinkPresent() {
		return isElementPresent(homeLink);
	}

	public void searchPerform(String searchText) throws InterruptedException {
		waitForElement(logo);
		searchBoxField.clear();
		searchBoxField.sendKeys(searchText);
		searchButton.click();
		sleep(3000);
	}

	public boolean checkPageLink() {
		return getPageUrl().contains("search.yahoo.com");
	}




}