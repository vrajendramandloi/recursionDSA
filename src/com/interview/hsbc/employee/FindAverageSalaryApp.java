package com.interview.hsbc.employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class FindAverageSalaryApp {
	
	public void findAverageSalary(List<Employee> employees) {
		if(employees == null) return;
		Map<String, List<Employee>> map = new HashMap<String, List<Employee>>(100, 1);
		// grouping
		for(Employee emp : employees) {
			String key= emp.getOfficeLocation()+" --> "+emp.getDesignation();
			List<Employee> list = map.get(key);
			if(list == null) {
				list = new ArrayList<Employee>();
				list.add(emp);
				map.put(key, list);
			} else {
				list.add(emp);
			}
		}
		// Optional Sorting
		/* map = map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey()) 			
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new)); */
		// Group Processing
		for(Map.Entry<String, List<Employee>> entry : map.entrySet()) {
			List<Employee> empList = entry.getValue();
			double avgSal= empList.stream().mapToDouble(e -> e.getSalary()).sum();
			avgSal = avgSal / empList.size();
			System.out.println(entry.getKey()+" --> "+ avgSal);
		}
		map = map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey()) 			
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		System.out.println(map);
		System.out.println(map.toString());
	}
}