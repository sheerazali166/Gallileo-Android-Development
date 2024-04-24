package IO_and_files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

//Search for Tokens, delimited
public class ScannerFile {

	
	public static void main(String[] args) throws Exception{
		
		Scanner input = null;
		
		//Token per Token
		try {
			
			input = new Scanner(new BufferedReader(new FileReader("raw/listofFigures.txt")));
		
			while(input.hasNext()) {
				
				System.out.println(" > " + input.hasNext() + "\n");
				
			}
		
		} finally {
			
			if (input != null) {
				
				input.close();
			}
		}
		
		
	}
}
