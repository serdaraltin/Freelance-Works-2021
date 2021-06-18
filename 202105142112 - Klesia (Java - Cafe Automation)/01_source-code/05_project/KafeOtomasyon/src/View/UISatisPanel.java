package View;

import Controller.ControllerDosya;
import Controller.ControllerSatis;
import Model.Garson;
import Model.Satis;
import Model.Urun;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class UISatisPanel extends javax.swing.JFrame {

    ControllerSatis controllerSatis = new ControllerSatis();

    private ArrayList<Satis> satislar;
    private ArrayList<Garson> garsonlar;
    private ArrayList<Urun> urunler;
    private Satis satis = new Satis();

    private void Listele() {
        controllerSatis.Listele(satislar, tbVeriler);
    }

    public UISatisPanel(ArrayList<Satis> liste, ArrayList<Garson> garsonlar, ArrayList<Urun> urunler) {
        initComponents();

        tbVeriler.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {

                tabloSatirSec(evt);
            }
        });

        setLocationRelativeTo(null);
        this.satislar = liste;
        this.garsonlar = garsonlar;
        this.urunler = urunler;

        Listele();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbVeriler = new javax.swing.JTable();
        btnYenile = new javax.swing.JButton();
        btnEkle = new javax.swing.JButton();
        btnGuncelle = new javax.swing.JButton();
        btnSil = new javax.swing.JButton();
        txtAra = new javax.swing.JTextField();
        btnAra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnRaporOlustur = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Satış İşlemleri");
        setResizable(false);

        tbVeriler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SatisNo", "Tc No", "Ürün No", "Ürün Adet", "Tutar", "Tarih"
            }
        ));
        jScrollPane1.setViewportView(tbVeriler);

        btnYenile.setText("Yenile");
        btnYenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYenileActionPerformed(evt);
            }
        });

        btnEkle.setText("Ekle");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        btnGuncelle.setText("Güncelle");
        btnGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelleActionPerformed(evt);
            }
        });

        btnSil.setText("Sil");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        btnAra.setText("Ara");
        btnAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAraActionPerformed(evt);
            }
        });

        jLabel1.setText("Tarih");

        btnRaporOlustur.setText("Rapor Oluştur");
        btnRaporOlustur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRaporOlusturActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnYenile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEkle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuncelle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRaporOlustur, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAra, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAra))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnYenile)
                    .addComponent(btnEkle)
                    .addComponent(btnGuncelle)
                    .addComponent(btnSil)
                    .addComponent(txtAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAra)
                    .addComponent(jLabel1)
                    .addComponent(btnRaporOlustur))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        new UISatis(satislar, garsonlar, urunler).setVisible(true);
        Listele();
    }//GEN-LAST:event_btnEkleActionPerformed

    private void btnYenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYenileActionPerformed
        Listele();
    }//GEN-LAST:event_btnYenileActionPerformed

    private void btnGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelleActionPerformed
        new UISatis(satislar, garsonlar, urunler, satis).setVisible(true);
        Listele();
    }//GEN-LAST:event_btnGuncelleActionPerformed

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        if (controllerSatis.Sil(satislar, satis)) {
            JOptionPane.showMessageDialog(null, "Silindi.");
            Listele();
        } else {
            JOptionPane.showMessageDialog(null, "Silinemedi !.");
        }
    }//GEN-LAST:event_btnSilActionPerformed

    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraActionPerformed
        if (txtAra.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Arama yapmak için değer giriniz !");
            return;
        }
        satis.setTarih(txtAra.getText());
        controllerSatis.Ara(satislar, satis, tbVeriler);
    }//GEN-LAST:event_btnAraActionPerformed

    private void btnRaporOlusturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRaporOlusturActionPerformed

        if(new ControllerDosya().RaporOlustur(satislar, garsonlar, urunler)){
            JOptionPane.showMessageDialog(this, "Rapor dosyası oluşturuldu. (rapor.txt)");
        }else{
            JOptionPane.showMessageDialog(this, "Rapor oluşturulamadı !");
        }
    }//GEN-LAST:event_btnRaporOlusturActionPerformed

    private void tabloSatirSec(ListSelectionEvent evt) {
        try {
            satis.setSatisNo(Integer.parseInt(tbVeriler.getValueAt(tbVeriler.getSelectedRow(), 0).toString()));
        } catch (Exception ex) {

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnGuncelle;
    private javax.swing.JButton btnRaporOlustur;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton btnYenile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVeriler;
    private javax.swing.JTextField txtAra;
    // End of variables declaration//GEN-END:variables
}
