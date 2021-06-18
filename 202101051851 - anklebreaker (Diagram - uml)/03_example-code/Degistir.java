import javax.swing.JTextArea;

public class Degistir extends javax.swing.JFrame {

    public JTextArea metin_kutusu;
    boolean buyuk_kucuk = false;
    boolean yukari_yon = false;
    int sonIndex = 0;
    BulDegistir cBul = new BulDegistir();

    public Degistir() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        rdAsagi.setSelected(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblAranan = new javax.swing.JLabel();
        txtAranan = new javax.swing.JTextField();
        btnAra = new javax.swing.JButton();
        chbTamEslesme = new javax.swing.JCheckBox();
        btnKapat = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        rdYukari = new javax.swing.JRadioButton();
        rdAsagi = new javax.swing.JRadioButton();
        txtDegistir = new javax.swing.JTextField();
        lblAranan1 = new javax.swing.JLabel();
        btnDegistir = new javax.swing.JButton();
        btnTumunuDegistir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblAranan.setText("Aranacak");

        btnAra.setText("Ara");
        btnAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAraActionPerformed(evt);
            }
        });

        chbTamEslesme.setText("Tam Eşleşme");
        chbTamEslesme.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chbTamEslesmeStateChanged(evt);
            }
        });

        btnKapat.setText("Kapat");
        btnKapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKapatActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Yön"));
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        rdYukari.setText("Yukarı");
        rdYukari.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdYukariStateChanged(evt);
            }
        });
        rdYukari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdYukariActionPerformed(evt);
            }
        });

        rdAsagi.setText("Aşağı");
        rdAsagi.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdAsagiStateChanged(evt);
            }
        });
        rdAsagi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAsagiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(rdYukari)
                .addGap(18, 18, 18)
                .addComponent(rdAsagi)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdYukari)
                    .addComponent(rdAsagi))
                .addGap(15, 15, 15))
        );

        lblAranan1.setText("Değiştirilecek");

        btnDegistir.setText("Değiştir");
        btnDegistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDegistirActionPerformed(evt);
            }
        });

        btnTumunuDegistir.setText("Tümünü Değiştir");
        btnTumunuDegistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTumunuDegistirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAranan)
                                .addGap(18, 18, 18)
                                .addComponent(txtAranan, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAranan1)
                                .addGap(18, 18, 18)
                                .addComponent(txtDegistir, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAra, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDegistir, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbTamEslesme))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTumunuDegistir, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKapat, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAranan)
                    .addComponent(txtAranan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAranan1)
                    .addComponent(txtDegistir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDegistir))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chbTamEslesme))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnTumunuDegistir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKapat)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraActionPerformed
        cBul.degeriBul(metin_kutusu, txtAranan.getText(), buyuk_kucuk, yukari_yon);
    }//GEN-LAST:event_btnAraActionPerformed

    private void btnKapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKapatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKapatActionPerformed

    private void chbTamEslesmeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chbTamEslesmeStateChanged
        if (chbTamEslesme.isSelected()) {
            buyuk_kucuk = true;
        } else {
            buyuk_kucuk = false;
        }
    }//GEN-LAST:event_chbTamEslesmeStateChanged

    private void rdYukariStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdYukariStateChanged

    }//GEN-LAST:event_rdYukariStateChanged

    private void rdAsagiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdAsagiStateChanged

    }//GEN-LAST:event_rdAsagiStateChanged

    private void rdYukariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdYukariActionPerformed
        if (rdYukari.isSelected()) {
            yukari_yon = true;
            rdAsagi.setSelected(false);
        }
    }//GEN-LAST:event_rdYukariActionPerformed

    private void rdAsagiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAsagiActionPerformed
        if (rdYukari.isSelected()) {
            yukari_yon = false;
            rdYukari.setSelected(false);
        }
    }//GEN-LAST:event_rdAsagiActionPerformed

    private void btnDegistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDegistirActionPerformed
       cBul.degeriDegistir(metin_kutusu,txtAranan.getText(), txtDegistir.getText(), buyuk_kucuk, yukari_yon);
    }//GEN-LAST:event_btnDegistirActionPerformed

    private void btnTumunuDegistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTumunuDegistirActionPerformed
        cBul.tumunuDegistir(metin_kutusu,txtAranan.getText(), txtDegistir.getText(), buyuk_kucuk, yukari_yon);
    }//GEN-LAST:event_btnTumunuDegistirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnDegistir;
    private javax.swing.JButton btnKapat;
    private javax.swing.JButton btnTumunuDegistir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chbTamEslesme;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAranan;
    private javax.swing.JLabel lblAranan1;
    private javax.swing.JRadioButton rdAsagi;
    private javax.swing.JRadioButton rdYukari;
    private javax.swing.JTextField txtAranan;
    private javax.swing.JTextField txtDegistir;
    // End of variables declaration//GEN-END:variables
}
