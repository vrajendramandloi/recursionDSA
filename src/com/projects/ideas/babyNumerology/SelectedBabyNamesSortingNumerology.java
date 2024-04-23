package babyNumerology;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SelectedBabyNamesSortingNumerology {
	private static Map<String, Integer> map = new HashMap<String, Integer>();
	private static List<Integer> expectedfirstNameNumerologyCount = new ArrayList<Integer>(Arrays.asList(5, 6));
	private static List<Integer> expectedcompleteNameNumerologyCount = new ArrayList<Integer>(Arrays.asList(5, 6));
	private static List<String> surNameArray = new ArrayList<String>(Arrays.asList("SINGHMANDLOI", "MANDLOI" ));

	public static void main(String[] args) throws Exception {
		SelectedBabyNamesSortingNumerology b1 = new SelectedBabyNamesSortingNumerology();
		b1.initMap();

		List<SearchData> dataRecordsList = new ArrayList<SearchData>();
		dataRecordsList.add(new SearchData("VACHI"));
		dataRecordsList.add(new SearchData("VACHHI"));
		dataRecordsList.add(new SearchData("VRITI"));
		dataRecordsList.add(new SearchData("VRITII"));
		dataRecordsList.add(new SearchData("VRITTI"));
		dataRecordsList.add(new SearchData("VRITTI"));
		dataRecordsList.add(new SearchData("VRITIKA"));
		b1.validateName(dataRecordsList);
	}

	public void validateName(List<SearchData> records) throws Exception {
		boolean isFirstNameNumerologyCountMatch = false;
		boolean isFullNameNumerologyCountMatch = false;
		boolean isMustContainMatch = false;
		boolean isStatrtsWithMatch = false;

		for (SearchData data : records) {
			try {
				String babyName = data.getBabyname().toUpperCase();
				int nameNumerologyCount = 0;
				try {
					nameNumerologyCount = getNumerologyCount(babyName);
				} catch(Exception e11) {
					continue;
				}
				isFirstNameNumerologyCountMatch = expectedfirstNameNumerologyCount.contains(nameNumerologyCount);

				int surnameNumerologyCount = 0;
				for (String surName : surNameArray) {
					String newName = babyName + surName;
					surnameNumerologyCount = getNumerologyCount(newName);
					
					System.out.println(nameNumerologyCount + "," + surnameNumerologyCount + "," + isMustContainMatch
								+ "," + isStatrtsWithMatch + "," + babyName + "_" + surName + ",\"" + data.getMeaning()+"\""
								+ ",\"" + data.getReligion()+"\""+ ",\"" + data.getOrigin()+"\""+ ",\"" + data.getNakshatra()+"\"");
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(data.toString());
			}
		}
	}

	int getNumerologyCount(String name) {
		char[] nameArrayList = name.toCharArray();
		int sum = 0;
		for (char c : nameArrayList) {
			sum += map.get(String.valueOf(c));
		}
		int newSum = findSum(sum);
		while (newSum > 9) {
			newSum = findSum(newSum);
		}
		return newSum;
	}

	static int findSum(int number) {
		int sum = 0;
		while (number != 0) {
			sum = sum + number % 10;
			number = number / 10;
		}
		return sum;
	}	

	public void initMap() {
		map.put("A", 1);
		map.put("I", 1);
		map.put("J", 1);
		map.put("Q", 1);
		map.put("Y", 1);
		map.put("B", 2);
		map.put("K", 2);
		map.put("R", 2);
		map.put("C", 3);
		map.put("G", 3);
		map.put("L", 3);
		map.put("S", 3);
		map.put("D", 4);
		map.put("M", 4);
		map.put("T", 4);
		map.put("E", 5);
		map.put("H", 5);
		map.put("N", 5);
		map.put("X", 5);
		map.put("U", 6);
		map.put("V", 6);
		map.put("W", 6);
		map.put("O", 7);
		map.put("Z", 7);
		map.put("F", 8);
		map.put("P", 8);
		map.put(" ", 0);
		map.put("-", 0);
		map.put("'", 0);
		map.put("(", 0);
		map.put(")", 0);
	}
}
