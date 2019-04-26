package ar.edu.ub.testing.Discount.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.ub.testing.Discount.CBrand;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

class CBrandTest {

	
	private CBrand marca;
	private CBrand marca2;
	
	@BeforeEach
	void setUp() throws Exception {
		
		marca= new CBrand("bagley"); 
		marca2= new CBrand(null);
		
	}

	@Test
	void testCBrand() {
		assertNull(marca);
		assertNull(marca2);
	
	}
	
	@Test
	void testName() {
		assertNotNull(marca.name());
		assertSame(marca.name(),"");
		
	}
}
