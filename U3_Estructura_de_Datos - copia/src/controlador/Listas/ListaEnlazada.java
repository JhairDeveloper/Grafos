package Controlador.Listas;

import Controlador.Listas.Excepciones.ListaNullException;
import Controlador.Listas.Excepciones.PosicionException;

public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;
    private Integer size;

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    public boolean estaVacia() {
        return cabecera == null;
    }

    /**
     * private Integer tamanio(){ Integer tamanio = 0; NodoLista <E> aux =
     * cabecera; while (aux != null) { tamanio++; aux = aux.getSiguiente(); }
     * return tamanio; }
     * @param dato
     */
    public void insertar(E dato) {
        NodoLista<E> nodo = new NodoLista<E>(dato, null);
        if (estaVacia()) {
            this.cabecera = nodo;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nodo);
        }
        size++;
    }

    public int getUltimaPosicionOcupada() {
        int posicion = 0;

        if (!estaVacia()) {
            NodoLista<E> aux = cabecera;
            posicion += 1;

            while (aux.getSiguiente() != null) {
                posicion += 1;
                aux = aux.getSiguiente();
            }
        }

        return posicion;
    }

    public void insertarCabecera(E dato) {
        NodoLista<E> nodo = new NodoLista<>(dato, null);
        if (estaVacia()) {
            insertar(dato);
        } else {
            nodo.setSiguiente(cabecera);
            cabecera = nodo;
            size++;
        }
    }

    public void insertarPosicion(E dato, Integer pos) throws PosicionException {
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            NodoLista<E> nodo = new NodoLista<>(dato, null);
            NodoLista<E> aux = cabecera;
            if (pos == (size - 1)) {
                insertar(dato);
            } else if (pos == 0) {
                insertarCabecera(dato);
            } else {
                for (int i = 0; i < pos - 1; i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nodo);
                nodo.setSiguiente(siguiente);
                size++;
            }
        } else {
            throw new PosicionException();
        }
    }

    public E obtener(Integer pos) throws ListaNullException, PosicionException {
        // System.out.println(estaVacia());
        if (!estaVacia()) {
            E dato = null;
            // System.out.println(pos + " - " + size);
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }
            } else {
                throw new PosicionException();
            }
            return dato;
        } else {
            throw new ListaNullException();
        }
    }

    public E eliminarDato(Integer pos) throws PosicionException, ListaNullException {
        E dato = null;
        if (!estaVacia()) {
            // System.out.println("Pocisión: " + pos + " Size: " + size + " Última: " + getUltimaPosicionOcupada());
            if (pos >= 0 && pos < size) {
                if (pos == 0) {
                    dato = cabecera.getDato();
                    cabecera = cabecera.getSiguiente();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos - 1; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                    NodoLista<E> proximo = aux.getSiguiente();
                    aux.setSiguiente(proximo.getSiguiente());
                    size--;
                }
                return dato;

            } else {
                throw new PosicionException("Error en eliminar dato: No existe la posicion dada");
            }

        } else {
            throw new ListaNullException("Error en eliminar dato: La lista esta vacia, por endde no hay esa posicion");
        }
    }

    public void imprimir() {
        System.out.println("Lista enlazada");
        NodoLista<E> aux = cabecera;
        while (aux != null) {
            System.out.println(aux.getDato().toString());
            aux = aux.getSiguiente();
        }
    }
}
