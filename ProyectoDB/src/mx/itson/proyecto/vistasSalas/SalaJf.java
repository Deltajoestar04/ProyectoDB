/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.proyecto.vistasSalas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import mx.itson.proyectodb.entidades.Sala;
import mx.itson.proyectodb.model.SalaModel;

/**
 *
 * @author Admin
 */
public class SalaJf extends javax.swing.JFrame {
SalaModel SalaModel = new SalaModel();
    /**
     * Creates new form SalaJf
     */
    public SalaJf() {
        initComponents();
   // Llama al método actualizarTabla para cargar los datos de las salas en la tabla.
        actualizarTabla();
    }

    /**
     * Método privado para actualizar la tabla de salas en la interfaz gráfica.
     */
    private void actualizarTabla() {
        // Se crea un modelo de tabla por defecto para manejar los datos de la tabla.
        DefaultTableModel datosTabla = new DefaultTableModel();

        // Se añaden las columnas a la tabla.
        datosTabla.addColumn("ID");
        datosTabla.addColumn("Capacidad");
        datosTabla.addColumn("Tipo de sala");

        // Se obtienen las salas desde la base de datos a través del objeto SalaModel.
        for (Sala s : SalaModel.select()) {
            // Se añaden las filas con la información de cada sala a la tabla.
            datosTabla.addRow(
                    new Object[]{
                        s.getSala_id(),
                        s.getCapacidad(),
                        s.getTipo()
                    });
        }

        // Se establece el modelo de la tabla en la interfaz gráfica.
        tbsala.setModel(datosTabla);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbsala = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txfbuscar = new javax.swing.JTextField();
        btBuscador = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbsala.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(tbsala);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 393, 275));

        jLabel1.setText("Sala");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 89, -1));

        txfbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfbuscarActionPerformed(evt);
            }
        });
        jPanel1.add(txfbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 42, 260, 40));

        btBuscador.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btBuscador.setText("Buscar");
        btBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscadorActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 372));

        jButton1.setText("Agegar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      // Creación de una nueva instancia de la clase SalaAdd.
SalaAdd sA = new SalaAdd(null, true);

// Hace visible la instancia de SalaAdd recién creada.
sA.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txfbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfbuscarActionPerformed

    private void btBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscadorActionPerformed
 // Obtener el texto ingresado en el campo de búsqueda
String buscar = txfbuscar.getText();

// Verificar si el campo de búsqueda está vacío
if (buscar.isEmpty()) {
    // Si está vacío, actualizar la tabla con la lista completa de Salas
    this.actualizarTabla();
} else {
    // Si hay texto en el campo de búsqueda, realizar la búsqueda
    List<Sala> busqueda = new ArrayList();

    // Iterar sobre la lista completa de Salas y agregar aquellas que coincidan con el criterio de búsqueda
    for (Sala sala : Sala.getAll(buscar)) {
        // Verificar si el tipo de Sala contiene el texto de búsqueda (ignorar mayúsculas y minúsculas)
        if (sala.getTipo().toLowerCase().contains(buscar.toLowerCase())) {
            busqueda.add(sala);
        } else if (sala.getTipo().toLowerCase().contains(buscar.toLowerCase())) {
            // Esta condición parece ser redundante, ya que es idéntica a la anterior
            // Puede ser un error y debería revisarse
            busqueda.add(sala);
        }
    }

    // TODO: Hace falta lógica para mostrar el resultado de la búsqueda en la tabla
    // Actualizar la tabla con el resultado de la búsqueda (falta implementar esta parte)
    // this.actualizarTabla();
}


    }//GEN-LAST:event_btBuscadorActionPerformed

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
            java.util.logging.Logger.getLogger(SalaJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalaJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalaJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalaJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalaJf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscador;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbsala;
    private javax.swing.JTextField txfbuscar;
    // End of variables declaration//GEN-END:variables
}
