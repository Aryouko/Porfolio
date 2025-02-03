/**
* Programme qui affiche le salaire brut, les prélèvements, le total des prélèvement et le salaire net
* et qui calcule les prélèvements ainsi que le salaire net en demandant le salaire brut
* @author L. Carré
**/
class Prelevements{
	void principal(){
		double salaireBrut = SimpleInput.getDouble("Votre salaire brut : ");
		if (salaireBrut < 0) {
			System.out.println("Salaire invalide");
		} else {
			double salaireAssuMal = salaireBrut * 0.0075;
			double salaireAssuVieiDepl = salaireBrut * 0.001;
			double salaireAssuVieiPl = salaireBrut * 0.0675;
			double salairePro = salaireBrut * 0.0175;
			double salaireContSocGen = (salaireBrut - salairePro) * 0.075;
			double salaireCRDS = (salaireBrut - salairePro) * 0.005;
			double salaireChom = salaireBrut * 0.024;
			double prelevTot = salaireChom + salaireCRDS + salaireContSocGen + salairePro + salaireAssuVieiPl + salaireAssuVieiDepl + salaireAssuMal;
			
			System.out.println("Salaire brut : " + salaireBrut);
			System.out.println("Prélèvement Assurance maladie : " + salaireAssuMal);
			System.out.println("Prélèvement Assurance vieillesse déplafonnée : " + salaireAssuVieiDepl);
			System.out.println("Prélèvement Assurance vieillesse plafonnée : " + salaireAssuVieiPl);
			System.out.println("Prélèvement Frais professionels : " + salairePro);
			System.out.println("Prélèvement Contribution sociale généralisée : " + salaireContSocGen);
			System.out.println("Prélèvement CRDS : " + salaireCRDS);
			System.out.println("Prélèvement Chômage : " + salaireChom);
			System.out.println("Total prélèvement : " + prelevTot);
			System.out.println("Salaire net : " + (salaireBrut - prelevTot));		
		}
	}
}
