
package week3.personnames;

import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Илья
 */
public class PersonNames {
    private String firstName;
    private String lastName;
    private String middleName;
    private final String NAME_PATTERN = 
            "([A-Z][a-z]*[a-z\\.]){1}([\\s]{1}([A-Z][a-z]*[a-z\\.])?)?([\\s]{1}([A-Z][a-z]*[a-z\\.])?)?";
    
    public PersonNames() {}
    
    public PersonNames(String fullName) {
        if (fullName == null) {
            throw new IllegalStateException();
        }
        Pattern p = Pattern.compile(NAME_PATTERN);
        Matcher m = p.matcher(fullName);
        if (m.find()) {
            firstName = m.group(1);
            
            //no magic, just bad regex
            if (m.group(5) != null) {
                lastName = m.group(5);
                middleName = m.group(3);
            }
            else {
                lastName = m.group(3);
                
            }
            
        }
        else {
            throw new NoSuchElementException();
        }
    }
    
    public String getFullName() {
        
        if (middleName == null) {
            return lastName == null ? firstName : firstName + ' ' + lastName;
        } 
        else {
            return firstName + ' ' + middleName + ' ' + lastName;
        }
    }
    

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    
    
}
