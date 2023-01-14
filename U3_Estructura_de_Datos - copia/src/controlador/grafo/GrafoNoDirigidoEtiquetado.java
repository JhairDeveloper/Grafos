/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.grafo;

import Controlador.Listas.ListaEnlazada;
import java.lang.reflect.Array;
import java.util.HashMap;

/**
 *
 * @author TecnoeXtrem
 */
public class GrafoNoDirigidoEtiquetado<E> extends GrafoNoDirigido{
    protected E etiquetas[];
    protected HashMap<E, Integer> dirVertices;
    private Class<E> clazz;
    
    public GrafoNoDirigidoEtiquetado(Integer numVert, Class clazz ){
        super(numVert);
        this.clazz = clazz;
        etiquetas = (E[]) Array.newInstance(clazz, numVert + 1);
        dirVertices = new HashMap(numVert);
    }
    
    public Boolean existeAristaE(E o, E d) throws  Exception{
        return this.existeArista(obtenerCodigoE(o), obtenerCodigoE(d));
    }
    
    public void insertarAristaE(E o, E d, Double peso) throws Exception {
        insertarArista(obtenerCodigoE(o), obtenerCodigoE(d), peso);
    }

    public void insertarAristaE(E o, E d) throws Exception {
        insertarArista(obtenerCodigoE(o), obtenerCodigoE(d));
    }

    public ListaEnlazada<Adyacencia> adyacentesE(E o) { ///VERIFICAR 
        return adyacentesE((E) obtenerCodigoE(o));
    }
    
    public Integer obtenerCodigoE(E etiqueta){
        return  dirVertices.get(etiqueta);
    }
    
    public E obtenerEtiqueta(Integer codigo) {
        return etiquetas[codigo];
    }

    public void etiquetarVertice(Integer codigo, E etiqueta) {
        etiquetas[codigo] = etiqueta;
        dirVertices.put(etiqueta, codigo);
    }
    
    @Override
    public String toString() {
        StringBuffer grafo = new StringBuffer("");

        try {
            for (int i = 1; i <= numVertices(); i++) {
                grafo.append("Vertice == ").append(String.valueOf(i) + " ");
                
                ListaEnlazada<Adyacencia> adyacenciaList = adyacentes(i);
                

                for (int j = 0; j < adyacenciaList.getSize(); j++) {
                    Adyacencia a = adyacenciaList.obtener(j);
                    
                    if (a.getPeso().toString().equalsIgnoreCase(String.valueOf(Double.NaN))) {
                        grafo.append("-- Vertice destino ").append(a.getDestino()).append(" -- SP");
//                        grafo.append("-- Grafo etiqueta --- " ).append(etiquetas[j]);
                    } else {
                        grafo.append("-- Vertice destino ").append(a.getDestino()).append(" -- Peso ").append(a.getPeso());
                    }
                    grafo.append("\n");
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        return grafo.toString();
    }
    
}
