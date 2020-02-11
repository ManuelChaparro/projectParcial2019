package persistence;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import models.Fruit;

public class BinarianFileManager {

	public BinarianFileManager(String pathExportBinary, ArrayList<Fruit> fruitList) {
		writeFile(pathExportBinary, fruitList);
	}

	public void writeFile(String route, ArrayList<Fruit> fruitList) {

		FileOutputStream fos = null;
		DataOutputStream salida = null;
		try {
			fos = new FileOutputStream(route);
			salida = new DataOutputStream(fos);
			for (Fruit fruit : fruitList) {
				salida.writeChars(fruit.getDepartment());
				salida.writeDouble(fruit.getHectare());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (salida != null) {
					salida.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
}
