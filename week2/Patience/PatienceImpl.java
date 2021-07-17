
package week2.patience;

/**
 *
 * @author Илья
 */
public class PatienceImpl implements Patience {
    
    private int heyCounter = 0;
    @Override
    public void hey() {
        if (heyCounter < HEY_MAX) {
            System.out.println("Hey there!");
            heyCounter++;
        }
        else {
            System.out.println("You can stop it now...");
        }
    }
}
