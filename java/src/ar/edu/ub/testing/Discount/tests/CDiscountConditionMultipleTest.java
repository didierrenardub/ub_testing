package ar.edu.ub.testing.Discount.tests;

import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.ub.testing.Discount.CDiscountConditionMultiple;
import ar.edu.ub.testing.Discount.CShoppingBasket;
import ar.edu.ub.testing.Discount.CShoppingBasketItem;

class CDiscountConditionMultipleTest {

	@BeforeEach
	void setUp() throws Exception {
	    
		discountmult = new CDiscountConditionMultiple(null) {
			
			@Override
			public boolean met(CShoppingBasket basket, CShoppingBasketItem item) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

	@Test
	void testCDiscountConditionMultiple() {
		assertNotEquals(null,discountmult);
		
	}
	
	
	//No es posible traer la coleccion
	//no hay get y la coleccion es privada
	@Test
	void testAdd() {
		
	discountmult.add(null);
	
	
		
	}
	

	CDiscountConditionMultiple discountmult;
	
}
 