
package phoneconverter;

/**
 *
 * @author Илья
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String phone1 = "89175655655";
        String phone2 = "+79175655655";
        String phone3 = "+104289652211";
        PhoneConverter obj1 = new PhoneConverter(phone3);
        System.out.println(obj1.toString());
    }
    
}
