package View;

import Model.Musteri;
import Model.Satis;
import Model.Urun;
import java.util.ArrayList;

public class UIMain extends javax.swing.JFrame {

    private ArrayList<Urun> urunler = new ArrayList<Urun>();
    private ArrayList<Musteri> musteriler = new ArrayList<Musteri>();
    private ArrayList<Satis> satislar = new ArrayList<Satis>();

    public UIMain(ArrayList<Urun> urunler, ArrayList<Musteri> musteriler, ArrayList<Satis> satislar) {
        initComponents();
        setLocationRelativeTo(null);
        this.urunler = urunler;
        this.musteriler = musteriler;
        this.satislar = satislar;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnMusteriIslemleri = new javax.swing.JButton();
        btnUrunIslemleri = new javax.swing.JButton();
        btnSatisIslemleri = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ana Pencere");

        btnMusteriIslemleri.setText("Müşteri İşlemleri");
        btnMusteriIslemleri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMusteriIslemleriActionPerformed(evt);
            }
        });

        btnUrunIslemleri.setText("Ürün İşlemleri");
        btnUrunIslemleri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUrunIslemleriActionPerformed(evt);
            }
        });

        btnSatisIslemleri.setText("Satıs İşlemleri");
        btnSatisIslemleri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSatisIslemleriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSatisIslemleri, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMusteriIslemleri, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUrunIslemleri, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnUrunIslemleri, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMusteriIslemleri, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSatisIslemleri, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUrunIslemleriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUrunIslemleriActionPerformed
        new UIUrunPanel(urunler).setVisible(true);
    }//GEN-LAST:event_btnUrunIslemleriActionPerformed

    private void btnMusteriIslemleriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMusteriIslemleriActionPerformed
       new UIMusteriPanel(musteriler).setVisible(true);
    }//GEN-LAST:event_btnMusteriIslemleriActionPerformed

    private void btnSatisIslemleriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSatisIslemleriActionPerformed
         new UISatisPanel(satislar,musteriler,urunler).setVisible(true);
    }//GEN-LAST:event_btnSatisIslemleriActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMusteriIslemleri;
    private javax.swing.JButton btnSatisIslemleri;
    private javax.swing.JButton btnUrunIslemleri;
    // End of variables declaration//GEN-END:variables
}
