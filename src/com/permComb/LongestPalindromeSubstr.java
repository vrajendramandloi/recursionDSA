package com.permComb;

public class LongestPalindromeSubstr {
	public static void main(String[] args) {
		String str = "rasdgbbgdsaw";
		int maxlen = 0;
		for(int i=0; i< str.length(); i++) {
			int len1 = maxLengthPalinDrome(str, i, i+1);
			int len2 = maxLengthPalinDrome(str, i, i);
			int newMaxlen = Math.max(len1, len2);
			if ( newMaxlen > maxlen ) {
				maxlen = newMaxlen;
			}
		}
		System.out.println("Max palindrome Substring : "+maxlen);
	}

	static int maxLengthPalinDrome(String str, int i, int j) {
		while(i>=0 && j<str.length() && str.charAt(i) ==  str.charAt(j)) {
			i--; j++;
		}
		return j-i-1;
	}
}
