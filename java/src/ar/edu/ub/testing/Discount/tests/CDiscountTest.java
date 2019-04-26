/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Discount;

import ar.edu.ub.testing.Discount.CDiscount;
import ar.edu.ub.testing.Discount.CShoppingBasket;
import ar.edu.ub.testing.Discount.CShoppingBasketItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alejandra
 */
public class CDiscountTest {
    
    public CDiscountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        disTest = new CDiscount("name", "description", true, null);
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of name method, of class CDiscount.
     */
    @Test
    void nameTest(){
        assertNotNull(disTest.name());
        assertNotEquals(disTest.name(), "");
    }
    
    void descriptionTest(){
        assertNotNull(disTest.description());
        assertNotEquals(disTest.description(), "");
    }
    void cumulativeTest(){
        assertNotNull(disTest.cumulative());
    }
    
    void collectionTest(){
        assertNotNull(disTest.effects());
    }
    void conditionTest(){
        assertNotNull(disTest.condition());
    }
    void applicableTest(){
        CShoppingBasketItem item = null;
        CShoppingBasket bask = null;
        assertNotNull(disTest.applicable(bask,item));
    }
    
    void applyTest(){
        CShoppingBasket bask = null;
        assertNotNull(disTest.apply(bask));
    }
    CDiscount disTest;
    
}
