package helpers;

import java.util.ArrayList;

public class jsonHelper {
	public static String toJsonArray(String ArrayLabel, String content) {
		//Removes last comma
		String lastCharacter = content
				.substring(content.length() - 1);
		if (lastCharacter == ",") {
			content = content
				.substring(0, content.lastIndexOf(","));
		}
		
		String pattern = "\"%s\": [ %s ]";
		String returnString = String.format(
				pattern, 
				ArrayLabel, 
				content);

		return returnString;
	}
	
	
	public static String toJsonObject(ArrayList<keyvaluepair> content) {
		String jsonString = "";
		String itemPattern = "\"%s\": [ %s ]";
		for (keyvaluepair item : content) {
			jsonString += String.format(itemPattern, item.key, item.value);
		}
		if (jsonString.contains(",")) {
			int commaPosition = jsonString.lastIndexOf(",");
			jsonString = jsonString.substring(0, commaPosition);			
		}
		
		String objectPattern = "{ %s }";
		return String.format(objectPattern, jsonString);
	}
	
	public static String toJsonObjectFromStrings(ArrayList<String> content) {
		String jsonString = "";
		for (String item : content) {
			jsonString += item + ",";
		}
		
		jsonString = jsonString.substring(0, jsonString.lastIndexOf(","));
		
		String objectPattern = "{ %s }";
		return String.format(objectPattern, jsonString);
	}
	
	public static String toJsonDocument(String content) {
		return "{ " + content + " }";
	}
}