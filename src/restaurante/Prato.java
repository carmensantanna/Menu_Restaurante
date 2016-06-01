/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Carmen
 */
public class Prato {
    private int idPrato;
    private String nomePrato;
    private double custo;
    private double lucro;
    private double lucroAtual;
    private double razao;
    private int contRepeticao;
    private static int contID;
    
    static
    {
        contID = 0;
    }
    
    public Prato()
    {
        this.idPrato = contID++;
        NumberFormat formatter = new DecimalFormat("00");
        String num = formatter.format(idPrato);
        this.nomePrato = num;
        this.contRepeticao = 0;
        this.custo = this.lucro = this.lucroAtual = this.razao = 0;
    }
    
    public Prato(double custo, double lucro)
    {
        this.idPrato = contID++;
        NumberFormat formatter = new DecimalFormat("00");
        String num = formatter.format(idPrato);
        this.nomePrato = num;
        this.custo = custo;
        this.lucro = lucro;
        this.lucroAtual = lucro;
        this.razao = this.lucroAtual / this.custo;
        this.contRepeticao = 0;
    }
    
    public void repetePrato()
    {
        this.contRepeticao++;
        if(this.contRepeticao == 1)
            this.lucroAtual = this.lucroAtual / 2;
        else if(this.contRepeticao == 2)
            this.lucroAtual = 0;
        
        this.razao = this.lucroAtual / this.lucro;
    }
    
    public void exibe()
    {
        System.out.println("Prato " + this.nomePrato);
    }

    public int getIdPrato() {
        return idPrato;
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getLucro() {
        return lucro;
    }

    public double getLucroAtual() {
        return lucroAtual;
    }

    public void setLucroAtual(double lucroAtual) {
        this.lucroAtual = lucroAtual;
        this.razao = this.lucroAtual / this.custo;
    }

    public double getRazao() {
        return razao;
    }

    public void setRazao(double razao) {
        this.razao = razao;
    }

    public int repetido() {
        return contRepeticao;
    }

    public void setRepetido(int contRepeticao) {
        this.contRepeticao = contRepeticao;
        setLucroAtual(this.lucro);
    }
    
    
}
