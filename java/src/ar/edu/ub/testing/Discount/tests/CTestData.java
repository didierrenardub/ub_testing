package ar.edu.ub.testing.Discount.tests;

import java.util.Arrays;
import java.util.HashMap;

import ar.edu.ub.testing.Discount.CBrand;
import ar.edu.ub.testing.Discount.CCommerce;
import ar.edu.ub.testing.Discount.CDiscount;
import ar.edu.ub.testing.Discount.CDiscountConditionBrand;
import ar.edu.ub.testing.Discount.CDiscountConditionProduct;
import ar.edu.ub.testing.Discount.CDiscountEffectAmount;
import ar.edu.ub.testing.Discount.CDiscountEffectPercentage;
import ar.edu.ub.testing.Discount.CDataManager;
import ar.edu.ub.testing.Discount.CPayment;
import ar.edu.ub.testing.Discount.CProduct;
import ar.edu.ub.testing.Discount.CProductInstance;
import ar.edu.ub.testing.Discount.CShoppingBasket;

public class CTestData
{
	public CTestData()
	{
		this.m_data = new HashMap<>();

		CDataManager data = new CDataManager();
		
		data.addBrands(Arrays.asList(
				new CBrand("Bagley")
				, new CBrand("Terrabussi")));
		
		data.addProducts(Arrays.asList(
			new CProduct(data.brand("Bagley")
					, Arrays.asList("alimento", "galletitas", "chatarra")
					, "Sonrisas"
					, "Caritas rellenas de frambuesa")
			, new CProduct(data.brand("Bagley")
					, Arrays.asList("alimento", "galletitas", "chatarra")
					, "Panchitas"
					, "Caritas de chocolate rellenas de crema")
			, new CProduct(data.brand("Terrabussi")
					, Arrays.asList("alimento", "galletitas", "chatarra")
					, "Melba"
					, "Galletitas de chocolate rellenas de crema")
			, new CProduct(data.brand("Terrabussi")
					, Arrays.asList("alimento", "galletitas", "chatarra")
					, "Duquesa"
					, "Galletitas de vainilla rellenas de crema")));
		
		data.addPayments(Arrays.asList(
			new CPayment("Efectivo")
			, new CPayment("Visa")
			, new CPayment("Mastercard")));
		
		CCommerce coto = new CCommerce("Coto");
		coto.addProducts(Arrays.asList(
			new CProductInstance(data.product("Sonrisas"), 20.0f)
			, new CProductInstance(data.product("Melba"), 22.0f)));
		
		CCommerce carrefour = new CCommerce("Carrefour");
		carrefour.addProducts(Arrays.asList(
			new CProductInstance(data.product("Duquesa"), 18.0f)
			, new CProductInstance(data.product("Melba"), 23.0f)));
		
		CCommerce dia = new CCommerce("Dia");
		dia.addProducts(Arrays.asList(
			new CProductInstance(data.product("Panchitas"), 16.0f)
			, new CProductInstance(data.product("Duquesa"), 20.0f)));
		
		data.addCommerces(Arrays.asList(
				coto, carrefour, dia));
		
		CShoppingBasket basket = new CShoppingBasket();
		basket.addItems(Arrays.asList(
				));
		
		CDiscount bagleyDiscount = new CDiscount(
				"20% Bagley"
				, "20% de descuento en productos Bagley"
				, true
				, Arrays.asList(new CDiscountEffectPercentage(20.0f))
				, new CDiscountConditionBrand(data.brand("Bagley")));
		
		CDiscount melbaDiscount = new CDiscount(
				"$5 en Melba"
				, "$5 en Melba (maximo 5 unidades)"
				, true
				, Arrays.asList(new CDiscountEffectAmount(5.0f, 5))
				, new CDiscountConditionProduct(data.product("Melba")));
		
		data.addDiscounts(Arrays.asList(
				bagleyDiscount, melbaDiscount));
		
		this.addDataManager("default", data);
	}
	
	public void addDataManager(String datasetName, CDataManager data)
	{
		this.m_data.put(datasetName, data);
	}
	
	public CDataManager manager(String withName)
	{
		return this.m_data.get(withName);
	}
	
	private HashMap<String, CDataManager> m_data;
}
