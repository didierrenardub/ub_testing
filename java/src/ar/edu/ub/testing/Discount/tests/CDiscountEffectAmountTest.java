package ar.edu.ub.testing.Discount.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.ub.testing.Discount.CDiscountEffectAmount;
import ar.edu.ub.testing.Discount.CShoppingBasket;
import ar.edu.ub.testing.Discount.CShoppingBasketItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;

class CDiscountEffectAmountTest {

	
	
	private static final Object CDiscountInstance = null;
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		discount = new   CDiscountEffectAmount(20.0f,1);		
	
		
	}

	@Test
	void testCDiscountEffectAmount() {
		
		assertEquals(discount.amount(),20.0f);
		assertEquals(discount.maxCount(),1);
		
		
	}
	
	@Test
	void testMaxCount() {
		
		assertNotNull(discount.maxCount());
		assertEquals(discount.maxCount(),null );
		assertNotEquals(discount.maxCount(),-1);
		
		
	}
	
	@Test
	void testAmount() {
		
		assertNotNull(discount.amount());
		assertNotSame(discount.amount(),null);
	}
	
	@Test
	void testApply() {
		
		assertNull(discount.apply(null , null));
		CShoppingBasket basket = null;
		CShoppingBasketItem item = null;
		assertNull(discount.apply(basket, item));
		
	}

	CDiscountEffectAmount discount ;
	
	
}
