package View;

import Controller.ControllerOgrenci;
import Controller.ControllerOgretimGorevlisi;
import Model.Ogrenci;
import Model.OgretimGorevlisi;
import Model.Talep;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ViewGirisKullanici extends javax.swing.JFrame {

    ArrayList<Talep> talepler;
    ArrayList<Ogrenci> ogrenciler;
    ArrayList<OgretimGorevlisi> ogrGorevliler;
    private int tur;

    public ViewGirisKullanici(
            ArrayList<Ogrenci> ogrenciler,
            ArrayList<OgretimGorevlisi> ogrGorevliler,ArrayList<Talep> talepler, int tur) {
        this.talepler = talepler;
        this.ogrenciler = ogrenciler;
        this.ogrGorevliler = ogrGorevliler;
        this.tur = tur;
        initComponents();
        setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtTcNo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kullanıcı Giriş");
        setResizable(false);

        jLabel1.setText("TC No");

        jButton1.setText("Giriş");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtTcNo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTcNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (txtTcNo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Gerekli alanaları doldurunuz!!!");
            return;
        }
        int hesapNo = -1;
        if (tur == 1) {
            hesapNo = new ControllerOgrenci().Kontrol(ogrenciler, txtTcNo.getText());
        }
        if (tur == 2) {
            hesapNo = new ControllerOgretimGorevlisi().Kontrol(ogrGorevliler, txtTcNo.getText());
        }
        if (hesapNo == -1) {
            JOptionPane.showMessageDialog(null, "Hatalı No veya Parola !");
            return;
        }
        new ViewIslemKullanici(talepler, hesapNo, tur).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtTcNo;
    // End of variables declaration//GEN-END:variables
}
