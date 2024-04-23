package babyNumerology;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


public class GetAllBabyNames {
	private static String payload = "{ \"gender\": [ \"unisex\" ], \"religion\": \"Hindu\", \"category\": \"\", \"keyword\": \"\", \"startwith\": [    ], \"endwith\": \"all\", \"length\": \"all\", \"numofletter\": \"all\", \"origin\": \"Indian\", \"numerology\": \"all\", \"rashi\": \"all\", \"nakshatra\": \"all\", \"god\": \"all\", \"pageNo\": :PAGE_NO:, \"pageSize\": 100, \"sortkey\": \"Most Popular\", \"systemflag\": \"0\", \"IsTryingToConceive\": 0 }";

	public static void main(String[] args)  {
		GetAllBabyNames g1 = new GetAllBabyNames();
		HttpClient httpClient = HttpClientBuilder.create().build();
		try {
			g1.setupDbConnection();
			HttpPost request = new HttpPost(
					"https://parenting.firstcry.com/parenting/Babynames/getbabysearchbyfilters");
			for (int i = 1; i < 1000; i++) {
				String newPayload = new String(payload);
				newPayload = newPayload.replace(":PAGE_NO:", String.valueOf(i));
				StringEntity params = new StringEntity(newPayload);
				request.addHeader("content-type", "application/x-www-form-urlencoded");
				request.setEntity(params);
				
				HttpResponse response = httpClient.execute(request);
				HttpEntity entity = response.getEntity();
				String fileResponseText = EntityUtils.toString(entity);
				
				/* 
				File responseFile = new File("D:\\TEST\\helloworld\\src\\main\\java\\com\\name\\baby\\response.json");
				String fileResponseText= new String(Files.readAllBytes(Paths.get(responseFile.getAbsolutePath())), StandardCharsets.UTF_8);
				*/
				//System.out.println(fileResponseText);
				JSONObject jsonObject = new JSONObject(fileResponseText);
				JSONArray arrayListData = jsonObject.getJSONArray("SearchData");
				List<SearchData> dataList = new ArrayList<SearchData>();
				for(int l=0; l< arrayListData.length(); l++) {
					JSONObject objectMap = (JSONObject) arrayListData.get(l);
					dataList.add(toSearchDataMap(objectMap));
				}
				g1.insertRecords(dataList);
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	public static SearchData toSearchDataMap(JSONObject map) {
		SearchData data = new SearchData();
		data.setRecordid(String.valueOf(map.get("recordid")));
		data.setBabyname(String.valueOf(map.get("babyname")));
		data.setMeaning(String.valueOf(map.get("meaning")));
		data.setGender(String.valueOf(map.get("gender")));
		data.setReligion(String.valueOf(map.get("religion")));
		data.setOrigin(String.valueOf(map.get("origin")));
		data.setNakshatra(String.valueOf(map.get("nakshatra")));
		return data;
	}
	
	private Connection conn;
	private PreparedStatement stmt;
	private static String insertQuery = "INSERT INTO BABY_NAMES_DUMP (RECORDID, BABYNAME, MEANING, GENDER, RELIGION, ORIGIN, NAKSHATRA) VALUES (?,?,?,?,?,?,?)";
	public void setupDbConnection() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		try {
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521", "SYSTEM", "MANAGER");
			this.stmt = conn.prepareStatement(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static int count = 0;
	public void insertRecords(List<SearchData> dataList) throws Exception {
		try {
			for(SearchData data : dataList) {
				stmt.setString(1, data.getRecordid());
	            stmt.setString(2, data.getBabyname());
	            stmt.setString(3, data.getMeaning());
	            stmt.setString(4, data.getGender());
	            stmt.setString(5, data.getReligion());
	            stmt.setString(6, data.getOrigin());
	            stmt.setString(7, data.getNakshatra());
	            stmt.addBatch();
	            count++;
			}
        	stmt.executeBatch();
        	System.out.println("updated Count in DB "+count);
        } catch (SQLException e) {
            System.out.println("Error message: " + e.getMessage());
            return;
        }
	}
}
