package vector;


public class Student {
	private String name;
	
	public Student(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		return other.getName().equals(this.name);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
 }
