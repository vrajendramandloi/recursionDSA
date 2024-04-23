package permComb;

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

	public String longestPalindrome(String s) {
		String maxStr = "";
		for(int i=0; i<s.length(); i++) {
			String pal1 = validatePalindrome(s, i,i);
			String pal2 = validatePalindrome(s, i,i+1);
			String longest = pal1.length() > pal2.length() ? pal1 : pal2;
			maxStr = longest.length() > maxStr.length() ? longest : maxStr;
		}
		return maxStr;
	}

	String validatePalindrome(String str, int index1, int index2) {
		while(index1>=0 && index2<str.length() && str.charAt(index1) == str.charAt(index2)) {
			index1--; index2++;
		}
		return str.substring(index1, index2);
	}
}
