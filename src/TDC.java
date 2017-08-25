/*
 * TMX Data Converter
 * Autor: Zbigniew Góra
 * sierpień 2017
 * 
 * Program usuwa właściwości klienta/tłumacza z plików TMX
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
            // Set cross-platform Java L&F (also called "Metal")
        UIManager.setLookAndFeel(
        		"com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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

//		SwingUtilities.updateComponentTreeUI(this);
		
		int rows, sopo;
		String name, file, str, fileBody, tempFileBody;
		
		file = args[0];
		name = file+".tmx";
		
		rows = 0;
		sopo = 0;
		
		try {
			
			BufferedReader in = new BufferedReader(new FileReader(name));

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
			
			PrintWriter save = new PrintWriter(file+"_Sopoltrad.tmx");
			
			save.print(tempFileBody);
			save.close();
			JOptionPane.showMessageDialog(null, "Odczytane wiersze:        "+rows+"\nZmienione segmenty:   "+(sopo-1), "Zakończono pomyślnie", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Nieprawidłowa nazwa pliku lub brak pliku w folderze. Spróbuj ponownie.", "Błąd!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
