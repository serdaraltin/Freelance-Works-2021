package VW;

import CN.CBankaKart;
import CN.CFaturaOdeme;
import CN.CKrediKart;
import CN.CParaCekme;
import CN.CParaYatirma;
import MD.MBankaKart;
import MD.MKrediKart;
import MD.MMusteri;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class VAtm extends javax.swing.JFrame {

    CParaCekme paraCekme = new CParaCekme();
    CParaYatirma paraYatirma = new CParaYatirma();
    CFaturaOdeme faturaOdeme = new CFaturaOdeme();
    MMusteri musteri;
    int kart_Id = 0;
    String kart_tur;

    public VAtm(MMusteri mm) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("ATM");
        this.musteri = mm;

        lbMusteri.setText(musteri.getAd() + " " + musteri.getSoyad());
        KartListele();
    }

    public void KartListele() {
        kart_tur = cbKartTuru.getSelectedItem().toString();
        if (kart_tur.equals("Banka Kartı")) {
            tbKartlar.setModel(new DefaultTableModel(new Object[][]{}, new MBankaKart().getKolonlar()));
            new CBankaKart().Ara(tbKartlar, String.valueOf(musteri.getId()));
            return;
        }
        tbKartlar.setModel(new DefaultTableModel(new Object[][]{}, new MKrediKart().getKolonlar()));
        new CKrediKart().Ara(tbKartlar, String.valueOf(musteri.getId()));
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKartlar = new javax.swing.JTable();

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
        cbKartTuru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKartTuruActionPerformed(evt);
            }
        });

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
        btnFaturaOde.setActionCommand("FATURA");
        btnFaturaOde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFaturaOdeActionPerformed(evt);
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
        
        tbKartlar.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent evt){
            SatirSec(evt);
        }
        });
        jScrollPane1.setViewportView(tbKartlar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbKartTuru, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnParaYatir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFaturaOde, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbMusteri)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnParaCek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMusteri)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKartTuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnParaYatir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFaturaOde, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnParaCek, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
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
        paraYatirma.Ac(kart_tur, kart_Id);
    }//GEN-LAST:event_btnParaYatirActionPerformed

    private void btnParaCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParaCekActionPerformed
        if (kart_Id == 0) {
            JOptionPane.showMessageDialog(this, "Önce bir kart seçiniz !");
            return;
        }
        paraCekme.Ac(kart_tur, kart_Id);
    }//GEN-LAST:event_btnParaCekActionPerformed

    private void btnFaturaOdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFaturaOdeActionPerformed
        if (kart_Id == 0) {
            JOptionPane.showMessageDialog(this, "Önce bir kart seçiniz !");
            return;
        }
        faturaOdeme.Ac(kart_tur, kart_Id);
    }//GEN-LAST:event_btnFaturaOdeActionPerformed

    private void cbKartTuruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKartTuruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKartTuruActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFaturaOde;
    private javax.swing.JButton btnParaCek;
    private javax.swing.JButton btnParaYatir;
    private javax.swing.JComboBox<String> cbKartTuru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMusteri;
    private javax.swing.JTable tbKartlar;
    // End of variables declaration//GEN-END:variables
}
