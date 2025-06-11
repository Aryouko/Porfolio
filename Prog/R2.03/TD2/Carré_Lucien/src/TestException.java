/**
 * Class allow test my exception class
 * @author L. CARRE
 * @version 1.0
 */
public class TestException {

	/**
	 * Entry of the program
	 * @param args - useless here
	 */
	public static void main(String[] args) {
		
		TestException test = new TestException();
		
        System.out.println();
		System.out.println("*** Test MaMeth1 ***");
		System.out.println();
		
        try {
            test.maMeth1();
        } catch (My2Exception e) {
            System.err.println(e.getMessage());
        } catch (My1Exception e) {
            System.err.println(e.getMessage());
        } finally {
            System.out.println("Finally exécuté (maMeth1)");
        }

        System.out.println();
		System.out.println("*** Test MaMeth2 ***");
		System.out.println();
		
		System.out.println("** Cas sans try-catch **");
        //test.maMeth2();
		System.out.println("Exception non contrôlée, passe la compilation mais erreur à l'exécution");

        System.out.println("** Cas avec try-catch **");
        try {
            test.maMeth2();
        } catch (My2Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println();
		System.out.println("*** Test MaMeth3 ***");
		System.out.println();
		
        System.out.println("** Cas sans try-catch **");
		System.out.println("Exception contrôlée, ne passe pas la compilation");
        //test.maMeth3();

        System.out.println("** Cas avec try-catch **");
        try {
            test.maMeth3();
        } catch (My1Exception e) {
            System.err.println(e.getMessage());
        }
        
        System.out.println();
		System.out.println("*** Test MaMeth4 ***");
		System.out.println();
		
		System.out.println("** Cas à 2 niveaux : maMeth4 -> n -> p **");
		try {
			test.maMeth4();
        } catch (My1Exception e) {
            System.err.println(e.getMessage());
        }
	}
	
	/**
	 * Demonstrates throwing either a controlled or uncontrolled exception
	 * @throws My1Exception - controlled exception
	 * @throws My2Exception - uncontrolled exception
	 */	
	public void maMeth1() throws My1Exception, My2Exception {
		if (Math.random() > 0.5) { // I use random because two "throw new" in the same method is not possible
			throw new My1Exception("Erreur contrôlée dans maMeth1");
		} else {
			throw new My2Exception("Erreur non contrôlée dans maMeth1");
			
		}
	}
	
	/**
	 * Always throws an uncontrolled exception
	 * @throws My2Exception - uncontrolled exception
	 */	
	public void maMeth2() throws My2Exception {
        throw new My2Exception("Erreur non contrôlée dans maMeth2");
	}
	
	/**
	 * Always throws an controlled exception
	 * @throws My1Exception - controlled exception
	 */	
	public void maMeth3() throws My1Exception {
		throw new My1Exception("Erreur contrôlée dans maMeth3");
	}
	
	/**
	 * Calls method n() which throws a controlled exception from method p().
	 * @throws My1Exception - controlled exception
	 */	
	public void maMeth4() throws My1Exception {
		n();
	}
	
	/**
	 * Intermediate method that calls p() and propagates its controlled exception.
	 * @throws My1Exception - controlled exception
	 */	
	public void n() throws My1Exception {
		p();
	}
	
	/**
	 * Throws a controlled exception
	 * @throws My1Exception - controlled exception
	 */	
	public void p() throws My1Exception {
		throw new My1Exception("Exemple sur 2 niveaux d'appels");
	}
}
