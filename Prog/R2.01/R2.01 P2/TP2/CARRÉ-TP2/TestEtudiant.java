/**
 * The <code>TestEtudiant</code> class allows you to play with the Etudiant class
 *
 * @author L. Carré
 * @version 1.0
 */
public class TestEtudiant {

	/**
     * Example method to quickly test the <code>Etudiant</code> class.
     * <p><strong>This main method is for demonstration purposes only.</strong></p>
     *
     * @param args Arguments passed to the program (not used).
     */
    public static void main(String[] args) {
		String[] mat = {"Prog", "GL", "Math"};
		double[] coeff = {3.0, 5.0, 1.0};
		System.out.println("Test d'un nouvel étudiant");
		Etudiant e1 = new Etudiant("toto", mat, coeff, 3);
		System.out.println(e1);
		System.out.println("Test getNom : " + e1.getNom());
		System.out.println("Test getNbMatieres : " + e1.getNbMatieres());
		System.out.println("Test getUneNote : " + e1.getUneNote(1, 2));
		e1.setNom("Lucien");
		System.out.println("Test changement de nom : " + e1.getNom());
		System.out.println("Test moyenne matière : " + e1.moyenneMatiere(0));
		System.out.println("Test moyenne générale : " + e1.moyenneGenerale());
		System.out.println("Test meilleure note : " + e1.meilleureNote());
		
		System.out.println();
		System.out.println("Test d'un nouvel étudiant");
		Etudiant e2 = new Etudiant("", null, null, 0);
		System.out.println(e2);
		System.out.println("Test getNom : " + e2.getNom());
		System.out.println("Test getNbMatieres : " + e2.getNbMatieres());
		System.out.println("Test getUneNote : " + e2.getUneNote(1, 2));
		e2.setNom("Lucien");
		System.out.println("Test changement de nom : " + e2.getNom());
		System.out.println("Test moyenne matière : " + e2.moyenneMatiere(0));
		System.out.println("Test moyenne générale : " + e2.moyenneGenerale());
		System.out.println("Test meilleure note : " + e2.meilleureNote());
	}
}
