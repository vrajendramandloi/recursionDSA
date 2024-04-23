package babyNumerology;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BabyNamesSortingNumerology {
	private static Map<String, Integer> map = new HashMap<String, Integer>();
	private static List<String> mustContainLetters = new ArrayList<String>(); //Arrays.asList("V","R")
	private static List<String> startWithLetter = new ArrayList<String>();
	private static List<Integer> expectedfirstNameNumerologyCount = new ArrayList<Integer>(); //Arrays.asList(5)
	private static List<String> surNameArray = new ArrayList<String>(Arrays.asList("SINGHMANDLOI", "MANDLOI"));

	public static void main(String[] args) throws Exception {
		BabyNamesSortingNumerology b1 = new BabyNamesSortingNumerology();
		b1.initMap();
		b1.setupDbConnection();
		b1.initializeBufferedWriter();

		List<SearchData> dataRecordsList = new ArrayList<SearchData>();
		ResultSet rs = b1.stmt.executeQuery();
		int count = 0;
		if (rs != null) {
			while (rs.next()) {
				SearchData dataRec = new SearchData();
				dataRec.setRecordid(rs.getString("RECORDID"));
				dataRec.setBabyname(rs.getString("BABYNAME"));
				dataRec.setMeaning(rs.getString("MEANING"));
				dataRec.setGender(rs.getString("GENDER"));
				dataRec.setReligion(rs.getString("RELIGION"));
				dataRec.setOrigin(rs.getString("ORIGIN"));
				dataRec.setNakshatra(rs.getString("NAKSHATRA"));
				dataRecordsList.add(dataRec);
				count++;
				if (dataRecordsList.size() == 100) {
					System.out.println("Validated  Records count " + count);
					b1.validateName(dataRecordsList);
					dataRecordsList = new ArrayList<SearchData>();
				}
			}
		}
		if (!dataRecordsList.isEmpty()) {
			System.out.println("Validated Last Records count " + count);
			b1.validateName(dataRecordsList);
		}
	}

	public void validateName(List<SearchData> records) throws Exception {
		boolean isFirstNameNumerologyCountMatch = false;
		boolean isFullNameNumerologyCountMatch = false;
		boolean isMustContainMatch = false;
		boolean isStatrtsWithMatch = false;

		for (SearchData data : records) {
			try {
				String babyName = data.getBabyname().toUpperCase();
				for (String matchStr : mustContainLetters) {
					if (babyName.contains(matchStr)) {
						isMustContainMatch = true;
					}
				}
				if (!isMustContainMatch && mustContainLetters.isEmpty()) {
					isMustContainMatch = true;
				}
				for (String letterStart : startWithLetter) {
					if (babyName.startsWith(letterStart)) {
						isStatrtsWithMatch = true;
					}
				}
				if (!isStatrtsWithMatch && startWithLetter.isEmpty()) {
					isStatrtsWithMatch = true;
				}
				if (isMustContainMatch && isStatrtsWithMatch) {
					String[] firstNameNumerology;
					try {
						firstNameNumerology = getNumerologyCount(babyName);
						if(firstNameNumerology == null) continue;
					} catch(Exception e11) {
						continue;
					}
					if(expectedfirstNameNumerologyCount.isEmpty()) {
						isFirstNameNumerologyCountMatch = true;
					} else {
						isFirstNameNumerologyCountMatch = expectedfirstNameNumerologyCount.contains(Integer.valueOf(firstNameNumerology[0])); 
					}
					if(isFirstNameNumerologyCountMatch) {
						for (String surName : surNameArray) {
							String newName = babyName + surName;
							String[] surnameNameNumerology = getNumerologyCount(newName);
							
							buffer.append(firstNameNumerology[0] + "," + firstNameNumerology[1] + "," +babyName+  ","
									+ surnameNameNumerology[0] + "," + surnameNameNumerology[1] + "," + babyName + "_" + surName 
									+ ",\"" + data.getMeaning()+"\""
									+ ",\"" + data.getReligion()+"\""+ ",\"" + data.getOrigin()+"\""+ ",\"" + data.getNakshatra()+"\"");
							buffer.newLine();
						}
					}
					buffer.flush();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(data.toString());
			}
		}
	}
	
	String[] getNumerologyCount(String name) {
		String[] arrReturn = new String[2];
 		String counterVal = "";
		char[] nameArrayList = name.toCharArray();
		int sum = 0;
		for (char c : nameArrayList) {
			sum += map.get(String.valueOf(c));
		}
		int newSum = findSum(sum);
		counterVal += " :: "+newSum;
		while (newSum > 9) {
			newSum = findSum(newSum);
			counterVal += " :: "+newSum;
		}
		arrReturn[0] = String.valueOf(newSum);
		arrReturn[1] = counterVal;
		
		return arrReturn;
	}

	static int findSum(int number) {
		int sum = 0;
		while (number != 0) {
			sum = sum + number % 10;
			number = number / 10;
		}
		return sum;
	}

	public void initializeBufferedWriter() throws IOException {
		String mustContainL = this.mustContainLetters.toString();
		String startsWithL = this.startWithLetter.toString();
		FileWriter writer = new FileWriter("D:\\resultNames" + mustContainL + "_" + startsWithL + ".csv");
		buffer = new BufferedWriter(writer);
		buffer.append("num_firstName, num_firstNameBreak, FirtName,  num_fullName, num_fullNameBreak, fullName, meaning, relegion, origin, nakshatra");
		buffer.newLine();
		buffer.flush();
	}

	private static BufferedWriter buffer;
	private Connection conn;
	private PreparedStatement stmt;
	private static String selectQuery = "select * from BABY_NAMES_DUMP where gender='GIRL'";

	public void setupDbConnection() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		try {
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "SYSTEM", "MANAGER");
			this.stmt = conn.prepareStatement(selectQuery);
			this.stmt.setFetchSize(1000);
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
