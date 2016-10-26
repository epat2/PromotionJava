package iss.pos.test;

import static org.junit.Assert.*;

import org.junit.Test;
import iss.pos.*;
import iss.pos.promotion.*;

public class DiscountTest {

	@Test
	public void test1ABuy1Item() {
		
		//setup
		Promotion promo = new Promotion(); //TODO: setup the promotion as you see fit
		DiscountCalculator dc = new DiscountCalculator(promo);
		
		Order order = new Order(); //TODO: setup the order, you can refer to SampleTest.java for example
		Product productA = new Product("product_type_001","Shirt",100);
		Product productB = new Product("product_type_001","T-Shirt",100);
		order.add(productA, 1);
		order.add(productB, 1);
		
		//exercise
		Order newOrder = dc.calculateDiscount(order);
		
		//verify
		double expectedValue = 170;//TODO: set the expected value;
		System.out.println("newOrder.getTotalPrice(): "+newOrder.getTotalPrice());
		assertEquals(expectedValue, newOrder.getTotalPrice(),0.001);
        //TODO: add additional verification if necessary
	}

}
