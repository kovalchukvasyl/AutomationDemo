package pageobject.pages.abstractpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

/*
 * Abstract class representation of a Page in the UI few additional features.
 */
public abstract class Page {
	
	protected WebDriver webDriver;
	
	/*
	 * Constructor with the WebDriver interface
	 * 
	 * @param webDriver
	 */
	
	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public String getTitle() {
		return webDriver.getTitle();
	}
	
	public String getPageUrl() {
		return webDriver.getCurrentUrl();
	}
	
	public boolean isElementPresent(WebElement element) {
        try {
        	element.isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(webDriver, 10);
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}