package entities;

public class Department {

	private String name;

	public Department(String name) {
		this.setName(name);
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return this.getName();
	}
	
}
