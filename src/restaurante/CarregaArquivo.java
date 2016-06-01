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
    //Lê e carrega os dados do arquivo
    public ArrayList<Menu> leArquivo() {
        try {
            //Verifica se arquivo existe
            File file = new File(nomeArq);
            if (file.exists()) {
                //Objeto para leitura
                FileReader arq = new FileReader(nomeArq);
                BufferedReader leArq = new BufferedReader(arq);
                //Variáveis utilizadas
                Menu menu = new Menu();
                Prato prato = null;
                int numDias, quantPrato;
                double orcamento, custo, lucro;
                //Lê a primeira linha do arquivo
                String linha = leArq.readLine();
                String[] parts = linha.split(" ");
                numDias = Integer.parseInt(parts[0]);
                //Enquanto os dados não forem 0 (encerramento do arquivo)
                while (numDias != 0) {
                    //Lê o menu
                    if (parts.length == 3) {
                        quantPrato = Integer.parseInt(parts[1]);
                        orcamento = Double.parseDouble(parts[2]);
                        pratos = new Prato[quantPrato];
                        menu = new Menu(numDias, quantPrato, orcamento, pratos);
                        menus.add(menu);
                    }
                    //Lê e carrega os pratos de cada menu
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
                //Fecha o arquivo
                arq.close();
                //Retorna os menus carregados
                return menus;
            }

        } catch (IOException e) {//Exceção para tratar possíveis erros da abertura do arquivo
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        //Retorna nulo caso não seja possível ler o arquivo
        return null;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }
}
