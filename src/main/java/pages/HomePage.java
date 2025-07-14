package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	private By selectSearchCriteriaTest = By.xpath("//h3[text() = 'Select Search Criteria']");
	private By logoutButton = By.xpath("//span[text()='Logout']");
	private By currentUserName = By.id("current-user-name");

	public WebElement getSelectSearchCriteriaTest() {
		return driver.findElement(selectSearchCriteriaTest);
	}
	
	public WebElement getCurrentUser() {
		return driver.findElement(currentUserName);
	}

	public void logout() {
		driver.findElement(currentUserName).click();
		driver.findElement(logoutButton).click();
	}

}
