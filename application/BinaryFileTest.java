package application;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileTest {

	public static void main(String[] args) {
		File fofo = new File("out.dat");
		// TODO Auto-generated method 
		try {
			FileOutputStream fos = new FileOutputStream(fofo);
			DataOutputStream dos = new DataOutputStream(fos);
			dos.write(2003);
			dos.writeDouble(200);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
