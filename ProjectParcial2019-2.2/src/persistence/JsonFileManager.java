package persistence;

import java.io.FileReader;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

public class JsonFileManager {
	
	public static Object[][] readFile(String url) {
		Object[][] allData = null;
		JsonObject jsonArrayData;
		try {
			jsonArrayData = (JsonObject) Jsoner.deserialize(new FileReader(url));
			JsonArray jsonArray = (JsonArray) jsonArrayData.get("data");
			allData = new Object[jsonArray.size()][10];
			for (int i = 0; i < jsonArray.size(); i++) {
				JsonArray jsonArray2 = (JsonArray) jsonArray.get(i);
				for (int j = 0; j < jsonArray2.size(); j++) {
					allData[i][0] = jsonArray2.get(11);
					allData[i][1] = jsonArray2.get(8);
					allData[i][2] = jsonArray2.get(9);
					allData[i][3] = jsonArray2.get(10);
					allData[i][4] = jsonArray2.get(12);
					allData[i][5] = jsonArray2.get(13);
					allData[i][6] = jsonArray2.get(15);
					allData[i][7] = jsonArray2.get(19);
					allData[i][8] = jsonArray2.get(20);
					allData[i][9] = jsonArray2.get(21);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return allData;
	}
	

}
