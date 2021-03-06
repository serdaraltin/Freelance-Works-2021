/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.isparta.edu.tr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author drhal
 */
public class Soru2 extends javax.swing.JFrame {

    String dosyaYol = "", dosyaAd = "";

    /**
     * Creates new form Soru2
     */
    public Soru2() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTDosya = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jBOlustur = new javax.swing.JButton();
        jBSec = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bölüm İsmi");
        jLabel1.setToolTipText("");

        jTDosya.setEnabled(false);

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jScrollPane1.setViewportView(jTextArea);

        jBOlustur.setText("Oluştur");
        jBOlustur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOlusturActionPerformed(evt);
            }
        });

        jBSec.setText("Seç");
        jBSec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jTDosya, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBSec, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBOlustur, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTDosya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBSec))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBOlustur)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String karakterTemizle(String metin) {
        String yeni = "";
        char[] turkceKarakterler = {'Ş', 'ş', 'Ç', 'ç', 'İ', 'ı', 'Ğ', 'ğ', 'Ü', 'ü', 'Ö', 'ö', ' '};
        char[] duzeltilmis = {'S', 's', 'C', 'c', 'I', 'i', 'G', 'G', 'U', 'u', 'O', 'o', '_'};

        for (int i = 0; i < metin.length(); i++) {
            boolean yok = true;
            for (int j = 0; j < turkceKarakterler.length; j++) {
                if (metin.charAt(i) == turkceKarakterler[j]) {
                    yeni += duzeltilmis[j];
                    yok = false;
                    break;
                }
            }
            if (yok) {
                yeni += metin.charAt(i);
            }
        }
        for (int i = 0; i < 10; i++) {

        }
        return yeni;
    }
    private void jBOlusturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOlusturActionPerformed
        if (dosyaYol == "") {
            JOptionPane.showMessageDialog(this, "Dosya yolu boş bırakılamaz !!!");
            return;
        }
        dosyaYol = karakterTemizle(dosyaYol);

        try {
            FileWriter yaz = new FileWriter(dosyaYol);
            PrintWriter printWriter = new PrintWriter(yaz);

            printWriter.print(jTextArea.getText());

            printWriter.close();
        JOptionPane.showMessageDialog(this, "Dosya oluşturuldu");
        } catch (IOException ex) {
            Logger.getLogger(Soru1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jBOlusturActionPerformed

    private void jBSecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSecActionPerformed
        JFileChooser dosyaSec = new JFileChooser();
        dosyaSec.setDialogTitle("dosya adı");

        int userSelection = dosyaSec.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = dosyaSec.getSelectedFile();
            dosyaYol = dosyaSec.getSelectedFile().getPath();
            System.out.println(dosyaYol);
            dosyaAd = dosyaSec.getSelectedFile().getName();
            jTDosya.setText(dosyaYol);
        }
    }//GEN-LAST:event_jBSecActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Soru2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Soru2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Soru2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Soru2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Soru2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBOlustur;
    private javax.swing.JButton jBSec;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTDosya;
    private javax.swing.JTextArea jTextArea;
    // End of variables declaration//GEN-END:variables
}
