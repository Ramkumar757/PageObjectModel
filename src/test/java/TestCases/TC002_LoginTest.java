package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseTest;
import PageObjects.AccountLogoutPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import Utilities.DataProviders;

public class TC002_LoginTest extends BaseTest {

	@Test(groups = {"regression","master"})
	public void validLoginTest() {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLoginElement();

		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(properties.getProperty("email"));
		loginPage.setPassword(properties.getProperty("password"));
		loginPage.clickLogin();

		MyAccountPage accountPage = new MyAccountPage(driver);
		try {
			Assert.assertTrue(accountPage.verifyMyAccount());
		} catch (Exception e) {
			logger.error("Error Msg : My Account Header is Not Diplayed");
			logger.debug("Debug Msg : My Account Header is Not Diplayed");
			Assert.fail();
		}
		accountPage.clickAccountLnk();
		accountPage.clickLogout();
	}

	@Test(dataProvider ="LoginData" , dataProviderClass = DataProviders.class,groups = {"sanity","master"})
	public void loginDataDrivenTest(String email, String pwd, String expRes) throws InterruptedException {

		try {
			HomePage hp = new HomePage(driver);
			
			hp.clickMyAccount();
		
			hp.clickLoginElement();

			LoginPage loginPage = new LoginPage(driver);
			loginPage.setEmail(email);
			loginPage.setPassword(pwd);
			loginPage.clickLogin();

			MyAccountPage accountPage = new MyAccountPage(driver);
			AccountLogoutPage alp = new AccountLogoutPage(driver);
			boolean targetPage = accountPage.isMyAccountExits();

			if (expRes.equalsIgnoreCase("valid")) {

				if (targetPage == true) {
					accountPage.clickAccountLnk();
					accountPage.clickLogout();
					alp.clickAccountLnk();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

			} else if (expRes.equalsIgnoreCase("invalid")) {
				if (targetPage == true) {
					accountPage.clickAccountLnk();
					accountPage.clickLogout();
					alp.clickAccountLnk();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}

	}

}
