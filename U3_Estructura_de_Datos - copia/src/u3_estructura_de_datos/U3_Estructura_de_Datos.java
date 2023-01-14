/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package u3_estructura_de_datos;

import controlador.grafo.Grafo;
import controlador.grafo.GrafoDirigido;
import controlador.grafo.GrafoDirigidoEtiquetado;
import controlador.grafo.GrafoNoDirigido;
import controlador.grafo.GrafoNoDirigidoEtiquetado;
import vista.FrmGrafo;

/**
 *
 * @author TecnoeXtrem
 */
public class U3_Estructura_de_Datos {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic herez
//        GrafoDirigido grafoDirigido = new GrafoDirigido(4);
//
//        System.out.println(grafoDirigido);
//        System.out.println(" -------------------------------------- ");
//
//        try {
//            grafoDirigido.insertarArista(4, 4);
//            grafoDirigido.insertarArista(2, 3);
//            grafoDirigido.insertarArista(2, 2);
//            
//            grafoDirigido.insertarArista(4, 1);
////            grafoDirigido.insertarArista(3, 4);
//            
//            new FrmGrafo(null, true, grafoDirigido).setVisible(true);
//            System.out.println(grafoDirigido);
//        } catch (Exception e) {
//            System.out.println("Error en main: ");
//            System.out.println(e);
//        }

//        
//        System.out.println("GRAFO NO DIRIGIDO");
//        GrafoNoDirigido grafoNoDirigido = new GrafoNoDirigido(4);
//        System.out.println(grafoNoDirigido);

//        try {
//            grafoNoDirigido.insertarArista(4, 2);
//            grafoNoDirigido.insertarArista(4, 3);
//            grafoNoDirigido.insertarArista(4, 4);
//            
//            new FrmGrafo(null, true, grafoNoDirigido).setVisible(true);
//
//            System.out.println(grafoNoDirigido);
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//
//        GrafoDirigidoEtiquetado gde = new GrafoDirigidoEtiquetado(3, String.class);
//        System.out.println(gde.toString());
//        gde.etiquetarVertice(1, "A");
//        gde.etiquetarVertice(2, "B");
//        gde.etiquetarVertice(3, "C");
////        gde.etiquetarVertice(4, "D");
////        gde.etiquetarVertice(5, "E");
//        try {
//            gde.insertarAristaE(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(2), 10.0);
//            gde.insertarAristaE(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(3), 1000.0);
//            gde.insertarAristaE(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(1), 15.0);
////            gde.insertarAristaE(gde.obtenerEtiqueta(3), gde.obtenerEtiqueta(4), 20.0);
//            
//            new FrmGrafo(null, true, gde).setVisible(true);
//            System.out.println(gde.toString());
//        } catch (Exception e) {
//            System.out.println("Error en grafo etiquetado " + e);
//        }


        GrafoNoDirigidoEtiquetado gnde = new GrafoNoDirigidoEtiquetado(4, String.class);
        System.out.println(gnde.toString());
        gnde.etiquetarVertice(1, "A");
        gnde.etiquetarVertice(2, "B");
        gnde.etiquetarVertice(3, "C");
        gnde.etiquetarVertice(4, "D");
        try {
            gnde.insertarAristaE(gnde.obtenerEtiqueta(4), gnde.obtenerEtiqueta(3), 10.0);
            gnde.insertarAristaE(gnde.obtenerEtiqueta(4), gnde.obtenerEtiqueta(2), 1000.0);
            gnde.insertarAristaE(gnde.obtenerEtiqueta(4), gnde.obtenerEtiqueta(1), 15.0);
//            gnde.insertarAristaE(gnde.obtenerEtiqueta(3), gnde.obtenerEtiqueta(4), 20.0);
            
            new FrmGrafo(null, true, gnde).setVisible(true);
            System.out.println(gnde.toString());
        } catch (Exception e) {
            System.out.println("Error en grafo etiquetado " + e);
        }
    }
}
