package tr.isparta.edu.cevaplar;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Mustafa Kehya
 */
public class Soru1 extends javax.swing.JFrame {

    static ArrayList<Integer> listTamSayi = new ArrayList<>();
    static ArrayList<Double> listOndalikliSayi = new ArrayList<>();
    String pathOndalikliSayi = "", pathTamSayi = "";

    public Soru1() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBOtomobilDosyasi = new javax.swing.JButton();
        JBOndalikliAktar = new javax.swing.JButton();
        jBTamsayilariAktar = new javax.swing.JButton();
        jBAktar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 255, 255));

        jBOtomobilDosyasi.setText("Otomabil Dosyası");
        jBOtomobilDosyasi.setMaximumSize(new java.awt.Dimension(141, 33));
        jBOtomobilDosyasi.setMinimumSize(new java.awt.Dimension(141, 33));
        jBOtomobilDosyasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOtomobilDosyasiActionPerformed(evt);
            }
        });

        JBOndalikliAktar.setText("Ondalıklıları Aktar");
        JBOndalikliAktar.setPreferredSize(new java.awt.Dimension(136, 33));
        JBOndalikliAktar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBOndalikliAktarActionPerformed(evt);
            }
        });

        jBTamsayilariAktar.setText("Tam Sayıları Aktar");
        jBTamsayilariAktar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTamsayilariAktarActionPerformed(evt);
            }
        });

        jBAktar.setText("Aktar");
        jBAktar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAktarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JBOndalikliAktar, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBTamsayilariAktar, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBAktar, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBOtomobilDosyasi, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jBOtomobilDosyasi, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBOndalikliAktar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBTamsayilariAktar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBAktar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBOtomobilDosyasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOtomobilDosyasiActionPerformed
        JFileChooser dosya = new JFileChooser();

        int result = dosya.showOpenDialog(this);
        String pathOtomobilDosya = "";
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = dosya.getSelectedFile();
            pathOtomobilDosya = selectedFile.getAbsolutePath();
        }
        if (pathOtomobilDosya != "") {
            try {
                Scanner scanner = new Scanner(new File(pathOtomobilDosya));
                while (scanner.hasNextLine()) {
                    String[] satir = scanner.nextLine().split("	");
                    for (int i = 0; i < satir.length; i++) {
                        if (i == 5 ){
                            listTamSayi.add(Integer.valueOf(satir[i]));
                        }
                        if (i == 2){
                            listTamSayi.add(Integer.valueOf(satir[i]));
                        }
                        if (i == 3){
                            listOndalikliSayi.add(Double.valueOf(satir[i]));
                        }
                    }
                }
              
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Soru1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //System.out.println(listTamSayi+"\n"+listOndalikliSayi);
    }//GEN-LAST:event_jBOtomobilDosyasiActionPerformed

    private void JBOndalikliAktarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBOndalikliAktarActionPerformed
        JFileChooser dosya = new JFileChooser();
        if (dosya.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = dosya.getSelectedFile();
            pathOndalikliSayi = selectedFile.getAbsolutePath();
        }
       
    }//GEN-LAST:event_JBOndalikliAktarActionPerformed

    private void jBAktarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAktarActionPerformed
     
        try {
            FileWriter dosyaYaz = new FileWriter(pathOndalikliSayi);
            try (PrintWriter dosyaYazdir = new PrintWriter(dosyaYaz)) {
                for (int i = 0; i < listOndalikliSayi.size(); i++) {
                    if(i > 0 )
                        dosyaYazdir.print("\n");
                    dosyaYazdir.print(String.valueOf(listOndalikliSayi.get(i)+"   "));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Soru1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            FileWriter dosyaYaz = new FileWriter(pathTamSayi);
            try (PrintWriter dosyaYazdir = new PrintWriter(dosyaYaz)) {
                for (int i = 0; i < listTamSayi.size(); i++) {
                    if(i > 0 && i % 2 == 0)
                        dosyaYazdir.print("\n");
                    dosyaYazdir.print(String.valueOf(listTamSayi.get(i)+" "));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Soru1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(this, "Dosya yazma işlemi tamamlandı.");
    }//GEN-LAST:event_jBAktarActionPerformed

    private void jBTamsayilariAktarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTamsayilariAktarActionPerformed
        JFileChooser dosya = new JFileChooser();
        if (dosya.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = dosya.getSelectedFile();
            pathTamSayi = selectedFile.getAbsolutePath();
        }
    }//GEN-LAST:event_jBTamsayilariAktarActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Soru1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBOndalikliAktar;
    private javax.swing.JButton jBAktar;
    private javax.swing.JButton jBOtomobilDosyasi;
    private javax.swing.JButton jBTamsayilariAktar;
    // End of variables declaration//GEN-END:variables
}
