import ar.edu.ub.testing.Discount.CDataManager;
import ar.edu.ub.testing.Discount.CPayment;
import ar.edu.ub.testing.Discount.CProductInstance;
import ar.edu.ub.testing.Discount.CShoppingBasketItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CShoppingBasketItemTest
{
    @Test
    public void testConstructorParametersValid()
    {
        CDataManager data = m_testData.manager("default");
        CShoppingBasketItem item = new CShoppingBasketItem(
                data.payment("Visa"),
                new CProductInstance(data.product("Sonrisas"), 80.0f),
                3);

        assertEquals(data.payment("Visa"), item.payment());
        assertEquals(data.product("Sonrisas"), item.productInstance().product());
        assertEquals(3, item.count());
    }

    @Test
    public void testConstructorParametersNullPayment()
    {
        CDataManager data = m_testData.manager("default");
        CShoppingBasketItem item = new CShoppingBasketItem(
                null,
                new CProductInstance(data.product("Sonrisas"), 80.0f),
                3);

        assertNotNull(item.payment());
    }

    @Test
    public void testConstructorParametersInvalidPayment()
    {
        CDataManager data = m_testData.manager("default");
        CShoppingBasketItem item = new CShoppingBasketItem(
                new CPayment("Invalid"),
                new CProductInstance(data.product("Sonrisas"), 80.0f),
                3);

        assertNull(data.payment(item.payment().name()));
    }

    @Test
    public void testConstructorParametersNullProductInstance()
    {
        CDataManager data = m_testData.manager("default");
        CShoppingBasketItem item = new CShoppingBasketItem(
                data.payment("Visa"),
                null,
                3);

        assertNull(item.productInstance());
    }

    @Test
    public void testConstructorParametersInvalidProductInstanceNullProduct()
    {
        CDataManager data = m_testData.manager("default");
        CShoppingBasketItem item = new CShoppingBasketItem(
                data.payment("Visa"),
                new CProductInstance(null, 80.0f),
                3);

        assertNull(item.productInstance());
    }

    @Test
    public void testConstructorParametersInvalidProductInstanceNegativePrice()
    {
        CDataManager data = m_testData.manager("default");
        CShoppingBasketItem item = new CShoppingBasketItem(
                data.payment("Visa"),
                new CProductInstance(data.product("Sonrisas"), -80.0f),
                3);

        assertNull(item.productInstance());
    }

    private ar.edu.ub.testing.Discount.tests.CTestData m_testData = new ar.edu.ub.testing.Discount.tests.CTestData();
}
