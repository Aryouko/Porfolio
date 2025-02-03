/**
* Programme qui dit si on a eu son année avec combien de note entre 8 et 10
* ou si on ne l'a pas eu et pourquoi on ne l'a pas eu
* @author L. Carré
**/
class ObtentionAnnee{
	void principal(){
		double noteC1 = SimpleInput.getDouble("Votre note dans la compétence 1 : ");
		double noteC2 = SimpleInput.getDouble("Votre note dans la compétence 2 : ");
		double noteC3 = SimpleInput.getDouble("Votre note dans la compétence 3 : ");
		double noteC4 = SimpleInput.getDouble("Votre note dans la compétence 4 : ");
		double noteC5 = SimpleInput.getDouble("Votre note dans la compétence 5 : ");
		double noteC6 = SimpleInput.getDouble("Votre note dans la compétence 6 : ");
		int noteSup10 = 0;
		int noteBet810 = 0;
		int noteInf8 = 0;
		
		if ((noteC1 < 0 || noteC1 > 20) || (noteC2 < 0 || noteC2 > 20) || (noteC3 < 0 || noteC3 > 20) || (noteC4 < 0 || noteC4 > 20) || (noteC5 < 0 || noteC5 > 20) || (noteC6 < 0 || noteC6 > 20)) {
			System.out.println("Erreur durant la saisie des notes");
		} else {
			if (noteC1 >= 10) {
				noteSup10 += 1;
			} else if (noteC1 < 8) {
				noteInf8 += 1;
			} else {
				noteBet810 += 1;
			}
			
			if (noteC2 >= 10) {
				noteSup10 += 1;
			} else if (noteC2 < 8) {
				noteInf8 += 1;
			} else {
				noteBet810 += 1;
			}
			
			if (noteC3 >= 10) {
				noteSup10 += 1;
			} else if (noteC3 < 8) {
				noteInf8 += 1;
			} else {
				noteBet810 += 1;
			}
			
			if (noteC4 >= 10) {
				noteSup10 += 1;
			} else if (noteC4 < 8) {
				noteInf8 += 1;
			} else {
				noteBet810 += 1;
			}
			
			if (noteC5 >= 10) {
				noteSup10 += 1;
			} else if (noteC5 < 8) {
				noteInf8 += 1;
			} else {
				noteBet810 += 1;
			}
			
			if (noteC6 >= 10) {
				noteSup10 += 1;
			} else if (noteC6 < 8) {
				noteInf8 += 1;
			} else {
				noteBet810 += 1;
			}
			
			
			
			
			if ((noteSup10 >= 4) && (noteInf8 == 0)) {
				System.out.println("Vous avez votre année avec " + noteBet810 + " notes entre 8 et 10.");
			} else if ((noteSup10 >= 4) && (noteInf8 != 0)) {
				System.out.println("Vous n'avez pas votre année, vous avez une ou plusieurs notes en dessous de 8.");
			} else if ((noteSup10 < 4) && (noteInf8 == 0)) {
				System.out.println("Vous n'avez pas votre année, vous n'avez pas assez de notes au dessus de 10.");
			} else {
				System.out.println("Vous n'avez pas votre année, vous n'avez pas assez de notes au dessus de 10 et vous avez une ou plusieurs notes en dessous de 8.");
			}
		}
	}
}
