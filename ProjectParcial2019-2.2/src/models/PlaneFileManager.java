package models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.Fruit;

public class PlaneFileManager {

	File f;
	FileWriter fw;
	FileReader fr;
	BufferedWriter bw = null;
	BufferedReader br = null;
	
	public PlaneFileManager(String nameFile, ArrayList<Fruit> fruitList) {
		f = new File(nameFile);
		writeFileFruits(fruitList);
	}
	
	
	
public void open(char modo)	{
	try {
		if (modo=='w'){
		 fw = new FileWriter(f);
		 bw = new BufferedWriter(fw);
		}
		else{
		  fr = new FileReader(f);
		  br = new BufferedReader(fr);
		}
	} catch (IOException e) {
		e.printStackTrace();
	}	
}

	public void record(String cad){
		if (bw!=null){
			try {
				bw.write(cad);
				bw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
 }
	 public String read(){		  
		 String cad="";	
			try {
				cad= br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return cad;
	   }
	 public void close(){
			try {
				 if (br!=null)
				    br.close();
				 if (bw!=null)
					bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 }
	 
	 public void writeFileFruits(ArrayList<Fruit> fruitList) {
		 open('w');
		 for (Fruit fruit : fruitList) {
			String toRecord = "all Fruits"+"; "+fruit.getTown()+"; "+fruit.getHectare();
			record(toRecord);
		}
		 close();
	 }
	 

}

