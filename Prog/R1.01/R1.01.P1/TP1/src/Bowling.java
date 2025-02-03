/**
* Programme qui calcule le nombre de quilles tombées
* @author L. Carré
**/
class Bowling{
	void principal(){
		int quilles1 = SimpleInput.getInt("Nombre de quilles (premier lancer) : ");
		if (quilles1 == 10) {
			System.out.println("Strike !");
		} else if ((quilles1 > 10) || (quilles1 < 0)) {
			System.out.println("Nombre incorrect");
		} else {
			int quilles2 = SimpleInput.getInt("Nombre de quilles (deuxieme lancer) : ");
			if ((quilles2 > 10) || (quilles2 < 0)) {
				System.out.println("Nombre incorrect");
			} else {
				int quillesTotal = quilles1 + quilles2;
				if (quillesTotal == 10){
					System.out.println("Spare");
				} else if ((quillesTotal > 10) || (quillesTotal < 0)) {
					System.out.println("Nombre incorrect");
				} else {
					System.out.println(quillesTotal);
				}
			}
		}
	}
}
