package uke9.iostreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


/*
 * En av flere måter en kan lagre til fil -  denne utnytter grensesnittet Serializable
 * Tilsvarer Python sin pickle
 */
public class Dyrehage implements Serializable{

	private static final long serialVersionUID = 1L;

	private Collection<Dyr> dyr = new ArrayList<>();
	
	public void leggTil(Dyr dyr) {
		this.dyr.add(dyr);
	}
	
	@Override
	public String toString() {
		String tmp = "";
		for (Dyr dyr2 : dyr) {
			tmp += dyr2 + "\n";
		}
		return tmp;
	}
	
	public void readObjectFromFile(String filepath) {

		try (
			FileInputStream fileIn = new FileInputStream(filepath);
			ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

			Object obj = objectIn.readObject();
			System.out.println("The Object has been read from the file");
			this.dyr = (Collection<Dyr>) obj;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void writeObjectToFile(Object serObj) {

		try {
			FileOutputStream fileOut = new FileOutputStream("C:/temp/dyrehage.binary");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(serObj);
			objectOut.close();
			System.out.println("Alle dyrene lagret til fil!");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Dyrehage dh = new Dyrehage();
		dh.leggTil(new Dyr("Ku", "mø", 4));
		dh.leggTil(new Dyr("Katt", "mjau", 4));
		dh.leggTil(new Dyr("Flaggermus", "pip", 2));
		System.out.println(dh);
		dh.writeObjectToFile(dh.dyr);
		Dyrehage dhFraFil = new Dyrehage();
		dhFraFil.readObjectFromFile("C:/temp/dyrehage.binary");
		System.out.println(dhFraFil);
	}
	
}
