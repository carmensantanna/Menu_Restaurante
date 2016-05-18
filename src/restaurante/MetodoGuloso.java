/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

/**
 *
 * @author Carmen
 */
public class MetodoGuloso implements IMetodo{
    
    private double lucroMax;
    private double[] razao;
    
    public double calculaLucro(Menu menu)
    {
        double quantOrc = 0;
        lucroMax = 0;
        Prato pratoAtual, ultimoPrato = new Prato();
        Prato[] pratos = menu.getPratos();
        QuickSort ordena = new QuickSort();
        
        for(int i = 0; i < menu.getQuantDias(); i++)
        {
            ordena.sort(pratos);
            pratoAtual = pratos[pratos.length - 1];
            quantOrc += pratoAtual.getCusto();
            
            if(quantOrc <= menu.getOrcamento())
            {
              if(pratoAtual.getIdPrato() != ultimoPrato.getIdPrato())
                  ultimoPrato.setRepetido(0);
              
              lucroMax += pratoAtual.getLucroAtual();
              pratoAtual.repetePrato();
              ultimoPrato = pratoAtual;
            }
            else
                lucroMax = 0;
        }
        return lucroMax;
    }
}
