
package week2.voice;

/**
 *
 * @author Илья
 */
public class VoiceTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();
        System.out.println("Cat says: " + cat.voice());
        System.out.println("Dog says: " + dog.voice());
        System.out.println("Cow says: " + cow.voice());
    }
    
}
