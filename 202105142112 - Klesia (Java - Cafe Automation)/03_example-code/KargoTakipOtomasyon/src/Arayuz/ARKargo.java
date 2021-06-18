package Arayuz;

import Dosya.DosyaOku;
import Dosya.DosyaYaz;
import Kayit.Kargo;
import java.util.Random;
import javax.swing.JOptionPane;

public class ARKargo extends javax.swing.JFrame {

    int id = 0;

    DosyaYaz dosyaYaz = new DosyaYaz();
    DosyaOku dosyaOku = new DosyaOku();

    public ARKargo() {
        initComponents();
        txtId.setText(String.valueOf(UretId()));
    }

    public ARKargo(int _id) {
        initComponents();
        id = _id;
        Kargo kargo = dosyaOku.KargoBul(id);
        if (kargo != null) {
            txtId.setText(String.valueOf(kargo.getId()));
            txtGondericiId.setText(String.valueOf(kargo.getGondericiId()));
            txtAliciId.setText(String.valueOf(kargo.getAliciId()));
            txtGondericiAdres.setText(kargo.getGondericiAdres());
            txtAliciAdres.setText(kargo.getAliciAdres());
            txtUcret.setText(String.valueOf(kargo.getUcret()));
        }
    }

    public int UretId() {
        Random rast = new Random();
        return rast.nextInt((99999 - 10000) + 1) + 10000;
    }

    public double UcretHesapla(int km, int uzunluk, int yukseklik, int genislik) {
        return uzunluk * yukseklik * genislik * km * 0.000003 + 5;
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtGondericiId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAliciId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGondericiAdres = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAliciAdres = new javax.swing.JTextArea();
        txtMesafe = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtBoyut = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUcret = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnKargoEkle = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kargo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Id");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        txtId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        txtId.setEnabled(false);
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 120, 30));

        jLabel2.setText("Gönderici \nAdres");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 110, 30));

        getContentPane().add(txtGondericiId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 120, -1));

        jLabel3.setText("Mesafe(km)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, 30));

        getContentPane().add(txtAliciId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 120, -1));

        txtGondericiAdres.setColumns(20);
        txtGondericiAdres.setRows(5);
        jScrollPane1.setViewportView(txtGondericiAdres);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        jLabel4.setText("Gönderici Id");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 30));

        jLabel5.setText("Alıcı  Adres");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 110, 30));

        txtAliciAdres.setColumns(20);
        txtAliciAdres.setRows(5);
        jScrollPane2.setViewportView(txtAliciAdres);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        getContentPane().add(txtMesafe, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 120, 30));

        jLabel6.setText("Alıcı Id");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 30));

        jLabel7.setText("Boyut(uzunluk,yükseklik,genişlik)");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, 30));

        getContentPane().add(txtBoyut, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 120, 30));

        jLabel8.setText("Ücret");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, -1, 30));

        txtUcret.setEnabled(false);
        getContentPane().add(txtUcret, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 80, -1));

        jLabel9.setText("TL");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, -1, 30));

        btnKargoEkle.setText("Kargo Ekle");
        btnKargoEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKargoEkleActionPerformed(evt);
            }
        });
        getContentPane().add(btnKargoEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 220, 60));

        pack();
        setTitle("Kargo");
        setSize(385, 585);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    private void btnKargoEkleActionPerformed(java.awt.event.ActionEvent evt) {
        txtUcret.setText(String.valueOf(UcretHesapla(
                Integer.parseInt(txtMesafe.getText()),
                Integer.parseInt(txtBoyut.getText().split(",")[0]),
                Integer.parseInt(txtBoyut.getText().split(",")[1]),
                Integer.parseInt(txtBoyut.getText().split(",")[2])
        )));

        Kargo kargo = new Kargo(Integer.parseInt(txtId.getText()), Integer.parseInt(txtGondericiId.getText()),
                Integer.parseInt(txtAliciId.getText()), txtGondericiAdres.getText(), txtAliciAdres.getText(), Float.parseFloat(txtUcret.getText()));

        if (id == 0) {
            if (dosyaYaz.YazKargo(kargo)) {
                JOptionPane.showMessageDialog(null, "Kargo Eklendi");
                 txtId.setText(String.valueOf(UretId()));
            } else {
                JOptionPane.showMessageDialog(null, "HATA");
            }
        } else {
            if (dosyaYaz.GuncelleKargo(kargo)) {
                JOptionPane.showMessageDialog(null, "Kargo Güncellendi");
            } else {
                JOptionPane.showMessageDialog(null, "HATA");
            }
        }
    }

    private javax.swing.JButton btnKargoEkle;
    private javax.swing.JTextField txtAliciId;
    private javax.swing.JTextField txtGondericiId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAliciAdres;
    private javax.swing.JFormattedTextField txtBoyut;
    private javax.swing.JTextArea txtGondericiAdres;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JFormattedTextField txtMesafe;
    private javax.swing.JTextField txtUcret;

}
