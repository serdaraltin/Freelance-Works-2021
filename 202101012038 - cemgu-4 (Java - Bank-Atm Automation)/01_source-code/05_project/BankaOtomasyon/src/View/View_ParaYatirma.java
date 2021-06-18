package View;

import Controller.Controller_ParaYatirma;
import Model.Model_BankaKart;
import Model.Model_KrediKart;
import Model.Model_ParaYatirma;
import Model.Model_Musteri;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public final class View_ParaYatirma extends javax.swing.JFrame {

    String kart_tur;
    int Id = 0;
    String baslik = "PARA YATIRMA";
    Model_Musteri musteri;
    Model_BankaKart bankaKart;
    Model_KrediKart krediKart;
    Controller_ParaYatirma controller = new Controller_ParaYatirma();

    public View_ParaYatirma(String kart_tur, int kart_Id) {
        initComponents();
        setLocationRelativeTo(null);
        this.kart_tur = kart_tur;
        this.Id = kart_Id;

        lbBaslik.setText(kart_tur);
        setTitle(baslik);

        KartBilgiGetir();
    }

    public void KartBilgiGetir() {
        if (kart_tur.equals("Banka Kartı")) {
            bankaKart = new Controller.Controller_BankaKart().Getir(new Model_BankaKart(Id));
            return;
        }
        krediKart = new Controller.Controller_KrediKart().Getir(new Model_KrediKart(Id));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBaslik = new javax.swing.JLabel();
        btnIslemYap = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMiktar = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lbBaslik.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbBaslik.setText("...");

        btnIslemYap.setText("İŞLEMİ GERÇEKLEŞTİR");
        btnIslemYap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIslemYapActionPerformed(evt);
            }
        });

        jLabel1.setText("Miktar");

        txtMiktar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel3.setText("TL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIslemYap, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBaslik)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(24, 24, 24)
                                .addComponent(txtMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBaslik)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMiktar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnIslemYap, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIslemYapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIslemYapActionPerformed
        if (txtMiktar.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Gerekli alanları doldurunuz !!");
            return;
        }
        boolean sonuc = controller.Ekle(
                new Model_ParaYatirma(
                        kart_tur,
                        Id,
                        Integer.valueOf(txtMiktar.getText()),
                        LocalDateTime.now().toString()
                )
        );
        if (sonuc) {
            JOptionPane.showMessageDialog(null, "İşlem başarılı.");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "İşlem başarısız.");
        }
    }//GEN-LAST:event_btnIslemYapActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIslemYap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbBaslik;
    private javax.swing.JFormattedTextField txtMiktar;
    // End of variables declaration//GEN-END:variables
}
