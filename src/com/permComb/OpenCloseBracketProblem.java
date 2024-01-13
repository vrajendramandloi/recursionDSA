package com.permComb;

import java.util.ArrayList;
import java.util.List;

public class OpenCloseBracketProblem {
	public static void main(String[] args) {
		List<String> result = new ArrayList<String>();
		printAllBracketsCombination("(",1,0,result,4);
		System.out.println(result.toString());
	}
	
	static void printAllBracketsCombination(String str, int openCount, int closeCount, List<String> result, int targetCount) {
		if(str.length() == 2*targetCount) {
			result.add(str); return;
		}
		if(openCount < targetCount) printAllBracketsCombination(str+"(", openCount+1, closeCount, result, targetCount);
		if(closeCount < openCount) printAllBracketsCombination(str+")", openCount, closeCount+1, result, targetCount);
	}
}
