package test;

public class Cat extends Animal {

	public Cat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	//@Override
	public String getAnimalName() {
		// TODO Auto-generated method stub
		return this.getName();

	}
	public static void main(String[] args) {
		Cat thang = new Cat("Thang");
		thang.sua();
	}
}
