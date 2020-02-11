package persistence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import models.Fruit;

public class JsonFileManager {
	
	public JsonFileManager() {
	}

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

	public void writeFilehectares(String path, ArrayList<Fruit> Fruits) {
		try {
			File file = new File(path);
			file.createNewFile();
			FileWriter fileWriter = new FileWriter(file);
			JsonArray fruitsArray = new JsonArray();
			JsonObject jsonObjectFruits = new JsonObject();
			JsonObject jsonObjectFruitsContent = new JsonObject();
			for (Fruit fruit : Fruits) {
				JsonObject jsonObjectFruit = new JsonObject();
				jsonObjectFruit.put("Town", fruit.getTown());
				jsonObjectFruit.put("Heactares", fruit.getHectare());
				fruitsArray.add(jsonObjectFruit);
			}
			jsonObjectFruits.put("Frutas", fruitsArray);
			jsonObjectFruitsContent.put("fruits_content", jsonObjectFruits);
			fileWriter.write(jsonObjectFruitsContent.toJson());
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


}
