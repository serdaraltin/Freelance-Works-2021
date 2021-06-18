package View;

import Controller.ControllerMusteri;
import Controller.ControllerSatis;
import Controller.ControllerUrun;
import Model.Musteri;
import Model.Satis;
import Model.Urun;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UISatis extends javax.swing.JFrame {

    ControllerSatis controllerSatis = new ControllerSatis();
    ControllerMusteri controllerMusteri = new ControllerMusteri();
    ControllerUrun controllerUrun = new ControllerUrun();

    private ArrayList<Satis> satislar = new ArrayList<Satis>();
    private ArrayList<Musteri> musteriler = new ArrayList<Musteri>();
    private ArrayList<Urun> urunler = new ArrayList<Urun>();
    private Satis satis = new Satis();

    public UISatis(ArrayList<Satis> liste, ArrayList<Musteri> musteriler, ArrayList<Urun> urunler) {
        initComponents();
        setLocationRelativeTo(null);
        this.satislar = liste;
        btnSil.setVisible(false);

        this.musteriler = musteriler;
        this.urunler = urunler;

        txtSatisNo.setText(String.valueOf(satislar.size() + 1));

        for (Musteri musteri : musteriler) {
            cbMusteri.addItem(musteri.getAd() + " " + musteri.getSoyad());
        }

        for (Urun urun : urunler) {
            cbUrun.addItem(urun.getAd());
        }
    }

    public UISatis(ArrayList<Satis> liste, ArrayList<Musteri> musteriler, ArrayList<Urun> urunler, Satis guncellenecek) {
        initComponents();
        setLocationRelativeTo(null);
        this.satislar = liste;
        this.satis = controllerSatis.Sec(liste, guncellenecek);
        btnEkle.setText("Güncelle");
        btnSil.setVisible(true);
        txtSatisNo.enable(false);

        this.musteriler = musteriler;
        this.urunler = urunler;

        txtSatisNo.setText(String.valueOf(satislar.size() + 1));
        txtAdet.setText(String.valueOf(satis.getAdet()));
        txtTarih.setText(satis.getTarih());
        

        for (Musteri musteri : musteriler) {
            cbMusteri.addItem(musteri.getAd() + " " + musteri.getSoyad());
        }

        for (Urun urun : urunler) {
            cbUrun.addItem(urun.getAd());
        }

        for (int i = 0; i < cbMusteri.getItemCount(); i++) {
            for (Musteri musteri : musteriler) {
                if (cbMusteri.getItemAt(i).equals(musteri.getAd() + " " + musteri.getSoyad())) {
                    cbMusteri.setSelectedIndex(i);
                    break;
                }
            }
        }

        for (int i = 0; i < cbUrun.getItemCount(); i++) {
            for (Urun urun : urunler) {
                if (cbUrun.getItemAt(i).equals(urun.getAd())) {
                    cbUrun.setSelectedIndex(i);
                    break;
                }
            }
        }
        
        Urun urun = controllerUrun.Sec(urunler, urunler.get(cbUrun.getSelectedIndex()));
        txtTutar.setText(String.valueOf(urun.getFiyat() * Float.parseFloat(txtAdet.getText())));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSatisNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtAdet = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnSil = new javax.swing.JButton();
        btnEkle = new javax.swing.JButton();
        txtTutar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTarih = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbMusteri = new javax.swing.JComboBox<>();
        cbUrun = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Satış");
        setResizable(false);

        jLabel1.setText("No");

        txtSatisNo.setEnabled(false);

        jLabel2.setText("Müsteri");

        jLabel3.setText("Ürün");

        txtAdet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAdetKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAdetKeyReleased(evt);
            }
        });

        jLabel4.setText("Adet");

        btnSil.setText("SİL");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        btnEkle.setText("EKLE");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        txtTutar.setEnabled(false);

        jLabel5.setText("Tutar");

        jLabel6.setText("Tarih");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAdet, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbUrun, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSatisNo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTutar, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTarih, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSatisNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbUrun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAdet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTutar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        if (controllerSatis.Sil(satislar, satis)) {
            JOptionPane.showMessageDialog(null, "Silindi.");
        } else {
            JOptionPane.showMessageDialog(null, "Silinemedi !.");
        }
    }//GEN-LAST:event_btnSilActionPerformed

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        if (controllerSatis.Sec(satislar, satis) != null) {
            Urun urun = controllerUrun.Sec(urunler, urunler.get(cbUrun.getSelectedIndex()));
            satis.setMusteriTcNo(controllerMusteri.Sec(musteriler, musteriler.get(cbMusteri.getSelectedIndex())).getTcNo());
            satis.setUrunNo(urun.getNo());

            satis.setTarih(txtTarih.getText());
            satis.setTutar(urun.getFiyat() * Float.parseFloat(txtAdet.getText()));
            satis.setAdet(Integer.parseInt(txtAdet.getText()));

            if (controllerSatis.Guncelle(satislar, satis)) {
                JOptionPane.showMessageDialog(null, "Güncellendi.");
            } else {
                JOptionPane.showMessageDialog(null, "Güncellenemedi !");
            }
        } else {
            satis.setSatisNo(Integer.parseInt(txtSatisNo.getText()));
            Urun urun = controllerUrun.Sec(urunler, urunler.get(cbUrun.getSelectedIndex()));
            satis.setMusteriTcNo(controllerMusteri.Sec(musteriler, musteriler.get(cbMusteri.getSelectedIndex())).getTcNo());
            satis.setUrunNo(urun.getNo());

            satis.setTarih(txtTarih.getText());
            satis.setTutar(urun.getFiyat() * Float.parseFloat(txtAdet.getText()));
            satis.setAdet(Integer.parseInt(txtAdet.getText()));

            if (controllerSatis.Ekle(satislar, satis)) {
                JOptionPane.showMessageDialog(null, "Eklendi.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Eklenemedi !");
            }
        }

    }//GEN-LAST:event_btnEkleActionPerformed

    private void txtAdetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdetKeyPressed
        try {
            Urun urun = controllerUrun.Sec(urunler, urunler.get(cbUrun.getSelectedIndex()));
            txtTutar.setText(String.valueOf(urun.getFiyat() * Float.parseFloat(txtAdet.getText())));
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_txtAdetKeyPressed

    private void txtAdetKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdetKeyReleased
        try {
            Urun urun = controllerUrun.Sec(urunler, urunler.get(cbUrun.getSelectedIndex()));
            txtTutar.setText(String.valueOf(urun.getFiyat() * Float.parseFloat(txtAdet.getText())));
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_txtAdetKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnSil;
    private javax.swing.JComboBox<String> cbMusteri;
    private javax.swing.JComboBox<String> cbUrun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtAdet;
    private javax.swing.JTextField txtSatisNo;
    private javax.swing.JTextField txtTarih;
    private javax.swing.JTextField txtTutar;
    // End of variables declaration//GEN-END:variables
}
