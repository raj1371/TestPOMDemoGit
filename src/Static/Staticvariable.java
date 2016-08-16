package Static;

public class Staticvariable {
	
	static int count = 0;// will get memory when instance is created

	Staticvariable() {
		count++;
		System.out.println(count);
	}

	public static void main(String args[]) {

		Staticvariable c1 = new Staticvariable();
		Staticvariable c2 = new Staticvariable();
		Staticvariable c3 = new Staticvariable();

	}

}
