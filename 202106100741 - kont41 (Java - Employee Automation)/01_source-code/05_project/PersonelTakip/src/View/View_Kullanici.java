package View;

import Controller.Controller_Kullanici;
import Controller.Controller_Personel;
import Model.Model_Kullanici;
import Model.Model_Main;
import Model.Model_Personel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public final class View_Kullanici extends javax.swing.JFrame {
    
    int Id = 0;
    String baslik = "KULLANICI";
    Controller_Kullanici controller = new Controller_Kullanici();
    Controller_Personel controller_Personel = new Controller_Personel();
    
    public View_Kullanici() {
        initComponents();
        setTitle("EKLE");
        
        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);
        Listele();
    }
    
    public View_Kullanici(int _Id) {
        initComponents();
        this.Id = _Id;
        setTitle("GÜNCELLE (" + Id + ")");
        
        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);
        
        btnKaydet.setText("GÜNCELLE");
        Listele();
        Getir();
        
    }
    
    public void Listele() {
        for (Model_Main eleman : controller_Personel.Listele(new JTable())) {
            cbPersonel.addItem(((Model_Personel) eleman).getTcno());
        }
        cbPersonel.setSelectedIndex(0);
        cbYetki.setSelectedIndex(0);
    }
    
    public void Getir() {
        Model_Kullanici model = controller.Getir(Id);
        txtKullaniciAd.setText(model.getKullaniciAd());
        txtParola.setText(model.getParola());
        cbPersonel.setSelectedItem(controller_Personel.Getir(model.getPersonelId()).getTcno());
        cbYetki.setSelectedIndex(model.getYetki());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBaslik = new javax.swing.JLabel();
        btnKaydet = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtKullaniciAd = new javax.swing.JTextField();
        txtParola = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbYetki = new javax.swing.JComboBox<>();
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

        jLabel5.setText("Kullanıcı Ad");

        jLabel6.setText("Parola");

        jLabel7.setText("Personel");

        jLabel8.setText("Yetki");

        cbYetki.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Yönetici" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKaydet, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbBaslik)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtKullaniciAd)
                    .addComponent(txtParola)
                    .addComponent(cbYetki, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBaslik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKullaniciAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbPersonel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbYetki, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        int personelId = controller_Personel.Getir(cbPersonel.getSelectedItem().toString()).getId();
        
        if (Id == 0) {
            
            boolean sonuc = controller.Ekle(
                    new Model_Kullanici(
                            txtKullaniciAd.getText(),
                            txtParola.getText(),
                            personelId,
                            cbYetki.getSelectedIndex()
                    )
            );
            if (sonuc) {
                JOptionPane.showMessageDialog(null, "Kayıt eklendi.");
            } else {
                JOptionPane.showMessageDialog(null, "Kayıt ekleme başarısız.");
            }
        } else {
            boolean sonuc = controller.Guncelle(
                    new Model_Kullanici(
                            Id,
                            txtKullaniciAd.getText(),
                            txtParola.getText(),
                            personelId,
                            cbYetki.getSelectedIndex()
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
    private javax.swing.JComboBox<String> cbPersonel;
    private javax.swing.JComboBox<String> cbYetki;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbBaslik;
    private javax.swing.JTextField txtKullaniciAd;
    private javax.swing.JTextField txtParola;
    // End of variables declaration//GEN-END:variables
}
