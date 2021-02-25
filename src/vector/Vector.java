package vector;
import java.util.Arrays;

public class Vector {
	private Student[] students = new Student[100];
	private int totalStudents = 0;

	private boolean occupiedIndex(int index) {
		return index >= 0 && index < this.totalStudents;
	}
	
	private boolean validPosition(int index) {
		return index >= 0 && index <= this.totalStudents;
	}
	
	private void mostSpace() {
		if (this.totalStudents == this.students.length) {
			Student[] newStudents = new Student[this.students.length * 2];
			
			for (int i = 0; i < this.students.length; i++) {
				newStudents[i] = this.students[i];
			}
			
			this.students = newStudents;
		}
	}
	
	public void add(Student student) {
		this.mostSpace();
			
		this.students[this.totalStudents] = student;
		this.totalStudents++;
	}
	
	public void add(Student student, int index) {
		this.mostSpace();
		
		
		if(!this.validPosition(index)) {
			throw new IllegalArgumentException("Invalid position");
		}
		
		for(int i  = this.totalStudents - 1; i >= index; i--) {
			this.students[i+1] = this.students[i];
		}
		
		this.students[index] = student;
		this.totalStudents++;
	}
	
	public Student searchByIndex(int index) {
		if (!this.occupiedIndex(index)) {
			throw new IllegalArgumentException("Occupied index");
		}
		
		return this.students[index];
	}
	
	public boolean exist(Student student) {
		for(int i = 0; i < this.totalStudents; i++) {
			if (student.equals(this.students[i])) {
				return true;
			}
		}
		
		return false;
	}
	
	public void remove(int index) {
		for (int i = index; i < this.totalStudents - 1; i++) {
			this.students[i] = this.students[i+1];
		}
		
		this.totalStudents--;
		
		this.students[this.totalStudents] = null;
	}
	
	public int length() {
		return this.totalStudents;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(this.students);
	}
}
