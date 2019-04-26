package ar.edu.ub.testing.Discount.tests;

import ar.edu.ub.testing.Discount.CPayment;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PaymentTest {
    
    public PaymentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void createCPayment(){
        assertNotEquals(null,new CPayment("Pay1"));
    }
    
    @Test
    public void createNullPayment(){
        assertEquals(null,new CPayment(null));
    }
    
    @Test
    public void testNameMethod(){
        CPayment cPayment = new CPayment("Pay1");
        assertNotEquals(null,cPayment.name());
    }
}
