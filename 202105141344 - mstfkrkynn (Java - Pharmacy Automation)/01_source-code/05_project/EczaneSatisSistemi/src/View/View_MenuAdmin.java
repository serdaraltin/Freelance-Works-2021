package View;

import Controller.Controller_Musteri;
import Controller.Controller_Ilac;
import Controller.Controller_Personel;
import Controller.Controller_Satis;
import Controller.Controller_Veritabani;
import javax.swing.JOptionPane;

public class View_MenuAdmin extends javax.swing.JFrame {

    public View_MenuAdmin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        btnMusteri = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnIlac = new javax.swing.JButton();
        btnPersonel = new javax.swing.JButton();
        btnCikis = new javax.swing.JButton();
        btnSatis = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("YÖNETİM PANELİ");
        setResizable(false);

        btnMusteri.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMusteri.setText("MÜŞTERİ İŞLEMLERİ");
        btnMusteri.setToolTipText("");
        btnMusteri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusteriActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("ADMİN MENÜSÜ");

        btnIlac.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnIlac.setText("İLAÇ İŞLEMLERİ");
        btnIlac.setToolTipText("");
        btnIlac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIlacActionPerformed(evt);
            }
        });

        btnPersonel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnPersonel.setText("PERSONEL İŞLEMLERİ");
        btnPersonel.setToolTipText("");
        btnPersonel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonelActionPerformed(evt);
            }
        });

        btnCikis.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCikis.setText("ÇIKIŞ");
        btnCikis.setToolTipText("");
        btnCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCikisActionPerformed(evt);
            }
        });

        btnSatis.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSatis.setText("SATIŞ İŞLEMLERİ");
        btnSatis.setToolTipText("");
        btnSatis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSatisActionPerformed(evt);
            }
        });

        jMenu1.setText("Dosya");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Kapat");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Veritabanı");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Sıfırla");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(135, 135, 135))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIlac, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnSatis, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(btnCikis, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIlac, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSatis, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCikis, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed

    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        if (new Controller_Veritabani().Sifirla()) {
            JOptionPane.showMessageDialog(null, "Veritabanı sıfılandı !");
            return;
        }
        JOptionPane.showMessageDialog(null, "İşlem başarısız");
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void btnMusteriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusteriActionPerformed
        new View_Liste(new Controller_Musteri()).setVisible(true);
    }//GEN-LAST:event_btnMusteriActionPerformed

    private void btnPersonelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonelActionPerformed
        new View_Liste(new Controller_Personel()).setVisible(true);
    }//GEN-LAST:event_btnPersonelActionPerformed

    private void btnCikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCikisActionPerformed
        new View_Giris().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCikisActionPerformed

    private void btnSatisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSatisActionPerformed
        new View_Liste(new Controller_Satis()).setVisible(true);
    }//GEN-LAST:event_btnSatisActionPerformed

    private void btnIlacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIlacActionPerformed
        new View_Liste(new Controller_Ilac()).setVisible(true);
    }//GEN-LAST:event_btnIlacActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCikis;
    private javax.swing.JButton btnIlac;
    private javax.swing.JButton btnMusteri;
    private javax.swing.JButton btnPersonel;
    private javax.swing.JButton btnSatis;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
