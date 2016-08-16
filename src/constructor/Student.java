package constructor;

public class Student {

	String name;
	int rno;

	  Student(String name, int rno) {
		this.name = name;
		this.rno = rno;
		System.out.println("Values are:::\n" +name+"\n"+rno);

	}

}

class Test {
	public static void main(String[] args) {
		
		Student s1=new Student("Rajesh",100);
		Student s2=new Student("Ravi",101);

	}

}