import java.io.FileWriter;
import java.io.IOException;

public class AppendTextFile {
	public static void main(String args[]) {
		try
			{
				String filename= "MyFile.txt";
				FileWriter fw = new FileWriter(filename,true); //the true will append the new data
				fw.write("add a line");//appends the string to the file
				fw.close();
			}
			catch(IOException ioe)
			{
				System.err.println("IOException: " + ioe.getMessage());
			}
	}
}