package iss.pos.promotion;

import java.util.List;

import iss.pos.Order;
import iss.pos.OrderItem;

public class DiscountCalculator {
	
	Promotion promo;
	
	public DiscountCalculator(Promotion promo){
		this.promo = promo;
	}
	
	public Order calculateDiscount(Order order){
		//loop through all order items
			//at the second item, check isPromotionApplicable?
				//if true, getPromotionrate and apple to item Product price
		List<OrderItem> items = order.getItems();
		for(OrderItem item : items ){
			int countofitemtoapplydiscount = item.getQuantity() / 2;

			int countofitemwithoutdiscount = item.getQuantity()  - countofitemtoapplydiscount;

			
			double priceBeforePromo = item.getProduct().getPrice();
			double priceAfterPromo = priceBeforePromo * (1-this.promo.getDiscountrate());

			System.out.println("count of item to apply discount: "+countofitemtoapplydiscount + " "+(countofitemtoapplydiscount*priceAfterPromo));
			System.out.println("count of item without discount: "+countofitemwithoutdiscount + " "+(countofitemwithoutdiscount*priceBeforePromo));			
			item.getProduct().setPrice((countofitemtoapplydiscount*priceAfterPromo) + (countofitemwithoutdiscount*priceBeforePromo));

		}
		return order;
	}
}
