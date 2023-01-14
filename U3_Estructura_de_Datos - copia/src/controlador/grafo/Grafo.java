/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.grafo;

import Controlador.Listas.ListaEnlazada;

/**
 *
 * @author TecnoeXtrem
 */
public abstract class Grafo {

    public abstract Integer numVertices();

    public abstract Integer numAristas();

    public abstract Boolean existeArista(Integer o, Integer d) throws Exception; // o de origen , y d de destino

    public abstract Object pesoArista(Integer o, Integer d);

    public abstract void insertarArista(Integer o, Integer d);

    public abstract void insertarArista(Integer o, Integer d, Double peso);

    // Vertice sconectados por arista
    public abstract ListaEnlazada<Adyacencia> adyacentes(Integer vertice);

    
    @Override
    public String toString() {
        StringBuffer grafo = new StringBuffer(""); // Presenta una cadena cuyo tamalio puede variar
        // consumined mas recursos del sitema
        
        try {
            for (int i = 1; i <= numVertices(); i++) {
                grafo.append("Vertice ").append(String.valueOf(i) + " "); //Ayuda a añadir un string
                // Clase abstracta 
                ListaEnlazada<Adyacencia> adyacenciaList = adyacentes(i);
                // Cargar la lista de adyacencias 

                for (int j = 0; j < adyacenciaList.getSize(); j++) {
                    // Instancear adyacencias
                    
                    Adyacencia a = adyacenciaList.obtener(j);
                    if (a.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                        grafo.append("-- Vertice destino * ").append(a.getDestino()).append(" -- SP");
                    } else {
                        grafo.append("-- Vertice destino ** ").append(a.getDestino()).append(" -- Peso ").append(a.getPeso());
                    }
                    grafo.append("\n");
                }
            }
        } catch (Exception e) {
            System.err.println("Error en toString de Grafo " + e.getMessage());
            e.printStackTrace();
        }
        
        return grafo.toString();
    }

}
