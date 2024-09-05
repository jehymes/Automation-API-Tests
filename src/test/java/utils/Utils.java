package utils;

import java.util.regex.Pattern;

import io.restassured.response.Response;

public class Utils {

	public static String[] responseToArrayIds(Response response) {
		String obj = response.jsonPath().getString("id");
		obj = obj.replace('[', ' ');
		obj = obj.replace("]", " ");
		obj = obj.trim();
		String[] ids = obj.split(Pattern.quote(","));
		return ids;
	}
	
}
