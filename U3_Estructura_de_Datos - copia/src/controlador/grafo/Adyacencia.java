/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.grafo;

/**
 *
 * @author TecnoeXtrem
 */
public class Adyacencia {

    // de donde vas hasta donde terminas
    private Integer destino; // Se pone integer, porque se va a trabajar con nodos numericos, pero normalmente apunta a un nodo
    private Object peso; //porque el peso puede ser cualquier cosa, no necesariamente numerico
    // solo se puede tener un destino, por que se comprende en una adyacencia, de ahi el nodo puede tener varias adyacencias

    public Adyacencia() {
    }

    public Adyacencia(Integer destino, Object peso) {
        this.destino = destino;
        this.peso = peso;
    }

    public Integer getDestino() {
        return destino;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }

    public Object getPeso() {
        return peso;
    }

    public void setPeso(Object peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Adyacencia{" + "destino=" + destino + ", peso=" + peso + '}';
    }
}
