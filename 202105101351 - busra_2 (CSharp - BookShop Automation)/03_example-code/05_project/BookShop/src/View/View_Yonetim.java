package View;

import Controller.Controller_Kitap;
import Controller.Controller_KitapVerilen;
import Controller.Controller_Kullanici;
import Controller.Controller_Musteri;
import Controller.Controller_Veritabani;
import javax.swing.JOptionPane;

public class View_Yonetim extends javax.swing.JFrame {

    public View_Yonetim() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        btnKitap = new javax.swing.JButton();
        btnKullanici = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btnMusteri = new javax.swing.JButton();
        btnVerilenKitap = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("YÖNETİM PANELİ");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("YÖNETİM PANELİ");

        btnKitap.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnKitap.setText("KİTAP İŞLEMLERİ");
        btnKitap.setToolTipText("");
        btnKitap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKitapActionPerformed(evt);
            }
        });

        btnKullanici.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnKullanici.setText("KULLANICI İŞLEMLERİ");
        btnKullanici.setToolTipText("");
        btnKullanici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKullaniciActionPerformed(evt);
            }
        });

        btn8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btn8.setText("ÇIKIŞ");
        btn8.setToolTipText("");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btnMusteri.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMusteri.setText("MÜŞTERİ İŞLEMLERİ");
        btnMusteri.setToolTipText("");
        btnMusteri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusteriActionPerformed(evt);
            }
        });

        btnVerilenKitap.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnVerilenKitap.setText("VERİLEN KİTAP İŞLEMLERİ");
        btnVerilenKitap.setToolTipText("");
        btnVerilenKitap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerilenKitapActionPerformed(evt);
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
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnKitap, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerilenKitap, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnKullanici, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKitap, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKullanici, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerilenKitap, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        if (new Controller_Veritabani().Sifirla()) {
            JOptionPane.showMessageDialog(null, "Veritabanı sıfılandı !");
            return;
        }
        JOptionPane.showMessageDialog(null, "İşlem başarısız");
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void btnKitapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKitapActionPerformed
         new View_Liste(new Controller_Kitap()).setVisible(true);
    }//GEN-LAST:event_btnKitapActionPerformed

    private void btnKullaniciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKullaniciActionPerformed
        new View_Liste(new Controller_Kullanici()).setVisible(true);
    }//GEN-LAST:event_btnKullaniciActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn8ActionPerformed

    private void btnMusteriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusteriActionPerformed
        new View_Liste(new Controller_Musteri()).setVisible(true);
    }//GEN-LAST:event_btnMusteriActionPerformed

    private void btnVerilenKitapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerilenKitapActionPerformed
        new View_Liste(new Controller_KitapVerilen()).setVisible(true);
    }//GEN-LAST:event_btnVerilenKitapActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn8;
    private javax.swing.JButton btnKitap;
    private javax.swing.JButton btnKullanici;
    private javax.swing.JButton btnMusteri;
    private javax.swing.JButton btnVerilenKitap;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
