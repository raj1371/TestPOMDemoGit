package Lists;

import java.util.LinkedList;

public class HashTable {

	public static void main(String[] args) {

		//Hash Table Demo
		LinkedList<String> lList = new LinkedList<String>();

		lList.add("Rajesh");
		lList.add(null);
		lList.add("Rajesh");
		lList.set(0, "Software");
		lList.add(0, "venky");
		lList.removeLast();
		lList.addFirst("CCC");

		System.out.println(lList);

	}
}
