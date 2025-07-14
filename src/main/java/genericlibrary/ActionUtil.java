package genericlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Utility class to perform common user interactions using Selenium's Actions
 * class.
 */
public class ActionUtil {
	private final Actions actions;

	/**
	 * Constructor to initialize ActionUtil with WebDriver instance.
	 *
	 * @param driver the WebDriver instance to be used for performing actions
	 */
	public ActionUtil(WebDriver driver) {
		this.actions = new Actions(driver);
	}

	/**
	 * Performs mouse hover over the specified element.
	 *
	 * @param element the target WebElement to hover over
	 */
	public void hoverOverElement(WebElement element) {
		actions.moveToElement(element).perform();
	}

	/**
	 * Performs right-click (context click) on the specified element.
	 *
	 * @param element the target WebElement to right-click
	 */
	public void rightClick(WebElement element) {
		actions.contextClick(element).perform();
	}

	/**
	 * Performs double-click on the specified element.
	 *
	 * @param element the target WebElement to double-click
	 */
	public void doubleClick(WebElement element) {
		actions.doubleClick(element).perform();
	}

	/**
	 * Drags an element from the source and drops it to the target element.
	 *
	 * @param source the WebElement to drag
	 * @param target the WebElement to drop onto
	 */
	public void dragAndDrop(WebElement source, WebElement target) {
		actions.dragAndDrop(source, target).perform();
	}

	/**
	 * Clicks and holds the specified element.
	 *
	 * @param element the WebElement to click and hold
	 */
	public void clickAndHold(WebElement element) {
		actions.clickAndHold(element).perform();
	}

	/**
	 * Releases the mouse from the specified element.
	 *
	 * @param element the WebElement to release from
	 */
	public void release(WebElement element) {
		actions.release(element).perform();
	}

	/**
	 * Sends keyboard keys to the specified element.
	 *
	 * @param element the target WebElement
	 * @param keys    the CharSequence of keys to send
	 */
	public void sendKeys(WebElement element, CharSequence keys) {
		actions.sendKeys(element, keys).perform();
	}
}
