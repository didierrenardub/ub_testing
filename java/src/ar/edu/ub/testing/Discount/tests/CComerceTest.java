package ar.edu.ub.testing.Discount.tests;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;

//import org.graalvm.compiler.debug.Assertions_OptionDescriptors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

//import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

import ar.edu.ub.testing.Discount.CBrand;
import ar.edu.ub.testing.Discount.CCommerce;
import ar.edu.ub.testing.Discount.CProductInstance;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CCommerceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		String nameTest = new String("nameTest");
		Collection<CProductInstance> arrayTest = new ArrayList();
		CCommerce commerceTest = new CCommerce(nameTest);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
		assertNotNull(commerceTest.name());
		assertNotNull(commerceTest.branded(testBrand));
		assertNotNull(commerceTest.tagged(nameTest));
		assertNotNull(commerceTest.product(nameTest));
	}
	
	void testName() {
		assertEquals("nameTest", commerceTest.name());
		assertNotEquals("", commerceTest.name());
		assertNotEquals(" ", commerceTest.name());
	}
	
	void testBranded() {
		assertFalse(testBrand.name().equals(""));
		assertFalse(testBrand.name().equals(" "));
		assertEquals(arrayTest, commerceTest.branded(testBrand));
	}
	
	void testTagged() {
		assertFalse(String.valueOf(nameTest) != "");
		assertFalse(String.valueOf(nameTest) != " ");
		assertEquals(arrayTest, commerceTest.tagged(nameTest));
	}
	
	void testProduct() {
		assertFalse(testInstance.equals(null));
		assertEquals(testInstance, commerceTest.product(nameTest));
		assertNotEquals("", commerceTest.product(nameTest));
		assertNotEquals(" ", commerceTest.product(nameTest));
	}
	
	void addProductsTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			commerceTest.addProducts(arrayTest);
		});
	}
	
	void addProductTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			commerceTest.addProduct(testInstance);
		});
	}

	
	String nameTest;
	ArrayList<CProductInstance> arrayTest;
	CCommerce commerceTest;
	CProductInstance testInstance;
	CBrand testBrand;
}