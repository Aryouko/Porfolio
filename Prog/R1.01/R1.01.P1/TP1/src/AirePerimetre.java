/**
* Programme qui calcule l'aire et le périmètre d'un cercle avec son rayon
* @author L. Carré
**/
class AirePerimetre{
	void principal(){
		double rayon, aire, perimetre;
		rayon = SimpleInput.getDouble("Rayon du cercle = ");
		if (rayon < 0) {
			System.out.println("Rayon invalide");
		} else {
			aire = (rayon * rayon) * Math.PI;
			perimetre = 2 * rayon * Math.PI;
			System.out.println("Le cercle de rayon " + rayon + " à pour aire " + aire + " et pour perimetre " + perimetre);
		}
	}
}		
