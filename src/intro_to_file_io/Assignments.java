package intro_to_file_io;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

import javax.swing.JOptionPane;

public class Assignments {
	public static void main(String[] args) {
	String s = JOptionPane.showInputDialog("Enter a message");

	try {
		encrypt(s.getBytes());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	public static void encrypt(byte[] Message) throws IOException
	{
		
		FileWriter fw = new FileWriter("src/intro_to_file_io/crypt.txt");
		String encoded = Base64.getEncoder().encodeToString(Message);
		fw.write(encoded);
		fw.close();
	}
}
