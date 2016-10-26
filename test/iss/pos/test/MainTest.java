package iss.pos.test;

import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Test;

import iss.pos.Main;
import iss.pos.Order;

public class MainTest {
	private Main main;

	public Order getOrder1(){
		Order o = new Order();		
        o.add(Products.GetProduct("A"), 2);
        return o;
	}

	@Test
	public void testFinalPurchaseValue1() throws IOException {

		Order fullorder = getOrder1();
		assertEquals(200.0, fullorder.getFinalPurchaseValue(), 0.001);
	}
	
	public Order getOrder2(){
		Order o = new Order();		
        o.add(Products.GetProduct("A"), 2);
        o.add(Products.GetProduct("B"), 3);
        o.add(Products.GetProduct("C"), 1);
        return o;
	}

	@Test
	public void testFinalPurchaseValue2() throws IOException {

		Order fullorder = getOrder2();
		assertEquals(600.0, fullorder.getFinalPurchaseValue(), 0.001);
	}
}
