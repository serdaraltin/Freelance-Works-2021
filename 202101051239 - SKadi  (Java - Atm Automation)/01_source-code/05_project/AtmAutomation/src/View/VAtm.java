package View;

import Controller.CBank;
import Controller.CInvoice;
import Controller.CCredit;
import Controller.CWithDraw;
import Controller.CLodgment;
import Model.MBank;
import Model.MCredit;
import Model.MCustomer;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class VAtm extends javax.swing.JFrame {

    CWithDraw paraCekme = new CWithDraw();
    CLodgment paraYatirma = new CLodgment();
    CInvoice faturaOdeme = new CInvoice();
    MCustomer customer;
    int kart_Id = 0;
    String kart_tur;

    public VAtm(MCustomer mm) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("ATM");
        this.customer = mm;

        lbMusteri.setText(customer.getAd() + " " + customer.getSoyad());
        KartListele();
    }

    public void KartListele() {
        kart_tur = cbKartTuru.getSelectedItem().toString();
        if (kart_tur.equals("Banka Kartı")) {
            tbKartlar.setModel(new DefaultTableModel(new Object[][]{}, new MBank().getKolonlar()));
            new CBank().Search(tbKartlar, String.valueOf(customer.getId()));
            return;
        }
        tbKartlar.setModel(new DefaultTableModel(new Object[][]{}, new MCredit().getKolonlar()));
        new CCredit().Search(tbKartlar, String.valueOf(customer.getId()));
    }

    public void SatirSec(ListSelectionEvent evt) {
        //o an tablodan seçilen satırdaki Id değerinin ilgili değişkene atanması
        try {
            kart_Id = Integer.valueOf(tbKartlar.getValueAt(tbKartlar.getSelectedRow(), 0).toString());
        } catch (Exception ex) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbMusteri = new javax.swing.JLabel();
        cbKartTuru = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnParaYatir = new javax.swing.JButton();
        btnParaCek = new javax.swing.JButton();
        btnFaturaOde = new javax.swing.JButton();
        btnBakiyeOgren = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKartlar = new javax.swing.JTable();
        btnYenile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lbMusteri.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbMusteri.setText("...");
        lbMusteri.setToolTipText("");

        cbKartTuru.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banka Kartı", "Kredi Kartı" }));
        cbKartTuru.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKartTuruItemStateChanged(evt);
            }
        });

        jLabel1.setText("Kart Türü");

        btnParaYatir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnParaYatir.setText("PARA YATIRMA");
        btnParaYatir.setToolTipText("");
        btnParaYatir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParaYatirActionPerformed(evt);
            }
        });

        btnParaCek.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnParaCek.setText("PARA ÇEKME");
        btnParaCek.setToolTipText("");
        btnParaCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParaCekActionPerformed(evt);
            }
        });

        btnFaturaOde.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnFaturaOde.setText("FATURA ÖDEME");
        btnFaturaOde.setToolTipText("");
        btnFaturaOde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFaturaOdeActionPerformed(evt);
            }
        });

        btnBakiyeOgren.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBakiyeOgren.setText("BAKİYE ÖĞRENME");
        btnBakiyeOgren.setToolTipText("");
        btnBakiyeOgren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBakiyeOgrenActionPerformed(evt);
            }
        });

        tbKartlar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbKartlar);

        btnYenile.setText("Yenile");
        btnYenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYenileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMusteri)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbKartTuru, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnYenile))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnParaYatir, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnParaCek, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFaturaOde, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBakiyeOgren, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMusteri)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKartTuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnYenile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnParaYatir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnParaCek, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFaturaOde, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBakiyeOgren, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbKartTuruItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKartTuruItemStateChanged
        KartListele();
    }//GEN-LAST:event_cbKartTuruItemStateChanged

    private void btnParaYatirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParaYatirActionPerformed
        if (kart_Id == 0) {
            JOptionPane.showMessageDialog(this, "Önce bir kart seçiniz !");
            return;
        }
        paraYatirma.Open(kart_tur, kart_Id);
    }//GEN-LAST:event_btnParaYatirActionPerformed

    private void btnParaCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParaCekActionPerformed
        if (kart_Id == 0) {
            JOptionPane.showMessageDialog(this, "Önce bir kart seçiniz !");
            return;
        }
        paraCekme.Open(kart_tur, kart_Id);
    }//GEN-LAST:event_btnParaCekActionPerformed

    private void btnFaturaOdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFaturaOdeActionPerformed
        if (kart_Id == 0) {
            JOptionPane.showMessageDialog(this, "Önce bir kart seçiniz !");
            return;
        }
        faturaOdeme.Open(kart_tur, kart_Id);
    }//GEN-LAST:event_btnFaturaOdeActionPerformed

    private void btnBakiyeOgrenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBakiyeOgrenActionPerformed
        if (kart_Id == 0) {
            JOptionPane.showMessageDialog(this, "Önce bir kart seçiniz !");
            return;
        }
        if (kart_tur.equals("Banka Kartı")) {
            int bakiye = new CBank().Get(new MBank(kart_Id)).getBakiye();
            JOptionPane.showMessageDialog(this, "Banka kartınızın bakiyesi : " + bakiye + "TL");
            return;
        }
        int bakiye = new CCredit().Get(new MCredit(kart_Id)).getBakiye();
        JOptionPane.showMessageDialog(this, "Kredi Kartınızın kalan bakiyesi : " + bakiye + "TL");
    }//GEN-LAST:event_btnBakiyeOgrenActionPerformed

    private void btnYenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYenileActionPerformed
        KartListele();
    }//GEN-LAST:event_btnYenileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBakiyeOgren;
    private javax.swing.JButton btnFaturaOde;
    private javax.swing.JButton btnParaCek;
    private javax.swing.JButton btnParaYatir;
    private javax.swing.JButton btnYenile;
    private javax.swing.JComboBox<String> cbKartTuru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMusteri;
    private javax.swing.JTable tbKartlar;
    // End of variables declaration//GEN-END:variables
}
