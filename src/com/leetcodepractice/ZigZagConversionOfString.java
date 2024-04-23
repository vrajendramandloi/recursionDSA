package leetcodepractice;

public class ZigZagConversionOfString {
    public static void main(String[] args) {
        ZigZagConversionOfString z1 = new ZigZagConversionOfString();

        String output = z1.convert("PAYPALISHIRING", 3);
        System.out.println(output);
        output = z1.convert("PAYPALISHIRING", 4);
        System.out.println(output);
        output = z1.convert("AB", 1);
        System.out.println(output);
    }
    public String convert(String s, int numRows) {
        int len = s.length();
        char arr [][] = new char[numRows][len];
        int i=0;
        int rowCount = 0;
        int columnCount = 0;
        boolean isTraversingBack = false;
        if(numRows == 1) return s;
        while(i<s.length()) {
            if(isTraversingBack) {
                arr[--rowCount][++columnCount] = s.charAt(i);
                if(rowCount == 0) {
                    isTraversingBack = false;
                    rowCount++;
                }
            } else {
                arr[rowCount][columnCount] = s.charAt(i);
                rowCount ++;
            }
            i++;
            if(rowCount >= numRows) {
                isTraversingBack = true;
                rowCount --;
            }
        }
        StringBuilder builder = new StringBuilder();
        for(int k =0; k< numRows; k++) {
            for(int j =0; j< len; j++) {
                builder.append(arr[k][j]);
            }
        }
        return builder.toString();
    }
}
