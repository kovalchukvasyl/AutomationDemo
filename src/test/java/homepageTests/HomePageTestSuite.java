package homepageTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import basic.TestBase;

public class HomePageTestSuite extends TestBase {

	@Test
	public void TestLogoPresence() {
		Assert.assertEquals(homePage.isLogoDisplayed(), true);
	}

}
