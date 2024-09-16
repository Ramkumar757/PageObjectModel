package TestCases;

import org.testng.Assert;
import org.testng.annotations.*;

import BasePackage.BaseTest;
import PageObjects.HomePage;
import PageObjects.RegistrationPage;

public class TC001_AccountRegistrationTest extends BaseTest {

	@Test(groups = {"sanity","regression","master"})
	public void verify_AccountRegistration() {
		logger.info("***Starting TC001_AccountRegistrationTest***");
		try {
			HomePage hp = new HomePage(driver);
			logger.info("clicking on the MyAccountLink");
			hp.clickMyAccount();
			logger.info("clicking on the RegisterLink Link");
			hp.clickRegisterElement();
			logger.info("Providing the Customer details to register account");
			RegistrationPage regPage = new RegistrationPage(driver);
			regPage.setFirstName(randomString());
			regPage.setLastName(randomString());
			regPage.setEmail(randomString() + "@gmail.com");
			regPage.setPassword(randomPassword());
			regPage.clickNewsletter();
			regPage.clickAgree();
			regPage.clickSubmit();
			String conformationMsg = regPage.getConformationMsg();
			logger.info("Validating the confirmation Message");
			if (conformationMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			} else {
				logger.error("confirmation msg is not correct");
				logger.debug("Debug :==>  confirmation msg is not correct");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("***Ending TC001_AccountRegistrationTest***");
	}

}
