package json;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonTest1 {
	
	public static void jsonFormat(String key3) {
		JsonParser jsonPar = new JsonParser();
		JsonArray array = jsonPar.parse(key3).getAsJsonArray();
		for(JsonElement el : array) {
			System.out.println(el);
			String temp = el.toString();
			JsonParser jsonPar1 = new JsonParser();
			JsonObject jsonObj = jsonPar.parse(temp).getAsJsonObject();
			String value = jsonObj.get("age").toString();
			System.out.println(value);
		}
	}
	
	public static void main(String[] args) {
		String key = "{\"key\":\"abcd1324\"}";
		String key2 = "{\"key\":\"abcd1324\",\"name\":\"김유신\"}";
		String key3 = "[{\"key\":\"abcd1324\",\"name\":\"김유신\",\"age\":30}]";
		//System.out.println(key);
		/*
		 * 위 문자열은 json 포맷이 아니다.
		 * 왜냐하면 바깥쪽에 대괄호가 없으니까
		 * 그래서 gson으로 파싱이 안됨
		 */
		JsonParser jsonPar = new JsonParser();
		JsonObject jsonObj = jsonPar.parse(key2).getAsJsonObject();
		String value = jsonObj.get("name").toString();
		//System.out.println(value);
		
		//JsonTest1 js = new JsonTest1();
		jsonFormat(key3);
	}
}