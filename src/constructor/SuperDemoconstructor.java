package constructor;

class Car {
	Car() {
		System.out.println("Car:: constructor");
	}
}

class Audi extends Car {

	Audi() {
		super();

		System.out.println("Audi :: Constructor");
	}

	Audi(String latest) {
		this();
		System.out.println("Audi ::" + latest);
	}

}

public class SuperDemoconstructor {

	public static void main(String[] args) {
		//Audi d1 = new Audi();
		Audi d2 = new Audi("Latest");

	}
}


