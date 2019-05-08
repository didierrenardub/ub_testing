package ar.edu.ub.testing.Discount.tests;

import ar.edu.ub.testing.Discount.CBrand;
import ar.edu.ub.testing.Discount.CDiscountConditionAnd;
import ar.edu.ub.testing.Discount.CDiscountConditionPayment;
import ar.edu.ub.testing.Discount.CDiscountConditionProduct;
import ar.edu.ub.testing.Discount.CPayment;
import ar.edu.ub.testing.Discount.CProduct;
import ar.edu.ub.testing.Discount.CProductInstance;
import ar.edu.ub.testing.Discount.CShoppingBasket;
import ar.edu.ub.testing.Discount.CShoppingBasketItem;
import ar.edu.ub.testing.Discount.IDiscountCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CDiscountConditionAndTest {

    Collection<IDiscountCondition> cond;
    Collection<String> tags;
    CPayment paym;
    CProduct prod;
    CProductInstance inst;
    CShoppingBasket basket;
    CShoppingBasketItem item;
    CDiscountConditionAnd condAnd;

    @BeforeEach
    void setUp() {
        cond = new ArrayList<>();
        tags = new ArrayList<>();
        paym = new CPayment("tarjeta");
        prod = new CProduct(new CBrand("Colgate"), tags, "Colgate Total 12", "higiene");
        inst = new CProductInstance(prod, 20);
        basket = new CShoppingBasket();
        item = new CShoppingBasketItem(paym, inst, 1);
        condAnd = new CDiscountConditionAnd(cond);
        cond.add(new CDiscountConditionPayment(paym));
        cond.add(new CDiscountConditionProduct(prod));
    }


    @Test
    void metTrue() {
        basket.addItem(item);
        assertEquals(true, condAnd.met(basket, item));
    }

    @Test
    void metFalse() {
        basket.addItem(item);
        assertEquals(false, condAnd.met(basket, item));
    }

    @Test
    void metNull () throws Exception {
        basket.addItem(item);
        assertThrows(NullPointerException.class, () -> condAnd.met(null, null));
    }


    @Test
    void createCOND (){
        new CDiscountConditionAnd(cond);
    }


}