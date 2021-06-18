package View;

import Controller.Controller_Main;
import Model.Model_Main;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class View_Liste extends javax.swing.JFrame {

    //kullanılacak sınıftan nesne üretilmesi
    static Controller_Main controller;
    //tablodan seçilen kaydın Id değerini tutan değişken
    static int Id = 0;
    static String baslik;

    //kurucu method
    public View_Liste(Controller_Main controller) {
        initComponents();
        //pencerenin ortalanmasi
        setLocationRelativeTo(null);
        this.controller = controller;

        Model_Main model = controller.getModel();
        BaslikAyarla(model);

        setTitle(baslik);
        lb_Baslik.setText(baslik);
        //tablo alanlarının belirlenmesi
        tb_Kayitlar.setModel(new DefaultTableModel(new Object[][]{}, model.getKolonlar()));
        Listele();
        btnIade.setVisible(false);
        if (model instanceof Model.Model_KitapVerilen) {
            btnIade.setVisible(true);
        }
    }

    public static void BaslikAyarla(Model_Main model) {
        baslik = model.getClass().getName().substring(12);

    }

    public void Listele() {
        //mevcut bilet adedinin ilgili labele yazıdırılması
        controller.Listele(tb_Kayitlar);

    }

    public void SatirSec(ListSelectionEvent evt) {
        //o an tablodan seçilen satırdaki Id değerinin ilgili değişkene atanması
        try {
            Id = Integer.valueOf(tb_Kayitlar.getValueAt(tb_Kayitlar.getSelectedRow(), 0).toString());
        } catch (Exception ex) {

        }
    }

    //bütün nesne tanımlama ve konumlandırma işlemleri diğer sınıflarda aynı olduğundan tekrar açıklama eklenmemiştir
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSil = new javax.swing.JButton();
        lb_Baslik = new javax.swing.JLabel();
        btnYenile = new javax.swing.JButton();
        btnGuncelle = new javax.swing.JButton();
        btnEkle = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtAra = new javax.swing.JTextField();
        btnAra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Kayitlar = new javax.swing.JTable();
        btnIade = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filmler");

        btnSil.setText("SİL");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        lb_Baslik.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lb_Baslik.setText("...");

        btnYenile.setText("YENİLE");
        btnYenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYenileActionPerformed(evt);
            }
        });

        btnGuncelle.setText("GÜNCELLE");
        btnGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelleActionPerformed(evt);
            }
        });

        btnEkle.setText("EKLE");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        jLabel2.setText("Ara");

        btnAra.setText("Ara");
        btnAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAraActionPerformed(evt);
            }
        });

        tb_Kayitlar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_Kayitlar);

        btnIade.setText("İade Gerçekleştir");
        btnIade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIadeActionPerformed(evt);
            }
        });
          tb_Kayitlar.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent evt){
            SatirSec(evt);
        }
        });
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(lb_Baslik)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAra, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAra))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnYenile, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIade, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 265, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lb_Baslik)
                    .addComponent(txtAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnYenile, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIade, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraActionPerformed
        //arama alanının boş olmaması ve ilgili kontrol sınıfından arama işleminin gerçekleştirilmesi
        if (!txtAra.getText().equals("")) {
            controller.Ara(tb_Kayitlar, txtAra.getText());
        } else {
            Listele();
        }
    }//GEN-LAST:event_btnAraActionPerformed

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        //tablodan seçilen değerin ilgili kontrol sınıfı üzerinden silinmesi işlemi
        if (Id == 0) {
            JOptionPane.showMessageDialog(this, "Kayit seciniz.");
            return;
        }
        if (controller.Sil(Id)) {
            JOptionPane.showMessageDialog(this, "Kayit silindi.");
        } else {
            JOptionPane.showMessageDialog(this, "Kayit silinemedi.");
        }
        Listele();
    }//GEN-LAST:event_btnSilActionPerformed

    private void btnGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuncelleActionPerformed
        //tablodan bir değer seçilmiş ve güncelleme butonuna tıklanmış ise güncelleme ekranının açılması
        if (Id != 0) {
            controller.Guncelle(Id);
        }
    }//GEN-LAST:event_btnGuncelleActionPerformed

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        //ekleme ekranın açılması
        controller.Ac();
    }//GEN-LAST:event_btnEkleActionPerformed

    private void btnYenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYenileActionPerformed
        //Listele methodunun çağrılması
        Listele();
    }//GEN-LAST:event_btnYenileActionPerformed

    private void btnIadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIadeActionPerformed
        if (Id != 0) {
            new View_Iade(Id).setVisible(true);
        }
    }//GEN-LAST:event_btnIadeActionPerformed

    //ilgili nesnelerin tanımlanması işlemi
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnGuncelle;
    private javax.swing.JButton btnIade;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton btnYenile;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Baslik;
    private javax.swing.JTable tb_Kayitlar;
    private javax.swing.JTextField txtAra;
    // End of variables declaration//GEN-END:variables
}
