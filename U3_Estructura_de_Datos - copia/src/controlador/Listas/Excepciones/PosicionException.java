/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Listas.Excepciones;

/**
 *
 * @author Admin
 */
public class PosicionException extends Exception{

    public PosicionException(String msg) {
        super(msg);
    }

    public PosicionException() {
    super("Esta fuera de los limites");
    }
    
}
