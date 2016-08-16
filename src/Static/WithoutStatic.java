package Static;

public class WithoutStatic {

	int count = 0;// will get memory when instance is created

	WithoutStatic() {
		count++;
		System.out.println(count);
	}

	public static void main(String args[]) {

		WithoutStatic c1 = new WithoutStatic();
		WithoutStatic c2 = new WithoutStatic();
		WithoutStatic c3 = new WithoutStatic();

	}
}
