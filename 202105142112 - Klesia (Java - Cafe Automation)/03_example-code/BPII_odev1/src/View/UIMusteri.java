package View;

import Controller.ControllerMusteri;
import Model.Musteri;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UIMusteri extends javax.swing.JFrame {

    ControllerMusteri controllerMusteri = new ControllerMusteri();
    private ArrayList<Musteri> musteriler = new ArrayList<Musteri>();
    private Musteri musteri = new Musteri();

    public UIMusteri(ArrayList<Musteri> liste) {
        initComponents();
        setLocationRelativeTo(null);
        this.musteriler = liste;
        btnSil.setVisible(false);
    }

    public UIMusteri(ArrayList<Musteri> liste, Musteri guncellenecek) {
        initComponents();
        setLocationRelativeTo(null);
        this.musteriler = liste;
        this.musteri = controllerMusteri.Sec(liste, guncellenecek);
        btnEkle.setText("Güncelle");;
        btnSil.setVisible(true);
        txtTcNo.enable(false);
        
        txtTcNo.setText(musteri.getTcNo());
        txtAd.setText(musteri.getAd());
        txtSoyad.setText(musteri.getSoyad());
        txtTelefon.setText(musteri.getTelefon());
        txtEposta.setText(musteri.getEposta());
        txtAdres.setText(musteri.getAdres());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTcNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAd = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSoyad = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEposta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAdres = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnSil = new javax.swing.JButton();
        btnEkle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Müşteri");
        setResizable(false);

        jLabel1.setText("TcNo");

        jLabel2.setText("Ad");

        jLabel3.setText("Soyad");

        jLabel4.setText("Telefon");

        jLabel5.setText("Eposta");

        jLabel6.setText("Adres");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEposta, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTcNo, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTcNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtEposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        if (controllerMusteri.Sil(musteriler, musteri)) {
            JOptionPane.showMessageDialog(null, "Silindi.");
        } else {
            JOptionPane.showMessageDialog(null, "Silinemedi !.");
        }
    }//GEN-LAST:event_btnSilActionPerformed

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        if (musteri.getTcNo() != null) {
            musteri.setAd(txtAd.getText());
            musteri.setSoyad(txtSoyad.getText());
            musteri.setTelefon(txtTelefon.getText());
            musteri.setEposta(txtEposta.getText());
            musteri.setAdres(txtAdres.getText());

            if (controllerMusteri.Guncelle(musteriler, musteri)) {
                JOptionPane.showMessageDialog(null, "Güncellendi.");
            } else {
                JOptionPane.showMessageDialog(null, "Güncellenemedi !");
            }
        } else {
            musteri.setTcNo(txtTcNo.getText());
            musteri.setAd(txtAd.getText());
            musteri.setSoyad(txtSoyad.getText());
            musteri.setTelefon(txtTelefon.getText());
            musteri.setEposta(txtEposta.getText());
            musteri.setAdres(txtAdres.getText());

            if (controllerMusteri.Ekle(musteriler, musteri)) {
                JOptionPane.showMessageDialog(null, "Eklendi.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Eklenemedi !");
            }
        }

    }//GEN-LAST:event_btnEkleActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnSil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextField txtAdres;
    private javax.swing.JTextField txtEposta;
    private javax.swing.JTextField txtSoyad;
    private javax.swing.JTextField txtTcNo;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
