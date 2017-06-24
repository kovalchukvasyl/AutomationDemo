package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageobject.pages.HomePage;
import pageobject.pages.LoginPage;
import pageobject.pages.MailboxPage;
import pageobject.pages.RegistrationPage;
import pageobject.webdriver.WebDriverFactory;

public class TestBase {

	private WebDriver webDriver;
	
	protected HomePage homePage;
	protected LoginPage loginPage;
	protected MailboxPage mailboxPage;
	protected RegistrationPage registrationPage;

	@BeforeMethod
	@Parameters({ "browserName" })
	public void setup(String browserName) throws Exception {
		webDriver = WebDriverFactory.getInstance(browserName);
		webDriver.get("https://www.yahoo.com");
		homePage = PageFactory.initElements(webDriver, HomePage.class);
		loginPage = PageFactory.initElements(webDriver, LoginPage.class);
		mailboxPage = PageFactory.initElements(webDriver, MailboxPage.class);
		registrationPage = PageFactory.initElements(webDriver, RegistrationPage.class);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		if (webDriver != null) {
			WebDriverFactory.killDriverInstance();
		}
	}

}