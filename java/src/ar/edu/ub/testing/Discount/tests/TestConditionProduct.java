
package ar.edu.ub.testing.Discount.tests;

import ar.edu.ub.testing.Discount.CDiscountConditionPayment;
import ar.edu.ub.testing.Discount.CDiscountConditionProduct;
import ar.edu.ub.testing.Discount.CPayment;
import ar.edu.ub.testing.Discount.CProduct;
import ar.edu.ub.testing.Discount.CProductInstance;
import ar.edu.ub.testing.Discount.CShoppingBasket;
import ar.edu.ub.testing.Discount.CShoppingBasketItem;
import java.time.LocalDate;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestConditionProduct {
    
    public TestConditionProduct() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        prod=null;
        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void createCondProduct(){
        assertNotEquals(null,new CDiscountConditionProduct(prod));
    }
    
    @Test
    public void createNullCondProduct(){
        assertEquals(null,new CDiscountConditionProduct(null));
    }
    
    @Test
    public void testMet()
    {
        CDiscountConditionProduct c = new CDiscountConditionProduct(prod);
        assertEquals(true,c.met(new CShoppingBasket(), new CShoppingBasketItem(new CPayment("name"), new CProductInstance(null, 20), 0)));
    }
    
    private CProduct prod;
}
