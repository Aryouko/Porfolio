/**
 * The <code>TestPolynome</code> class allows you to play (a little) with the Polynomial class
 *
 * @author L. Carré
 * @version 1.0
 */
public class TestPolynome {

	/**
     * Example method to quickly test the <code>Polynome</code> class.
     * <p><strong>This main method is for demonstration purposes only.</strong></p>
     *
     * @param args Arguments passed to the program (not used).
     */
    public static void main(String[] args) {
        testConstructeur();
        testSetCoefficient();
        testGetCoefficient();
        testAdd();
        testIsIdentical();
        testEvaluate();
        testGetDegree();
        testToString();
        testMultiply();
    }
    
    /**
	 * Test constructor() method
	 */
	public static void testConstructeur() {
		System.out.println();
		System.out.println("*** testConstructeur() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		
		double[] coeffs1 = {2.0, 3.0, 5.0}; // 2 + 3x + 5x^2
        Polynome p1 = new Polynome(coeffs1);
        System.out.println("Coefficient souhaite : " + coeffs1[0] + "," + coeffs1[1] + "," + coeffs1[2]);
        System.out.println("p1 est : " + p1);
        
        System.out.println();
		System.out.println("* Cas limite *");
		
		double[] coeffs2 = {0.0}; // 0
        Polynome p2 = new Polynome(coeffs2);
        System.out.println("Coefficient souhaite : " + coeffs2[0]);
        System.out.println("p2 est : " + p2);
        
        System.out.println();
		System.out.println("* Cas d'erreur *");
		
		double[] coeffs3 = null; //null
        Polynome p3 = new Polynome(coeffs3);
        System.out.println("p3 est : " + p3);
	}
	
	/**
	 * Tests the getCoefficient() method
	 */
	public static void testGetCoefficient() {
		System.out.println();
		System.out.println("*** testGetCoefficient() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		
		double[] coeffs1 = {2.0, 3.0, 5.0}; // 2 + 3x + 5x^2
        Polynome p1 = new Polynome(coeffs1);
        System.out.println("p1 est : " + p1);
        
        System.out.println();
		System.out.println("* Cas d'erreur *");
		
        System.out.println("Maintenant cherchons le 4eme coefficient (non-existant)");
        System.out.println(p1);
        
        System.out.println();
        System.out.println("* Réponse à la question *");
        System.out.println();
        System.out.println("On ne peut pas savoir si -1 est un coefficient ou le dépassement de la liste, le problème est ignoré dans le setter");
	}
	
	/**
	 * Tests the setCoefficient() method
	 */
	public static void testSetCoefficient() {
		System.out.println();
		System.out.println("*** testSetCoefficient() ***");
		
		System.out.println();
		System.out.println("Test visuel");
		
		System.out.println();
		System.out.println("* Cas normal *");
		
		double[] coeffs1 = {2.0}; // 2
        Polynome p1 = new Polynome(coeffs1);
        System.out.println("p1 est : " + p1);
        p1.setCoefficient(0, 5);
        System.out.println("Coefficient souhaite en 0 : " + coeffs1[0]);
        System.out.println("p1 est : " + p1);
        
        System.out.println();
		System.out.println("* Cas limite *");
		
        System.out.println("p1 est : " + p1);
        p1.setCoefficient(0, 0);
        System.out.println("Coefficient souhaite en 0 : " + coeffs1[0]);
        System.out.println("p1 est : " + p1);
        
        System.out.println();
		System.out.println("* Cas d'erreur *");
		
		//p1.setCoefficient(0, null);
        //System.out.println("Coefficient souhaite : 0");
        //System.out.println("p1 est : " + p1);
	}
	
	/**
	 * Test add() method
	 */
	public static void testAdd() {
		System.out.println();
		System.out.println("*** testAdd() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		
		double[] coeffs1 = {2.0, 3.0, 5.0}; // 2 + 3x + 5x^2
        Polynome p1 = new Polynome(coeffs1);
        double[] coeffs2 = {2.0}; // 2
        Polynome p2 = new Polynome(coeffs2);
        double[] coeffs3 = {4.0, 3.0, 5.0}; // 4 + 3x + 5x^2
        Polynome p3 = new Polynome(coeffs3);
        testCasIsIdentical(p1, p2, p3);
        
        System.out.println();
		System.out.println("* Cas limite *");
		
		double[] coeffs4 = {0.0}; // 0
        Polynome p4 = new Polynome(coeffs4);
		double[] coeffs5 = {2.0}; // 0
        Polynome p5 = new Polynome(coeffs5);
        testCasIsIdentical(p4, p2, p5);
        
        System.out.println();
		System.out.println("* Cas d'erreur *");
		
        System.out.println(p2 + "  +  null : " + p2 + " : ");
        Polynome p6 = p2.add(null);
        
		if (p6.isIdentical(p2)) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
	}
	
	/**
	 * Test a case of add() method
	 * 
	 * @param p1 first polynomial
	 * @param p2 second polynomial
	 * @param res result polynomial
	 */
	public static void testCasIsIdentical(Polynome p1, Polynome p2, Polynome res) {
		System.out.println();
		System.out.print(p1 + "  +  " + p2 + " : " + res + " : ");
        Polynome p3 = p1.add(p2);
		
		if (p3.isIdentical(res)) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
	}
	
	/**
	 * Tests isIdentical() method
	 */
	public static void testIsIdentical() {
		System.out.println();
		System.out.println("*** testIsIdentical() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		
		double[] coeffs1 = {2.0, 3.0, 5.0}; // 2 + 3x + 5x^2
        Polynome p1 = new Polynome(coeffs1);
        double[] coeffs2 = {2.0}; // 2
        Polynome p2 = new Polynome(coeffs2);
        testCasIsIdentical(p1, p2, false);
        
		//The problem with isIdentical was that when a coefficient at the end was zero (0) it was checked then when either it did not influence the result of isIdentical in any way
		
        double[] coeffs3 = {2.0, 3.0, 5.0, 0.0}; // 2 + 3x + 5x^2
        Polynome p3 = new Polynome(coeffs3);
        testCasIsIdentical(p1, p3, true);
        System.out.println("Le problème était qu'un coeff 0 derrière le polynome faisait que c'était différent alors quand réalité non");
        
        System.out.println();
		System.out.println("* Cas limite *");
		
        boolean verif2 = p1.isIdentical(p1);
        testCasIsIdentical(p1, p1, true);
        
        System.out.println();
		System.out.println("* Cas d'erreur *");
		
        boolean verif3 = p2.isIdentical(null);
        System.out.print(p2 + " et null Egaux ? false : ");
        if (verif3 == false) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
	}
	
	/**
	 * Test a case of isIdentical() method
	 * 
	 * @param p1 first polynomial
	 * @param p2 second polynomial
	 * @param res result
	 */
	public static void testCasIsIdentical(Polynome p1, Polynome p2, boolean res) {
		System.out.print(p1 + " et " + p2 + "Egaux ? " + res + " : " );
		boolean verif = p1.isIdentical(p2);
		
		if (verif == res) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
	}
	
	/**
	 * Tests evaluate() method
	 */
	public static void testEvaluate() {
		System.out.println();
		System.out.println("*** testEvaluate() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		
		double[] coeffs1 = {2.0, 3.0, 5.0}; // 2 + 3x + 5x^2
        Polynome p1 = new Polynome(coeffs1);
        testCasEvaluate(p1, 3, 56);
        
        System.out.println();
		System.out.println("* Cas limite *");
		
		double[] coeffs2 = {5.0}; // 5
        Polynome p2 = new Polynome(coeffs2);
        testCasEvaluate(p2, 3, 5);
        
        double[] coeffs3 = {0.0, 0.0}; // 0 + 0x
        Polynome p3 = new Polynome(coeffs3);
        testCasEvaluate(p3, 3, 0);
    }
        
    /**
	 * Test a case of evaluate() method
	 * 
	 * @param p polynomial
	 * @param n the x
	 * @param res result
	 */
	public static void testCasEvaluate(Polynome p, double n, double res) {
		System.out.print(p + " avec n = " + n + " : " + res + " : ");
		double verif = p.evaluate(n);
		
		if (verif == res) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
	}
	
	/**
	 * Tests getDegree() method
	 */
	public static void testGetDegree() {
		System.out.println();
		System.out.println("*** testGetDegree() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		
		double[] coeffs1 = {2.0, 3.0, 5.0}; // 2 + 3x + 5x^2
        Polynome p1 = new Polynome(coeffs1);
        testCasGetDegree(p1, 2);
        
        System.out.println();
		System.out.println("* Cas limite *");
		
		double[] coeffs2 = {5.0, 0.0}; // 5
        Polynome p2 = new Polynome(coeffs2);
        testCasGetDegree(p2, 0);
    }
        
    /**
	 * Test a case of getDegree() method
	 * 
	 * @param p polynomial
	 * @param res result
	 */
	public static void testCasGetDegree(Polynome p, double res) {
		System.out.print("Degrée de " + p + " = " + res + " : ");
		double verif = p.getDegree();
		
		if (verif == res) {
			System.out.println("OK");
		} else {
			System.out.println("ERREUR");
		}
	}
	
	/**
	 * Tests toString() method
	 */
	public static void testToString() {
		System.out.println();
		System.out.println("*** testToString() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		
		double[] coeffs1 = {2.0, 3.0, 5.0}; // 2 + 3x + 5x^2
        Polynome p1 = new Polynome(coeffs1);
		System.out.println("Test visuel : ");
        System.out.println("Test méthode : " + p1);
		System.out.println("Test manuel : " + p1.getCoefficient(0) + " + " + p1.getCoefficient(1) + "x^1 + " + p1.getCoefficient(2) + "x^2");
        
        System.out.println();
		System.out.println("* Cas limite *");
		
		double[] coeffs2 = {5.0, 0.0}; // 5
        Polynome p2 = new Polynome(coeffs2);
		System.out.println("Test visuel : ");
        System.out.println("Test méthode : " + p2);
		System.out.println("Test manuel : " + p2.getCoefficient(0) + " + " + p2.getCoefficient(1) + "x^1");
    }
    
    /**
	 * Tests Multiply() method
	 */
	public static void testMultiply() {
		System.out.println();
		System.out.println("*** testMultiply() ***");
		
		System.out.println();
		System.out.println("* Cas normal *");
		
		double[] coeffs1 = {2.0, 3.0, 4.0}; // 2 + 3x + 4x^2
        Polynome p1 = new Polynome(coeffs1);
        double[] coeffs2 = {2.0, -4.0}; // 2 - 4x
        Polynome p2 = new Polynome(coeffs2);
        Polynome p3 = p1.multiply(p2);  
        System.out.println("Le résultat devrait être : 4.0 + -2.0x^1 + -4.0x^2 + -16.0x^3");
        System.out.println(p3);  
        
        System.out.println();
		System.out.println("* Cas limite *");
		
        double[] coeffs4 = {2.0, -4.0, 0.0}; // 2 - 4x
        Polynome p4 = new Polynome(coeffs4);
        Polynome p5 = p1.multiply(p4);  
        System.out.println("Le résultat devrait être : 4.0 + -2.0x^1 + -4.0x^2 + -16.0x^3");
        System.out.println(p5); 
    }
}
