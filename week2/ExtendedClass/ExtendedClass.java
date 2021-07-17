
package week2.extendedclass;

import java.util.Objects;

/**
 *
 * @author Илья
 */
public class ExtendedClass {

    private byte b;
    private int i;
    private double d;
    private String s;

    public byte getB() {
        return b;
    }

    public int getI() {
        return i;
    }

    public double getD() {
        return d;
    }

    public String getS() {
        return s;
    }
    
    

    public ExtendedClass(byte b, int i, double d, String s) {
        this.b = b;
        this.i = i;
        this.d = d;
        this.s = s;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.b;
        hash = 67 * hash + this.i;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.d) ^ (Double.doubleToLongBits(this.d) >>> 32));
        hash = 67 * hash + Objects.hashCode(this.s);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        ExtendedClass other = (ExtendedClass) obj;
        if (this.b != other.b) {
            return false;
        }
        if (this.i != other.i) {
            return false;
        }
        if (this.d != other.d) {
            return false;
        }
        
        return this.s.equals(other.s);
    }

    @Override
    public String toString() {
        return "b=" + b + ", i=" + i + ", d=" + d + ", s=" + s ;
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ExtendedClass ext = new ExtendedClass((byte)1, 2, 3, "Chetire");
        System.out.println("ext is: " + ext.toString());
        
        ExtendedClass trap = new ExtendedClass((byte)1, 2, 3, "Chetire");
        System.out.println("trap is: " + trap.toString());
        
        System.out.println();
        System.out.println(ext == trap);
        System.out.println(ext.equals(trap));
        
    }
    
}
