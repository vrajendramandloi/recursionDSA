package leetcodepractice;

import java.math.BigInteger;

public class ReverseIntegerTest {
    public static void main(String[] args) {
        ReverseIntegerTest p1 = new ReverseIntegerTest();
        System.out.println(p1.reverse(123));
        System.out.println(p1.reverse(-2223));
        System.out.println(p1.reverse2(1534236469));
    }

    public int reverse(int x) {
        if(x==0) return 0;
        boolean isNegative = x<0 ? true : false;
        x = Math.abs(x);
        String result = "";
        while(x != 0) {
            int remainder = x%10;
            result+=remainder;
            x = x/10;
        }
        Integer x1 = 0;
        if(result.length() < 10) {
            x1 = Integer.parseInt(result);
        } else {
            BigInteger p1 = new BigInteger(result);
            x1 = p1.intValue();
        }
        return isNegative  ? -x1 : x1;
    }

    public int reverse2(int x) {
        long finalNum = 0;
        while(x!=0){
            int lastDig = x%10;
            finalNum += lastDig;
            finalNum = finalNum*10;
            x= x/10;
        }
        finalNum = finalNum/10;
        if(finalNum > Integer.MAX_VALUE || finalNum<Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            return (int)(-1*finalNum);
        }
        return (int)finalNum;
    }
}
