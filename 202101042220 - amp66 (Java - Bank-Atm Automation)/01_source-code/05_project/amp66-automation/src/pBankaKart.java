import javax.swing.JOptionPane;
import javax.swing.JTable;

public class pBankaKart extends javax.swing.JFrame {

    int id = 0;
    String title = "BANKA KART ONAY";
    cBankaKart cont = new cBankaKart();

    public pBankaKart() {
        initComponents();
        setTitle(title);

        /*pencerenin ortalanmasi*/ setLocationRelativeTo(null);
        /*başlığın ilgili labele yazdırılması*/labelTitle.setText(title);

        for (amlMain model_Main : new cMusteri().KayitlariListele(new JTable())) {
            mlMusteri mMusteri = ((mlMusteri) model_Main);
            cbMusteri.addItem(mMusteri.getAd() + " " + mMusteri.getSoyad());
        }
    }

    public pBankaKart(int _Id) {
        initComponents();
       /*parametre olarak gelen id değerinin id değişkenine atanması*/  this.id = _Id;
        setTitle("GÜNCELLE (" + id + ")");

        /*pencerenin ortalanmasi*/ setLocationRelativeTo(null);
        /*başlığın ilgili labele yazdırılması*/labelTitle.setText(title);

        /*buton metninin ilgili işleme göre değiştirilmesi*/ btnKaydet.setText("GÜNCELLE");
        for (amlMain model_Main : new cMusteri().KayitlariListele(new JTable())) {
            mlMusteri mMusteri = ((mlMusteri) model_Main);
            cbMusteri.addItem(mMusteri.getAd() + " " + mMusteri.getSoyad());
        }
        KayitBilgisi();
    }

    /*o anki kayit bilgilerini listeler*/public void KayitBilgisi() {
        mlBankaKart model = cont.KayitBilgisi(new mlBankaKart(id));
        int id = new cMusteri().KayitlariListele(new JTable()).get(cbMusteri.getSelectedIndex()).getId();
        cbMusteri.setSelectedIndex(id);
        txtBakiye.setText(String.valueOf(model.getBakiye()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        btnKaydet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbMusteri = new javax.swing.JComboBox<>();
        txtBakiye = new javax.swing.JFormattedTextField();

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

        jLabel1.setText("Bakiye");

        jLabel7.setText("Kişi");

        txtBakiye.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKaydet, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTitle)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBakiye, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbMusteri, javax.swing.GroupLayout.Alignment.TRAILING, 0, 222, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBakiye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 81, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        if (txtBakiye.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Eksik bilgi !!");
            return;
        }
        int id = new cMusteri().KayitlariListele(new JTable()).get(cbMusteri.getSelectedIndex()).getId();

        if (id == 0) {
           /*yapılan işleminin tutulduğu değişken*/  boolean sonuc = cont.KayitEkle(
                    new mlBankaKart(
                            id,
                            Integer.valueOf(txtBakiye.getText())
                    )
            );
          /*işlem sonucunun true olması durumu*/  if (sonuc) {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarılı.");
            } else {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarısız.");
            }
        } else {
           /*yapılan işleminin tutulduğu değişken*/  boolean sonuc = cont.KayitGuncelle(
                    new mlBankaKart(
                            id,
                            id,
                            Integer.valueOf(txtBakiye.getText())
                    )
            );
          /*işlem sonucunun true olması durumu*/  if (sonuc) {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarılı.");
            } else {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarısız.");
            }
        }
    }//GEN-LAST:event_btnKaydetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydet;
    private javax.swing.JComboBox<String> cbMusteri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JFormattedTextField txtBakiye;
    // End of variables declaration//GEN-END:variables
}
