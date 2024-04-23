package com.learning.permComb;

public class MaxSubstringWithoutDuplicates {
	public static void main(String[] args) {
		MaxSubstringWithoutDuplicates m1 = new MaxSubstringWithoutDuplicates();
		System.out.println("Output : "+ m1.lengthOfLongestSubstring("AABSBBEWDD"));
	}
	
	public int lengthOfLongestSubstring(String str) {
        int countIndex = 0;
		int maxSubstringLen = 0;
		if(str == null) return 0;
        if(str.length() == 1) return 1;
		boolean[] freq = new boolean[150];
		for(int i=0 ;i< str.length(); i++) {
			char c = str.charAt(i);
			if(freq[c]) {
				if(countIndex > maxSubstringLen) {
					maxSubstringLen = countIndex;
					freq = new boolean[150];
				}
				countIndex = 0;
			}
			freq[c] = true;
            countIndex++;
		}
        if( countIndex != 0 && countIndex > maxSubstringLen ) {
            maxSubstringLen = countIndex;
        }
        return maxSubstringLen;
    }
}
