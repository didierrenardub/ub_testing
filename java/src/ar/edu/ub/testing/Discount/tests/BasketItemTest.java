
package ar.edu.ub.testing.Discount.tests;

import ar.edu.ub.testing.Discount.CPayment;
import ar.edu.ub.testing.Discount.CProduct;
import ar.edu.ub.testing.Discount.CProductInstance;
import ar.edu.ub.testing.Discount.CShoppingBasketItem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BasketItemTest {
    
    public BasketItemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    /*
    Creo todas instancias nulas de las clases para testear mas rapido.
    */
    @Before
    public void setUp() {
        pay=null;
        pinst=null;
        Item=new CShoppingBasketItem(pay,pinst,2);
    }
    
    @After
    public void tearDown() {
    }

    
    /*
    Metodo que testea el constructor con parametros validos
    */
    @Test
    public void createBasketItem(){
        assertNotEquals(null, new CShoppingBasketItem(pay, pinst, 20));
    }
    
    /*
    Metodo que testea que no se pueda mandar parametros null al constructor
    */
    @Test
    public void createNullBasketItem(){
        assertEquals(null, new CShoppingBasketItem(null, null, 20));
    }
    
    /*
    Metodo que testea que no se pueda agregar un item que no tenga stock
    Ingreso pago e instancia valida y count 0.
    */
    @Test
    public void createNoStockItem(){
        assertEquals(null, new CShoppingBasketItem(pay, pinst, 0));
    }
    
    /*
    Metodo que testea que no se pueda poner un numero invalido en el count
    */
    @Test
    public void addNegativeItem(){
        assertEquals(null, new CShoppingBasketItem(pay, pinst, -20));
    }
    
    /*
    Metodo que impide que el count sea una cantidad exagerada
    */
    @Test
    public void addMonsterItem(){
        assertEquals(null, new CShoppingBasketItem(pay, pinst, 200000));
    }
    
    /*
    Deberia existir un metodo que verifique el count con el stock disponible del producto.
    */
    
    /*
    Metodo que retorna un CPayment y testea que no devuelva un null
    */
    @Test
    public void getCPayment(){
          assertNotEquals(null, Item.payment());
    }
    
    /*
    Metodo que testea el retorno de una ProductInstance y que no retorne null
    */
    @Test
    public void getInstance(){
        assertNotEquals(null, Item.productInstance());
    }
    
    /*
    Metodo que testea el retorno del count del producto
    */
    @Test
    public void returnCount(){
        assertNotEquals(null, Item.count());
    }
    
    /*
    Metodo que testea que el count no retorne 0
    */
    @Test
    public void return0Count(){
        assertNotEquals(0, Item.count());
    }
    
    /*
    Metodo que testa que el count no retorne un numero invalido
    */
    @Test
    public void returnInvalidCount(){
        assertEquals(false, Item.count()<0);
    }
    
    /*
    Metodo que testea que el total sea valido (No de 0 ni negativo)
    */
    @Test
    public void getTotal(){
        assertEquals(false, Item.total()<0);   
    }
    
    /*
    Metodo que testea que le total no retorne null
    */
    @Test
    public void totalNotNull(){
        assertNotEquals(null, Item.total());
    }
    private CPayment pay;
    private CProductInstance pinst;
    private CShoppingBasketItem Item;
}
