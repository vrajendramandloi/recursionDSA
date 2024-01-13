package com.heretech.classroomLecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinClassroomNeeded {
	// Start and End Time of Lectures.. 
	// ASK: how many Max Classroom Needed?
	
	
	// Object class which contain Lecture info.
	// List of LectureObject class. 
	// int MaxClass = 1. 
	
	// Fequency of Lectures to be measured
	// Map<StartTime+EndTime, Boolean > freq;
	// Condition 1:
	// If Same time Match is found Increment the Class Counter +1.
	
	
	
	// If LectureObjectList == 0 Classroom = 0
	// (11:12) (12:14) (14:17) MinClass = 1
	// (11:12) (11:14) (12:14) (14:17) (15:17) MinClass = 2
	
	static List<boolean[]> lectureTimeSheets = new ArrayList<boolean[]>();
	public static void main(String[] args) {
		LectureObj l1 = new LectureObj("l1", 11, 12);
		LectureObj l2 = new LectureObj("l2", 12, 14);
		LectureObj l3 = new LectureObj("l3", 14, 17);
		LectureObj l4 = new LectureObj("l4", 11, 14);
		LectureObj l5 = new LectureObj("l5", 15, 17);
		
		List<LectureObj> lectureList = new ArrayList<LectureObj>(Arrays.asList(l1,l2,l3,l4,l5));
		
		
		for(LectureObj obj : lectureList) {
			if(lectureTimeSheets.isEmpty()) {
				addnewTimesheet(obj);
				continue;
			}
			boolean isLectureAdjusted = false;
			for(boolean[] timesheet : lectureTimeSheets) {
				boolean[] newTimeSheet = getTimesheet(timesheet, obj.getStartTime(), obj.getEndTime());
				if(newTimeSheet != null ) {
					isLectureAdjusted = true;
					timesheet = newTimeSheet;
					break;
				}
			}
			if(!isLectureAdjusted) {
				addnewTimesheet(obj);
			}
		}	
		System.out.println("Minimum Classroom Needed " + lectureTimeSheets.size());
	}
	
	static void addnewTimesheet(LectureObj obj) {
		boolean[] lectureTimesheet = new boolean[24];
		lectureTimesheet = getTimesheet(lectureTimesheet, obj.getStartTime(), obj.getEndTime());
		lectureTimeSheets.add(lectureTimesheet);
	}
	
	static boolean[] getTimesheet(boolean[] timesheet, int StartTime, int EndTime) {
		for(int i=StartTime ; i< EndTime; i++) {
			if(timesheet[i] == true) return null;
			timesheet[i] = true;
		}
		return timesheet;
	}
	
}
