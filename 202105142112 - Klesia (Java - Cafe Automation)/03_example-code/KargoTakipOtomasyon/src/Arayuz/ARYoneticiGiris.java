package Arayuz;

import javax.swing.JOptionPane;

public class ARYoneticiGiris extends javax.swing.JFrame {

    public ARYoneticiGiris() {
        initComponents();
    }

    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 140, -1));

        jLabel1.setText("Kullanıcı Adı");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 30));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 140, -1));

        jLabel2.setText("Parola");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 30));

        jButton1.setText("Giriş");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 110, 40));

        pack();

        setTitle("Yönetici Giriş");
        setSize(300, 220);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTextField1.getText().equals("admin") && jTextField2.getText().equals("admin")) {
            ARYoneticiPanel yoneticiPanel = new ARYoneticiPanel();
            this.setVisible(false);
        }
        else{
            JOptionPane.showMessageDialog(null, "Kullanıcı Adı veya Parola hatalı");
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPasswordField jTextField2;

}
