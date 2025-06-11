package com.mycompany.app;
import java.util.ArrayList;
/**
* Class allow to 
* @author L. CARRE
* @version 1.0
*/
public class MoneyBag implements IMoney{
	
	/**
	 * The different monies in a list
	 */
	private ArrayList<Money> monies;
	
	/**
	* Constructor of the class
	*/
	public MoneyBag() {
		this.monies = new ArrayList<>();
	}
	
	/**
	 * Constructor of the class
	 * @param bag - a list of monies
	 * @throws RuntimeException - if the bag is empty
	 */
	public MoneyBag(Money[] bag) throws RuntimeException {
		this.monies = new ArrayList<>();
		
		if (bag == null) {
			throw new RuntimeException("Le sac passé en paramètre en vide");
		}
		
		for (Money element : bag) {
			this.appendMoney(element);
		}
		
		assert this.invariant() : "Invariant violé !";
	}
	
	/**
	 * Method allow to append a new or old Money in the bag
	 * @param theM - the money to add
	 * @throws RuntimeException - if the money is null
	 */
	public void appendMoney(Money theM) throws RuntimeException{
		if (theM == null) {
			throw new RuntimeException("Money passée en paramètre null");
		}
		
		int verif = -1;
		for (int i = 0; i < this.monies.size(); i++) {
			if (monies.get(i).getCurrency().equals(theM.getCurrency())) {
				verif = i;
			}
		}
	
		if (verif != -1) {
			if (this.monies.get(verif).getAmount() + theM.getAmount() != 0) {
				Money moneyAssert = new Money(this.monies.get(verif).getAmount() + theM.getAmount(), theM.getCurrency());
				this.monies.set(verif, (Money) this.monies.get(verif).add(theM));
				assert this.toString().contains(moneyAssert.toString()) : "Post-condition échouée : modification incorrecte";
			} else {
				this.monies.remove(verif);
				assert !this.toString().contains(theM.getCurrency()) : "Post-condition échouée : modification incorrecte";
			}
		} else {
			this.monies.add(theM);
			assert this.toString().contains(theM.toString()) : "Post-condition échouée : modification incorrecte";
		}
		
		assert this.invariant() : "Invariant violé !";
	}
	
	/**
	 * Method allow to create a new bag to add the new money
	 * @param theM - the money to add
	 * @return a new bag with the new money
	 * @throws RuntimeException - if the money is null
	 */
	public IMoney add(Money theM) throws RuntimeException {
		if (theM == null) {
			throw new RuntimeException("La money passée en paramètre est nulle");
		}
		
		MoneyBag ret = new MoneyBag();
		for (Money money : this.monies) {
			ret.appendMoney(new Money(money.getAmount(), money.getCurrency()));
		}
		
		ret.appendMoney(theM);
		
		Money moneyAssert = null;
		for (int i = 0; i < this.monies.size(); i++) {
			if (this.monies.get(i).getCurrency().equals(theM.getCurrency())) {
				moneyAssert = new Money(this.monies.get(i).getAmount() + theM.getAmount(), theM.getCurrency());
			}
		}
		
		assert ret.toString().contains(theM.toString()) || ret.toString().contains(moneyAssert.toString()): "Post-condition échouée : modification incorrecte";
		
		assert ret.invariant() : "Invariant violé !";
		
		return ret;
	}
	
	/**
	 * Method allow to verify if two bags are the same
	 * @param otherBag - an other bag to test
	 * @throws NotTheSameException - if bags are different
	 */
	public void theSame(MoneyBag otherBag) throws NotTheSameException {
		if (otherBag == null) {
			throw new NotTheSameException("L'autre sac est nulle");
		}
		
		if (this.monies.size() != otherBag.monies.size()) {
			throw new NotTheSameException("Les sacs ne sont pas de la même taille");
		}
		
		for (int i = 0; i < this.monies.size(); i++) {
			if (!this.monies.get(i).equals(otherBag.monies.get(i))) {
				throw new NotTheSameException("Les sacs sont différents");
			}
		}			
	}
	
	/**
	 * Method allow to show properly
	 * @return a clean character string
	 */
	public String toString() {
		String ret = "(";
		if (!this.monies.isEmpty()) {
			for (int i = 0; i < this.monies.size() - 1; i++) {
				ret += this.monies.get(i) + ", ";
			}
			ret += this.monies.get(this.monies.size() - 1);
		}
		return ret + ")";
	}
	
	/**
	 * Method allow to know if attributes are valid
	 * @return true if valid, otherwise false
	 */
	private boolean invariant() {
		boolean ret = true;
		if (this.monies == null) {
			ret = false;
		} else {
			ArrayList<String> visites = new ArrayList<>();
			for (Money money : this.monies) {
				if (money == null) {
					ret = false;
				}
				
				if (money.getAmount() == 0) {
					ret = false;
				}
				
				String currency = money.getCurrency();
				if (currency == null || currency == "") {
					ret = false;
				}

				if (visites.contains(currency)) {
					ret = false;
				}
				visites.add(currency);
			}
		}
		return ret;
	}
}
