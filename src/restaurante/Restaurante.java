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
        
        System.out.println("----- MÉTODO DINÂMICO -----");

        long tempoInicio = System.currentTimeMillis();

        IMetodo algoritmo = new MetodoDinamico();
        executaAlgoritmo(menus, algoritmo);
        System.out.println("Tempo de execução: " + (System.currentTimeMillis() - tempoInicio) + "ms");

        System.out.println("\n\n----- MÉTODO GULOSO -----");

        tempoInicio = System.currentTimeMillis();

        algoritmo = new MetodoGuloso();
        executaAlgoritmo(menus, algoritmo);
        System.out.println("Tempo de execução: " + (System.currentTimeMillis() - tempoInicio) + "ms");
       
    }

    public static void executaAlgoritmo(ArrayList<Menu> menus, IMetodo algoritmo) {
        ArrayList<Prato> pratosLucro;
        IMetodo calcLucro;

        Iterator<Menu> iterator = menus.iterator();
        while (iterator.hasNext()) {
            Menu menu = iterator.next();
            menu.setTipoMetodo(algoritmo);
            pratosLucro = menu.calcLucroMax();
            System.out.println(menu.getMaxLucro());
            exibeLista(pratosLucro);
        }
    }

    public static void exibeLista(ArrayList<Prato> pratos) {
        Iterator<Prato> itPrato = pratos.iterator();

        if (pratos.size() > 0) {
            while (itPrato.hasNext())
                System.out.print(itPrato.next().getIdPrato() + " ");
            System.out.println();
        }
    }

}
