package com.heretech.classroomLecture;

public class LectureObj {
	private String LectureName;
	private int StartTime;
	private int endTime;
	public LectureObj(String lectureName, int startTime, int endTime) {
		super();
		LectureName = lectureName;
		StartTime = startTime;
		this.endTime = endTime;
	}
	public String getLectureName() {
		return LectureName;
	}
	public void setLectureName(String lectureName) {
		LectureName = lectureName;
	}
	public int getStartTime() {
		return StartTime;
	}
	public void setStartTime(int startTime) {
		StartTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
}
