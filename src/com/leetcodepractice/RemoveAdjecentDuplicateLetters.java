package leetcodepractice;

public class RemoveAdjecentDuplicateLetters {
    /*
	 * Remove the adjacent duplicate characters from the input string
		{"abbccdd" -> "a", "bccb" -> "", xwxx -> xw , xwxw -> xwxw, xwxxxww -> xwx}
	 */
    public static void main(String[] args) {
        RemoveAdjecentDuplicateLetters w1 = new RemoveAdjecentDuplicateLetters();
        String str = "abbccdd";
        System.out.println("started Debugging test "+str);
        while(w1.hasDuplicate(str)) {
            str = w1.removeAdjcentDuplicate(str);
        }
        System.out.println(str);
        str = "bccb";
        System.out.println("started Debugging test 2 "+str);
        while(w1.hasDuplicate(str)) {
            str = w1.removeAdjcentDuplicate(str);
        }
        System.out.println(str);
        str = "xwxx";
        System.out.println("started Debugging test 3 "+str);
        while(w1.hasDuplicate(str)) {
            str = w1.removeAdjcentDuplicate(str);
        }
        System.out.println(str);
        str = "xwxw";
        System.out.println("started Debugging test 4 "+str);
        while(w1.hasDuplicate(str)) {
            str = w1.removeAdjcentDuplicate(str);
        }
        System.out.println(str);
        str = "xwxxxww";
        System.out.println("started Debugging test 4 "+str);
        while(w1.hasDuplicate(str)) {
            str = w1.removeAdjcentDuplicate(str);
        }
        System.out.println(str);
    }

    public boolean hasDuplicate(String str) {
        char lastchar = 0;
        char[] strArr = str.toCharArray();
        for(char c : strArr) {
            if(lastchar==0) {
                lastchar = c; continue;
            }
            if(lastchar == c) {
                return true;
            } else {
                lastchar = c;
            }
        }
        return false;
    }

    public String removeAdjcentDuplicate(String str) {
        char lastchar = 0;
        int index = 0;
        char[] strArr = str.toCharArray();
        for(int i=0; i<strArr.length ; i++) {
            if(i==0 || lastchar == 0) {
                lastchar = strArr[i];
                index = i;
                continue;
            }
            if(strArr[i]==lastchar) { // remove the duplicates
                strArr[i] = 0;
                strArr[index] = 0;
                lastchar = 0;
            } else {
                lastchar = strArr[i];
                index = i;
            }
        }
        String newStr = "";
        for(char c : strArr) {
            if(c!=0) {
                newStr+=c;
            }
        }
        return newStr;
    }
}
