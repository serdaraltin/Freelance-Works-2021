package View;

import Controller.ControllerOgrenci;
import Controller.ControllerOgretimGorevlisi;
import Controller.ControllerTalep;
import Model.Ogrenci;
import Model.OgretimGorevlisi;
import Model.Talep;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ViewIslemYonetici extends javax.swing.JFrame {

    ArrayList<Ogrenci> ogrenciler;
    ArrayList<OgretimGorevlisi> ogrGorevliler;
    ArrayList<Talep> talepler;

    ControllerOgrenci controllerOgrenci = new ControllerOgrenci();
    ControllerOgretimGorevlisi controllerOgretimGorevlisi = new ControllerOgretimGorevlisi();
    ControllerTalep controllerTalep = new ControllerTalep();
    private int tur;
    private int no;

    private void Listele() {
        if (tur == 1) {
            controllerOgrenci.Listele(ogrenciler, tbVeriler);
        }
        if (tur == 2) {
            controllerOgretimGorevlisi.Listele(ogrGorevliler, tbVeriler);
        }
        if (tur == 3) {
            controllerTalep.Listele(talepler, tbVeriler);
        }
    }

    public ViewIslemYonetici(
            ArrayList<Ogrenci> ogrenciler,
            ArrayList<OgretimGorevlisi> ogrGorevliler, ArrayList<Talep> talepler, int tur) {
        this.talepler = talepler;
        this.ogrenciler = ogrenciler;
        this.ogrGorevliler = ogrGorevliler;
        this.tur = tur;
        initComponents();

        tbVeriler.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {

                tabloSatirSec(evt);
            }
        });
        if (tur == 3) {
            this.btnEkle.setVisible(false);
        }

        setLocationRelativeTo(null);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Yönetici İşlemler");
        setResizable(false);

        tbVeriler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

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
                        .addGap(206, 437, Short.MAX_VALUE))
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
                    .addComponent(btnSil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed

        if (tur == 1) {
            new ViewOgrenci(ogrenciler).setVisible(true);
        }
        if (tur == 2) {
            new ViewOgretimGorevlisi(ogrGorevliler).setVisible(true);
        }

        Listele();
    }//GEN-LAST:event_btnEkleActionPerformed

    private void btnYenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYenileActionPerformed
        Listele();
    }//GEN-LAST:event_btnYenileActionPerformed

    private void btnGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelleActionPerformed

        if (tur == 1) {
            new ViewOgrenci(ogrenciler, no).setVisible(true);
        }
        if (tur == 2) {
            new ViewOgretimGorevlisi(ogrGorevliler, no).setVisible(true);
        }
        if (tur == 3) {
            new ViewTalep(talepler, no, true).setVisible(true);
        }
        Listele();
    }//GEN-LAST:event_btnGuncelleActionPerformed

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        boolean sonuc = false;
        if (tur == 1) {
            sonuc = controllerOgrenci.Sil(ogrenciler, no);
        }
        if (tur == 2) {
            sonuc = controllerOgretimGorevlisi.Sil(ogrGorevliler, no);
        }
        if (tur == 3) {
            sonuc = controllerTalep.Sil(talepler, no);
        }
        if (sonuc) {
            JOptionPane.showMessageDialog(null, "Silindi.");
            Listele();
        } else {
            JOptionPane.showMessageDialog(null, "Silinemedi !.");
        }
    }//GEN-LAST:event_btnSilActionPerformed

    private void tabloSatirSec(ListSelectionEvent evt) {
        try {
            no = Integer.parseInt(tbVeriler.getValueAt(tbVeriler.getSelectedRow(), 0).toString());
        } catch (Exception exception) {

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnGuncelle;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton btnYenile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVeriler;
    // End of variables declaration//GEN-END:variables
}
