import java.util.Scanner;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CalculateAge {
	public static void main (String args[]) {
		String regex = "[A-Za-z0-9'-]+";
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a date:");
		String s = in.nextLine();
		
		final String DATE_FORMAT = "dd-MM-yyyy";
		


        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            Date convertedDate = df.parse(s);
			Calendar c = Calendar.getInstance();
		c.setTime(convertedDate);
		int bDay = c.get(Calendar.DAY_OF_MONTH);
    	int bmonth = c.get(Calendar.MONTH)+1;
    	int bYear = c.get(Calendar.YEAR);
		System.out.println(bDay+"/"+bmonth+"/"+bYear);
            //return true;
        } catch (ParseException e) {
            //return false;
			
			
			
			System.out.println("INVALID");
        }

		//String date = birthday
	}
}