/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante;

import java.util.ArrayList;

/**
 *
 * @author Carmen
 */
public interface IMetodo {
    
    public ArrayList<Prato> calculaLucro(Menu menu);
    public double getLucroMax();
}
