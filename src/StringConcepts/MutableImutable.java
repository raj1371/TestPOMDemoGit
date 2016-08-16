package StringConcepts;

import java.lang.String;
import java.lang.StringBuffer;

public class MutableImutable {

	public static void main(String[] args) {

		// String is mutable
		String str = new String("Raj");
		str.concat("Software");
		System.out.println("Imutable object value is::"+str);
		
		String str4="Rajesh";
		str4.concat("test");
		System.out.println(str4);
		

		// String Buffer is Imutable

		StringBuffer sb = new StringBuffer("Raj");
		sb.append("Software");
		System.out.println("Mutable object value is::"+sb);
	}

}
