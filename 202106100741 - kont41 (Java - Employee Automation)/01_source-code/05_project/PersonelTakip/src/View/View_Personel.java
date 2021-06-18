package View;

import Controller.Controller_Departman;
import Controller.Controller_Personel;
import Model.Model_Departman;
import Model.Model_Main;
import Model.Model_Personel;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public final class View_Personel extends javax.swing.JFrame {

    int Id = 0;
    String baslik = "PERSONEL";
    Controller_Personel controller = new Controller_Personel();
    Controller_Departman controller_Departman = new Controller_Departman();

    public View_Personel() {
        initComponents();
        setTitle("EKLE");

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);
            Listele();
    }

    public View_Personel(int _Id) {
        initComponents();
        this.Id = _Id;
        setTitle("GÜNCELLE (" + Id + ")");

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);

        btnKaydet.setText("GÜNCELLE");
        Listele();
        Getir();
    }

    public View_Personel(int _Id, boolean a) {
        initComponents();
        this.Id = _Id;
        setTitle("GÖRÜNTÜLE (" + Id + ")");

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);

        btnKaydet.setText("GÖRÜNTÜLE");
        Listele();
        Getir();

        txtTcno.setEditable(false);
        txtAd.setEditable(false);
        txtSoyad.setEditable(false);
        txtTelefon.setEditable(false);
        txtAdres.setEditable(false);
        txtEposta.setEditable(false);
        txtMaas.setEditable(false);
        cbDepartman.setEnabled(false);
        btnKaydet.setVisible(false);
    }

    public void Listele() {
        for (Model_Main eleman : controller_Departman.Listele(new JTable())) {
            cbDepartman.addItem(((Model_Departman) eleman).getAd());
        }
        cbDepartman.setSelectedIndex(0);
    }

    public void Getir() {
        Model_Personel model = controller.Getir(Id);

        txtTcno.setText(model.getTcno());
        txtAd.setText(model.getAd());
        txtSoyad.setText(model.getSoyad());
        txtTelefon.setText(model.getTelefon());
        txtAdres.setText(model.getAdres());
        txtEposta.setText(model.getEposta());
        cbDepartman.setSelectedItem(controller_Departman.Getir(model.getDepartmanId()).getAd());
        txtMaas.setText(String.valueOf(model.getMaas()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBaslik = new javax.swing.JLabel();
        btnKaydet = new javax.swing.JButton();
        txtTcno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAd = new javax.swing.JTextField();
        txtSoyad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAdres = new javax.swing.JTextField();
        txtTelefon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtEposta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaas = new javax.swing.JFormattedTextField();
        cbDepartman = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();

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

        jLabel3.setText("TC No");

        jLabel4.setText("Telefon");

        jLabel5.setText("Ad");

        jLabel6.setText("Soyad");

        jLabel7.setText("Adres");

        jLabel8.setText("Departman");

        jLabel9.setText("Eposta");

        jLabel10.setText("Maas");

        txtMaas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel11.setText("TL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKaydet, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBaslik)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)))
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10))
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTcno, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                    .addComponent(txtAd)
                                    .addComponent(txtSoyad)
                                    .addComponent(txtTelefon, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                    .addComponent(txtEposta, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                    .addComponent(txtAdres, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMaas, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11))
                                    .addComponent(cbDepartman, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBaslik)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTcno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtEposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbDepartman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(35, 35, 35)
                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        int departmanId = controller_Departman.Getir(cbDepartman.getSelectedItem().toString()).getId();
        if (Id == 0) {

            boolean sonuc = controller.Ekle(
                    new Model_Personel(
                            txtTcno.getText(),
                            txtAd.getText(),
                            txtSoyad.getText(),
                            txtTelefon.getText(),
                            txtEposta.getText(),
                            txtAdres.getText(),
                            departmanId,
                            Integer.valueOf(txtMaas.getText())
                    )
            );
            if (sonuc) {
                JOptionPane.showMessageDialog(null, "Kayıt eklendi.");
            } else {
                JOptionPane.showMessageDialog(null, "Kayıt ekleme başarısız.");
            }
        } else {
            boolean sonuc = controller.Guncelle(
                    new Model_Personel(
                            Id,
                            txtTcno.getText(),
                            txtAd.getText(),
                            txtSoyad.getText(),
                            txtTelefon.getText(),
                            txtEposta.getText(),
                            txtAdres.getText(),
                            departmanId,
                            Integer.valueOf(txtMaas.getText())
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
    private javax.swing.JComboBox<String> cbDepartman;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbBaslik;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextField txtAdres;
    private javax.swing.JTextField txtEposta;
    private javax.swing.JFormattedTextField txtMaas;
    private javax.swing.JTextField txtSoyad;
    private javax.swing.JTextField txtTcno;
    private javax.swing.JTextField txtTelefon;
    // End of variables declaration//GEN-END:variables
}
