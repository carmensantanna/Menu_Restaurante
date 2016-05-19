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
    //Calcula e retorna o lucro máximo de um determinado menu
    public double calculaLucro(Menu menu)
    {
        double quantOrc = 0;
        lucroMax = 0;
        Prato pratoAtual, ultimoPrato = new Prato();
        //Pega todos os pratos do menu
        Prato[] pratos = menu.getPratos();
        //Instancia objeto da classe de ordenação
        QuickSort ordena = new QuickSort();
        //Para cada dia do cardápio calcula o prato que possui a melhor razão(lucro/custo)
        for(int i = 0; i < menu.getQuantDias(); i++)
        {
            //Ordena os possíveis pratos do dia pela razão em ordem crescente
            ordena.sort(pratos);
            //Pega o prato com a maior razão
            pratoAtual = pratos[pratos.length - 1];
            //Soma o custo do prato no orçamento total
            quantOrc += pratoAtual.getCusto();
            //Verifica se ainda está dentro do orçamento
            if(quantOrc <= menu.getOrcamento())
            {
              //Verifica se o prato está ou não sendo repetido
              if(pratoAtual.getIdPrato() != ultimoPrato.getIdPrato())
                  ultimoPrato.setRepetido(0);
              //Soma o lucro do prato no lucro total (lucro máximo)
              lucroMax += pratoAtual.getLucroAtual();
              //Marca que este prato foi utilizado
              pratoAtual.repetePrato();
              //Guarda o prato atual para verificar se será repetido no próximo dia
              ultimoPrato = pratoAtual;
            }
            else //Orçamento estourado
                lucroMax = 0;
        }
        //Retorna o lucro máximo calculado 
        return lucroMax;
    }
}
