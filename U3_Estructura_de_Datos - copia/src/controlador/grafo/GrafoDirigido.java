/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.grafo;

import Controlador.Listas.ListaEnlazada;
import controlador.grafo.exception.VerticeOfSizeException;

/**
 *
 * @author TecnoeXtrem
 */
public class GrafoDirigido extends Grafo {

    private Integer numVertices;
    private Integer numAristas;
    private ListaEnlazada<Adyacencia> listaAdyacente[];
    private Integer origen;

    public GrafoDirigido(Integer numVertices) {

        this.numVertices = numVertices;
        numAristas = 0;
        listaAdyacente = new ListaEnlazada[numVertices + 1];

        for (int i = 0; i <= this.numVertices; i++) {
            listaAdyacente[i] = new ListaEnlazada<>();
        }
    }

    @Override
    public Integer numVertices() {
        return numVertices;
    }

    @Override
    public Integer numAristas() {
        return numAristas;
    }

    @Override
    public Boolean existeArista(Integer o, Integer d) throws Exception {
        Boolean existe = false;

        if (o.intValue() <= numVertices && d.intValue() <= numVertices) {
            ListaEnlazada<Adyacencia> lista = listaAdyacente[o];//4 , 4, 4
//            System.out.println("Ultima posicion  " + lista.getUltimaPosicionOcupada());
            for (int i = 0; i < lista.getUltimaPosicionOcupada(); i++) { // 4
                Adyacencia a = lista.obtener(i);
//                System.out.println("Adyacencia " + a);
                if (a.getDestino().intValue() == d.intValue()) {
//                    System.out.println("Existe " + a.getDestino().intValue());
                    existe = true;
                    break;
                }
            }
        } else {
            // TODO Exception VerticeOfSize
            throw new VerticeOfSizeException();
        }
        return existe;
    }

    @Override
    public Double pesoArista(Integer o, Integer d) {
        Double peso = Double.NaN;
        try {
            if (existeArista(o, d)) {
                ListaEnlazada<Adyacencia> adyacentes = listaAdyacente[o];

                for (int i = 0; i < adyacentes.getUltimaPosicionOcupada(); i++) {
                    Adyacencia a = adyacentes.obtener(i);

                    if (a.getDestino().intValue() == d.intValue()) {
                        peso = (double) a.getPeso();
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return peso;
    }

    @Override
    public void insertarArista(Integer o, Integer d, Double peso) {
        try {
            if (d.intValue() <= numVertices && o >= 0 && d <= numVertices) {

                if (!existeArista(o, d)) {
                    numAristas++;
                    listaAdyacente[o].insertar(new Adyacencia(d, peso));
                    if (origen == null) {
                        origen = o;
                    } else if (origen == o) {
                        numAristas++;
                        listaAdyacente[o].insertar(new Adyacencia(d, peso));
                        origen = o;
                    } else {
                        numAristas++;
                        listaAdyacente[origen].insertar(new Adyacencia(d, peso));
                    }
                }
            } else {
                throw new VerticeOfSizeException();
            }
        } catch (Exception e) {
            System.out.println("Error en insertarArista: " + e);
        }
    }

    @Override
    public ListaEnlazada<Adyacencia> adyacentes(Integer vertice) {
        return listaAdyacente[vertice];
    }

    @Override
    public void insertarArista(Integer o, Integer d) {
        insertarArista(o, d, Double.NaN);
    }

    public Integer getNumVertices() {
        return numVertices;
    }

    public Integer getNumAristas() {
        return numAristas;
    }

    public void setNumAristas(Integer numA) {
        this.numAristas = numA;
    }

    public ListaEnlazada<Adyacencia>[] getListaAdyacente() {
        return listaAdyacente;
    }

}
