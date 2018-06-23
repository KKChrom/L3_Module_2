package intro_to_file_io;
import javax.swing.JOptionPane;
import javax.swing.JFrame;


import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.JButton;
public class todolist implements ActionListener{
	JButton addtask = new JButton("Add Task");
	JButton removetask = new JButton("Remove Task");
	JButton save = new JButton("Save");
	JButton load = new JButton("Load");
	List l = new List();
	FileWriter fw;
	BufferedReader br;
	public static void main(String[] args)
	{
		todolist t = new todolist();
		t.start();
	}
	public void start()
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		addtask.addActionListener(this);
		removetask.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		
		panel.add(addtask);
		panel.add(removetask);
		panel.add(save);
		panel.add(load);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}
	public void addtask()
	{
		String input = JOptionPane.showInputDialog("What is the name of the task?");
		l.add(input.toLowerCase());
		
	}
	public void removetask()
	{
		String input = JOptionPane.showInputDialog("Name the task you would like to be removed");
		l.remove(input.toLowerCase());
	}
	public void save() 
	{
		try {
		 fw = new FileWriter("src/intro_to_file_io/todolist.txt");
		 String j = "";
		 for(int i =0;i<l.getItemCount();i++)
		 {
			 j+= l.getItem(i)+"\n";
		 }
			fw.write(j);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void load() throws IOException
	{
	
			br = new BufferedReader(new FileReader("src/intro_to_file_io/todolist.txt"));
			String line = br.readLine();
			l.add(line);
			while(line != null){
				System.out.println(line);
				line = br.readLine();
				
				l.add(line);
			
			}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if(addtask.equals(buttonPressed))
		{
			addtask();
		}
		if(removetask.equals(buttonPressed))
		{
			removetask();
		}
		if(save.equals(buttonPressed))
		{
			save();
		}
		if(load.equals(buttonPressed))
		{
			try {
				load();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
	
}
