package application;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ParentsNotFoundException extends Exception {
	ParentsNotFoundException(String note){
		super(note);
	}

}


