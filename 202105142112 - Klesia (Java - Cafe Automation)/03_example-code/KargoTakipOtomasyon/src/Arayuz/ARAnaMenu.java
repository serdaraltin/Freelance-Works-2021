package Arayuz;

public class ARAnaMenu extends javax.swing.JFrame {

    public ARAnaMenu() {
        initComponents();
    }

    private void initComponents() {

        btnCikis = new javax.swing.JButton();
        btnYoneticiGiris = new javax.swing.JButton();
        btnKargoTakip = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCikis.setText("Çıkış");
        btnCikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCikisActionPerformed(evt);
            }
        });
        getContentPane().add(btnCikis, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 260, 50));

        btnYoneticiGiris.setText("Yonetici Giriş");
        btnYoneticiGiris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYoneticiGirisActionPerformed(evt);
            }
        });
        getContentPane().add(btnYoneticiGiris, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 260, 50));

        btnKargoTakip.setText("Kargo Takip");
        btnKargoTakip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKargoTakipActionPerformed(evt);
            }
        });
        getContentPane().add(btnKargoTakip, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 260, 50));

        pack();
    }

    private void btnYoneticiGirisActionPerformed(java.awt.event.ActionEvent evt) {
        ARYoneticiGiris yoneticiGiris = new ARYoneticiGiris();
        this.setVisible(false);
    }

    private void btnKargoTakipActionPerformed(java.awt.event.ActionEvent evt) {
        ARKargoTakip kargoTakip = new ARKargoTakip();
         this.setVisible(false);
    }

    private void btnCikisActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }
    
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ARAnaMenu AnaMenu = new ARAnaMenu();
                AnaMenu.setSize(340,285);
                AnaMenu.setLocationRelativeTo(null);
                AnaMenu.setVisible(true);
            }
        });
    }
    private javax.swing.JButton btnCikis;
    private javax.swing.JButton btnKargoTakip;
    private javax.swing.JButton btnYoneticiGiris;
}
