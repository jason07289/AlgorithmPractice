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
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(yearInt+"-01-01");
        LocalDateTime ldt = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(ldt);
	}
}
