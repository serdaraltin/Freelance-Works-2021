
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class pKrediKart extends javax.swing.JFrame {

    int id = 0;
    String title = "KREDİ KART ONAY";
    cKrediKart cont = new cKrediKart();

    public pKrediKart() {
        initComponents();
        setTitle(title);

        /*pencerenin ortalanmasi*/ setLocationRelativeTo(null);

        for (amlMain model_Main : new cMusteri().KayitlariListele(new JTable())) {
            mlMusteri mMusteri = ((mlMusteri) model_Main);
            cbMusteri.addItem(mMusteri.getAd() + " " + mMusteri.getSoyad());
        }
    }

    public pKrediKart(int _Id) {
        initComponents();
       /*parametre olarak gelen id değerinin id değişkenine atanması*/  this.id = _Id;
        setTitle("GÜNCELLE (" + id + ")");

        /*pencerenin ortalanmasi*/ setLocationRelativeTo(null);

        /*buton metninin ilgili işleme göre değiştirilmesi*/ btnKaydet.setText("GÜNCELLE");
        for (amlMain model_Main : new cMusteri().KayitlariListele(new JTable())) {
            mlMusteri mMusteri = ((mlMusteri) model_Main);
            cbMusteri.addItem(mMusteri.getAd() + " " + mMusteri.getSoyad());
        }
        KayitBilgisi();
    }

    /*o anki kayit bilgilerini listeler*/public void KayitBilgisi() {
        mlKrediKart model = cont.KayitBilgisi(new mlKrediKart(id));
        int id = new cMusteri().KayitlariListele(new JTable()).get(cbMusteri.getSelectedIndex()).getId();
        cbMusteri.setSelectedIndex(id);
        txtBakiye.setText(String.valueOf(model.getBakiye()));
        txtLimit.setText(String.valueOf(model.getKart_limit()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnKaydet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbMusteri = new javax.swing.JComboBox<>();
        txtBakiye = new javax.swing.JFormattedTextField();
        txtLimit = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btnKaydet.setText("KAYDET");
        btnKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetActionPerformed(evt);
            }
        });

        jLabel1.setText("Mevcut");

        jLabel2.setText("Limit");

        jLabel7.setText("Müşteri");

        txtBakiye.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        txtLimit.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtBakiye, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbMusteri, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMusteri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBakiye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed

        if (txtBakiye.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Eksik bilgi !!");
            return;
        }
        if (Integer.valueOf(txtBakiye.getText()) > Integer.valueOf(txtLimit.getText())) {
            JOptionPane.showMessageDialog(this, "Geçersiz değer bulunmakta !");
            return;
        }
        int id = new cMusteri().KayitlariListele(new JTable()).get(cbMusteri.getSelectedIndex()).getId();

        if (id == 0) {
            /*yapılan işleminin tutulduğu değişken*/ boolean sonuc = cont.KayitEkle(
                    new mlKrediKart(
                            id,
                            Integer.valueOf(txtBakiye.getText()),
                            Integer.valueOf(txtLimit.getText())
                    )
            );
            /*işlem sonucunun true olması durumu*/ if (sonuc) {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarılı.");
            } else {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarısız.");
            }
        } else {
            /*yapılan işleminin tutulduğu değişken*/ boolean sonuc = cont.KayitGuncelle(
                    new mlKrediKart(
                            id,
                            id,
                            Integer.valueOf(txtBakiye.getText()),
                            Integer.valueOf(txtLimit.getText())
                    )
            );
            /*işlem sonucunun true olması durumu*/ if (sonuc) {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarılı..");
            } else {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarısız.");
            }
        }
    }//GEN-LAST:event_btnKaydetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKaydet;
    private javax.swing.JComboBox<String> cbMusteri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JFormattedTextField txtBakiye;
    private javax.swing.JFormattedTextField txtLimit;
    // End of variables declaration//GEN-END:variables
}
