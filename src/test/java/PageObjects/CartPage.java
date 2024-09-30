package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePackage.BaseClass;

public class CartPage extends BaseClass {

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"header-cart\"]/div/ul/li/div[2]/p/a[3]") WebElement lnk_CheckOut;
	
public void clickCheckOutlnk() {
	lnk_CheckOut.click();
}
}
