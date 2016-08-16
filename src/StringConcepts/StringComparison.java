package StringConcepts;

public class StringComparison {

	public static void main(String[] args) {
		
		String s1= new String("Raj");
		String s2= new String("Raj");
		String s3="Raj";
		String s4="Raj";
		System.out.println(s1==s2);
		System.out.println(s3==s4);
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));

	}

}
