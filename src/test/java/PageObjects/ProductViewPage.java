package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePackage.BaseClass;

public class ProductViewPage extends BaseClass {

	public ProductViewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='col-sm']/h1") WebElement pName;
	@FindBy(xpath = "//h2/span[@class='price-new']") WebElement pPrice;
	@FindBy(xpath = "//h3[normalize-space()='Available Options']") WebElement availableOptions;
	@FindBy(xpath = "//*[@id=\"input-option-value-17\"]") WebElement chkCheckBox1;
	@FindBy(xpath = "//*[@id=\"input-option-value-18\"]") WebElement chkCheckBox2;
	@FindBy(xpath = "//input[@id='input-quantity']") WebElement pQuantity;
	@FindBy(xpath = "//button[@id='button-cart']") WebElement btn_AddToCart;
	
	public String getpName() {
		String name= pName.getText();
	return name.trim();	 
		 
	}
	public String getpPrice() {
		return pPrice.getText();
	}
	
	public void clickCheckBoxes(String chk) {
		try {
		if(availableOptions.isDisplayed()){
			if(chk.equals("chk1")) {
				chkCheckBox1.click();
			}
			else if(chk.equals("chk2")) {
				chkCheckBox2.click();
			}
		}
		}catch(Exception e) {
			System.out.println("CheckBoxes not present");
		}
	}
	public void setQauntitiy(String qty) {
		pQuantity.clear();
		pQuantity.sendKeys(qty);
		
	}
	public void clickAddToCart() {
		scrollIntoView(btn_AddToCart);
		waitWedDriver(btn_AddToCart);
	
		btn_AddToCart.click();
		
	}
}
