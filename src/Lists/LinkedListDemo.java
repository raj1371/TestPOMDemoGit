package Lists;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {

		LinkedList<String> lList = new LinkedList<String>();

		lList.add("Rajesh");
		lList.add(null);
		lList.add("Rajesh");
		
		System.out.println("AFter Duplicate"+lList);
		
		lList.set(0, "Software");
		lList.add(0, "venky");
		
		System.out.println("Before remove list was"+lList);
		lList.removeLast();
		lList.addFirst("CCC");

		System.out.println("After Remove List was"+lList);

	}

}
