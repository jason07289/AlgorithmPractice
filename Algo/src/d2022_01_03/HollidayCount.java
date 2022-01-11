package d2022_01_03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class HollidayCount {
	public static void main(String[] args) throws ParseException {
		String startDate = "2022-05-04";
		String endDate = "2022-05-10";
		String[] startDateList = startDate.split("-");
		String[] endDateList = endDate.split("-");
		if(!startDateList[0].equals(endDateList[0]))
			System.out.println("exception");
		HollidayCalendar hollidayCalendar= new HollidayCalendar();
		Set<String> hollidaySet = hollidayCalendar.getHoliday(startDateList[0]);
		System.out.println(hollidaySet);
		
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = dateformat.parse(startDate);
		Date eDate = dateformat.parse(endDate);
		Calendar sCal = Calendar.getInstance();
		Calendar eCal = Calendar.getInstance();
		sCal.setTime(sDate);
		eCal.setTime(eDate);
		while(sCal.compareTo(eCal) !=1) {
			if(!hollidaySet.isEmpty()) {
				Date dateObj = sCal.getTime();//공휴일 확인을 위한 포매팅
				dateformat = new SimpleDateFormat("yyyyMMdd");
				String formattedDate = dateformat.format(dateObj);
				
				int dayOfWeek = sCal.get(Calendar.DAY_OF_WEEK);//주말 확인을 위한 포매팅
				
				if(!hollidaySet.contains(formattedDate) && dayOfWeek < 6 && dayOfWeek > 1) {
					System.out.println(dayOfWeek);
					System.out.println(formattedDate);
				}
			}
			sCal.add(Calendar.DATE, 1);
		}

		
	}
}
