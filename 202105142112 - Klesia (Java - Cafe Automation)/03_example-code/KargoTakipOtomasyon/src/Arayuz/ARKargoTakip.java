package Arayuz;

import Dosya.DosyaOku;
import Dosya.DosyaYaz;
import Kayit.Kisi;
import javax.swing.JOptionPane;

public class ARKargoTakip extends javax.swing.JFrame {

    public ARKargoTakip() {
        initComponents();
    }
    DosyaYaz dosyaYaz = new DosyaYaz();
    DosyaOku dosyaOku = new DosyaOku();

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtParola = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Id");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 30, 30));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 200, -1));

        jLabel2.setText("Parola");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 50, 30));
        getContentPane().add(txtParola, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 200, -1));

        jButton1.setText("Giriş");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 150, 50));

        pack();

        setTitle("Kişi");
        setSize(361, 208);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //361, 208
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            int num = Integer.parseInt(txtId.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Id rakam türünde olmalıdır");
            return;
        }
        Kisi kisi = dosyaOku.KisiBul(Integer.parseInt(txtId.getText()));
        if (kisi != null && kisi.getParola().equals(txtParola.getText())) {
            //JOptionPane.showMessageDialog(null, "Giriş Başarılı");
            ARKargolarKisi kargolarKisi = new ARKargolarKisi(kisi.getId());
        } else {
            JOptionPane.showMessageDialog(null, "Id veya Parola hatalı !");
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtId;
    private javax.swing.JPasswordField txtParola;

}
