package intro_to_file_io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class decrypt {
	public static void main(String[] args) throws IOException {
		enc();
	}

	public static void enc() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/crypt.txt"));

		String e = "";
		String s = br.readLine();

		FileWriter fw = new FileWriter("src/intro_to_file_io/crypt.txt");
		for (int i = 0; i < s.length(); i++) {
			e += (char) (s.charAt(i) - 3);

		}
		System.out.println(e);
		fw.write(e);
		fw.close();
	}
}
