package Arayuz;

public class ARYoneticiPanel extends javax.swing.JFrame {

    public ARYoneticiPanel() {
        initComponents();
    }

    private void initComponents() {

        btnKargolar = new javax.swing.JButton();
        btnKisiEkle = new javax.swing.JButton();
        btnKisiler = new javax.swing.JButton();
        btnCikis = new javax.swing.JButton();
        btnKargoEkle = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnKargolar.setText("Kargolar");
        btnKargolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKargolarActionPerformed(evt);
            }
        });
        getContentPane().add(btnKargolar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 150, 50));

        btnKisiEkle.setText("Kişi Ekle");
        btnKisiEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKisiEkleActionPerformed(evt);
            }
        });
        getContentPane().add(btnKisiEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 50));

        btnKisiler.setText("Kişiler");
        btnKisiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ARKisiler kisiler = new ARKisiler();
            }
        });
        getContentPane().add(btnKisiler, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 150, 50));

        btnCikis.setText("Çıkış");
        btnCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCikisActionPerformed(evt);
            }
        });
        getContentPane().add(btnCikis, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 150, 50));

        btnKargoEkle.setText("Kargo Ekle");
        btnKargoEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKargoEkleActionPerformed(evt);
            }
        });
        getContentPane().add(btnKargoEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 150, 50));

        pack();

        setTitle("Yönetici Panel");
        setSize(405, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void btnKisiEkleActionPerformed(java.awt.event.ActionEvent evt) {
        ARKisi kisi = new ARKisi();
    }

    private void btnKargoEkleActionPerformed(java.awt.event.ActionEvent evt) {
        ARKargo kargo = new ARKargo();
    }

    private void btnKargolarActionPerformed(java.awt.event.ActionEvent evt) {
        ARKargolar kargolar = new ARKargolar();
    }

    private void btnCikisActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private javax.swing.JButton btnCikis;
    private javax.swing.JButton btnKargoEkle;
    private javax.swing.JButton btnKargolar;
    private javax.swing.JButton btnKisiEkle;
    private javax.swing.JButton btnKisiler;
}
