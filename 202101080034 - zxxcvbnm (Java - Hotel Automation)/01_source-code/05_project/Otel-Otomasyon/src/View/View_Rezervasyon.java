package View;

import Controller.Controller_Musteri;
import Controller.Controller_Oda;
import Controller.Controller_Rezervasyon;
import Model.Model_Main;
import Model.Model_Musteri;
import Model.Model_Oda;
import Model.Model_Rezervasyon;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public final class View_Rezervasyon extends javax.swing.JFrame {

    int Id = 0;
    String baslik = "REZERVASYON";
    Controller_Rezervasyon controller = new Controller_Rezervasyon();
    Controller_Musteri controller_Musteri = new Controller_Musteri();
    Controller_Oda controller_Oda = new Controller_Oda();

    public View_Rezervasyon() {
        initComponents();
        setTitle("EKLE");

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);
        Listele();
        txtCikis.setEnabled(false);
    }

    public View_Rezervasyon(int _Id) {
        initComponents();
        this.Id = _Id;
        setTitle("GÜNCELLE (" + Id + ")");

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);

        btnKaydet.setText("GÜNCELLE");
        txtCikis.setText(String.valueOf(LocalDateTime.now()).substring(0, 10));
        txtGiris.setEnabled(false);
        Listele();
        Getir();

    }

    public void Listele() {
        txtGiris.setText(String.valueOf(LocalDateTime.now()).substring(0, 10));
        controller_Oda.Listele(new JTable()).stream().map((item) -> (Model_Oda) item).map((oda) -> String.valueOf(oda.getNo()) + "/" + String.valueOf(oda.getKat()) + "/" + oda.getTur()).forEachOrdered((text) -> {
            cbOda.addItem(text);
        });

        controller_Musteri.Listele(new JTable()).stream().map((item) -> (Model_Musteri) item).map((musteri) -> musteri.getAd() + " " + musteri.getSoyad() + " [" + musteri.getTcno() + "]").forEachOrdered((text) -> {
            cbMusteri.addItem(text);
        });
        if (Id != 0) {
            ArrayList<Model_Main> olist = controller_Oda.Listele(new JTable());
            ArrayList<Model_Main> mlist = controller_Musteri.Listele(new JTable());
            for (int i = 0; i < olist.size(); i++) {
                if (olist.get(i).getId() == controller.Getir(Id).getOda_Id()) {
                    cbOda.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < mlist.size(); i++) {
                if (mlist.get(i).getId() == controller.Getir(Id).getMusteri_Id()) {
                    cbMusteri.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    public void Getir() {
        Model_Rezervasyon model = controller.Getir(Id);

        txtGiris.setText(model.getGiris_tarih());
        if(model.getCikis_tarih().equals("Çıkış Yapılmadı")){
            btnKaydet.setText("ÇIKIŞ VER");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBaslik = new javax.swing.JLabel();
        btnKaydet = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtGiris = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbOda = new javax.swing.JComboBox<>();
        cbMusteri = new javax.swing.JComboBox<>();
        txtCikis = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

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

        jLabel3.setText("Oda [No/Kat/Tür]");

        jLabel5.setText("Müşteri [Ad/Soyad/Tc]");

        jLabel6.setText("Giriş Tarih");

        jLabel7.setText("Çıkış Tarih");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbBaslik)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbOda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMusteri, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtGiris)
                            .addComponent(txtCikis, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBaslik)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbOda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCikis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed

        int oda_Id = controller_Oda.Listele(new JTable()).get(cbOda.getSelectedIndex()).getId();
        int musteri_Id = controller_Musteri.Listele(new JTable()).get(cbMusteri.getSelectedIndex()).getId();
        if (Id == 0 && controller.Kontrol(oda_Id)) {
            JOptionPane.showMessageDialog(null, "Oda dolu !!");
            return;
        }
        if (Id == 0) {

            boolean sonuc = controller.Ekle(
                    new Model_Rezervasyon(
                            oda_Id,
                            musteri_Id,
                            txtGiris.getText(),
                            "Çıkış Yapılmadı"
                    )
            );
            if (sonuc) {
                JOptionPane.showMessageDialog(null, "Kayıt eklendi.");
            } else {
                JOptionPane.showMessageDialog(null, "Kayıt ekleme başarısız.");
            }
        } else {
            boolean sonuc = controller.Guncelle(
                    new Model_Rezervasyon(
                            Id,
                            oda_Id,
                            musteri_Id,
                            txtGiris.getText(),
                            txtCikis.getText()
                    )
            );
            if (sonuc) {
                JOptionPane.showMessageDialog(null, "Çıkış yapıldı.");
            } else {
                JOptionPane.showMessageDialog(null, "Çıkış işlemi başarısız.");
            }
        }
    }//GEN-LAST:event_btnKaydetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydet;
    private javax.swing.JComboBox<String> cbMusteri;
    private javax.swing.JComboBox<String> cbOda;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbBaslik;
    private javax.swing.JTextField txtCikis;
    private javax.swing.JTextField txtGiris;
    // End of variables declaration//GEN-END:variables
}
