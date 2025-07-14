package utilities;

import java.util.Base64;

public class TestCredentials {

	private static DataUtility dataUtility = new DataUtility();

	public static String uwUsername() {
		return dataUtility.getProperty("UWUsername");
	}
	public static String uwPassword() {
		return decode(dataUtility.getProperty("UWPassword"));
	}

	public static String decode(String text) {
		return new String(Base64.getDecoder().decode(text));
	}
}
