//Anup
package iss.pos.promotion;

public class Promotion {

	private double discountrate = 0.3;
	
	public double getDiscountrate() {
		return discountrate;
	}

	public boolean isPromotionApplicable(int itemposition){
		if(itemposition == 2)
			return true;
		else
			return false;
	}

}
