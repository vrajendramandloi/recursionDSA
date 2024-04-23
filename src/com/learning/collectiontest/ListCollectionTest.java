package collectiontest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListCollectionTest {
	public static void main(String[] args) {
		ListCollectionTest dl1 =new ListCollectionTest();
		dl1.ArrayListRemoveTest();
		dl1.testLinkedList();
	}
	
	
	public void ArrayListRemoveTest() {
		List<String> list = new ArrayList<String>();
		list.add("a");list.add("b");list.add("c");list.add("d");list.add("e");
		
		for(int i=0; i<list.size(); i++) {
			if("a".equalsIgnoreCase(list.get(i))) {
				list.remove(i);
			}
		}
		System.out.println(list.toString());
	}
	
	public void testLinkedList() {
		List<String> strList = new LinkedList<String>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		strList.add("d");
		System.out.println(strList.toString());
		
		
	}
}
