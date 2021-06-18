import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public final class pParaYatirma extends javax.swing.JFrame {

    String ktur;
    int id = 0;
    String title = "PARA YATIRMA";
    mlMusteri mMusteri;
    mlBankaKart mKBanka;
    mlKrediKart mKKredi;
    cParaYatirma cont = new cParaYatirma();

    public pParaYatirma(String ktur, int kID) {
        initComponents();
        /*pencerenin ortalanmasi*/ setLocationRelativeTo(null);
        this.ktur = ktur;
        this.id = kID;

        labelTitle.setText(ktur);
        setTitle(title);

        KartBilgiGetir();
    }

    public void KartBilgiGetir() {
        if (ktur.equals("Banka Kartı")) {
            mKBanka = new cBankaKart().KayitBilgisi(new mlBankaKart(id));
            return;
        }
        mKKredi = new cKrediKart().KayitBilgisi(new mlKrediKart(id));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitle = new javax.swing.JLabel();
        btnIslemYap = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMiktar = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labelTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        labelTitle.setText("...");

        btnIslemYap.setText("Yatır");
        btnIslemYap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIslemYapActionPerformed(evt);
            }
        });

        jLabel1.setText("Yatırılacak");

        txtMiktar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(txtMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIslemYap, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnIslemYap, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIslemYapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIslemYapActionPerformed
        if (txtMiktar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Eksik bilgi !!");
            return;
        }
       /*yapılan işleminin tutulduğu değişken*/  boolean sonuc = cont.KayitEkle(
                new mlParaYatirma(
                        ktur,
                        id,
                        Integer.valueOf(txtMiktar.getText()),
                        LocalDateTime.now().toString()
                )
        );
      /*işlem sonucunun true olması durumu*/  if (sonuc) {
            /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarılı.");
            /*mevcut pencerenin kapatilmasi*/ this.dispose();
        } else {
            /*mesaj kutusu oluşturulması*/ JOptionPane.showMessageDialog(null, "İşlem başarısız.");
        }
    }//GEN-LAST:event_btnIslemYapActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIslemYap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelTitle;
    private javax.swing.JFormattedTextField txtMiktar;
    // End of variables declaration//GEN-END:variables
}
