package ar.edu.ub.testing.Discount.tests;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.ub.testing.Discount.CBrand;
import ar.edu.ub.testing.Discount.CCommerce;
import ar.edu.ub.testing.Discount.CDataManager;
import ar.edu.ub.testing.Discount.CDiscount;
import ar.edu.ub.testing.Discount.CDiscountConditionBrand;
import ar.edu.ub.testing.Discount.CDiscountEffectPercentage;
import ar.edu.ub.testing.Discount.CPayment;
import ar.edu.ub.testing.Discount.CProduct;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

class CDataManagerTest {

	@BeforeEach
	void setUp() throws Exception {
		  data= new  CDataManager();
		  brand = new CBrand("arcor");
		  product =new CProduct(brand,product.tags(), "melba", "galletitas");
		  pago = new CPayment("efectivo");
		  comercio= new CCommerce("coto");
		  discount = new CDiscount ("20% Bagley", "20% de descuento en productos Bagley", true, Arrays.asList(new CDiscountEffectPercentage(20.0f)), new CDiscountConditionBrand(data.brand("Bagley")));
		    
	}

	@Test
	void testBrands() {
		assertNotNull(data.brands());
		assertNotEquals(data.brands(),0);
		assertNotSame(data.brands().isEmpty(),true );
	}
	
	@Test
	void testProducts() {
		assertNotNull(data.products());
		assertNotEquals(data.products().size(),0);
		assertNotSame(data.products().isEmpty(),true );
		
	}
	
	@Test
	void testPayments() {
		assertNotNull(data.payments());
		assertNotEquals(data.payments().size(),0);
		assertNotSame(data.payments().isEmpty(),true );
	}
	
	@Test
	void testCommerces() {
		assertNotNull(data.commerces());
		assertNotEquals(data.commerces().size(),0);
		assertNotSame(data.commerces().isEmpty(),true );
	}
	
	@Test
	void testDiscounts() {
		assertNotNull(data.discounts());
		assertNotEquals(data.discounts().size(),0);
		assertNotSame(data.discounts().isEmpty(),true );
	}
	
	@Test
	void testAdd() {
		data.brands().add(brand);
		assertNotEquals(data.brands().contains(brand),false );
		assertNotNull(data.brands());
		assertNotEquals(data.brands(),0);
		assertNotSame(data.brands().isEmpty(),true );
	}
	
	@Test
	void testAddp() {
		data.products().add(product);
		assertNotEquals(data.products().contains(product),false );
		assertNotNull(data.products());
		assertNotEquals(data.products(),0);
		assertNotSame(data.brands().isEmpty(),true );
	}
	
	@Test
	void testAddpa() {
		data.payments().add(pago);
		assertNotEquals(data.payments().contains(pago),false );
		assertNotNull(data.payments());
		assertNotEquals(data.payments(),0);
		assertNotSame(data.payments().isEmpty(),true );
	}
	
	@Test
	void testAddc() {
		data.commerces().add(comercio);
		assertNotEquals(data.commerces().contains(comercio),false );
		assertNotNull(data.commerces());
		assertNotEquals(data.commerces(),0);
		assertNotSame(data.commerces().isEmpty(),true );
	}
	
	@Test
	void testAddd() {
		data.discounts().add(discount);
		assertNotEquals(data.discounts().contains(discount),false );
		assertNotNull(data.discounts());
		assertNotEquals(data.discounts(),0);
		assertNotSame(data.discounts().isEmpty(),true );
	}
	
	@Test
	void testAddproduc() {
		data.products().add(product);
		assertNotEquals(data.products().contains(product),false );
		assertNotNull(data.products());
		assertNotEquals(data.products(),0);
		assertNotSame(data.products().isEmpty(),true );
	}
	

	@Test
	void testAddBrands() {
		data.brands().add(brand);
		data.addBrands(data.brands());
		
		assertNotNull(data.brands());
		assertNotEquals(data.brands(),0);
		assertNotSame(data.brands().isEmpty(),true );
	}
	
	@Test
	void testAddProduct() {
		data.products().add(product);
		data.addProducts(data.products());
		
		assertNotNull(data.products());
		assertNotEquals(data.products(),0);
		assertNotSame(data.products().isEmpty(),true );
	}
	
	@Test
	void testAddPayments() {
		data.payments().add(pago);
		data.addPayments(data.payments());
		
		assertNotNull(data.payments());
		assertNotEquals(data.payments(),0);
		assertNotSame(data.payments().isEmpty(),true );
	}
	
	@Test
	void testAddCommerces() {
		data.commerces().add(comercio);
		data.addCommerces(data.commerces());
		
		assertNotNull(data.commerces());
		assertNotEquals(data.commerces(),0);
		assertNotSame(data.commerces().isEmpty(),true );
	}
	
	@Test
	void testAddDiscounts() {
		data.discounts().add(discount);
		data.addDiscounts(data.discounts());
		
		assertNotNull(data.discounts());
		assertNotEquals(data.discounts(),0);
		assertNotSame(data.discounts().isEmpty(),true );
	}
	
	@Test
	void testBrand() {
		assertNotNull(data.brand("arcor"));
		assertEquals(data.brand("arcor").name(),"arcor" );
		assertNotEquals(data.brand("arcor").name(),"");
	}
	
	@Test
	void testProduct() {
		assertNotNull(data.product("melba"));
		assertEquals(data.product("melba").name(),"melba" );
		assertNotEquals(data.product("melba").name(),"");
	}
	
	@Test
	void testPayment() {
		assertNotNull(data.payment("mastercard"));
		assertEquals(data.payment("mastercard").name(),"mastercard" );
		assertNotEquals(data.payment("mastercard").name(),"");
	}

	
	@Test
	void testCommerce() {
		assertNotNull(data.commerce("coto"));
		assertEquals(data.commerce("coto").name(),"coto" );
		assertNotEquals(data.commerce("coto").name(),"");
	}
	
	@Test
	void testDiscount() {
		assertNotNull(data.discount("20% Bagley"));
		assertEquals(data.discount("20% Bagley").name(),"20% Bagley" );
		assertNotEquals(data.discount("20% Bagley").name(),"");
	}
	
	
	CDataManager data;
	CBrand brand;
	CProduct product;
	CPayment pago;
	CDiscount discount;
	CCommerce comercio;
}
