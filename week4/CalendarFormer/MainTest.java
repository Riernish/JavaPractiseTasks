
package calendarformer;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Илья
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String test = "2001 09 04\n15 01";
        
        try {
            CalendarFormer obj = new CalendarFormer(test);
            System.out.println(obj.getCalendar());
        } catch (ParseException ex) {
            Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
