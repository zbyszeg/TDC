/*
 * TMX Data Converter @ Sopoltrad
 * Author: Zbigniew Góra
 * August 2017
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.commons.lang3.StringUtils;

public class TDC
{	
	public static void main(String[] args) throws IOException
	{		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		
		int rows, sopo;
		String name, file, str, fileBody, tempFileBody, location;
		
		location = args[0];
		
		name = JOptionPane.showInputDialog(null, "Wprowadź nazwę pliku (bez rozszerzenia)", "TMX Data Changer @ Sopoltrad", JOptionPane.QUESTION_MESSAGE);;
		
		if(name==null)
			System.exit(1);
		
		file = location+"\\"+name+".tmx";
		
		rows = 0;
		sopo = 0;
		
		Window Okno = new Window();
		
		try
		{
			Okno.setVisible(true);
			
			BufferedReader in = new BufferedReader(new FileReader(file));

			List<String> list = new ArrayList<String>();
			
			while((str = in.readLine()) != null)
			{
				list.add(str+"\n");
				rows++;
			}
				
			in.close();
			
			StringBuilder builder = new StringBuilder();
			
			for (String value : list)
			{
			    builder.append(value);
			}
			
			fileBody = builder.toString();
			
			tempFileBody = fileBody.replaceAll("creationid=\".*\"", "creationid=\"SOPOLTRAD\"");
			
			sopo += StringUtils.countMatches(tempFileBody, "SOPOLTRAD");
			
			PrintWriter save = new PrintWriter(name+"_Sopoltrad.tmx");
			
			save.print(tempFileBody);
			save.close();
			
			Okno.setVisible(false);

			JOptionPane.showMessageDialog(null, "Odczytane wiersze:        "+rows+"\nZmienione segmenty:   "+(sopo-1), "Zakończono pomyślnie", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(null, "Nieprawidłowa nazwa pliku lub brak pliku w folderze. Spróbuj ponownie.", "Błąd!", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

	}
}
