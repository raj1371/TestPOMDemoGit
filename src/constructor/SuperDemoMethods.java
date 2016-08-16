package constructor;

class Animal {

	void Eat() {
		System.out.println("Animal ::EAT");
	}

}

class Dog extends Animal {

	void Eat() {
		super.Eat();
		System.out.println("Dog ::EAT");
	}

	void Eat(String pedigree) {
		this.Eat();
		System.out.println("Dog::" + pedigree);

	}

}

public class SuperDemoMethods {

	public static void main(String[] args) {
		Dog d1 = new Dog();
		d1.Eat();
		d1.Eat("pedigree");

	}

}