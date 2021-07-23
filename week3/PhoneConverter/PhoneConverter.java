
package phoneconverter;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Илья
 */
public class PhoneConverter {
    private String countryId;
    private String firstTriple;
    private String secondTriple;
    private String lastQuadro;
    private final String PATTERN_ONE = 
            "\\+([0-9]+)([0-9]{10})";
    private final String PATTERN_TWO = 
            "8[0-9]{10}";
    
    public PhoneConverter(String phone) {
        Pattern p1 = Pattern.compile(PATTERN_ONE);
        Matcher m1 = p1.matcher(phone);
        
        if (m1.find()) {
            converterFirst(phone);
        }
        else {
            Pattern p2 = Pattern.compile(PATTERN_TWO);
            Matcher m2 = p2.matcher(phone);
            if (m2.find()) {
                converterSecond(phone);
            }
            else {
                throw new NoSuchElementException();
            }
        }
        
    }
    
    private void converterFirst(String phone) {
        Pattern p1 = Pattern.compile(PATTERN_ONE);
        Matcher m1 = p1.matcher(phone);
        m1.find();
        countryId = m1.group(1);
        String digits = m1.group(2);
        firstTriple  = digits.substring(0, 3);
        secondTriple = digits.substring(3, 6);
        lastQuadro   = digits.substring(6, 10);
    }
    private void converterSecond(String phone) {
        Pattern p2 = Pattern.compile(PATTERN_TWO);
        Matcher m2 = p2.matcher(phone);
        m2.find();
        countryId = "7";
        
        String digits = m2.group();
        firstTriple  = digits.substring(0, 3);
        secondTriple = digits.substring(3, 6);
        lastQuadro   = digits.substring(6, 10);
        
    }

    @Override
    public String toString() {
        return "+" + countryId + firstTriple + "-" + secondTriple + "-" + lastQuadro;
    }
    
}
