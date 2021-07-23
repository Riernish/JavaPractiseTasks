
package shirt;


/**
 *
 * @author Илья
 */
public class Shirt {
    private String id;
    private String desc;
    private String color;
    private String size;
    
    public Shirt(String fullInfo) {
        if (fullInfo == null) {
            throw new NullPointerException();
        }
        String[] splittedInfo = fullInfo.split(",");
        if (splittedInfo.length != 4) {
            throw new IllegalStateException();
        }
        id    = splittedInfo[0];
        desc  = splittedInfo[1];
        color = splittedInfo[2];
        size  = splittedInfo[3];
        
    }
    
    
    public String getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "id    = " + id + "\ndesc  = " + desc + "\ncolor = " + color + "\nsize  = " + size + '\n';
    }

    
}
