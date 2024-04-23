package leetcodepractice;

public class MaxlenSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String str) {
        int startIndex = 0, count = 0, maxLen = 0;
        if(str == null) return 0;
        boolean[] freq = new boolean[150];
        while(startIndex <= str.length()-1) {
            char c = str.charAt(count);
            if(freq[c]) {
                freq = new boolean[150];
                if(count >= maxLen) maxLen = count;
                startIndex++;
                count = 0;
                continue;
            }
            freq[c] = true;
            count++;
        }
        return maxLen;
    }
}
