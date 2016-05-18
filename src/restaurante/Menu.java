/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;
import java.text.NumberFormat;
import java.text.DecimalFormat;
/**
 *
 * @author Carmen
 */
public class Menu {
    private int idMenu;
    private int quantDias;
    private int numPratos;
    private double orcamento;
    private double maxLucro;
    private Prato[] pratos;
    private static int contID;
    private int contPratos;
    private IMetodo tipoMetodo;
    
    static
    {
        contID = 0;
    }
    
    public Menu()
    {
         this.idMenu = contID++;
         this.quantDias = this.contPratos = this.numPratos = 0;
         this.orcamento = this.maxLucro = 0;
         this.pratos = null;
    }
    
    public Menu(int quantDias, int numPratos, double orcamento, double maxLucro)
    {
        this.idMenu = contID++;
        this.quantDias = quantDias;
        this.numPratos = numPratos;
        this.orcamento = orcamento;
        this.maxLucro = maxLucro;
        this.pratos = new Prato[numPratos];
        this.contPratos = 0;
    }
    
    public Menu(int quantDias, int numPratos, double orcamento, Prato[] pratos)
    {
        this.idMenu = contID++;
        this.quantDias = quantDias;
        this.numPratos = numPratos;
        this.orcamento = orcamento;
        this.maxLucro = 0;
        this.pratos = pratos;
        this.contPratos = 0;
    }
    
    public void addPrato(Prato prato)
    {
        pratos[contPratos] = prato;
        contPratos++;
    }
    
    public double calcLucroMax()
    {
        this.maxLucro = tipoMetodo.calculaLucro(this);
        
        return this.maxLucro;
    }
    
    public void exibeMenu()
    {
        NumberFormat formatter = new DecimalFormat("00");
        String num = formatter.format(idMenu);
        System.out.println("Menu " + num + ": \n" +
                           "Quantidade de dias: " + quantDias + "\n" +
                           "Número de pratos: " + numPratos + "\n" +
                           "Orçamento: " + orcamento);
    }

    public int getIdMenu() {
        return idMenu;
    }

    public int getQuantDias() {
        return quantDias;
    }

    public void setQuantDias(int quantDias) {
        this.quantDias = quantDias;
    }

    public int getNumPratos() {
        return numPratos;
    }

    public void setNumPratos(int numPratos) {
        this.numPratos = numPratos;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public double getMaxLucro() {
        return maxLucro;
    }

    public void setMaxLucro(double maxLucro) {
        this.maxLucro = maxLucro;
    }

    public Prato[] getPratos() {
        return pratos;
    }

    public void setPratos(Prato[] pratos) {
        this.pratos = pratos;
    }

    public void setTipoMetodo(IMetodo tipoMetodo) {
        this.tipoMetodo = tipoMetodo;
    }
    
}
