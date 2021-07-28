
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
    
}
