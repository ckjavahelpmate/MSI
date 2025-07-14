package genericlibrary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Utility class for handling dropdown elements using Selenium's Select class.
 */
public class SelectUtils {

	/**
	 * Selects an option from dropdown using visible text.
	 *
	 * @param element The dropdown WebElement.
	 * @param text    The visible text to select.
	 */
	public static void selectByVisibleText(WebElement element, String text) {
		new Select(element).selectByVisibleText(text);
	}

	/**
	 * Selects an option from dropdown using value attribute.
	 *
	 * @param element The dropdown WebElement.
	 * @param value   The value attribute of the option to select.
	 */
	public static void selectByValue(WebElement element, String value) {
		new Select(element).selectByValue(value);
	}

	/**
	 * Selects an option from dropdown using index.
	 *
	 * @param element The dropdown WebElement.
	 * @param index   The index of the option to select.
	 */
	public static void selectByIndex(WebElement element, int index) {
		new Select(element).selectByIndex(index);
	}

	/**
	 * Retrieves all selected options from a multi-select dropdown.
	 *
	 * @param element The dropdown WebElement.
	 * @return A list of selected option WebElements.
	 */
	public static List<WebElement> getAllSelectedOptions(WebElement element) {
		return new Select(element).getAllSelectedOptions();
	}

	/**
	 * Retrieves the first selected option from a dropdown.
	 *
	 * @param element The dropdown WebElement.
	 * @return The WebElement of the first selected option.
	 */
	public static WebElement getFirstSelectedOption(WebElement element) {
		return new Select(element).getFirstSelectedOption();
	}

	/**
	 * Retrieves all available options in the dropdown.
	 *
	 * @param element The dropdown WebElement.
	 * @return A list of all option WebElements.
	 */
	public static List<WebElement> getAllOptions(WebElement element) {
		return new Select(element).getOptions();
	}

	/**
	 * Deselects all selected options in a multi-select dropdown.
	 *
	 * @param element The dropdown WebElement.
	 */
	public static void deselectAll(WebElement element) {
		new Select(element).deselectAll();
	}

	/**
	 * Deselects an option using visible text.
	 *
	 * @param element The dropdown WebElement.
	 * @param text    The visible text to deselect.
	 */
	public static void deselectByVisibleText(WebElement element, String text) {
		new Select(element).deselectByVisibleText(text);
	}

	/**
	 * Deselects an option using value attribute.
	 *
	 * @param element The dropdown WebElement.
	 * @param value   The value attribute to deselect.
	 */
	public static void deselectByValue(WebElement element, String value) {
		new Select(element).deselectByValue(value);
	}

	/**
	 * Deselects an option using index.
	 *
	 * @param element The dropdown WebElement.
	 * @param index   The index of the option to deselect.
	 */
	public static void deselectByIndex(WebElement element, int index) {
		new Select(element).deselectByIndex(index);
	}

	/**
	 * Checks whether the dropdown supports multiple selections.
	 *
	 * @param element The dropdown WebElement.
	 * @return true if the dropdown supports multiple selections; otherwise false.
	 */
	public static boolean isMultiple(WebElement element) {
		return new Select(element).isMultiple();
	}
}
