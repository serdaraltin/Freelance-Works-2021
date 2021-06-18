package View;

import Controller.Controller_Kategori;
import Controller.Controller_Stok;
import Controller.Controller_Tedarikci;
import Controller.Controller_Urun;
import Model.Model_Kategori;
import Model.Model_Main;
import Model.Model_Marka;
import Model.Model_Stok;
import Model.Model_Tedarikci;
import Model.Model_Urun;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class View_Stok extends javax.swing.JFrame {

    int Id = 0;
    String baslik = "STOK";
    Controller_Stok controller = new Controller_Stok();
    Controller_Kategori controller_Tedarikci = new Controller_Kategori();
    Controller_Stok controller_Urun = new Controller_Stok();

    public View_Stok() {
        initComponents();
        setTitle("EKLE");

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);
        Listele();
    }

    public View_Stok(int _Id) {
        initComponents();
        this.Id = _Id;
        setTitle("GÜNCELLE (" + Id + ")");

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);

        btnKaydet.setText("GÜNCELLE");
        Getir();
        Listele();
    }

    public void Listele() {
        for (Model_Main object : new Controller_Urun().Listele(new JTable())) {
            Model_Urun urun = (Model_Urun) object;
            cbUrun.addItem(urun.getAd());
        }
        for (Model_Main object : new Controller_Tedarikci().Listele(new JTable())) {
            Model_Tedarikci tedarikci = (Model_Tedarikci) object;
            cbTedarikci.addItem(tedarikci.getAd());
        }
    }

    public void Getir() {
        Model_Stok model = controller.Getir(new Model_Stok(Id));

        cbUrun.setSelectedItem(new Controller_Urun().Getir(new Model_Urun(model.getUrun_Id())).getAd());
        cbTedarikci.setSelectedItem(new Controller_Tedarikci().Getir(new Model_Tedarikci(model.getTedarikci_Id())).getAd());

        txtAdet.setText(String.valueOf(model.getAdet()));
        txtTutar.setText(String.valueOf(model.getTutar()));
        txtEklenmeTarih.setText(model.getEklenme_tarih());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBaslik = new javax.swing.JLabel();
        btnKaydet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtAdet = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTutar = new javax.swing.JTextField();
        cbUrun = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbTedarikci = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEklenmeTarih = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lbBaslik.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbBaslik.setText("...");

        btnKaydet.setText("KAYDET");
        btnKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetActionPerformed(evt);
            }
        });

        jLabel1.setText("Adet");

        jLabel2.setText("Tutar");

        txtTutar.setEnabled(false);
        txtTutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTutarActionPerformed(evt);
            }
        });

        jLabel3.setText("Ürün");

        jLabel4.setText("Tedarikçi");

        jLabel7.setText("Eklenme Tarih");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKaydet, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtEklenmeTarih))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(32, 32, 32)
                        .addComponent(cbTedarikci, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(53, 53, 53)
                        .addComponent(txtTutar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(57, 57, 57)
                        .addComponent(txtAdet))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbBaslik)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(57, 57, 57)
                        .addComponent(cbUrun, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBaslik)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbUrun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbTedarikci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAdet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTutar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEklenmeTarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        int uruId = new Controller_Urun().Listele(new JTable()).get(cbUrun.getSelectedIndex()).getId();
        int tedarikci_Id = new Controller_Tedarikci().Listele(new JTable()).get(cbTedarikci.getSelectedIndex()).getId();

        int tutar = new Controller_Urun().Getir(new Model_Urun(uruId)).getFiyat() * Integer.valueOf(txtAdet.getText());
        if (Id == 0) {

            boolean sonuc = controller.Ekle(
                    new Model_Stok(
                            uruId,
                            tedarikci_Id,
                            Integer.valueOf(txtAdet.getText()),
                            tutar,
                            txtEklenmeTarih.getText()
                    )
            );
            if (sonuc) {
                JOptionPane.showMessageDialog(null, "Kayıt eklendi.");
            } else {
                JOptionPane.showMessageDialog(null, "Kayıt ekleme başarısız.");
            }
        } else {
            boolean sonuc = controller.Guncelle(
                    new Model_Stok(
                            Id,
                            uruId,
                            tedarikci_Id,
                            Integer.valueOf(txtAdet.getText()),
                            tutar,
                            txtEklenmeTarih.getText()
                    )
            );
            if (sonuc) {
                JOptionPane.showMessageDialog(null, "Kayıt güncellendi.");
            } else {
                JOptionPane.showMessageDialog(null, "Kayıt güncelleme başarısız.");
            }
        }
    }//GEN-LAST:event_btnKaydetActionPerformed

    private void txtTutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTutarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTutarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydet;
    private javax.swing.JComboBox<String> cbTedarikci;
    private javax.swing.JComboBox<String> cbUrun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbBaslik;
    private javax.swing.JTextField txtAdet;
    private javax.swing.JTextField txtEklenmeTarih;
    private javax.swing.JTextField txtTutar;
    // End of variables declaration//GEN-END:variables
}
