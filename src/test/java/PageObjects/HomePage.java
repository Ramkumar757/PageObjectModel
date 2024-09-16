package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePackage.BaseClass;

public class HomePage extends BaseClass {

	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement myAccount_ele;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement register_ele;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement login_ele;
	
	public void clickMyAccount() {
		myAccount_ele.click();
	}
	public void clickRegisterElement() {
		register_ele.click();
	}
	public void clickLoginElement() {
		login_ele.click();
	}
}
