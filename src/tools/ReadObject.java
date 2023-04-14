package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import model.Movement;

public class ReadObject {
    private FileInputStream fis;
	private ObjectInputStream ois;
	
	public ReadObject(File file) throws IOException {
		fis = new FileInputStream(file);
		ois = new ObjectInputStream(fis);
	}
	
	public Object readObject() throws ClassNotFoundException, IOException {
		return ois.readObject();
	}
	
	public void cleanUp() throws IOException {
		ois.close();
	}

	/*public static void main(String[] args) throws IOException, ClassNotFoundException {
		ReadObject readObject = new ReadObject(new File("data/Movements1.trade"));
		Movement movement = (Movement) readObject.readObject();
		System.out.println(movement.toString());
	
	}*/
}

