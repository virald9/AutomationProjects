package oops;

public class Birds extends Mammal{

	int x=20;
	
	@Override
	public void parrot() {
		
		System.out.println("There are "+x+ " parrot - Bird");
		
	}

	@Override
	public void pigeon() {
		
		System.out.println("There are "+x+ " pigeon - Bird");
	}
	
	
	public int dove(int x) {
		
		
		return x;
	}
	
	public int dove(int x,int y) {
	
		return x+y;
	}

	public void  hello() {
		
		System.out.println("Hello");
	}

	
	public static void main(String[] args) {
		
	
		Birds b1= new Birds();
		b1.parrot();
		b1.pigeon();
		
		
		//Method Overriding - Upcasting - Runtime Polymorphism - Cannot override in same class
		Mammal b2=new Birds();
		b2.parrot();
		b2.pigeon();
		b2.Dog();
		System.out.println(b2.x);
		
		
		//Method Overloading - Compile time polymorphism - cannot inherit from difference class
		Birds b3= new Birds();
		System.out.println(b3.dove(100));
		System.out.println(b3.dove(100,100));
		b3.test();
		
		//Upcasting birds to interface1
		interface1 b4 = new Mammal();
		b4.cat();
		b4.pigeon();
		
		Mammal v = new Mammal();
		v.cat();
		
		
		
	
		
		
		
		
		
		
		
	}



}
