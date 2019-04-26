package ar.edu.ub.testing.Discount.tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import ar.edu.ub.testing.Discount.CDiscountEffectPercentage;
import ar.edu.ub.testing.Discount.CShoppingBasket;
import ar.edu.ub.testing.Discount.CShoppingBasketItem;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

class CDiscountEffectPercentageTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		CDiscountEffectPercentage testDEP = new CDiscountEffectPercentage(1,1);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertNotNull(testDEP.percentage());
		assertNotNull(testDEP.maxAmount());
		assertNotNull(testDEP.apply(basket, item));
	}
	
	void testPercentage() {
		assertEquals(1, testDEP.percentage());
		assertEquals(float.class, testDEP.percentage());
	}
	
	void testmaxAmount() {
		assertEquals(1, testDEP.maxAmount());
		assertEquals(float.class, testDEP.maxAmount());
	}
	
	CDiscountEffectPercentage testDEP;
	CShoppingBasket basket;
	CShoppingBasketItem item;
}