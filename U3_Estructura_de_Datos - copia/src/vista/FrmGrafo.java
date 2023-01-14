/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Controlador.Listas.ListaEnlazada;
import com.mxgraph.layout.mxGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.util.mxMorphing;
import com.mxgraph.util.mxEvent;
import com.mxgraph.util.mxEventObject;
import com.mxgraph.util.mxEventSource;
import com.mxgraph.view.mxGraph;
import controlador.grafo.Adyacencia;
import controlador.grafo.Grafo;
import controlador.grafo.GrafoDirigidoEtiquetado;
import controlador.grafo.GrafoNoDirigido;
import controlador.grafo.GrafoNoDirigidoEtiquetado;
import java.awt.BorderLayout;
import java.awt.Dimension;

/**
 *
 * @author TecnoeXtrem
 */
public class FrmGrafo extends javax.swing.JDialog {

    private Grafo grafo;

    /**
     * Creates new form FrmGrafo1
     */
    public FrmGrafo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public FrmGrafo(java.awt.Frame parent, boolean modal, Grafo grafo) {
        super(parent, modal);
        this.grafo = grafo;
        initComponents();
        cargarDatos();
    }

    private void cargarDatos() {
        mxGraph graph = new mxGraph(); // Desig a new
        mxGraphComponent graphComponent = new mxGraphComponent(graph);
        graphComponent.setSize(new Dimension(400, 400));
        jPanel1.add(graphComponent, BorderLayout.CENTER);
        GrafoNoDirigido gnd = new GrafoNoDirigido(1);
        GrafoNoDirigidoEtiquetado gnde = new GrafoNoDirigidoEtiquetado(1, String.class);
        GrafoDirigidoEtiquetado gde = new GrafoDirigidoEtiquetado(1, String.class);
        Object parent = graph.getDefaultParent();
        try {
            System.out.println("Num ver: " + grafo.numVertices());
            for (int i = 1; i <= grafo.numVertices(); i++) {
                Object start;
                if (grafo.getClass() == gnde.getClass() || grafo.getClass() == gde.getClass()) {
                    if (grafo.getClass() == gnde.getClass()) {
                        gnde = (GrafoNoDirigidoEtiquetado) grafo;
                        start = graph.insertVertex(parent, String.valueOf(gnde.obtenerEtiqueta(i)), String.valueOf(gnde.obtenerEtiqueta(i)), 100, 100, 80, 30);
                    } else {
                        System.out.println("ON GDE");
                        gde = (GrafoDirigidoEtiquetado) grafo;
                        start = graph.insertVertex(parent, String.valueOf(gde.obtenerEtiqueta(i)), String.valueOf(gde.obtenerEtiqueta(i)), 100, 100, 80, 30);
                    }
                }else{
                     start = graph.insertVertex(parent, String.valueOf(i), String.valueOf(i), 100, 100, 80, 30);
                }
                ListaEnlazada<Adyacencia> lista = grafo.adyacentes(i);
                System.out.println("Vertice  " + i);

                for (int j = 0; j < lista.getSize(); j++) {
                    System.out.println("Lista " + lista.getSize());
                    Adyacencia a = lista.obtener(j);

                    Object dest = graph.insertVertex(parent, String.valueOf(j), String.valueOf(j), 100, 100, 80, 30);
                    graph.insertEdge(parent, null, String.valueOf(a.getPeso()), start, dest);

                    if (grafo.getClass() == gnd.getClass() || grafo.getClass() == gnde.getClass()) {
                        graph.insertEdge(parent, null, String.valueOf(a.getPeso()), dest, start);
                        dest = graph.insertVertex(parent, String.valueOf(j), String.valueOf(j), 100, 100, 80, 30);
                    }
                    if (grafo.getClass() == gnde.getClass() || grafo.getClass() == gde.getClass()) {
                        if (grafo.getClass() == gnde.getClass()) {
                            gnde = (GrafoNoDirigidoEtiquetado) grafo;
                            dest = graph.insertVertex(parent, String.valueOf(gnde.obtenerEtiqueta(j)), String.valueOf(gnde.obtenerEtiqueta(j)), 100, 100, 80, 30);
                        } else {
                            gde = (GrafoDirigidoEtiquetado) grafo;
                            dest = graph.insertVertex(parent, String.valueOf(gde.obtenerEtiqueta(i)), String.valueOf(gde.obtenerEtiqueta(i)), 100, 100, 80, 30);
                        }
                    }

//                    start = graph.insertVertex(parent, String.valueOf(j), String.valueOf(j), 100, 100, 80, 30);
//                    System.out.println("a " + a);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en cargar datos " + e);
        } finally {
            graph.getModel().endUpdate();
        }
        morphGraph(graph, graphComponent);
    }

    private static void morphGraph(mxGraph graph, mxGraphComponent graphComponent) {
        mxGraphLayout layout = new mxGraphLayout(graph) {
        };
        graph.getModel().beginUpdate();
        try {
            layout.execute(graph.getDefaultParent());
        } catch (Exception e) {
        } finally {
            mxMorphing morph = new mxMorphing(graphComponent, 20, 1.5, 20);
            morph.addListener(mxEvent.DONE, new mxEventSource.mxIEventListener() {
                @Override
                public void invoke(Object arg0, mxEventObject arg1) {
                    graph.getModel().endUpdate();
                }
            });
            morph.startAnimation();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);
        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 0, 400, 300);

        setSize(new java.awt.Dimension(416, 308));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmGrafo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmGrafo dialog = new FrmGrafo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
