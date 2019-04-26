package ar.edu.ub.testing.Discount.tests;
import ar.edu.ub.testing.Discount.CProduct;
import ar.edu.ub.testing.Discount.CBrand;
import ar.edu.ub.testing.Discount.CProductInstance;

import java.util.ArrayList;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CProductInstanceTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		float precioTest = 35;
		CBrand brandTest = new CBrand("brandTest");
		ArrayList<String> arrayTest = new ArrayList();
		CProduct producTest = new CProduct(brandTest,arrayTest, "nombre", "descripcion");
		CProductInstance producInstanceTest = new CProductInstance(producTest, precioTest);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCrearProductInstance(){
		assertNotNull(producTest);
		assertNotNull(preciotest);
		assertTrue(producTest instanceof CProduct);
		assertTrue(preciotest >=0);
	}
	
	CBrand brandTest;
	ArrayList<String> arrayTest;
	CProduct producTest;
	CProductInstance producInstanceTest;
	float preciotest;
	
	}
