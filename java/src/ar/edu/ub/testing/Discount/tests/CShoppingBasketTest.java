package ar.edu.ub.testing.Discount.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.ub.testing.Discount.CShoppingBasket;
import ar.edu.ub.testing.Discount.CShoppingBasketItem;
import ar.edu.ub.testing.Discount.CDataManager;

class CShoppingBasketTest
{

	@BeforeEach
	void setUp() throws Exception
	{
		testData = new ar.edu.ub.testing.Discount.tests.CTestData();
	}

	@Test
	void example()
	{
		CDataManager data = testData.manager("default");
		
		CShoppingBasket basket = new CShoppingBasket();
		basket.addItems(Arrays.asList(
			new CShoppingBasketItem(
					data.payment("Efectivo")
					, data.commerce("Coto").product("Melba")
					, 3)
			));
		
		basket.applyDiscount(data.discount("$5 en Melba"));

		assertEquals(66.0f, basket.total());
		assertEquals(15.0f, basket.totalDiscount());
		assertEquals(51.0f, basket.net());
	}
	
	private ar.edu.ub.testing.Discount.tests.CTestData testData;
}
