package com.mycompany.app;
/**
* Class allow to 
* @author L. CARRE
* @version 1.0
*/
public class Money implements IMoney{
	
	/**
	 * The amount (sum of money) which can be positive, negative or zero
	 */
	private int amount; 
	
	/**
	 * The currency of the sum of money ("EUR", "USD", "CHF", "GBP", …)
	 */
	private String currency;
	
	/**
	 * Constructor of the class
	 * @param theAmnt - the amount of money
	 * @param theCurr - the currency of the money
	 */
	public Money(int theAmnt, String theCurr) throws RuntimeException {
		if (theAmnt != 0) {
			this.amount = theAmnt;
		} else {
			throw new RuntimeException("Montant nulle");
		}
		
		if (theCurr != null && theCurr != "") {
			this.currency = theCurr;
		} else {
			throw new RuntimeException("Devise vide");
		}
		
		assert this.invariant() : "Invariant violé !";
	}
	
	/**
	 * Getter method to get amount of money
	 * @return the amount of money
	 */
	public int getAmount() {
		return this.amount;
	}
		
	/**
	 * Getter method to get currency of the money
	 * @return the currency of the money
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Method allow to additionate two Money in a new instance Money
	 * @param theM - an other Money to additionate
	 * @return A new Money instance with additionate amount or a new bag with two monies
	 */
	public IMoney add(Money theM) {
		if (theM == null) {
            throw new IllegalArgumentException("Argument null dans add");
        }
        
        IMoney ret;
		if (theM.getCurrency().equals(this.getCurrency())) {
			ret = new Money(this.getAmount() + theM.getAmount(), this.getCurrency());
			
			assert ret instanceof Money : "Post-condition échouée : résultat attendu de type Money";
			assert ((Money) ret).getAmount() == this.amount + theM.getAmount() : "Post-condition échouée : somme incorrecte";
			assert ((Money) ret).getCurrency().equals(this.currency) : "Post-condition échouée : devise modifiée";
		} else {
			Money[] monies = new Money[2];
			monies[0] = this;
			monies[1] = theM;
			ret = new MoneyBag(monies);
			
			assert ret instanceof MoneyBag : "Post-condition échouée : résultat attendu de type MoneyBag";
			assert ret.toString().contains(this.toString()) && ret.toString().contains(theM.toString()) : "Post-condition échouée : le sac ne contient pas les deux montants";

		}
		
		assert this.invariant() : "Invariant violé !";
		
		return ret;
	}
	
	/**
	 * Method allow to know if two Money instances are the same
	 * @param otherM - an other Money to additionate
	 * @return if are the same true, else false
	 */
	public boolean equals(Money otherM) {
		return ((this.getAmount() == otherM.getAmount()) && (this.getCurrency().equals(otherM.getCurrency())));
	}	
	
	/**
	 * Method allow to show properly
	 * @return a clean character string
	 */
	public String toString() {
		return this.amount + " " + this.currency;
	}	
	
	/**
	 * Method allow to know if attributes are valid
	 * @return true if valid, otherwise false
	 */
	private boolean invariant() {
		return (this.amount != 0 && this.currency != null && this.currency != "");
	}
}
