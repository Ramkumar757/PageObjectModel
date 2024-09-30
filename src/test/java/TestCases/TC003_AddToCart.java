package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BasePackage.BaseTest;
import PageObjects.CartPage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ProductViewPage;
import PageObjects.SearchedProductPage;

public class TC003_AddToCart extends BaseTest{
	@Test(groups = {"sanity","regression"})
	public void addToCart() {
		HomePage hp = new HomePage(driver);
		
		   hp.clickMyAccount();
		  hp.clickLoginElement();
		  hp.closeMyAccountTab();
		
		  
		  LoginPage loginPage = new LoginPage(driver);
		  loginPage.setEmail(properties.getProperty("email"));
		  loginPage.setPassword(properties.getProperty("password"));
		  loginPage.clickLogin();
		 
		 
		  HomePage hp1 = new HomePage(driver);
		hp1.txtSearchBox("mac");
		hp1.clickBtnSearch();
		
		SearchedProductPage productPage = new SearchedProductPage(driver);
		productPage.selectSearchedProduct("MacBook Air");
		
		
		ProductViewPage productViewPage = new ProductViewPage(driver);
		String getpName = productViewPage.getpName();
		Assert.assertEquals(getpName, "MacBook Air");
		productViewPage.clickCheckBoxes("chk2");
		productViewPage.setQauntitiy("2");
		productViewPage.clickAddToCart();
		
		
		
		CartPage cartPage = new CartPage(driver);
		cartPage.clickCheckOutlnk();
	}

}
