import javax.swing.JOptionPane;

public class pKullanici extends javax.swing.JFrame {

    int id = 0;
    String title = "KULLANICI";
    cKullanici cont = new cKullanici();

    public pKullanici() {
        initComponents();
        /*başlığın pencerenin başlığına yazılması*/ setTitle("EKLE");

        /*pencerenin ortalanmasi*/ setLocationRelativeTo(null);
        /*başlığın ilgili labele yazdırılması*/labelTitle.setText(title);
    }

    public pKullanici(int _Id) {
        initComponents();
       /*parametre olarak gelen id değerinin id değişkenine atanması*/  this.id = _Id;
        setTitle("GÜNCELLE (" + id + ")");

        /*pencerenin ortalanmasi*/ setLocationRelativeTo(null);
        /*başlığın ilgili labele yazdırılması*/labelTitle.setText(title);

        /*buton metninin ilgili işleme göre değiştirilmesi*/ btnKaydet.setText("GÜNCELLE");
        KayitBilgisi();
    }

    /*o anki kayit bilgilerini listeler*/public void KayitBilgisi() {
        mlKullanici model = cont.KayitBilgisi(new mlKullanici(id));
        cbTip.setSelectedItem(model.getTip());
        txtKullaniciAd.setText(model.getKullanici_ad());
        txtParola.setText(model.getParola());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        btnKaydet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtKullaniciAd = new javax.swing.JTextField();
        txtParola = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbTip = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labelTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelTitle.setText("...");

        btnKaydet.setText("EKLE");
        btnKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetActionPerformed(evt);
            }
        });

        jLabel1.setText("Kullanıcı");

        jLabel2.setText("Parola");

        jLabel7.setText("Tip");

        cbTip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yönetici", "Personel" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addComponent(jLabel7)
                    .addComponent(labelTitle))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKaydet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtParola)
                    .addComponent(txtKullaniciAd)
                    .addComponent(cbTip, 0, 226, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbTip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKullaniciAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        if (txtKullaniciAd.getText().equals("") || txtParola.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Eksik bilgi !!");
            return;
        }
        if (id == 0 && cont.KayitKontrol(txtKullaniciAd.getText())) {
            /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "Aynı değere sahip kayıt bulunmakta !");
            return;
        }
        if (id == 0) {

           /*yapılan işleminin tutulduğu değişken*/  boolean sonuc = cont.KayitEkle(
                    new mlKullanici(
                            cbTip.getSelectedItem().toString(),
                            txtKullaniciAd.getText(),
                            txtParola.getText()
                    )
            );
          /*işlem sonucunun true olması durumu*/  if (sonuc) {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarılı.");
            } else {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarısız.");
            }
        } else {
           /*yapılan işleminin tutulduğu değişken*/  boolean sonuc = cont.KayitGuncelle(
                    new mlKullanici(
                            id,
                            cbTip.getSelectedItem().toString(),
                            txtKullaniciAd.getText(),
                            txtParola.getText()
                    )
            );
          /*işlem sonucunun true olması durumu*/  if (sonuc) {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarılı..");
            } else {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarısız.");
            }
        }
    }//GEN-LAST:event_btnKaydetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydet;
    private javax.swing.JComboBox<String> cbTip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTextField txtKullaniciAd;
    private javax.swing.JTextField txtParola;
    // End of variables declaration//GEN-END:variables
}
