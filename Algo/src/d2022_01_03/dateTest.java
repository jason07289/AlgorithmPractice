package d2022_01_03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.util.Date;

public class dateTest {
	public static void main(String[] args) throws ParseException {
        int yearInt = Integer.parseInt(Year.now().toString());
        yearInt++;
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-01");
        LocalDateTime ldt = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime currentDate = LocalDateTime.now();
        System.out.println(currentDate);
        System.out.println(ldt);
        if(currentDate.isBefore(ldt)) {
        	System.out.println("참");
        }
        
	}
}
