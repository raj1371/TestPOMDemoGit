package Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {

	public static void main(String[] args) {

		List<String> a1 = new ArrayList<String>();
		ListIterator<String> litr=null;
		

		/*
		 * Methods 
		 * ADD 
		 * Get 
		 * index of 
		 * Remove
		 * List Iterator
		 * 
		 */

		// add
		a1.add("Zara");
		a1.add("Mahnaz");
		a1.add("Ayan");
		System.out.println(" ArrayList Elements\t" + a1);
		
		// get
		System.out.println("First element \t" + a1.get(0));
		
		// index of

		System.out.println("Index of Zara \t" + a1.indexOf("Zara"));
		
		//remove
		System.out.println("Remove Zara \t" + a1.remove(0));
		System.out.println("After remove Arraylist was \t" + a1);
		
		
		//List Iterator
				litr= a1.listIterator();
				
				System.out.println("Elements in forward directiton");
		        while(litr.hasNext()){
		            System.out.println(litr.next());
		        }
		        System.out.println("Elements in backward directiton");
		        while(litr.hasPrevious()){
		            System.out.println(litr.previous());
		        }
		

				
		


	}

}
