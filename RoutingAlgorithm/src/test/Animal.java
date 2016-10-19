package test;

public abstract class Animal {
	private String name;
	
	public Animal(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	
	public void sua(){
		String str = this.getAnimalName();
		System.out.println("Sua di " + str);
	}
	
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract String getAnimalName();
}
