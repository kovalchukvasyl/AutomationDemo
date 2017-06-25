package pageobject.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

/**
 * A factory that returns a singleton of WebDriver object.
 */
public class WebDriverFactory {

	private static final String CHROME = "chrome";
	private static final String FIREFOX = "firefox";
	private static final String IE = "ie";

	private static WebDriver webDriver;
	private static DesiredCapabilities dc;

	private WebDriverFactory() {

	}

	/**
	 * Gets the single instance of WebDriverFactory.
	 *
	 * @param browser the browser set in properties
	 * @return single instance of WebDriverFactory
	 * @throws Exception the exception of invalid browser property
	 */
	public static WebDriver getInstance(String browser) throws Exception {
		if (webDriver == null) {
			if (CHROME.equals(browser)) {
				
				setChromeDriver();
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("test-type");
				// options.addArguments("--disable-extensions");
				options.addArguments("start-maximized");

				// set some options
				dc = DesiredCapabilities.chrome();
				dc.setCapability(ChromeOptions.CAPABILITY, options);

				webDriver = new ChromeDriver(dc);
				
			} else if (FIREFOX.equals(browser)) {
				setFFDriver();

				FirefoxProfile fp = new FirefoxProfile();
				dc = DesiredCapabilities.firefox();
				//dc.setCapability("marionette", false);
				dc.setCapability(FirefoxDriver.PROFILE, fp);

				webDriver = new FirefoxDriver(dc);

			} else if (IE.equals(browser)) {
				setIEDriver();
				webDriver = new InternetExplorerDriver();

			}

			else
				throw new IllegalAccessException("Invalid browser set in XML-file");
			
			webDriver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
			webDriver.manage().window().maximize();
		}

		return webDriver;
	}

	/**
	 * Kill driver instance.
	 * @throws Exception 
	 */
	public static void killDriverInstance() throws Exception {
		if (webDriver != null) {
			webDriver.quit();
			webDriver = null;
		}
	}

	/**
	 * Setup chrome driver path for specific OS.
	 *
	 * @throws Exception the exception
	 */
	private static void setChromeDriver() throws Exception {
		String osName = System.getProperty("os.name").toLowerCase();
		StringBuffer chromeBinaryPath = new StringBuffer(
				"src/main/resources/drivers/");

		if (osName.startsWith("win")) {
			chromeBinaryPath.append("chrome-win/chromedriver.exe");
		} else if (osName.startsWith("lin")) {
			chromeBinaryPath.append("chrome-lin/chromedriver");
		} else if (osName.startsWith("mac")) {
			chromeBinaryPath.append("chrome-mac/chromedriver");
		} else
			throw new Exception("Your OS is invalid for webdriver tests");

		System.setProperty("webdriver.chrome.driver",
				chromeBinaryPath.toString());
	}

	/**
	 * Setup firefox driver path for specific OS.
	 *
	 * @throws Exception the exception
	 */

	private static void setFFDriver() {
		String osName = System.getProperty("os.name").toLowerCase();
		StringBuffer firefoxBinary = new StringBuffer(
				"src/main/resources/drivers/");

		if (osName.startsWith("win")) {
			firefoxBinary.append("ff-win/geckodriver.exe");
		} else if (osName.startsWith("lin")) {
			firefoxBinary.append("ff-lin/geckodriver");
		} else if (osName.startsWith("mac")) {
			firefoxBinary.append("ff-mac/geckodriver");
		} else
			throw new IllegalStateException("Your OS is invalid for webdriver tests");

		System.setProperty("webdriver.gecko.driver",
				firefoxBinary.toString());
	}

	private static void setIEDriver() {
		StringBuffer ieBinary = new StringBuffer(
				"src/main/resources/drivers/");
		ieBinary.append("ie-driver/IEDriverServer.exe");

		System.setProperty("webdriver.ie.driver",
				ieBinary.toString());
	}
}