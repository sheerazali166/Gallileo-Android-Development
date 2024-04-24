package IO_and_files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//Just reading bytes
public class FileReaders {

	public static void main(String[] args) throws Exception {
		
		FileInputStream input = null;
		FileOutputStream output = null;
		
		//Byte per Byte
		try {
			
			input = new FileInputStream("raw/listofFigures.txt");
			output = new FileOutputStream("raw/listofFigures_out.txt");
			
			int character;
			
			while ((character = input.read()) != -1) {
			
				System.out.printf("0x%02X", character);
				System.out.print("\n");
				output.write(character);
			}
			
		} finally {
			
			if (input != null) {
				
				input.close();
				
			}
			
			if (output != null) {
				
				input.close();
			}
		}
	}

}
