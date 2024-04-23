package babyNumerology;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MainBabyModel implements Serializable {
	private static final long serialVersionUID = 1122L;
	private String msg;
	private String title;
	private String description;
	@JsonProperty("SearchData")
	private List<SearchData> searchData;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<SearchData> getSearchData() {
		return searchData;
	}
	public void setSearchData(List<SearchData> searchData) {
		this.searchData = searchData;
	}
	@Override
	public String toString() {
		return "MainBabyModel [msg=" + msg + ", title=" + title + ", description=" + description + ", searchData="
				+ searchData + "]";
	}
}
