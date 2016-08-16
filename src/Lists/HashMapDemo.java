package Lists;

import java.util.HashMap;
import java.util.Set;

public class HashMapDemo {
	public static void main(String[] args) {

		HashMap<String, String> phoneBook = new HashMap<String, String>();

		phoneBook.put("Rajesh", "9966951371");
		phoneBook.put("Ravi", "9966951372");
		phoneBook.put("Ram", "9966951373");

		System.out.println(phoneBook.get("Rajesh"));

		// To Print all elements

		Set<String> keys = phoneBook.keySet();

		for (String i : keys) {

			System.out.println("Element" + i + phoneBook.get(i));
		}

	}

}
