package tr.isparta.edu.butunlemecevap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author drhal
 */
public final class Soru3 extends javax.swing.JFrame {

    public Soru3() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        DosyaOku();
    }

    public void DosyaOku() {

        try {
            File dosyaKargo = new File("kelimeler.txt");
            if (!dosyaKargo.exists()) {
                lblBilgi.setText("Bilgi : Dosya bulunamadi.");
                return;
            }
            lblBilgi.setText("Bilgi : Dosya okunuyor...");
            Scanner scanner = new Scanner(dosyaKargo);
            DefaultTableModel model = (DefaultTableModel) tblKelimeler.getModel();

            model.setRowCount(0);
            int i = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                model.addRow(new Object[]{
                    i, line
                });
                i++;
            }
            if (i == 1) {
                lblBilgi.setText("Bilgi : Dosya bos.");
                return;
            }
            lblBilgi.setText("Bilgi : Dosya okundu.");
            btnAra.setEnabled(true);
            txtKelime.setEnabled(true);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Soru3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean KelimeAra(String kelime) {
        DefaultListModel dlm = new DefaultListModel();
        dlm.clear();

        DefaultTableModel dtm = (DefaultTableModel) tblKelimeler.getModel();
        
        lblBilgi.setText("Bilgi : Kelime araniyor...");
        int i;
        for (i = 0; i < dtm.getRowCount(); i++) {
            if (((String) dtm.getValueAt(i, 1)).equals(kelime)) {
                dlm.addElement(i + " : " + kelime);
            }
        }
        lstBulunan.setModel(dlm);
        if (dlm.getSize() == 0) {
             lblBilgi.setText("Bilgi : Kelime bulunamadi.");
            return false;
        }
        lblBilgi.setText("Bilgi : Kelime bulundu.");
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblKelimeler = new javax.swing.JTable();
        btnAra = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtKelime = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstBulunan = new javax.swing.JList<>();
        lblBilgi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Soru 3");
        setResizable(false);

        tblKelimeler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Satir", "Kelime"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblKelimeler);

        btnAra.setText("Ara");
        btnAra.setEnabled(false);
        btnAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAraActionPerformed(evt);
            }
        });

        jLabel1.setText("Kelime");

        txtKelime.setEnabled(false);

        jScrollPane2.setViewportView(lstBulunan);

        lblBilgi.setForeground(new java.awt.Color(0, 51, 204));
        lblBilgi.setText("Bilgi : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblBilgi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtKelime, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAra, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAra)
                    .addComponent(txtKelime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblBilgi)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraActionPerformed
        if (txtKelime.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Lütfen kelime giriniz");
            return;
        }
        KelimeAra(txtKelime.getText());

    }//GEN-LAST:event_btnAraActionPerformed

    public static void main(String args[]) {
        new Soru3();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBilgi;
    private javax.swing.JList<String> lstBulunan;
    private javax.swing.JTable tblKelimeler;
    private javax.swing.JTextField txtKelime;
    // End of variables declaration//GEN-END:variables

}
