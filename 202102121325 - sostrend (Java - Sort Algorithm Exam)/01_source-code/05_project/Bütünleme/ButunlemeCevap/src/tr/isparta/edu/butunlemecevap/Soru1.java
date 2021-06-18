package tr.isparta.edu.butunlemecevap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author drhal
 */
public class Soru1 extends javax.swing.JFrame {

    public Soru1() {
        initComponents();
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void BubbleSort(int[] dizi) {
        int n = dizi.length;
        
        for (int i = 0; i < n - 1; i++) {
          
            for (int j = 0; j < n - i - 1; j++) {
                
                if (dizi[j] > dizi[j + 1]) {
                    int gecici = dizi[j];
                    dizi[j] = dizi[j + 1];
                    dizi[j + 1] = gecici;
               
                }
            }
            
        }
    }

    public void SelectionSort(int[] dizi) {
        int n = dizi.length;
       
        for (int i = 0; i < n - 1; i++) {

            int minimum = i;
            
            for (int j = i + 1; j < n; j++) {
                if (dizi[j] < dizi[minimum]) {
                    minimum = j;
                }
            }
            
            int gecici = dizi[minimum];
            dizi[minimum] = dizi[i];
            dizi[i] = gecici;
        }
    }

    public void InsertionSort(int[] dizi) {
        int n = dizi.length;
        for (int i = 1; i < n; ++i) {
           
            int sayi = dizi[i];
            int j = i - 1;

            while (j >= 0 && dizi[j] > sayi) {
                dizi[j + 1] = dizi[j];
                j = j - 1;
            }
          
            dizi[j + 1] = sayi;
        }
    }

    public void DosyaOku(int secim) {
        try {
            File dosya = new File("matris.txt");
            File cikti = new File("soru1.txt");
            FileWriter fileWriter;

            cikti.createNewFile();
            fileWriter = new FileWriter(cikti);

            Scanner scanner = new Scanner(dosya);
            lblBilgi.setText("Bilgi : Okunuyor ve sıralanıyor...");
            while (scanner.hasNextLine()) {
                
                String[] satir = scanner.nextLine().split(",");
                int[] dizi = new int[satir.length];

                for (int i = 0; i < satir.length; i++) {
                    dizi[i] = Integer.valueOf(satir[i]);
                }
                
                switch (secim) {
                    case 0:
                        BubbleSort(dizi);
                        break;
                    case 1:
                        SelectionSort(dizi);
                        break;
                    case 2:
                        InsertionSort(dizi);
                        break;
                }

                for (int i = 0; i < dizi.length; i++) {
                    fileWriter.write(String.valueOf(dizi[i]));
                    if (i < dizi.length - 1) {
                        fileWriter.write(",");
                    }
                }
                
                fileWriter.write("\n");
                
            }
            lblBilgi.setText("Bilgi : İşlem tamamlandı.");
            fileWriter.close();
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Soru1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Soru1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbSiralamaAlgoritmasi = new javax.swing.JComboBox<>();
        btnSirala = new javax.swing.JButton();
        lblBilgi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Soru1");

        cbSiralamaAlgoritmasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elemeli Sıralama (Bubble Sort)", "Seçmeli Sıralama (Selection Sort)", "Eklemeli Sıralama (Insertion Sort)" }));

        btnSirala.setText("SIRALA");
        btnSirala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiralaActionPerformed(evt);
            }
        });

        lblBilgi.setForeground(new java.awt.Color(0, 51, 204));
        lblBilgi.setText("Bilgi : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBilgi)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbSiralamaAlgoritmasi, 0, 295, Short.MAX_VALUE)
                        .addComponent(btnSirala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(cbSiralamaAlgoritmasi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSirala, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBilgi)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiralaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiralaActionPerformed
        DosyaOku(cbSiralamaAlgoritmasi.getSelectedIndex());
    }//GEN-LAST:event_btnSiralaActionPerformed

    public static void main(String args[]) {
        new Soru1().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSirala;
    private javax.swing.JComboBox<String> cbSiralamaAlgoritmasi;
    private javax.swing.JLabel lblBilgi;
    // End of variables declaration//GEN-END:variables
}
