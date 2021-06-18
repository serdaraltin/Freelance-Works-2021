package View;

import Controller.Controller_Fatura;
import Controller.Controller_FaturaUrun;
import Controller.Controller_Musteri;
import Controller.Controller_Stok;
import Controller.Controller_Urun;
import Model.Model_Fatura;
import Model.Model_FaturaUrun;
import Model.Model_Main;
import Model.Model_Musteri;
import Model.Model_Urun;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class View_FaturaUrun extends javax.swing.JFrame {

    int Id = 0;
    String baslik = "FATURA ÜRÜN";
    Controller_FaturaUrun controller = new Controller_FaturaUrun();
    Controller_Musteri controller_Musteri = new Controller_Musteri();
    Controller_Fatura controller_Fatura = new Controller_Fatura();
    Controller_Urun controller_Urun = new Controller_Urun();

    public View_FaturaUrun() {
        initComponents();
        setTitle("EKLE");

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);
        Listele();
    }

    public View_FaturaUrun(int _Id) {
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
        for (Model_Main object : controller_Musteri.Listele(new JTable())) {
            Model_Musteri musteri = (Model_Musteri) object;
            cbFatura.addItem(object.getId() + " > " + musteri.getAd() + " " + musteri.getSoyad() + " [" + musteri.getTcno() + "]");
        }
        for (Model_Main object : controller_Urun.Listele(new JTable())) {
            Model_Urun urun = (Model_Urun) object;
            cbUrun.addItem(urun.getAd() + " [" + urun.getBarkod() + "]");
        }
    }

    public void Getir() {
        Model_FaturaUrun model = controller.Getir(new Model_FaturaUrun(Id));
        Model_Fatura fatura = new Controller_Fatura().Getir(new Model_Fatura(model.getFatura_Id()));
        Model_Musteri musteri = new Controller_Musteri().Getir(new Model_Musteri(fatura.getMusteri_Id()));
        cbFatura.setSelectedItem(musteri.getAd() + " " + musteri.getSoyad() + " [" + musteri.getTcno() + "]");
        txtAdet.setText(String.valueOf(model.getAdet()));
        txtTutar.setText(String.valueOf(model.getTutar()));
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
        cbFatura = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbUrun = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

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

        jLabel3.setText("Fatura");

        jLabel4.setText("Ürün");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKaydet, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(52, 52, 52)
                        .addComponent(cbUrun, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)
                        .addComponent(txtAdet))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(43, 43, 43)
                        .addComponent(cbFatura, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbBaslik)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(50, 50, 50)
                        .addComponent(txtTutar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBaslik)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbUrun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAdet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTutar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        int fatura_Id = controller_Fatura.Listele(new JTable()).get(cbFatura.getSelectedIndex()).getId();
        Model_Urun urun = (Model_Urun) controller_Urun.Listele(new JTable()).get(cbUrun.getSelectedIndex());
        
        int tutar = urun.getFiyat() * Integer.valueOf(txtAdet.getText());
        if (Id == 0) {

            boolean sonuc = controller.Ekle(
                    new Model_FaturaUrun(
                            fatura_Id,
                            urun.getId(),
                            Integer.valueOf(txtAdet.getText()),
                            tutar
                    )
            );
            if (sonuc) {

                JOptionPane.showMessageDialog(null, "Kayıt eklendi.");
                
            } else {
                JOptionPane.showMessageDialog(null, "Kayıt ekleme başarısız.");
            }
        } else {
            boolean sonuc = controller.Guncelle(
                    new Model_FaturaUrun(
                            Id,
                            fatura_Id,
                            urun.getId(),
                            Integer.valueOf(txtAdet.getText()),
                            tutar
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
    private javax.swing.JComboBox<String> cbFatura;
    private javax.swing.JComboBox<String> cbUrun;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbBaslik;
    private javax.swing.JTextField txtAdet;
    private javax.swing.JTextField txtTutar;
    // End of variables declaration//GEN-END:variables
}
