package genericlibrary;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * Utility class for capturing and saving screenshots using Selenium WebDriver.
 */
public class ScreenshotUtil extends BaseTest {

	private static final String SCREENSHOT_DIR = "./Screenshots/";

	/**
	 * Clears all screenshots from previous executions.
	 *
	 * @throws IOException If there's an error deleting files.
	 */
	public static void clearOldScreenshots() {
		DirectoryStream<Path> stream = null;
		try {
			Path dir = Paths.get(SCREENSHOT_DIR);
			if (Files.exists(dir)) {
				stream = Files.newDirectoryStream(dir);
				for (Path file : stream) {
					Files.delete(file);
				}

			} else {
				Files.createDirectories(dir);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			  try {
			        if (stream != null) {
			            stream.close();
			        }
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
		}

	}	

	/**
	 * Captures a screenshot of the current browser window and saves it with a
	 * timestamped filename.
	 *
	 * @param driver         WebDriver instance from which to capture the
	 *                       screenshot.
	 * @param screenshotName Base name for the screenshot file.
	 * @return The path to the saved screenshot file.
	 * @throws IOException If there is an error saving the screenshot.
	 */
	public static String takeScreenshot(String testCaseName) {
		String fileName = null;
		try {
			// Create screenshots directory if it doesn't exist
			Files.createDirectories(Paths.get(SCREENSHOT_DIR));

			// Format filename with timestamp
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			fileName = SCREENSHOT_DIR + testCaseName + "_" + timestamp + ".png";

			// Take screenshot and save it
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destination = new File(fileName);
			Files.copy(screenshot.toPath(), destination.toPath());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileName;
	}
}
