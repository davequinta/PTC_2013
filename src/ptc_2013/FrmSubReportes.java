/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmSubReportes.java
 *
 * Created on 25-ago-2013, 22:19:29
 */
package ptc_2013;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Toshiba
 */
public class FrmSubReportes extends javax.swing.JFrame {

    /** Creates new form FrmSubReportes */
    public FrmSubReportes() {
        initComponents();
        setTitle("SubReportes");
        frmdi fondo = new frmdi("/img/reportes.png",357, 300);
        this.pnlfondo.add(fondo);
        this.pnlfondo.repaint();//Refrescar
        frmdi fondo2 = new frmdi("/img/inventario.png",64, 64);
        this.pnl1.add(fondo2);
        this.pnl1.repaint();//Refrescar
        frmdi fondo3 = new frmdi("/img/visitas.png",64, 64);
        this.pnl2.add(fondo3);
        this.pnl2.repaint();//Refrescar
        frmdi fondo4 = new frmdi("/img/empleados.png",64, 64);
        this.pnl3.add(fondo4);
        this.pnl3.repaint();//Refrescar
        frmdi fondo5 = new frmdi("/img/plantas.png",64, 64);
        this.pnl4.add(fondo5);
        this.pnl4.repaint();//Refrescar
        frmdi fondo6 = new frmdi("/img/mante.png",64, 64);
        this.pnl5.add(fondo6);
        this.pnl5.repaint();//Refrescar
        frmdi fondo7 = new frmdi("/img/riego.png",64, 64);
        this.pnl6.add(fondo7);
        this.pnl6.repaint();//Refrescar
        frmdi fondo8 = new frmdi("/img/afiliados.png",64, 64);
        this.pnl7.add(fondo8);
        this.pnl7.repaint();//Refrescar
        frmdi fondo9 = new frmdi("/img/empleados.png",64, 64);
        this.pnl8.add(fondo9);
        this.pnl8.repaint();//Refrescar
        Image icono;
        icono = new ImageIcon(getClass().getResource("/img/icono.png")).getImage();
        this.setIconImage(icono);
        centrar();
    }
    private void centrar() {
        Dimension Pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension formulario = this.getSize();
        int X = (Pantalla.width - formulario.width) / 2;
        int Y = (Pantalla.height - formulario.height) / 2;
        this.setLocation(X, Y);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlfondo = new javax.swing.JPanel();
        pnl1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        pnl2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pnl3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        pnl4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        pnl5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        pnl6 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        pnl7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        pnl8 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlfondo.setPreferredSize(new java.awt.Dimension(387, 300));

        pnl1.setBackground(new java.awt.Color(153, 0, 255));
        pnl1.setPreferredSize(new java.awt.Dimension(64, 64));
        pnl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl1MouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 0, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl1Layout = new javax.swing.GroupLayout(pnl1);
        pnl1.setLayout(pnl1Layout);
        pnl1Layout.setHorizontalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl1Layout.setVerticalGroup(
            pnl1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl2.setBackground(new java.awt.Color(153, 0, 255));
        pnl2.setPreferredSize(new java.awt.Dimension(64, 64));
        pnl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl2MouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(153, 0, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl2Layout = new javax.swing.GroupLayout(pnl2);
        pnl2.setLayout(pnl2Layout);
        pnl2Layout.setHorizontalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl2Layout.setVerticalGroup(
            pnl2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl3.setBackground(new java.awt.Color(153, 0, 255));
        pnl3.setPreferredSize(new java.awt.Dimension(64, 64));
        pnl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl3MouseClicked(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(153, 0, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl3Layout = new javax.swing.GroupLayout(pnl3);
        pnl3.setLayout(pnl3Layout);
        pnl3Layout.setHorizontalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl3Layout.setVerticalGroup(
            pnl3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl3Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl4.setBackground(new java.awt.Color(153, 0, 255));
        pnl4.setPreferredSize(new java.awt.Dimension(64, 64));
        pnl4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl4MouseClicked(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(153, 0, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl4Layout = new javax.swing.GroupLayout(pnl4);
        pnl4.setLayout(pnl4Layout);
        pnl4Layout.setHorizontalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl4Layout.setVerticalGroup(
            pnl4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl4Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl5.setBackground(new java.awt.Color(153, 0, 255));
        pnl5.setPreferredSize(new java.awt.Dimension(64, 64));
        pnl5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl5MouseClicked(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(153, 0, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl5Layout = new javax.swing.GroupLayout(pnl5);
        pnl5.setLayout(pnl5Layout);
        pnl5Layout.setHorizontalGroup(
            pnl5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl5Layout.setVerticalGroup(
            pnl5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl5Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl6.setBackground(new java.awt.Color(153, 0, 255));
        pnl6.setPreferredSize(new java.awt.Dimension(64, 64));
        pnl6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl6MouseClicked(evt);
            }
        });

        jPanel12.setBackground(new java.awt.Color(153, 0, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl6Layout = new javax.swing.GroupLayout(pnl6);
        pnl6.setLayout(pnl6Layout);
        pnl6Layout.setHorizontalGroup(
            pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl6Layout.setVerticalGroup(
            pnl6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl6Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl7.setBackground(new java.awt.Color(153, 0, 255));
        pnl7.setPreferredSize(new java.awt.Dimension(64, 64));
        pnl7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl7MouseClicked(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(153, 0, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl7Layout = new javax.swing.GroupLayout(pnl7);
        pnl7.setLayout(pnl7Layout);
        pnl7Layout.setHorizontalGroup(
            pnl7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl7Layout.setVerticalGroup(
            pnl7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl7Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl8.setBackground(new java.awt.Color(153, 0, 255));
        pnl8.setPreferredSize(new java.awt.Dimension(64, 64));
        pnl8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl8MouseClicked(evt);
            }
        });

        jPanel16.setBackground(new java.awt.Color(153, 0, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnl8Layout = new javax.swing.GroupLayout(pnl8);
        pnl8.setLayout(pnl8Layout);
        pnl8Layout.setHorizontalGroup(
            pnl8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl8Layout.setVerticalGroup(
            pnl8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl8Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlfondoLayout = new javax.swing.GroupLayout(pnlfondo);
        pnlfondo.setLayout(pnlfondoLayout);
        pnlfondoLayout.setHorizontalGroup(
            pnlfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlfondoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnlfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlfondoLayout.createSequentialGroup()
                        .addComponent(pnl5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnl6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnl7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlfondoLayout.createSequentialGroup()
                        .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnlfondoLayout.setVerticalGroup(
            pnlfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlfondoLayout.createSequentialGroup()
                .addGroup(pnlfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlfondoLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addGroup(pnlfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnl4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlfondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63)
                .addGroup(pnlfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlfondoLayout.createSequentialGroup()
                        .addGroup(pnlfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnl7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 64, Short.MAX_VALUE)
                            .addComponent(pnl6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(pnl5, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE))
                        .addGap(50, 50, 50))
                    .addGroup(pnlfondoLayout.createSequentialGroup()
                        .addComponent(pnl8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlfondo, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlfondo, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void pnl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl1MouseClicked
 String path="";
try
{
    path = getClass().getResource("/Reportes/RptProductos.jasper").getPath();
    path = URLDecoder.decode(path, "UTF-8");
    Connection cn = new Conexion().conectar();
    Map parametros = new HashMap();
    parametros.put("Hola", "Mundo");
    JasperReport reporte = (JasperReport)JRLoader.loadObject(path);
    JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, cn);
    JasperViewer visor = new JasperViewer(imprimir, false);
    visor.setVisible(true);
}
catch(Exception ex)
{
    System.out.println("Error: " +  ex.getMessage());
}
                                              
}//GEN-LAST:event_pnl1MouseClicked

private void pnl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl2MouseClicked
 String path="";
try
{
    path = getClass().getResource("/Reportes/RptEmpleados.jasper").getPath();
    path = URLDecoder.decode(path, "UTF-8");
    Connection cn = new Conexion().conectar();
    Map parametros = new HashMap();
    parametros.put("Hola", "Mundo");
    JasperReport reporte = (JasperReport)JRLoader.loadObject(path);
    JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, cn);
    JasperViewer visor = new JasperViewer(imprimir, false);
    visor.setVisible(true);
}
catch(Exception ex)
{
    System.out.println("Error: " +  ex.getMessage());
}
                                            
}//GEN-LAST:event_pnl2MouseClicked

private void pnl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl3MouseClicked
 String path="";
try
{
    path = getClass().getResource("/Reportes/RptVisitante.jasper").getPath();
    path = URLDecoder.decode(path, "UTF-8");
    Connection cn = new Conexion().conectar();
    Map parametros = new HashMap();
    parametros.put("Hola", "Mundo");
    JasperReport reporte = (JasperReport)JRLoader.loadObject(path);
    JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, cn);
    JasperViewer visor = new JasperViewer(imprimir, false);
    visor.setVisible(true);
}
catch(Exception ex)
{
    System.out.println("Error: " +  ex.getMessage());
}
                                        
}//GEN-LAST:event_pnl3MouseClicked

private void pnl4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl4MouseClicked
 String path="";
try
{
    path = getClass().getResource("/Reportes/RptPlantas.jasper").getPath();
    path = URLDecoder.decode(path, "UTF-8");
    Connection cn = new Conexion().conectar();
    Map parametros = new HashMap();
    parametros.put("Hola", "Mundo");
    JasperReport reporte = (JasperReport)JRLoader.loadObject(path);
    JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, cn);
    JasperViewer visor = new JasperViewer(imprimir, false);
    visor.setVisible(true);
}
catch(Exception ex)
{
    System.out.println("Error: " +  ex.getMessage());
}
                                              
}//GEN-LAST:event_pnl4MouseClicked

private void pnl5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl5MouseClicked
 String path="";
try
{
    path = getClass().getResource("/Reportes/RptMante_Zona_Emple.jaesper").getPath();
    path = URLDecoder.decode(path, "UTF-8");
    Connection cn = new Conexion().conectar();
    Map parametros = new HashMap();
    parametros.put("Hola", "Mundo");
    JasperReport reporte = (JasperReport)JRLoader.loadObject(path);
    JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, cn);
    JasperViewer visor = new JasperViewer(imprimir, false);
    visor.setVisible(true);
}
catch(Exception ex)
{
    System.out.println("Error: " +  ex.getMessage());
}
         
}//GEN-LAST:event_pnl5MouseClicked

private void pnl6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl6MouseClicked
 String path="";
try
{
    path = getClass().getResource("/Reportes/RptRiego.jasper").getPath();
    path = URLDecoder.decode(path, "UTF-8");
    Connection cn = new Conexion().conectar();
    Map parametros = new HashMap();
    parametros.put("Hola", "Mundo");
    JasperReport reporte = (JasperReport)JRLoader.loadObject(path);
    JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, cn);
    JasperViewer visor = new JasperViewer(imprimir, false);
    visor.setVisible(true);
}
catch(Exception ex)
{
    System.out.println("Error: " +  ex.getMessage());
}
         
}//GEN-LAST:event_pnl6MouseClicked

private void pnl7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl7MouseClicked
 String path="";
try
{
    path = getClass().getResource("/Reportes/RptAfiliados.jasper").getPath();
    path = URLDecoder.decode(path, "UTF-8");
    Connection cn = new Conexion().conectar();
    Map parametros = new HashMap();
    parametros.put("Hola", "Mundo");
    JasperReport reporte = (JasperReport)JRLoader.loadObject(path);
    JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, cn);
    JasperViewer visor = new JasperViewer(imprimir, false);
    visor.setVisible(true);
}
catch(Exception ex)
{
    System.out.println("Error: " +  ex.getMessage());
}
         
}//GEN-LAST:event_pnl7MouseClicked

private void pnl8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl8MouseClicked
 String path="";
try
{
    path = getClass().getResource("/Reportes/RptEmpleados.jasper").getPath();
    path = URLDecoder.decode(path, "UTF-8");
    Connection cn = new Conexion().conectar();
    Map parametros = new HashMap();
    parametros.put("Hola", "Mundo");
    JasperReport reporte = (JasperReport)JRLoader.loadObject(path);
    JasperPrint imprimir = JasperFillManager.fillReport(reporte, parametros, cn);
    JasperViewer visor = new JasperViewer(imprimir, false);
    visor.setVisible(true);
}
catch(Exception ex)
{
    System.out.println("Error: " +  ex.getMessage());
}
         
}//GEN-LAST:event_pnl8MouseClicked

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
            java.util.logging.Logger.getLogger(FrmSubReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSubReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSubReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSubReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmSubReportes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel pnl1;
    private javax.swing.JPanel pnl2;
    private javax.swing.JPanel pnl3;
    private javax.swing.JPanel pnl4;
    private javax.swing.JPanel pnl5;
    private javax.swing.JPanel pnl6;
    private javax.swing.JPanel pnl7;
    private javax.swing.JPanel pnl8;
    private javax.swing.JPanel pnlfondo;
    // End of variables declaration//GEN-END:variables
}
