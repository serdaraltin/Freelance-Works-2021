package View;

import Controller.Controller_Kategori;
import Controller.Controller_Marka;
import Controller.Controller_Urun;
import Model.Model_Fatura;
import Model.Model_Kategori;
import Model.Model_Main;
import Model.Model_Marka;
import Model.Model_Urun;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class View_Urun extends javax.swing.JFrame {

    int Id = 0;
    String baslik = "URUN";
    Controller_Urun controller = new Controller_Urun();
    Controller_Kategori controller_Kategori = new Controller_Kategori();
    Controller_Marka controller_Marka = new Controller_Marka();

    public View_Urun() {
        initComponents();
        setTitle("EKLE");

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);
        Listele();
    }

    public View_Urun(int _Id) {
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
        for (Model_Main object : new Controller_Kategori().Listele(new JTable())) {
            Model_Kategori kategori = (Model_Kategori) object;
            cbKategori.addItem(kategori.getAd());
        }
        for (Model_Main object : new Controller_Marka().Listele(new JTable())) {
            Model_Marka marka = (Model_Marka) object;
            cbMarka.addItem(marka.getAd());
        }
    }

    public void Getir() {
        Model_Urun model = controller.Getir(new Model_Urun(Id));

        cbKategori.setSelectedItem(controller_Kategori.Getir(new Model_Kategori(model.getKategori_Id())).getAd());
        cbMarka.setSelectedItem(controller_Marka.Getir(new Model_Marka(model.getMarka_Id())).getAd());

        txtAd.setText(model.getAd());
        txtBarkod.setText(model.getBarkod());
        txtMiktar.setText(String.valueOf(model.getMiktar()));
        txtEklenmeTarih.setText(model.getEklenme_tarih());
        cbBirim.setSelectedItem(model.getBirim());
        txtFiyat.setText(String.valueOf(model.getFiyat()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBaslik = new javax.swing.JLabel();
        btnKaydet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBarkod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAd = new javax.swing.JTextField();
        cbKategori = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbMarka = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbBirim = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMiktar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEklenmeTarih = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFiyat = new javax.swing.JTextField();

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

        jLabel1.setText("Barkod");

        jLabel2.setText("Ad");

        jLabel3.setText("Kategori");

        jLabel4.setText("Marka");

        cbBirim.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kg", "Lt", "Adet" }));

        jLabel5.setText("Birim");

        jLabel6.setText("Miktar");

        jLabel7.setText("Eklenme Tarih");

        jLabel8.setText("Fiyat");

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
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(32, 32, 32)
                        .addComponent(cbMarka, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(txtBarkod))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(53, 53, 53)
                        .addComponent(txtAd))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(36, 36, 36)
                        .addComponent(cbBirim, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(30, 30, 30)
                        .addComponent(txtMiktar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbBaslik)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(39, 39, 39)
                        .addComponent(txtFiyat)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBaslik)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMarka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBarkod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbBirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFiyat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEklenmeTarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        int kategori_Id = new Controller_Kategori().Listele(new JTable()).get(cbKategori.getSelectedIndex()).getId();
        int marka_Id = new Controller_Marka().Listele(new JTable()).get(cbMarka.getSelectedIndex()).getId();
        if (Id == 0) {

            boolean sonuc = controller.Ekle(
                    new Model_Urun(
                            kategori_Id,
                            marka_Id,
                            txtBarkod.getText(),
                            txtAd.getText(),
                            String.valueOf(cbBirim.getSelectedItem()),
                            Integer.valueOf(txtMiktar.getText()),
                            Integer.valueOf(txtFiyat.getText()),
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
                    new Model_Urun(
                            Id,
                            kategori_Id,
                            marka_Id,
                            txtBarkod.getText(),
                            txtAd.getText(),
                            String.valueOf(cbBirim.getSelectedItem()),
                            Integer.valueOf(txtFiyat.getText()),
                            Integer.valueOf(txtMiktar.getText()),
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydet;
    private javax.swing.JComboBox<String> cbBirim;
    private javax.swing.JComboBox<String> cbKategori;
    private javax.swing.JComboBox<String> cbMarka;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbBaslik;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextField txtBarkod;
    private javax.swing.JTextField txtEklenmeTarih;
    private javax.swing.JTextField txtFiyat;
    private javax.swing.JTextField txtMiktar;
    // End of variables declaration//GEN-END:variables
}
