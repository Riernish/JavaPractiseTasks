
package wordsanalyzer;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 *
 * @author Илья
 */
public class WordsAnalyzer {
    private String firstString;
    private String secondString;
    private HashMap <String, Integer> firstWords;
    private HashMap <String, Integer> secondWords;
    private HashMap <Character, Integer> firstChars;
    private HashMap <Character, Integer> secondChars;
    private int n;   
    
    private final String SEPARATORS_PATTERN = 
            "[\\.,:;-]?[\\s]+";
    
    public WordsAnalyzer(String firstString, String secondString) {
        this.firstString = firstString;
        this.secondString = secondString;
    }

    public WordsAnalyzer(String firstString) {
        this.firstString = firstString;
    }

    public WordsAnalyzer() {
    }

    public void setN(int n) {
        this.n = n;
    }
    

    public String getFirstString() {
        return firstString;
    }

    public void setFirstString(String firstString) {
        this.firstString = firstString;
    }

    public String getSecondString() {
        return secondString;
    }

    public void setSecondString(String secondString) {
        this.secondString = secondString;
    }
    
    public HashMap<String, Integer> countFirstWords() {
        if (firstString == null) {
            throw new IllegalStateException();
        }
        Pattern p = Pattern.compile(SEPARATORS_PATTERN);
        
        String[] splittedText = p.split(firstString);
        firstWords = new HashMap<>();
        for (String singleWord : splittedText) {
            singleWord = singleWord.toLowerCase();
            if (singleWord.length() == 0) {
                continue;
            }
            firstWords.put(singleWord, firstWords.getOrDefault(singleWord, 0) + 1);
        }
        
        return firstWords;
    }
    
    private HashMap <Character, Integer> countChars(String data) {
        if (data == null) {
            throw new IllegalStateException();
        }
        HashMap <Character, Integer> container = new HashMap<>();
        for (int i = 0; i < data.length(); i++) {
            container.put(data.charAt(i), container.getOrDefault(data.charAt(i), 0) + 1);
        }
        
        return container;
    }
    
    private HashMap <Character, Integer>countFirstChars() {
        firstChars = countChars(firstString);
        return firstChars;
    }
    private HashMap <Character, Integer>countSecondChars() {
        secondChars = countChars(secondString);
        return secondChars;
    }
    
    
    Comparator <Character> comparatorDefault = Character::compare;
    Comparator <Character> comparatorByHash = new Comparator<>() {
        @Override
        public int compare(Character c1, Character c2) {
            int hash1 = c1.hashCode();
            int hash2 = c2.hashCode();
            return (cycleMoveLeft(hash1, n)) - (cycleMoveLeft(hash2, n));
        }
    };
    private int cycleMoveLeft(int number, int n) {
        for (int i = 0; i < n; i++) {
            int leftDigit = number & (1 << 31);
            number = (number << 1) | leftDigit;
        }
        return number;
    }
    
    
    public static final int DEFAULT_ORDER = 0;
    public static final int REVERSED_ORDER = 1;
    public static final int HASH_ORDER = 2;
    /**
     * 
     * @param ps
     * @param sortType
     * 0 is default order
     * 1 is reversed
     * 2 is order by cycle binary moving hash of character by n positions
     */
    public void printIntersection(PrintStream ps, int sortType) {
        if (firstChars  == null) {countFirstChars();}
        if (secondChars == null) {countSecondChars();}
        List <Character> intersection = new ArrayList<>();
        for (Map.Entry<Character, Integer> pair: firstChars.entrySet()) {
            if (secondChars.containsKey(pair.getKey())) {
                intersection.add(pair.getKey());
            }
        }
        switch (sortType) {
            case 0 -> intersection.sort(comparatorDefault);
            case 1 -> intersection.sort(comparatorDefault.reversed());
            case 2 -> intersection.sort(comparatorByHash);
            default -> throw new IllegalStateException();
        }
        ps.println(intersection);
        
    }
    public void printDiff(PrintStream ps, int sortType) {
        if (firstChars  == null) {countFirstChars();}
        if (secondChars == null) {countSecondChars();}
        List <Character> difference = new ArrayList<>();
        for (Map.Entry<Character, Integer> pair: firstChars.entrySet()) {
            if (!secondChars.containsKey(pair.getKey())) {
                difference.add(pair.getKey());
            }
        }
        switch (sortType) {
            case 0 -> difference.sort(comparatorDefault);
            case 1 -> difference.sort(comparatorDefault.reversed());
            case 2 -> difference.sort(comparatorByHash);
            default -> throw new IllegalStateException();
        }
        ps.println(difference);
        
    }
    
    public void printSum(PrintStream ps, int sortType) {
        if (firstChars  == null) {countFirstChars();}
        if (secondChars == null) {countSecondChars();}
        List <Character> summary = new ArrayList<>(secondChars.keySet());
        for (Map.Entry<Character, Integer> pair: firstChars.entrySet()) {
            if (!summary.contains(pair.getKey())) {
                summary.add(pair.getKey());
            }
        }
        switch (sortType) {
            case 0 -> summary.sort(comparatorDefault);
            case 1 -> summary.sort(comparatorDefault.reversed());
            case 2 -> summary.sort(comparatorByHash);
            default -> throw new IllegalStateException();
        }
        ps.println(summary);
        
    }
    
    
}
