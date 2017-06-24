package homepageTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import basic.TestBase;

public class DataProviderTest extends TestBase {

	@Test(dataProvider="getUser")
	public void TestNameTextfield(String dp1) throws InterruptedException {
		homePage.searchPerform(dp1);
		Assert.assertEquals(homePage.checkPageLink(),true);
	}

	@DataProvider(parallel = false)
	public Object[][] getUser() {
		return new String[][]{{"A"},{"B"}, {"C"}, {"D"}};
	}

}
