package View;

import Controller.Controller_Bul;

import javax.swing.JTextArea;

public class View_Bul extends javax.swing.JFrame {

    public JTextArea txtMetin;
    boolean tamEslesme = false;
    boolean yon = false;
    int lastIndex = 0;
    Controller_Bul controller_Bul = new Controller_Bul();

    public View_Bul() {
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
                .addContainerGap(33, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAranan)
                                .addGap(18, 18, 18)
                                .addComponent(txtAranan, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAra, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chbTamEslesme)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnKapat, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAranan)
                    .addComponent(txtAranan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAra))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chbTamEslesme)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnKapat)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraActionPerformed
        controller_Bul.bul(txtMetin, txtAranan.getText(), tamEslesme, yon);
    }//GEN-LAST:event_btnAraActionPerformed

    private void btnKapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKapatActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnKapatActionPerformed

    private void chbTamEslesmeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chbTamEslesmeStateChanged
        if (chbTamEslesme.isSelected()) {
            tamEslesme = true;
        } else {
            tamEslesme = false;
        }
    }//GEN-LAST:event_chbTamEslesmeStateChanged

    private void rdYukariStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdYukariStateChanged

    }//GEN-LAST:event_rdYukariStateChanged

    private void rdAsagiStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rdAsagiStateChanged

    }//GEN-LAST:event_rdAsagiStateChanged

    private void rdYukariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdYukariActionPerformed
        if (rdYukari.isSelected()) {
            yon = true;
            rdAsagi.setSelected(false);
        }
    }//GEN-LAST:event_rdYukariActionPerformed

    private void rdAsagiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdAsagiActionPerformed
        if (rdYukari.isSelected()) {
            yon = false;
            rdYukari.setSelected(false);
        }
    }//GEN-LAST:event_rdAsagiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnKapat;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chbTamEslesme;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAranan;
    private javax.swing.JRadioButton rdAsagi;
    private javax.swing.JRadioButton rdYukari;
    private javax.swing.JTextField txtAranan;
    // End of variables declaration//GEN-END:variables
}
