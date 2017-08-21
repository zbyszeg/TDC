import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

public class TDC
{	
	public static void main(String[] args) throws IOException
	{		
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
			JOptionPane.showMessageDialog(null, "Odczytane wiersze: "+rows+"\nZmienione segmenty: "+sopo, "Zakończono pomyślnie", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Nieprawidłowa nazwa pliku lub brak pliku w folderze. Spróbuj ponownie.", "Błąd!", JOptionPane.ERROR_MESSAGE);
		}
		
//		System.out.println("Odczytano wierszy:\t"+rows);
//		System.out.println("Zmieniono pozycji:\t"+sopo);
	}
}
