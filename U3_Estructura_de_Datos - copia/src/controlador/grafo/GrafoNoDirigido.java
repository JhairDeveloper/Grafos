/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.grafo;

import controlador.grafo.exception.VerticeOfSizeException;

/**
 *
 * @author TecnoeXtrem
 */
public class GrafoNoDirigido extends GrafoDirigido {

    public GrafoNoDirigido(Integer numV) {
        super(numV);
    }

    @Override
    public void insertarArista(Integer o, Integer d, Double peso) {
        try {
            if (o.intValue() == getNumVertices() && d.intValue() <= getNumVertices()) {
                if (!existeArista(o, d)) {
                    System.out.println("Dentro de no dirigido");
                    setNumAristas(getNumAristas() + 1);
                    getListaAdyacente()[o].insertar(new Adyacencia(d, peso));
                    getListaAdyacente()[d].insertar(new Adyacencia(o, peso));
                }
            } else {
                throw new VerticeOfSizeException();
            }
        } catch (Exception e) {
            System.out.println("Error en insertarArista en GrafoNoDirigido : " + e);
        }
    }
    
    
}
