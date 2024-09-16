package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePackage.BaseClass;

public class AccountLogoutPage extends BaseClass{

	public AccountLogoutPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath = "//a[@class='btn btn-primary']") WebElement btnContinue;

	public void clickAccountLnk() {

		btnContinue.click();
	}
}
