package namura;

import java.util.HashMap;
import java.util.Map;

public class PatternMatch {
    public static void main(String[] args) {
        PatternMatch p1 = new PatternMatch();
        System.out.println(p1.wordPattern("abba", "dog cat cat dog"));
        System.out.println(p1.wordPattern("abba", "dog cat cat fish"));
        System.out.println(p1.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(p1.wordPattern("aaa", "dog cat cat dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        Map<String , String> freqVal = new HashMap<>();
        char[] patternArray = pattern.toCharArray();
        String[] sArray = s.split(" ");
        if(sArray.length != pattern.length()) {
            return false;
        }
        for(int i=0; i< patternArray.length; i++) {
            String patterChar = String.valueOf(patternArray[i]);
            String sValue = sArray[i];
            String valueFromMap = freqVal.get(patterChar);
            if(valueFromMap == null) {
                freqVal.put(patterChar, sValue);
            } else {
                if(!sValue.equalsIgnoreCase(valueFromMap)) {
                    return false;
                }
            }
        }
        return true;
    }
}
