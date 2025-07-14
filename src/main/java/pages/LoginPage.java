package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailTextfield = By.id("LoginName");
	private By passwrodTextfield = By.id("LoginPassword");
	private By signInButton = By.id("buttonSignIn");
	private By signIntoVIPText = By.xpath("//h3[text()='Please sign in to VIP']");

	public WebElement getSignIntoVIPText() {
		return driver.findElement(signIntoVIPText);
	}

	public void singIn(String email, String password) {
		WebElement emailElement = driver.findElement(emailTextfield);
		emailElement.clear();
		emailElement.sendKeys(email);

		WebElement pwdElement = driver.findElement(passwrodTextfield);
		pwdElement.clear();
		pwdElement.sendKeys(password);

		driver.findElement(signInButton).click();

	}

}
