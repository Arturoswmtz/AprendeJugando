
package Formulario;

import javax.swing.table.DefaultTableModel;
import conexion.ConexionSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Registros extends javax.swing.JFrame {

    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion();

    public Registros() {
        initComponents();
        this.setLocationRelativeTo(null);
        MostrarDatos();
    }
    
    public void MostrarDatos(){  
        DefaultTableModel tusuarios = new DefaultTableModel();
        tusuarios.addColumn("No");
        tusuarios.addColumn("Nombre");
        tusuarios.addColumn("Apellido");
        tusuarios.addColumn("Ciencias Naturales");
        tusuarios.addColumn("Ingles");
        tusuarios.addColumn("Matemáticas");
        tusuarios.addColumn("Artes");
        tusuarios.addColumn("Español");
        tusuarios.addColumn("Cultura");
        tblRegistros.setModel(tusuarios);
        
        String [] datos = new String [11];
        
        try {
            Statement leer = con.createStatement();
            ResultSet result = leer.executeQuery("SELECT * FROM usuarios");
            
            while(result.next()){
                datos[0] = result.getString(1);
                datos[1] = result.getString(2);
                datos[2] = result.getString(3);
                datos[3] = result.getString(6);
                datos[4] = result.getString(7);
                datos[5] = result.getString(8);
                datos[6] = result.getString(9);
                datos[7] = result.getString(10);
                datos[8] = result.getString(11);
                
                tusuarios.addRow(datos);
            }
            
            tblRegistros.setModel(tusuarios);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "Error en la consulta");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton8 = new javax.swing.JButton();
        btnRegreso = new javax.swing.JButton();

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Regreso.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        tblRegistros.setAutoCreateRowSorter(true);
        tblRegistros.setBackground(new java.awt.Color(0, 51, 51));
        tblRegistros.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tblRegistros.setForeground(new java.awt.Color(255, 255, 255));
        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No.", "Nombre", "Apellido", "Ciencias Naturales", "Ingles", "Matemáticas", "Artes", "Español", "Cultura"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRegistros.setToolTipText("");
        jScrollPane1.setViewportView(tblRegistros);
        if (tblRegistros.getColumnModel().getColumnCount() > 0) {
            tblRegistros.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblRegistros.getColumnModel().getColumn(1).setResizable(false);
            tblRegistros.getColumnModel().getColumn(2).setResizable(false);
            tblRegistros.getColumnModel().getColumn(3).setResizable(false);
            tblRegistros.getColumnModel().getColumn(4).setPreferredWidth(30);
            tblRegistros.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblRegistros.getColumnModel().getColumn(6).setPreferredWidth(40);
            tblRegistros.getColumnModel().getColumn(7).setPreferredWidth(40);
            tblRegistros.getColumnModel().getColumn(8).setPreferredWidth(40);
        }

        jLabel1.setFont(new java.awt.Font("Press Start 2P", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registros");

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Regreso.png"))); // NOI18N

        btnRegreso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Regreso.png"))); // NOI18N
        btnRegreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegreso, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(279, 279, 279))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(347, Short.MAX_VALUE)
                    .addComponent(jButton8)
                    .addContainerGap(348, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegreso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(264, Short.MAX_VALUE)
                    .addComponent(jButton8)
                    .addContainerGap(265, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresoActionPerformed
        VentanaPrincipal form = new VentanaPrincipal();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresoActionPerformed

  
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
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegreso;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblRegistros;
    // End of variables declaration//GEN-END:variables
}
