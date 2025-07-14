package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataUtility {

	@DataProvider
	public JsonNode[] testData(Method method) {
		List<JsonNode> data = new ArrayList<JsonNode>();
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode dataNode = mapper.readTree(new File("./TestData/TestData.json")).get(method.getName());
			for (JsonNode jsonNode : dataNode) {
				if (jsonNode.get("Execute").toString().equals("true")) {
					data.add(jsonNode);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data.toArray(new JsonNode[0]);
	}

	public String getEnvironmentURL(String environmentName) {
		String url = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("./TestData/Environment.properties"));
			url = prop.getProperty(environmentName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	public String getProperty(String key) {
		String property = null;
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("./TestData/Environment.properties"));
			property = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return property;
	}

}
