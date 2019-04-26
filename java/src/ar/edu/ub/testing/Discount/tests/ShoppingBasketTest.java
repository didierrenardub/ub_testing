package ar.edu.ub.testing.Discount.tests;

import ar.edu.ub.testing.Discount.CBrand;
import ar.edu.ub.testing.Discount.CDiscount;
import ar.edu.ub.testing.Discount.CProduct;
import ar.edu.ub.testing.Discount.CShoppingBasket;
import ar.edu.ub.testing.Discount.CShoppingBasketItem;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingBasketTest {
    
    public ShoppingBasketTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        basket=null;
        bItem=null;
        prod=null;
        brand=null;
        disc=null;
        listProd=null;
    }
    
    @After
    public void tearDown() {
    }

   
    /*
    Metodo que testea el constructor de ShopingBasket. Como no se pasan parametros,
    el constructor resuelve todo solo no hay mucho para testear.
    */
    @Test
    public void createBasket(){
         assertNotEquals(null,new CShoppingBasket());
    }
    
    /*
    Metodo que retorna la canasta de los items de la Basket. (No puede devolver null)
    */
    @Test
    public void getItemsCanasta(){
        assertNotEquals(null, basket.items());           
    }
    
    /*
    Metodo que retorna la canasta de los descuentos. (No puede ser nulo)
    */
    @Test
    public void getDiscounts(){
        assertNotEquals(null, basket.discounts());
    }
    
    /*
    Metodo que prueba agregar un item a la lista. Cambiaria a que retorne true
    si lo agrega exitosamente y que retorne false de lo contrario para poder testearlo.
    */
    @Test
    public void agregarItemValido(){
        basket.addItem(bItem);
        assertEquals(true, basket.items().contains(bItem));        
    }
   
    /*
    Metodo que testea agregar un descuento
    */
    @Test
    public void agregarUnDescuento(){
        basket.applyDiscount(disc);
        assertEquals(true, basket.discounts().contains(disc));
    }
    
    /*
    Metodo que testea agregar una lista de items
    */
    @Test
    public void agregarListaItems(){
        basket.addItems(listProd);
        assertEquals(true, basket.discounts().containsAll(listProd));
    }
    
    /*
    Metodo para testear el removeItem
    */
    @Test
    public void removeItem(){
        basket.addItem(bItem);
        basket.removeItem(bItem);
        assertEquals(false, basket.items().contains(bItem));
    }
    
    
    /*
    Metodo que testea el total de la basket
    */
    @Test
    public void getTotal(){
        assertNotEquals(null, basket.total());
    }
    
    /*
    Metodo que testea que le total de la compra sea un numero valido.
    */
    @Test
    public void validarTotal(){
        assertEquals(false,basket.total()<0);
            
    }
    
    /*
    Metodo que testea el total de descuento
    */
    @Test
    public void getTotalDiscount(){
        assertNotEquals(null, basket.totalDiscount());
    }
    
    /*
    Metodo que testea que le total de discount sea un numero valido.
    */
    @Test
    public void validarTotalDiscount(){
        assertEquals(false,basket.totalDiscount()<0);
    }
    
    /*
    Metodo que devuelve el neto de la compra.
    */
    @Test
    public void traerNetCompra(){
        assertNotEquals(null, basket.net());
    }
    
    /*
    Metodo que valida el numero que retorna net
    */
    @Test
    public void validarNet(){
        assertEquals(false,basket.net()<0);
    }
        
    /*
    Metodo que testea el hasDiscount
    */
    @Test
    public void testHasDisc(){
        assertNotEquals(null,basket.hasDiscountOnProduct(prod));
    }
    
    /*
    Metodo que testea el has discount on brand
    */
    @Test
    public void brandHasDisc(){
        assertNotEquals(null,basket.hasDiscountOnBrand(brand));
    }
    
    /*
    Metodo que testea el return del ticket valido
    */
    @Test
    public void getTicket(){
        assertNotEquals(null, basket.ticket());
    }
    
    /*
    Metodo que testee que el String contenga algun caracter.
    */
    @Test
    public void checkStringValue(){
        String msj = basket.ticket();
        String [] splTicket=msj.split("");
        boolean valido=false;
        for (String letra : splTicket) {
            if(!"".equals(letra))valido=true;
        }
        
        assertNotEquals(false, valido);
    }
    
    private CShoppingBasket basket;
    private CShoppingBasketItem bItem;
    private CProduct prod;
    private CBrand brand;
    private CDiscount disc;
    private Collection<CShoppingBasketItem> listProd;
    
}
