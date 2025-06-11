package client;
import jeux.B;
public class C extends B{
	private int c1;
	public C(){
		super(-10);
		System.out.println("Constructeur de C");
	}
	public void m1(){
		System.out.println("m1 de C");
	}
	public void m5(){
		//this.a1 = 2; a1 has private access in A
		//this.a2 = 2; a2 is not public in A; cannot be accessed from outside package
		this.a3 = 2;
		this.a4 = 2;
		//this.b1 = 2; b1 has private access in B
				
		System.out.println(this.getA1());
		this.m1();
		this.m2();
		//this.m3(); package privacy (accessible que par les classes d'un meme package)
		//this.m4(); private access
	}
	
	protected void m7(){
		System.out.println("Méthode m7");
	}

	protected void m8(){
		System.out.println("Méthode m8");
	}
}
