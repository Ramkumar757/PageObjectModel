package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import BasePackage.BaseClass;

public class RegistrationPage extends BaseClass {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions act = new Actions(driver);

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	@FindBy(xpath = "//input[@id='input-newsletter']")
	WebElement btnNewsletter;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement btnAgree;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSubmit;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConformation;

	public void setFirstName(String firstName) {
		txtFirstname.sendKeys(firstName);
	}

	public void setLastName(String lastname) {
		txtLastname.sendKeys(lastname);
	}

	public void setEmail(String firstName) {
		txtEmail.sendKeys(firstName);
	}

	public void setPassword(String email) {
		txtPassword.sendKeys(email);
	}

	public void clickNewsletter() {
		try {
			act.moveToElement(btnNewsletter).click().build().perform();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", btnNewsletter);
		}
		
	}

	public void clickAgree() {
		
		try {
			act.moveToElement(btnAgree).click().build().perform();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", btnAgree);
		}
	}

	public void clickSubmit() {
		try {
			act.moveToElement(btnSubmit).click().build().perform();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", btnSubmit);
		}
		
		
	}

	public String getConformationMsg() {
		try {
			return (msgConformation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
}
