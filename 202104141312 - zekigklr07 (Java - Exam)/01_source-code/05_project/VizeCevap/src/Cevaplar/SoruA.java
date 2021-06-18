
package Cevaplar;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SoruA extends javax.swing.JFrame {

    /**
     * Creates new form SoruA
     */
    public SoruA() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtableSonuc = new javax.swing.JTable();
        txtBaslangic = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtBitis = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jbuttonHesapla = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtableSonuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sayı", "Bolen", "Sonuc"
            }
        ));
        jScrollPane1.setViewportView(jtableSonuc);

        txtBaslangic.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel1.setText("Başlangıç");

        txtBitis.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel2.setText("Bitiş");

        jbuttonHesapla.setText("Recursive Artan Asal Sayı Bulma");
        jbuttonHesapla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbuttonHesaplaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbuttonHesapla, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(16, 16, 16)
                        .addComponent(txtBaslangic, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(16, 16, 16)
                        .addComponent(txtBitis, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBaslangic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtBitis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jbuttonHesapla)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    //butonun tıklama eventi(olayı)
    private void jbuttonHesaplaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbuttonHesaplaActionPerformed
        
        //tablo modeli bir model nesnesine aktarılıyor
        DefaultTableModel model = (DefaultTableModel) jtableSonuc.getModel();
        //modeldeki tüm satırlar siliniyor
        model.setRowCount(0);
    
        //baslangic ve bitisin bos olma durumu kontrol ediliyor
        if (txtBaslangic.getText().equals("") || txtBitis.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Gerekli alanları doldurunuz");
            return;
        }

        //baslangic degeri bir int değişkene atanıyor
        int baslangic = Integer.valueOf(txtBaslangic.getText());
        //baslangic değerinin 1 olma durumu kontrol ediliyor
        if(baslangic == 1){
            JOptionPane.showMessageDialog(this, "1'den başlanamaz !");
            return;
        }
        //bitis degeri bir int değişkene atanıyor       
        int bitis = Integer.valueOf(txtBitis.getText());

        //bir dongü içinde bslangıçtan, bitişe gidiliyor
        for (int i = baslangic; i < bitis; i++) {
            //ArtanRecursiveAsal methoduna o anki sayı ve başlangı değeri olarak en küçük asal sayı olan 2 veriliyor
            //methodan dönen sonuç bir değişkene atanıyor
            int sonuc = ArtanRecursiveAsal(2, i);
            //sonuc 1 ise asalDurum değişkenine "Asal" metni değilse "Asal Değil" metni atanıyor
            String asalDurum = sonuc == 1 ? "Asal" : "Asal Değil";

            //modele bir satır ekleniyor (eklenen değerler sırasıyla o anki sayı, eğer asal değilse ilk bölündüğü sayı ve asallık durumu)
            model.addRow(new Object[]{i, sonuc, asalDurum});

            jtableSonuc.setModel(model);
        }


    }//GEN-LAST:event_jbuttonHesaplaActionPerformed

    //hesaplama methodu
    public int ArtanRecursiveAsal(int bolen, int sayi) {
        //o anki bolen değeri sayıya eşitse daha önceden bölüm olmadığından sayı asaldır ve geriye 1 dönülür
        if (bolen == sayi) {
            return 1;
        }
        //sayı o anki bölene bölünmüşse asal değildir ve o an onu bölen dönülür
        if (sayi % bolen == 0) {
            return bolen;
        }
        //yukardaki şart gerçerli değilse devam edilir ve methodun kendi çağrılır
         else {
            return ArtanRecursiveAsal(bolen + 1, sayi);
        }
    }

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
            java.util.logging.Logger.getLogger(SoruA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SoruA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SoruA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SoruA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SoruA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbuttonHesapla;
    private javax.swing.JTable jtableSonuc;
    private javax.swing.JFormattedTextField txtBaslangic;
    private javax.swing.JFormattedTextField txtBitis;
    // End of variables declaration//GEN-END:variables
}
