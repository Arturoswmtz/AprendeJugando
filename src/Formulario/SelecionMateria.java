package Formulario;

import AlphabetSoup.AllphabetSoup;
import ahorcado.Main;
import conectaColor.ConectaColor;
import gui.PlayGame;
import gui2.PlayGame2;
import static Formulario.Login.Usuario;


import paintapplication.PaintApplication;

public class SelecionMateria extends javax.swing.JFrame {

    public SelecionMateria() {
        initComponents();
        this.setLocationRelativeTo(null); //pone al centro el JFrame
    }
public static PaintApplication paint;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnCiencias = new javax.swing.JButton();
        btnIngles = new javax.swing.JButton();
        btnArtes = new javax.swing.JButton();
        btnMates = new javax.swing.JButton();
        btnEspañol = new javax.swing.JButton();
        btnCultura = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Press Start 2P", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Seleciona una materia");

        btnCiencias.setBackground(new java.awt.Color(255, 153, 0));
        btnCiencias.setFont(new java.awt.Font("Press Start 2P", 0, 24)); // NOI18N
        btnCiencias.setText("Ciencias");
        btnCiencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCienciasActionPerformed(evt);
            }
        });

        btnIngles.setBackground(new java.awt.Color(255, 153, 0));
        btnIngles.setFont(new java.awt.Font("Press Start 2P", 0, 24)); // NOI18N
        btnIngles.setText("Ingles");
        btnIngles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInglesActionPerformed(evt);
            }
        });

        btnArtes.setBackground(new java.awt.Color(255, 153, 0));
        btnArtes.setFont(new java.awt.Font("Press Start 2P", 0, 24)); // NOI18N
        btnArtes.setText("Artes");
        btnArtes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArtesActionPerformed(evt);
            }
        });

        btnMates.setBackground(new java.awt.Color(255, 153, 0));
        btnMates.setFont(new java.awt.Font("Press Start 2P", 0, 24)); // NOI18N
        btnMates.setText("Mates");
        btnMates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMatesActionPerformed(evt);
            }
        });

        btnEspañol.setBackground(new java.awt.Color(255, 153, 0));
        btnEspañol.setFont(new java.awt.Font("Press Start 2P", 0, 24)); // NOI18N
        btnEspañol.setText("Español");
        btnEspañol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEspañolActionPerformed(evt);
            }
        });

        btnCultura.setBackground(new java.awt.Color(255, 153, 0));
        btnCultura.setFont(new java.awt.Font("Press Start 2P", 0, 24)); // NOI18N
        btnCultura.setText("Cultura");
        btnCultura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCulturaActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Regreso.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnEspañol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMates, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCiencias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnCultura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnIngles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnArtes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(119, 119, 119))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCiencias)
                    .addComponent(btnIngles))
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMates)
                    .addComponent(btnArtes))
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEspañol)
                    .addComponent(btnCultura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
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

    private void btnCienciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCienciasActionPerformed
        AllphabetSoup form = new AllphabetSoup();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCienciasActionPerformed

    private void btnInglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInglesActionPerformed
        ConectaColor w1 = new ConectaColor();
	w1.setVisible(true);
	//w1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.dispose();
    }//GEN-LAST:event_btnInglesActionPerformed

    private void btnArtesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArtesActionPerformed
        paint = new PaintApplication();
    }//GEN-LAST:event_btnArtesActionPerformed

    private void btnMatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMatesActionPerformed
        PlayGame2 form = new PlayGame2();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMatesActionPerformed

    private void btnEspañolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEspañolActionPerformed
        Main form = new Main();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEspañolActionPerformed

    private void btnCulturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCulturaActionPerformed
        PlayGame form = new PlayGame();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCulturaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        VentanaPrincipal form = new VentanaPrincipal();
        form.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(SelecionMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelecionMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelecionMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelecionMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelecionMateria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArtes;
    private javax.swing.JButton btnCiencias;
    private javax.swing.JButton btnCultura;
    private javax.swing.JButton btnEspañol;
    private javax.swing.JButton btnIngles;
    private javax.swing.JButton btnMates;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
