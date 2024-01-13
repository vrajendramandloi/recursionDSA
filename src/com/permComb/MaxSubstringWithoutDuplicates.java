package com.permComb;

public class MaxSubstringWithoutDuplicates {
	public static void main(String[] args) {
		String str = "ABCDABCDEABCDEFA"; 
		int fromIndex = 0;
		int maxSubstringLen = 0;
		String substring = "";
		boolean[] freq = new boolean[150];
		for(int i=0 ;i< str.length(); i++) {
			char c = str.charAt(i);
			if(freq[c]) {
				int eval = i-fromIndex;
				if(eval > maxSubstringLen) {
					maxSubstringLen = eval; 
					substring = str.substring(fromIndex, i);
					freq = new boolean[150];
				}
				fromIndex = i;
			}
			freq[c] = true;
		}
		System.out.println("Output : "+ maxSubstringLen + " substr "+ substring);
	}
}
