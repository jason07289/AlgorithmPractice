package d2022_01_03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class dateTest {
	public static void main(String[] args) throws ParseException {
        int yearInt = Integer.parseInt(Year.now().toString());
        yearInt++;
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2023-01-01");
        LocalDateTime ldt = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime currentDate = LocalDateTime.now();
//        System.out.println(currentDate);
//        System.out.println(ldt);
        if(currentDate.isBefore(ldt)) {
        	System.out.println("참");
        }
        
        String startDate = "2022-01-03";
        
        DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = dateformat.parse(startDate);
		
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(sDate);
		Calendar nowCal = Calendar.getInstance();
		
		if(startCal.before(nowCal)) {
			System.out.println("시작날짜가 지금보다 이전");
		}
	}
}
