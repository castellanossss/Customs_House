package tools;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObject {
    private FileOutputStream fos;
	private ObjectOutputStream oos;
	
	public WriteObject(String path) throws IOException {
		fos = new FileOutputStream(path);
		oos = new ObjectOutputStream(fos);
	}
	
	public void writeObject(Object object) throws IOException {
		oos.writeObject(object);
	}
	
	public void cleanUp() throws IOException {
		oos.close();
	}
}
