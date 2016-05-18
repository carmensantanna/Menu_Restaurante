/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carmen
 */
public class CarregaArquivoTest {
    
    public CarregaArquivoTest() {
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
     * Test of leArquivo method, of class CarregaArquivo.
     */
    @Test
    public void testLeArquivo() {
        System.out.println("Ler um arquivo inexistente");
        CarregaArquivo instance = new CarregaArquivo("รง");
        ArrayList<Menu> result = instance.leArquivo();
        Assert.assertNull(result);
    }
    
    @Test
    public void testLeArquivoExist() {
        System.out.println("Ler um arquivo correto");
        CarregaArquivo instance = new CarregaArquivo("menu.txt");
        ArrayList<Menu> result = instance.leArquivo();
        Assert.assertNotNull(result);
    }

    /**
     * Test of getMenus method, of class CarregaArquivo.
     */
    @Test
    public void testGetMenus() {
        System.out.println("getMenus");
        CarregaArquivo instance = new CarregaArquivo("menu.txt");
        ArrayList<Menu> result = instance.leArquivo();
        Assert.assertNotNull(result);
    }
    
}
