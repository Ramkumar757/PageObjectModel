package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePackage.BaseClass;

public class MyAccountPage extends BaseClass {

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement expHeadingMsg;

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccountLnk;

	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Logout']")
	WebElement lnkLogout_ele;

	public void clickLogout() {

		lnkLogout_ele.click();
	}

	public void clickAccountLnk() {

		myAccountLnk.click();
	}

	public boolean verifyMyAccount() {
		try {
			return expHeadingMsg.isDisplayed();
		} catch (Exception e) {
			return false;

		}
	}

	public boolean isMyAccountExits() {
		try {
			return expHeadingMsg.isDisplayed();
		} catch (Exception e) {
			return false;

		}

	}
}
