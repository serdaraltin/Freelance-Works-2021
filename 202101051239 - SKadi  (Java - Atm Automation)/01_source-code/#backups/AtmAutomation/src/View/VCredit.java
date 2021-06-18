package View;

import Controller.CCredit;
import Controller.CCustomer;
import Model.MCredit;
import Model.MMain;
import Model.MCustomer;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class VCredit extends javax.swing.JFrame {

    int Id = 0;
    String baslik = "KREDİ KART ONAY";
    CCredit controller = new CCredit();

    public VCredit() {
        initComponents();
        setTitle(baslik);

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);

        for (MMain oModel_Main : new CCustomer().List(new JTable())) {
            MCustomer customer = ((MCustomer) oModel_Main);
            cbMusteri.addItem(customer.getAd() + " " + customer.getSoyad());
        }
    }

    public VCredit(int _Id) {
        initComponents();
        this.Id = _Id;
        setTitle("GÜNCELLE (" + Id + ")");

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);

        btnKaydet.setText("GÜNCELLE");
        for (MMain oModel_Main : new CCustomer().List(new JTable())) {
            MCustomer customer = ((MCustomer) oModel_Main);
            cbMusteri.addItem(customer.getAd() + " " + customer.getSoyad());
        }
        Get();
    }

    public void Get() {
        MCredit oModel = controller.Get(new MCredit(Id));
        int musteri_Id = new CCustomer().List(new JTable()).get(cbMusteri.getSelectedIndex()).getId();
        cbMusteri.setSelectedIndex(musteri_Id);
        txtBakiye.setText(String.valueOf(oModel.getBakiye()));
        txtLimit.setText(String.valueOf(oModel.getKart_limit()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBaslik = new javax.swing.JLabel();
        btnKaydet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbMusteri = new javax.swing.JComboBox<>();
        txtBakiye = new javax.swing.JFormattedTextField();
        txtLimit = new javax.swing.JFormattedTextField();

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

        jLabel1.setText("Bakiye");

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
                    .addComponent(btnKaydet, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBaslik)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBakiye, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbMusteri, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtLimit, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBaslik)
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
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLimit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 74, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        String musteriAd = cbMusteri.getSelectedItem().toString();
        /*if (Id == 0 && controller.Control(txtKullaniciAd.getText())) {
            JOptionPane.showMessageDialog(null, "Aynı değere sahip kayıt bulunmakta !");
            return;
        }*/
        if (txtBakiye.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Gerekli alanları doldurunuz !!");
            return;
        }
        if (Integer.valueOf(txtBakiye.getText()) > Integer.valueOf(txtLimit.getText())) {
            JOptionPane.showMessageDialog(this, "Geçersiz değer bulunmakta !");
            return;
        }
        int musteri_Id = new CCustomer().List(new JTable()).get(cbMusteri.getSelectedIndex()).getId();

        if (Id == 0) {
            boolean sonuc = controller.Add(new MCredit(
                            musteri_Id,
                            Integer.valueOf(txtBakiye.getText()),
                            Integer.valueOf(txtLimit.getText())
                    )
            );
            if (sonuc) {
                JOptionPane.showMessageDialog(null, "Kayıt eklendi.");
            } else {
                JOptionPane.showMessageDialog(null, "Kayıt ekleme başarısız.");
            }
        } else {
            boolean sonuc = controller.Update(new MCredit(
                            Id,
                            musteri_Id,
                            Integer.valueOf(txtBakiye.getText()),
                            Integer.valueOf(txtLimit.getText())
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
    private javax.swing.JComboBox<String> cbMusteri;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbBaslik;
    private javax.swing.JFormattedTextField txtBakiye;
    private javax.swing.JFormattedTextField txtLimit;
    // End of variables declaration//GEN-END:variables
}
