
package calendarformer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author Илья
 */
public class CalendarFormer {
    private Calendar calendar;
    private Date date;
    
    
    /**
     * 
     * @param stringDate "year month day\nhours minutes"
     * @throws java.text.ParseException
     */
//    public CalendarFormer(String stringDate) {
//        String[] splittedDate = stringDate.split("[\\s]");
//        calendar = new GregorianCalendar(Integer.decode(splittedDate[0]), 
//            Integer.decode(splittedDate[1]), Integer.decode(splittedDate[2]));
//        calendar.set(Calendar.DAY_OF_MONTH, Integer.decode(splittedDate[2]));
//        calendar.set(Calendar.HOUR, Integer.decode(splittedDate[3]));
//        calendar.set(Calendar.MINUTE, Integer.decode(splittedDate[4]));
//    }
    public CalendarFormer(String stringDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("y MM dd\nHH mm", Locale.ENGLISH);
        date = formatter.parse(stringDate);
        calendar = new GregorianCalendar();
        calendar.setTime(date);
        
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return date.toString();
    }
    
    public String toFormatString(String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.ENGLISH);
        return formatter.format(date);
    }
    
}
