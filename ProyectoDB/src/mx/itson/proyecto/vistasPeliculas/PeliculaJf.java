/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mx.itson.proyecto.vistasPeliculas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import mx.itson.proyectodb.entidades.Pelicula;
import mx.itson.proyectodb.model.PeliculaModel;

/**
 *
 * @author Admin
 */
public class PeliculaJf extends javax.swing.JFrame {
PeliculaModel PeliculaModel = new PeliculaModel();

/**
 * Constructor que inicializa la interfaz gráfica y actualiza la tabla de películas.
 */
public PeliculaJf() {
    initComponents();
    // Llama al método actualizarTabla para cargar los datos de las películas en la tabla.
    actualizarTabla();
}

/**
 * Método privado para actualizar la tabla de películas en la interfaz gráfica.
 */
private void actualizarTabla() {
    // Se crea un modelo de tabla por defecto para manejar los datos de la tabla.
    DefaultTableModel datosTabla = new DefaultTableModel();

    // Se añaden las columnas a la tabla.
    datosTabla.addColumn("ID");
    datosTabla.addColumn("Título");
    datosTabla.addColumn("Género");
    datosTabla.addColumn("Duración");
    datosTabla.addColumn("Sinopsis");

    // Se obtienen las películas desde la base de datos a través del objeto PeliculaModel.
    for (Pelicula p : PeliculaModel.select()) {
        // Se añaden las filas con la información de cada película a la tabla.
        datosTabla.addRow(
                new Object[]{
                    p.getPelicula_id(),
                    p.getTitulo(),
                    p.getGenero(),
                    p.getDuracion(),
                    p.getSinopsis()
                });
    }

    // Se establece el modelo de la tabla en la interfaz gráfica.
    tbpelicula.setModel(datosTabla);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbpelicula = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        txfbuscar = new javax.swing.JTextField();
        btBuscador = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Pelicula");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 144, -1));

        tbpelicula.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(tbpelicula);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 640, 275));

        jButton1.setText("Agegar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        txfbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfbuscarActionPerformed(evt);
            }
        });
        jPanel1.add(txfbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 280, 50));

        btBuscador.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        btBuscador.setText("Buscar");
        btBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscadorActionPerformed(evt);
            }
        });
        jPanel1.add(btBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       // Se crea una instancia de la clase PeliculaAdd.
// PeliculaAdd es probablemente una clase que extiende JFrame o JDialog y representa una ventana o diálogo para agregar películas.
PeliculaAdd pA = new PeliculaAdd(null, true);

// Hace visible la instancia de PeliculaAdd recién creada.
// Esto permite que la ventana o diálogo sea mostrado al usuario.
pA.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txfbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfbuscarActionPerformed

    private void btBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscadorActionPerformed
   // Obtener el texto ingresado en el campo de búsqueda
String buscar = txfbuscar.getText();

// Verificar si el campo de búsqueda está vacío
if (buscar.isEmpty()) {
    // Si está vacío, actualizar la tabla con la lista completa de Películas
    this.actualizarTabla();
} else {
    // Si hay texto en el campo de búsqueda, realizar la búsqueda
    List<Pelicula> busqueda = new ArrayList<>();

    // Iterar sobre la lista completa de Películas y agregar aquellas que coincidan con el criterio de búsqueda
    for (Pelicula pelicula : Pelicula.getAll(buscar)) {
        // Verificar si el título de la Película contiene el texto de búsqueda (ignorar mayúsculas y minúsculas)
        if (pelicula.getTitulo().toLowerCase().contains(buscar.toLowerCase())) {
            busqueda.add(pelicula);
        } else if (pelicula.getTitulo().toLowerCase().contains(buscar.toLowerCase())) {
            // Esta condición parece ser redundante, ya que es idéntica a la anterior
            // Puede ser un error y debería revisarse
            busqueda.add(pelicula);
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
            java.util.logging.Logger.getLogger(PeliculaJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeliculaJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeliculaJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeliculaJf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeliculaJf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscador;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbpelicula;
    private javax.swing.JTextField txfbuscar;
    // End of variables declaration//GEN-END:variables
}
