/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Carmen
 */
public class Restaurante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarregaArquivo carregaArq = new CarregaArquivo("menu.txt");
        
        ArrayList<Menu> menus = carregaArq.leArquivo();
        IMetodo calcLucro;
        
        Iterator<Menu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            Menu menu = iterator.next();
            menu.exibeMenu();
            calcLucro = new MetodoGuloso();
            menu.setTipoMetodo(calcLucro);
            double lucro = menu.calcLucroMax();
            System.out.println("Lucro máximo desse menu: " + lucro);
        }
    }
    
}
