import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TDC
{	
	public static void main(String[] args) throws IOException
	{		
		String name = args[0];
		
		BufferedReader in = new BufferedReader(new FileReader(name));

			String str;

			List<String> list = new ArrayList<String>();
			
			int counter = 0;
			while((str = in.readLine()) != null)
			{
				list.add(str+"\n");
				counter++;
			}
			
			in.close();
		
		StringBuilder builder = new StringBuilder();
		
		for (String value : list)
		{
		    builder.append(value);
		}
		
		String fileBody = builder.toString();
		
		String tempFileBody = fileBody.replaceAll("creationid=\".*\"", "creationid=\"SOPOLTRAD\"");
		
		PrintWriter save = new PrintWriter(name+"_Sopoltrad.tmx");
		
		save.print(tempFileBody);
		save.close();
		
		System.out.println("Zmieniono "+counter+" linii.");
	}
}
