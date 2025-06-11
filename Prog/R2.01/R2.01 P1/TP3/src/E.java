package client;
import jeux.*;
public class E{
	public static void main(String args[]){
		A unA=new A();
		B unB=new B(3);
		C unC =new C();
		D unD =new D();
		E unE=new E();
		
		unA=unC;
		unC=(C)unA;
		unC.m5();
		unA=unD;
		unC=(C)unA;
	}
}
