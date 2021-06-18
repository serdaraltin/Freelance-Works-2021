
import javax.swing.JOptionPane;

public final class pMusteri extends javax.swing.JFrame {

    //sınıfa ait özellikler
    int id = 0;
    String title = "MÜŞTERİ";
    //controller nesnesi
    cMusteri cont = new cMusteri();

    //kurucu method
    public pMusteri() {
        initComponents();
        /*başlığın pencerenin başlığına yazılması*/ setTitle("EKLE");

        /*pencerenin ortalanmasi*/ setLocationRelativeTo(null);
        /*başlığın ilgili labele yazdırılması*/
        labelTitle.setText(title);
    }

    public pMusteri(int _Id) {
        initComponents();
        /*parametre olarak gelen id değerinin id değişkenine atanması*/ this.id = _Id;
        setTitle("GÜNCELLE (" + id + ")");

        /*pencerenin ortalanmasi*/ setLocationRelativeTo(null);
        /*başlığın ilgili labele yazdırılması*/
        labelTitle.setText(title);

        /*buton metninin ilgili işleme göre değiştirilmesi*/ btnKaydet.setText("GÜNCELLE");
        KayitBilgisi();
    }

    /*o anki kayit bilgilerini listeler*/public void KayitBilgisi() {
        mlMusteri model = cont.KayitBilgisi(new mlMusteri(id));
        txtUnvan.setText(model.getUnvan());
        txtTcno.setText(model.getTcno());
        txtAd.setText(model.getAd());
        txtSoyad.setText(model.getSoyad());
        txtDogum.setText(model.getDogum());
        txtTelefon.setText(model.getTelefon());
        txtEposta.setText(model.getEposta());
        txtAdres.setText(model.getAdres());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        btnKaydet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtTcno = new javax.swing.JTextField();
        txtAd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSoyad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDogum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTelefon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEposta = new javax.swing.JTextField();
        txtUnvan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtAdres = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labelTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelTitle.setText("...");

        btnKaydet.setText("KAYDET");
        btnKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetActionPerformed(evt);
            }
        });

        jLabel1.setText("TcNo");

        jLabel2.setText("Adı");

        jLabel3.setText("Soyadı");

        jLabel4.setText("Doğum Tarihi");

        jLabel5.setText("Telefon");
        jLabel5.setToolTipText("");

        jLabel6.setText("Eposta");

        jLabel7.setText("Ünvanı");

        jLabel8.setText("Adresi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnKaydet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtSoyad)
                                    .addComponent(txtDogum, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtTcno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                                            .addComponent(txtAd, javax.swing.GroupLayout.Alignment.TRAILING)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefon)
                                    .addComponent(txtEposta)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAdres))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitle)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUnvan, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(txtUnvan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTcno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDogum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAdres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        if (id == 0 && cont.KayitKontrol(txtTcno.getText())) {
            /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "Aynı TcNo ya sahip kayıt bulunmakta !");
            return;
        }
        if (id == 0) {

            /*yapılan işleminin tutulduğu değişken*/ boolean sonuc = cont.KayitEkle(
                    new mlMusteri(
                            txtUnvan.getText(),
                            txtTcno.getText(),
                            txtAd.getText(),
                            txtSoyad.getText(),
                            txtDogum.getText(),
                            txtTelefon.getText(),
                            txtEposta.getText(),
                            txtAdres.getText()
                    )
            );
            /*işlem sonucunun true olması durumu*/ if (sonuc) {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarılı.");
            } else {
                /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarısız.");
            }
        } else {
            /*yapılan işleminin tutulduğu değişken*/ boolean sonuc = cont.KayitGuncelle(
                    new mlMusteri(
                            id,
                            txtUnvan.getText(),
                            txtTcno.getText(),
                            txtAd.getText(),
                            txtSoyad.getText(),
                            txtDogum.getText(),
                            txtTelefon.getText(),
                            txtEposta.getText(),
                            txtAdres.getText()
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JTextField txtAd;
    private javax.swing.JTextField txtAdres;
    private javax.swing.JTextField txtDogum;
    private javax.swing.JTextField txtEposta;
    private javax.swing.JTextField txtSoyad;
    private javax.swing.JTextField txtTcno;
    private javax.swing.JTextField txtTelefon;
    private javax.swing.JTextField txtUnvan;
    // End of variables declaration//GEN-END:variables
}
