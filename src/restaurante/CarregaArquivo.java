/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Carmen
 */
public class CarregaArquivo {
    private String nomeArq;
    private ArrayList<Menu> menus;
    private Prato[] pratos;
    
    public CarregaArquivo(String nomeArq)
    {
        this.nomeArq = nomeArq;
        menus = new ArrayList();
    }
    
    public ArrayList<Menu> leArquivo() {
        try {
            File file = new File(nomeArq);
            if (file.exists()) {
                FileReader arq = new FileReader(nomeArq);
                BufferedReader leArq = new BufferedReader(arq);
                Menu menu = new Menu();
                Prato prato = new Prato();
                int numDias, quantPrato;
                double orcamento, custo, lucro;

                String linha = leArq.readLine();
                String[] parts = linha.split(" ");
                numDias = Integer.parseInt(parts[0]);

                while (numDias != 0) {
                    if (parts.length == 3) {
                        quantPrato = Integer.parseInt(parts[1]);
                        orcamento = Double.parseDouble(parts[2]);
                        pratos = new Prato[quantPrato];
                        menu = new Menu(numDias, quantPrato, orcamento, pratos);
                        menus.add(menu);
                    }
                    if (parts.length == 2) {
                        custo = Double.parseDouble(parts[0]);
                        lucro = Double.parseDouble(parts[1]);
                        prato = new Prato(custo, lucro);
                        menu.addPrato(prato);
                    }

                    linha = leArq.readLine();
                    parts = linha.split(" ");
                    numDias = Integer.parseInt(parts[0]);
                }

                return menus;
            }

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        return null;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }
}
