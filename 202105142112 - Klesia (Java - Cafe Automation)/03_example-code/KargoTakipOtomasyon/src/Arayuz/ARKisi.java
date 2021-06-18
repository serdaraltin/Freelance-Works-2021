package Arayuz;

import Dosya.DosyaOku;
import Dosya.DosyaYaz;
import Kayit.Kisi;
import java.util.Random;
import javax.swing.JOptionPane;

public class ARKisi extends javax.swing.JFrame {

    int id = 0;

    DosyaYaz dosyaYaz = new DosyaYaz();
    DosyaOku dosyaOku = new DosyaOku();

    public ARKisi() {
        initComponents();
        txtId.setText(String.valueOf(UretId()));
    }

    public ARKisi(int _id) {
        initComponents();
        id = _id;
        Kisi kisi = dosyaOku.KisiBul(id);
        if (kisi != null) {
            txtId.setText(String.valueOf(id));
            txtAd.setText(kisi.getAd());
            txtSoyad.setText(kisi.getSoyad());
            txtParola.setText(kisi.getParola());
            btnKisiEkle.setText("Kişi Güncelle");
        }

    }

    public int UretId() {
        Random rast = new Random();
        return rast.nextInt((99999 - 10000) + 1) + 10000;
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JFormattedTextField();
        txtAd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSoyad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtParola = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnKisiEkle = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Id");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 30));

        txtId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtId.setEnabled(false);

        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 110, 30));

        getContentPane().add(txtAd, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 190, -1));

        jLabel2.setText("Ad");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 30));
        getContentPane().add(txtSoyad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 190, -1));

        jLabel3.setText("Soyad");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 40, 30));
        getContentPane().add(txtParola, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 190, -1));

        jLabel4.setText("Parola");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 40, 30));

        btnKisiEkle.setText("Kişi EKLE");
        btnKisiEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKisiEkleActionPerformed(evt);
            }
        });
        getContentPane().add(btnKisiEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 190, 50));

        pack();

        setTitle("Kişi");
        setSize(310, 320);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void btnKisiEkleActionPerformed(java.awt.event.ActionEvent evt) {
        Kisi kisi = new Kisi(Integer.parseInt(txtId.getText()), txtAd.getText(), txtSoyad.getText(), txtParola.getText());
        if (id == 0) {
            if (dosyaYaz.YazKisi(kisi)) {
                JOptionPane.showMessageDialog(null, "Kişi Eklendi");
                txtId.setText(String.valueOf(UretId()));
            } else {
                JOptionPane.showMessageDialog(null, "HATA");
            }
        } else {
            if (dosyaYaz.GuncelleKisi(kisi)) {
                JOptionPane.showMessageDialog(null, "Kişi Güncellendi");
            } else {
                JOptionPane.showMessageDialog(null, "HATA");
            }
        }
    }

    private javax.swing.JButton btnKisiEkle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtAd;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JTextField txtParola;
    private javax.swing.JTextField txtSoyad;

}
