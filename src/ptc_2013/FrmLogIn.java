package ptc_2013;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;




public class FrmLogIn extends javax.swing.JFrame {
    
//     public static int opper = 4;
     
         public void limpiar()
   {
       txt_usu.setText("");
       txt_pass.setText("");
   }
     
    public FrmLogIn() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(770,535);
        
        frmdi fondo = new frmdi("/img/log.png",750, 484);
        this.pnl.add(fondo);
        this.pnl.repaint();//Refrescar
        frmdi flecha = new frmdi("/img/flecha.png",44, 48);
        this.f.add(flecha);
        this.f.repaint();//Refrescar
        Image icono;
        icono = new ImageIcon(getClass().getResource("/img/icono.png")).getImage();
        this.setIconImage(icono);
        
        
        
        
    }
    
   int nivel;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl = new javax.swing.JPanel();
        txt_pass = new javax.swing.JPasswordField();
        txt_usu = new javax.swing.JTextField();
        f = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autenticación");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(734, 484));

        pnl.setBackground(new java.awt.Color(250, 250, 255));
        pnl.setPreferredSize(new java.awt.Dimension(760, 484));
        pnl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMouseClicked(evt);
            }
        });
        pnl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pnlKeyPressed(evt);
            }
        });

        txt_pass.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        txt_usu.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        f.setBackground(new java.awt.Color(255, 255, 255));
        f.setOpaque(false);
        f.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout fLayout = new javax.swing.GroupLayout(f);
        f.setLayout(fLayout);
        fLayout.setHorizontalGroup(
            fLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );
        fLayout.setVerticalGroup(
            fLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap(612, Short.MAX_VALUE)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayout.createSequentialGroup()
                        .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLayout.createSequentialGroup()
                        .addComponent(txt_usu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(85, 85, 85))))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap(326, Short.MAX_VALUE)
                .addComponent(txt_usu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(f, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlMouseClicked

    private void pnlKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnlKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlKeyPressed

    private void fMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fMouseClicked
        MtoLogIn obj = new MtoLogIn();
        obj.setUsua(txt_usu.getText());
        obj.setPass(txt_pass.getText());    
              
        if(obj.all_act())
        {
            
            nivel = obj.getNivel();
            
            
            
            System.out.println (nivel);
            if (nivel == 1){
              this.dispose();
                FrmPrincipalSistema prin = new FrmPrincipalSistema();
                 prin.show();
             JOptionPane.showMessageDialog( this, "Bienvenido" + " " + txt_usu.getText() );
            
            }   
            else if(nivel == 2) {
                this.dispose();
                FrmPrincipalSistema2 prin = new FrmPrincipalSistema2();
                 prin.show();
              JOptionPane.showMessageDialog( this, "Bienvenido" + " " + txt_usu.getText() );
            }
            
            else if(nivel == 3) {
                this.dispose();
                FrmPrincipalSistema3 prin = new FrmPrincipalSistema3();
                 prin.show();
              JOptionPane.showMessageDialog( this, "Bienvenido" + " " + txt_usu.getText() );
            }
                     
          
//            barra_al asd = new barra_al();
//            asd.show();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "El usuario o contrasena son incorrectas.");
            limpiar();
        }
    }//GEN-LAST:event_fMouseClicked
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogIn().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel f;
    private javax.swing.JPanel pnl;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_usu;
    // End of variables declaration//GEN-END:variables
}
