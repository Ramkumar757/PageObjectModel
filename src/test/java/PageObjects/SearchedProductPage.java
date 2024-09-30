package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import BasePackage.BaseClass;

public class SearchedProductPage extends BaseClass {

	public SearchedProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='col mb-3']")
	List<WebElement> productThumbs;

	public void selectSearchedProduct(String product) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int j = 1;
		for (int i = 1; i <= productThumbs.size(); i++) {
			WebElement element = driver.findElement(By.xpath("//div[@class='col mb-3'][" + i + "]"));
			scrollIntoView(element);

			String pName = driver.findElement(By.xpath("//*[@id=\"product-list\"]/div[" + i + "]/div/div[2]/div/h4/a"))
					.getText();

			if (pName.equalsIgnoreCase(product)) {
				System.out.println(pName);

				WebElement element2 = driver
						.findElement(By.xpath("//*[@id=\"product-list\"]/div[" + j + "]/div/div[1]"));

				element2.click();
			} else {
				j++;
			}

		}

	}

}
