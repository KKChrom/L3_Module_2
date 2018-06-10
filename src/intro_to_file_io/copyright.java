package intro_to_file_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class copyright {
	public static void main(String[] args) throws IOException {
		cr();
	}

	public static void cr() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/crypt.txt"));


		String fileContents = "";
		String line = br.readLine();
		while(line != null){
			System.out.println(line);
			fileContents += line;
			line = br.readLine();
			
		}
		br.close();
		FileWriter fw = new FileWriter("src/intro_to_file_io/crypt.txt");
		
		System.out.println(fileContents);
		fw.write(  "//Copyright © 2018 by sm \n"+fileContents);
		fw.close();
	}
}
