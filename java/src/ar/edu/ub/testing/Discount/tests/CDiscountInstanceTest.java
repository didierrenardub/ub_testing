package ar.edu.ub.testing.Discount.tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ar.edu.ub.testing.Discount.CDiscount;
import ar.edu.ub.testing.Discount.CDiscountInstance;
import ar.edu.ub.testing.Discount.CProductInstance;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class CDiscountInstanceTest {

	@BeforeEach
	void setUp() throws Exception {
		CDiscountInstance CdisInsTest = new CDiscountInstance(CDiscTest, CProdInsTest, 15, "Test");
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void discountTest() {
		assertNotNull(CdisInsTest.discount());
		assertEquals(CdisInsTest, CdisInsTest.discount());
	}

	void ProductInstanceTest() {
		assertNotNull(CdisInsTest.productInstance());
		assertEquals(CProdInsTest, CdisInsTest.productInstance());
	}
	
	void ammountTest() {
		assertNotNull(CdisInsTest.amount());
		assertEquals(15, CdisInsTest.amount());
		assertEquals(float.class, CdisInsTest.amount());
	}
	void nameTest() {
		assertNotNull(CdisInsTest.name());
		assertEquals("Test", CdisInsTest.name());
	}
	CDiscountInstance CdisInsTest;
	CProductInstance CProdInsTest;
	CDiscount CDiscTest;
}
