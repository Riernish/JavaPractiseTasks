
package week3.personnames;

/**
 *
 * @author Илья
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String data = "Osipov";
        PersonNames obj = new PersonNames(data);
        System.out.println(obj.getFullName());
        
    }
    
}
