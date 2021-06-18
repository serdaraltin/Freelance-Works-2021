package View;

import Controller.Controller_Bul;
import Controller.Controller_Dosya;
import Controller.Controller_Yazim;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.undo.UndoManager;

public class View_AnaPencere extends javax.swing.JFrame {

    Controller_Dosya controller_Dosya = new Controller_Dosya();
    Controller_Yazim controller_Yazim = new Controller_Yazim();
    Controller_Bul controller_Bul = new Controller_Bul();
    View_Bul view_Bul = new View_Bul();
    View_Degistir view_Degistir = new View_Degistir();
    UndoManager undoManager = new UndoManager();

    boolean kayitDurum;
    boolean yeniDosya;
    String dosyaAdi;
    String baslik = "Proje-1";

    File dosya = null;
    JFileChooser dosyaSec;

    ArrayList<String> kelimeler = controller_Dosya.dosyaOkuListe(new File("words.txt"));

    public View_AnaPencere() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle(baslik);
        txtMetin.getDocument().addUndoableEditListener(undoManager);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMetin = new javax.swing.JTextArea();
        jMenuBar2 = new javax.swing.JMenuBar();
        dosyaMenu = new javax.swing.JMenu();
        dosyaolustur = new javax.swing.JMenuItem();
        dosyac = new javax.swing.JMenuItem();
        dosyakaydet = new javax.swing.JMenuItem();
        dosyakapat = new javax.swing.JMenuItem();
        duzenleMenu = new javax.swing.JMenu();
        gerial = new javax.swing.JMenuItem();
        hatabul = new javax.swing.JMenuItem();
        duzelt = new javax.swing.JMenuItem();
        araMenu = new javax.swing.JMenu();
        bul = new javax.swing.JMenuItem();
        degistir = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        txtMetin.setColumns(20);
        txtMetin.setRows(5);
        jScrollPane1.setViewportView(txtMetin);

        dosyaMenu.setText("Dosya");

        dosyaolustur.setText("Dosya Oluştur");
        dosyaolustur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyaolusturActionPerformed(evt);
            }
        });
        dosyaMenu.add(dosyaolustur);

        dosyac.setText("Dosya Aç");
        dosyac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyacActionPerformed(evt);
            }
        });
        dosyaMenu.add(dosyac);

        dosyakaydet.setText("Dosya Kaydet");
        dosyakaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyakaydetActionPerformed(evt);
            }
        });
        dosyaMenu.add(dosyakaydet);

        dosyakapat.setText("Dosya Kapat");
        dosyakapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyakapatActionPerformed(evt);
            }
        });
        dosyaMenu.add(dosyakapat);

        jMenuBar2.add(dosyaMenu);

        duzenleMenu.setText("Düzenle");

        gerial.setText("Geri Al");
        gerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerialActionPerformed(evt);
            }
        });
        duzenleMenu.add(gerial);

        hatabul.setText("Hataları Bul");
        hatabul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hatabulActionPerformed(evt);
            }
        });
        duzenleMenu.add(hatabul);

        duzelt.setText("Hataları Düzelt");
        duzelt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duzeltActionPerformed(evt);
            }
        });
        duzenleMenu.add(duzelt);

        jMenuBar2.add(duzenleMenu);

        araMenu.setText("Ara");

        bul.setText("Bul");
        bul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulActionPerformed(evt);
            }
        });
        araMenu.add(bul);

        degistir.setText("Değiştir");
        degistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degistirActionPerformed(evt);
            }
        });
        araMenu.add(degistir);

        jMenuBar2.add(araMenu);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dosyacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyacActionPerformed
        dosya = controller_Dosya.dosyaAc(dosya, txtMetin, this);

    }//GEN-LAST:event_dosyacActionPerformed

    private void dosyaolusturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyaolusturActionPerformed
        dosya = controller_Dosya.dosyaOlustur(dosya, txtMetin.getText(), this);
    }//GEN-LAST:event_dosyaolusturActionPerformed

    private void dosyakapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyakapatActionPerformed
        if (dosya == null) {
            JOptionPane.showMessageDialog(this, "Herhangi bir dosya açık değil.");
            return;
        }
        dosya = controller_Dosya.dosyaKapa(dosya, txtMetin, this);
    }//GEN-LAST:event_dosyakapatActionPerformed

    private void dosyakaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyakaydetActionPerformed
        dosya = controller_Dosya.dosyaKaydet(dosya, txtMetin.getText(), this);
    }//GEN-LAST:event_dosyakaydetActionPerformed

    private void bulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bulActionPerformed

        view_Bul.txtMetin = this.txtMetin;
        view_Bul.setVisible(true);
    }//GEN-LAST:event_bulActionPerformed

    private void degistirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degistirActionPerformed
        view_Degistir.txtMetin = this.txtMetin;
        view_Degistir.setVisible(true);
    }//GEN-LAST:event_degistirActionPerformed

    private void gerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gerialActionPerformed
        undoManager.undo();
    }//GEN-LAST:event_gerialActionPerformed

    private void hatabulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hatabulActionPerformed
        int hataAdet = controller_Yazim.hataKontrol(txtMetin, kelimeler);
        if (hataAdet > 0) {
            JOptionPane.showMessageDialog(this, hataAdet + " adet yazım hatası bulundu.");
        }
    }//GEN-LAST:event_hatabulActionPerformed

    private void duzeltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duzeltActionPerformed
        boolean hataAdet = controller_Yazim.hataDuzelt(txtMetin, kelimeler);
        if (hataAdet) {
            JOptionPane.showMessageDialog(this, "Yazım hataları düzeltildi.");
        }
    }//GEN-LAST:event_duzeltActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_AnaPencere.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new View_AnaPencere().setVisible(true);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu araMenu;
    private javax.swing.JMenuItem bul;
    private javax.swing.JMenuItem degistir;
    private javax.swing.JMenu dosyaMenu;
    private javax.swing.JMenuItem dosyac;
    private javax.swing.JMenuItem dosyakapat;
    private javax.swing.JMenuItem dosyakaydet;
    private javax.swing.JMenuItem dosyaolustur;
    private javax.swing.JMenuItem duzelt;
    private javax.swing.JMenu duzenleMenu;
    private javax.swing.JMenuItem gerial;
    private javax.swing.JMenuItem hatabul;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtMetin;
    // End of variables declaration//GEN-END:variables

}
