/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carmen
 */
public class MetodoGulosoTest {
    
    public MetodoGulosoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculaLucro method, of class MetodoGuloso.
     */
    @Test
    public void testCalculaLucro() {
        System.out.println("calculaLucro");
        Menu menu = new Menu(3, 5, 20, 0);
        
        Prato prato = new Prato(2, 5);
        menu.addPrato(prato);
        prato = new Prato(18, 6);
        menu.addPrato(prato);
        prato = new Prato(1, 1);
        menu.addPrato(prato);
        prato = new Prato(3, 3);
        menu.addPrato(prato);
        prato = new Prato(2, 3);
        menu.addPrato(prato);
        
        MetodoGuloso instance = new MetodoGuloso();
        double expResult = 13.0;
        instance.calculaLucro(menu);
        double result = menu.getMaxLucro();
        assertEquals(expResult, result, 0.0);
    }
    
}
