
package wordsanalyzer;

/**
 *
 * @author Илья
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String data1 = "first string to be tested there";
        String data2 = "second(other) string";
        
        WordsAnalyzer obj = new WordsAnalyzer(data1, data2);
        obj.printIntersection(System.out, WordsAnalyzer.DEFAULT_ORDER);
        obj.printIntersection(System.out, WordsAnalyzer.REVERSED_ORDER);
        obj.setN(27);
        obj.printIntersection(System.out, WordsAnalyzer.HASH_ORDER);
        
        obj.printDiff(System.out, 0);
        obj.printSum(System.out, 0);
    }
    
}
