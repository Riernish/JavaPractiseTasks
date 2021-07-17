
package week2.voice;

/**
 *
 * @author Илья
 */
public interface Voice {

    String voice();
    
}

class Cat implements Voice {
    
    @Override
    public String voice() {
        return "Meow";
    }
}

class Cow implements Voice {
    
    @Override
    public String voice() {
        return "Moo-moo";
    }
}

class Dog implements Voice {
    
    @Override
    public String voice() {
        return "Woof";
    }
}

