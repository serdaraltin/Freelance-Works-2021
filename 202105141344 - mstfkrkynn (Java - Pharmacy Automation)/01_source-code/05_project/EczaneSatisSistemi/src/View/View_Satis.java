package View;

import Controller.Controller_Musteri;
import Controller.Controller_Ilac;
import Controller.Controller_Personel;
import Controller.Controller_Satis;
import Model.Model_Ilac;
import Model.Model_Main;
import Model.Model_Musteri;
import Model.Model_Oda;
import Model.Model_Personel;
import Model.Model_Satis;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public final class View_Satis extends javax.swing.JFrame {

    int Id = 0;
    String baslik = "SATIŞ";
    Controller_Satis controller = new Controller_Satis();
    Controller_Musteri controller_Musteri = new Controller_Musteri();
    Controller_Ilac controller_Ilac = new Controller_Ilac();
    Controller_Personel controller_Personel = new Controller_Personel();

    public View_Satis() {
        initComponents();
        setTitle("EKLE");

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);
        Listele();
        txtTarih.setEnabled(false);
    }

    public View_Satis(int _Id) {
        initComponents();
        this.Id = _Id;
        setTitle("GÜNCELLE (" + Id + ")");

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);

        btnKaydet.setText("GÜNCELLE");
        txtTarih.setText(String.valueOf(LocalDateTime.now()).substring(0, 10));
        txtTarih.setEnabled(true);
        Listele();
        Getir();

    }

    public void Listele() {
        txtTarih.setText(String.valueOf(LocalDateTime.now()).substring(0, 10));
        controller_Ilac.Listele(new JTable()).stream().map((item) -> (Model_Ilac) item).map((oda) -> String.valueOf(oda.getAd()) + " [" + String.valueOf(oda.getBarkod()) + "]").forEachOrdered((text) -> {
            cbIlac.addItem(text);
        });

        controller_Musteri.Listele(new JTable()).stream().map((item) -> (Model_Musteri) item).map((musteri) -> musteri.getAd() + " " + musteri.getSoyad() + " [" + musteri.getTcno() + "]").forEachOrdered((text) -> {
            cbMusteri.addItem(text);
        });
        controller_Personel.Listele(new JTable()).stream().map((item) -> (Model_Personel) item).map((personel) -> personel.getAd() + " " + personel.getSoyad() + " [" + personel.getTcno() + "]").forEachOrdered((text) -> {
            cbPersonel.addItem(text);
        });

        if (Id != 0) {
            ArrayList<Model_Main> ilacListe = controller_Ilac.Listele(new JTable());
            ArrayList<Model_Main> musteriListe = controller_Musteri.Listele(new JTable());
            ArrayList<Model_Main> personelListe = controller.Listele(new JTable());
            for (int i = 0; i < ilacListe.size(); i++) {
                if (ilacListe.get(i).getId() == controller.Getir(Id).getIlac_id()) {
                    cbIlac.setSelectedIndex(i);
                    break;
                }
            }
            for (int i = 0; i < musteriListe.size(); i++) {
                if (musteriListe.get(i).getId() == controller.Getir(Id).getMusteri_id()) {
                    cbMusteri.setSelectedIndex(i);
                    break;
                }
            }

            for (int i = 0; i < personelListe.size(); i++) {
                if (personelListe.get(i).getId() == controller.Getir(Id).getPersonel_id()) {
                    cbPersonel.setSelectedIndex(i);
                    break;
                }
            }
        }
    }

    public void Getir() {
        Model_Satis model = controller.Getir(Id);
        txtTarih.setText(model.getTarih());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBaslik = new javax.swing.JLabel();
        btnKaydet = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbIlac = new javax.swing.JComboBox<>();
        cbMusteri = new javax.swing.JComboBox<>();
        txtTarih = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbPersonel = new javax.swing.JComboBox<>();

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

        jLabel3.setText("İlaç [Ad/Barkod]");

        jLabel5.setText("Müşteri [Ad/Soyad/Tc]");

        jLabel7.setText("Tarih");

        jLabel8.setText("Personel [Ad/Soyad/Tc]");

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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(47, 47, 47))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbIlac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMusteri, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTarih, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbPersonel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBaslik)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbIlac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed

        int ilac_id = controller_Ilac.Listele(new JTable()).get(cbIlac.getSelectedIndex()).getId();
        int musteri_id = controller_Musteri.Listele(new JTable()).get(cbMusteri.getSelectedIndex()).getId();
        int personel_id = controller_Personel.Listele(new JTable()).get(cbPersonel.getSelectedIndex()).getId();
        if (Id == 0 && controller.Kontrol(ilac_id)) {
            JOptionPane.showMessageDialog(null, "Oda dolu !!");
            return;
        }
        if (Id == 0) {

            boolean sonuc = controller.Ekle(
                    new Model_Satis(
                            ilac_id,
                            musteri_id,
                            personel_id,
                            txtTarih.getText()
                    )
            );
            if (sonuc) {
                JOptionPane.showMessageDialog(null, "Kayıt eklendi.");
            } else {
                JOptionPane.showMessageDialog(null, "Kayıt ekleme başarısız.");
            }
        } else {
            boolean sonuc = controller.Guncelle(
                    new Model_Satis(
                            Id,
                            ilac_id,
                            musteri_id,
                            personel_id,
                            txtTarih.getText()
                    )
            );
            if (sonuc) {
                JOptionPane.showMessageDialog(null, "Güncelleme yapıldı.");
            } else {
                JOptionPane.showMessageDialog(null, "Güncelleme işlemi başarısız.");
            }
        }
    }//GEN-LAST:event_btnKaydetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydet;
    private javax.swing.JComboBox<String> cbIlac;
    private javax.swing.JComboBox<String> cbMusteri;
    private javax.swing.JComboBox<String> cbPersonel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbBaslik;
    private javax.swing.JTextField txtTarih;
    // End of variables declaration//GEN-END:variables
}
