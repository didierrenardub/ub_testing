package ar.edu.ub.testing.Discount.tests;

        
import ar.edu.ub.testing.Discount.CBrand;
import ar.edu.ub.testing.Discount.CDiscountConditionOr;
import ar.edu.ub.testing.Discount.CDiscountConditionPayment;
import ar.edu.ub.testing.Discount.CDiscountConditionProduct;
import ar.edu.ub.testing.Discount.CPayment;
import ar.edu.ub.testing.Discount.CProduct;
import ar.edu.ub.testing.Discount.CProductInstance;
import ar.edu.ub.testing.Discount.CShoppingBasket;
import ar.edu.ub.testing.Discount.CShoppingBasketItem;
import ar.edu.ub.testing.Discount.IDiscountCondition;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.assertEquals;


class CDiscountConditionOrTest {

    Collection<IDiscountCondition> cond;
    Collection<String> tags;
    CPayment paym;
    CProduct prod;
    CProductInstance inst;
    CShoppingBasket basket;
    CShoppingBasketItem item;
    CDiscountConditionOr condOR;

    @BeforeEach
    public void setUp () throws Exception {
        cond = new ArrayList<>();
        tags = new ArrayList<>();
        paym = new CPayment("efectivo");
        prod = new CProduct(new CBrand("Colgate"), tags, "Colgate Total 12", "higiene");
        inst = new CProductInstance(prod, 20);
        basket = new CShoppingBasket();
        item = new CShoppingBasketItem(paym, inst, 1);
        condOR = new CDiscountConditionOr(cond);
        cond.add(new CDiscountConditionPayment(paym));
        cond.add(new CDiscountConditionProduct(prod));



    }

    @AfterEach
    public void tearDown() throws Exception{

    }


    @Test
    void met() {
        basket.addItem(item);
        assertEquals(true, condOR.met(basket, item));
    }

    @Test
    void metNull () throws Exception {
        basket.addItem(item);
        assertThrows(NullPointerException.class, () -> condOR.met(null, null));
    }

    @Test
    void createCOND (){
        new CDiscountConditionOr(cond);
    }


}