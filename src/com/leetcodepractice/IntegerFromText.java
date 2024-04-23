package leetcodepractice;

public class IntegerFromText {
    public static void main(String[] args) {
        IntegerFromText t1 = new IntegerFromText();
        //t1.myAtoi("42");
        //t1.myAtoi("   -42");
        t1.myAtoi("4193 with words");
        int val = Integer.valueOf("9128347233").intValue();
        System.out.println(val);
    }

    public int myAtoi(String s) {
        int i = 0;
        int len = s.length();
        int sign  = 1;
        int num=0;
        while(i<len) {
            char iChar = s.charAt(i);
            if(iChar == ' ') { i++; continue; }
            if(iChar == '-' && Character.isDigit(s.charAt(i+1))) { sign = -1; i++; continue;}
            if(Character.isLetter(iChar)) {  return 0;  }
            if(Character.isDigit(iChar)) {
                s=s.substring(i);
                i=0;
                while(Character.isDigit(s.charAt(i))) {
                    int digit = s.charAt(i) - '0';
                    num = (10*num) + digit;
                    i++;
                }
            }
        }
        return num * sign;
    }
}
