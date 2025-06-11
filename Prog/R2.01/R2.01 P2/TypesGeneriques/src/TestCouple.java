import java.util.ArrayList;
import java.util.List;
/**
 * Class allow to test the Couple, CoupleG and CoupleGN class
 * @author L. CARRE
 * @version 1.0
 */
public class TestCouple {

	/**
	 * Program entry
	 * @param args optionnal arguments
	 */
	public static void main(String[] args) {
		
		//TEST DE LA CLASSE Couple
		
		System.out.println("*** Test de la classe Couple ***");
		Couple test = new Couple(2, "5");
		System.out.println(test);
		int l = (int) test.getLeft();
		System.out.println("Left : " + l);
		String r = (String) test.getRight();
		System.out.println("Right : " + r);
		test.setLeft("5");
		System.out.println(test);
		test.setRight(35);
		System.out.println(test);
		System.out.println();
		
		//TEST DE LA CLASSE CoupleG
		
		System.out.println("*** Test de la classe CoupleG ***");
		System.out.println("** Normal **");
		CoupleG <Number, String> c1 = new CoupleG<>(3.0, " Bonjour " );
		CoupleG <String, String> c2 = new CoupleG <>("Gauche", "Droite") ;
		System.out.println(c1);
		System.out.println(c2);
		//String lc1err = c1.getLeft();
		Number lc1 = c1.getLeft();
		System.out.println("Left de c1 : " + lc1);
		String rc2 = c2.getRight();
		System.out.println("Right de c2 : " + rc2);
		//c1.setLeft("Bye"); //Impossible car Number n'inclus pas String
		c1.setLeft(3); //Possible car Number est hérité avec usufruit par toutes ses sous-classes : Integer, Long, Float, Double, Byte, Short,...
		System.out.println(c1);
		System.out.println();
		
		System.out.println("*** Test de la classe CoupleG ***");
		System.out.println("** Avec creerCouple(T o) **");
		CoupleG<String, String> cC1 = creerCouple("salut");
		CoupleG<Integer, Integer> cC2 = creerCouple(3);
		System.out.println(cC1);
		System.out.println(cC2);
		System.out.println();
		
		System.out.println("*** Test de la classe CoupleG ***");
		System.out.println("** Avec withNewLeft(V newLeft) **");
		CoupleG<String, Integer> cBase = new CoupleG<>("Salut", 3);
		CoupleG<Integer, Integer> cNewLeft = cBase.withNewLeft(2);
		System.out.println(cBase);
		System.out.println(cNewLeft);
		System.out.println();
		
		//TEST DE LA CLASSE CoupleGN
		
		System.out.println("*** Test de la classe CoupleGN ***");
		System.out.println("** Avec addition et produit **");
		CoupleGN<Integer, Double> cMath1 = new CoupleGN<>(3, 4.5);
		CoupleGN<Float, Long> cMath2 = new CoupleGN<>(3.5f, 5L);
		System.out.println(cMath1);
		System.out.println("Addition de cMath1 : " + cMath1.additionComp());
		System.out.println("Produit de cMath1 : " + cMath1.produitComp());
		System.out.println(cMath2);
		System.out.println("Addition de cMath2 : " + cMath2.additionComp());
		System.out.println("Produit de cMath2 : " + cMath2.produitComp());
		System.out.println();
		
		//TEST DE TABLEAUX ET SOUS-TYPAGE
		
		System.out.println("*** Test de tableaux et sous-typage ***");
		String[] tabString = {"A", "B", "C"};
		Object[] tabObject = tabString;
		System.out.println("tabObject[0] : " + tabObject[0]);
		// tabObject[0] = 3;
		// Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer
		// at TestCouple.main(TestCouple.java:85)
		System.out.println();
		
		//TEST DE SOUS-TYPAGE INVARIANT SUR LES TYPES GENERIQUES
		
		System.out.println("*** Test de sous-typage sur les types génériques ***");
		ArrayList<String> arrayString = new ArrayList<>();
		ArrayList<Object> arrayObject = new ArrayList<>();
		// arrayString = arrayObject; Erreur présent à la compilation
		// incompatible types: ArrayList<Object> cannot be converted to ArrayList<String>
		// arrayObject = arrayString; Erreur présent à la compilation
		// incompatible types: ArrayList<String> cannot be converted to ArrayList<Object>
		List<String> newListString = arrayString;
		newListString.add("Salut");
		System.out.println(newListString);
		System.out.println();
		
		//TEST DES WILDCARDS
		
		System.out.println("*** Test des wildcards ***");
		System.out.println("** Méthode sameNumericContent avec wildcard **");
		CoupleGN<Integer, Double> cM1 = new CoupleGN<>(3, 2.0);
		CoupleGN<Float, Long> cM2 = new CoupleGN<>(3.0f, 2L);
		System.out.println(cM1);
		System.out.println(cM2);
		System.out.println("Est ce que c'est deux couples sont les même ? " + cM1.sameNumericContent(cM2));
		System.out.println();
		
		System.out.println("*** Test des wildcards ***");
		System.out.println("** Méthode sameNumericContent sans wildcard **");
		System.out.println(cM1);
		System.out.println(cM2);
		System.out.println("Est ce que c'est deux couples sont les même ? " + cM1.sameNumericContent2(cM2));
		System.out.println();
		
		System.out.println("*** Test des wildcards ***");
		System.out.println("** Methode addCoupleToCollection **");
		ArrayList<Number> collection = new ArrayList<>();
		System.out.println("Avant ajout : " + collection);
		addCoupleToCollection(cM1, collection);
		System.out.println("Après ajout : " + collection);
		System.out.println();
	}
	
	/**
	 * Create a new couple with generetic type and with a value
	 * @param <T> the type of values of couple
	 * @param o value with generic type
	 * @return a new CoupleG with the same values
	 */
	public static <T> CoupleG<T, T> creerCouple(T o) {
		return new CoupleG<>(o, o);
	}
	
	/**
	 * Add values of a couple in a collection
	 * @param couple the couple selected
	 * @param collection the collection select
	 */
	public static void addCoupleToCollection(CoupleGN<? extends Number, ? extends Number> couple, ArrayList<? super Number> collection) {
		collection.add(couple.getLeft());
		collection.add(couple.getRight());
	}
}
