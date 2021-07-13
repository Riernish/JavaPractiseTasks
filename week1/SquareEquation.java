
package squareequation;

/**
 * solves an equation of the form ax^2 + bx + c = 0;
 * 
 * @see AllNumbersException, NoSolutionException
 * @author Илья
 */
public class SquareEquation {

    private double a = 0;
    private double b = 0;
    private double c = 0;
    private boolean oneSolution = false;
    
    private double x1;
    private double x2;
    
    public SquareEquation() {}

    public SquareEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    
    /**
     * solves equation bx + c = 0
     * @param b
     * @param c
     * @return x - the solution
     */
    
    private double solveLinear(double b, double c) 
            throws AllNumbersException, NoSolutionException{
        if (b == 0) {
            if (c == 0) {
                throw new AllNumbersException("Any number is a solution");
            }
            else {
                throw new NoSolutionException("No solutions");
            }
            
        }
        return -c/b;
    }
    
    private double solveThisLinear()
            throws AllNumbersException, NoSolutionException{
        return solveLinear(b, c);
    }
    
    public void solve() 
            throws AllNumbersException, NoSolutionException {
        if (a == 0) {
            x1 = solveThisLinear();
            oneSolution = true;
        }
        else {
            Discriminant object = new Discriminant(a, b, c);
            double d = object.getAnswer();
            if (Double.isNaN(d)) {
                throw new NoSolutionException("No real solutions");
            }
            if (d == 0) {
                oneSolution = true;
                x1 = -b / (2*a);
            }
            else {
                x1 = (-b + d) / (2 * a);
                x2 = (-b - d) / (2 * a);
            }
        }
    }
    
    class Discriminant {
        private double answer;
        Discriminant (double a, double b, double c) {
            double expression = b * b - a * c * 4;
            answer = Math.sqrt(expression);
        }
        double getAnswer() {
            return answer;
        }
    }

    public double getX1() {
        return x1;
    }

    public double getX2() {
        return x2;
    }
    
    
    
    @Override
    public String toString() {
        if (oneSolution) {
            return "x is: " + Double.toString(x1);
        } 
        else {
            return "x1 is: " + Double.toString(x1) 
                    +"\nx2 is: " + Double.toString(x2);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = new int[] {0, 0, 0};
        SquareEquation exp = new SquareEquation(arr[0], arr[1], arr[2]);
        String inputEquation = arr[0] + "x^2 + (" + arr[1] 
                + ")x + (" + arr[2] + ") = 0";
        System.out.println(inputEquation);
        try {
            exp.solve();
            System.out.println(exp.toString());
        }
        catch (NoSolutionException | AllNumbersException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}

class AllNumbersException extends Exception{ 
    public AllNumbersException(String message){
     
        super(message);   
    }
}

class NoSolutionException extends Exception {

    public NoSolutionException(String message) {
        super(message);
    }
    
}
