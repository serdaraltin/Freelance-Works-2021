
import javax.swing.JTextArea;

public class Bul extends javax.swing.JFrame {

    public JTextArea metin_kutusu;
    boolean buyuk_kucuk = false;
    boolean yukari_yon = false;
    int sonIndex = 0;
    BulDegistir cBul = new BulDegistir();

    public Bul() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        r_asagi.setSelected(true);
    }

    private void initComponents() {

        laranan = new javax.swing.JLabel();
        t_aranan = new javax.swing.JTextField();
        b_ara = new javax.swing.JButton();
        c_buyukkucuk = new javax.swing.JCheckBox();
        b_kapat = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        r_yukari = new javax.swing.JRadioButton();
        r_asagi = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        laranan.setText("Aranacak");

        b_ara.setText("Ara");
        b_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAraActionPerformed(evt);
            }
        });

        c_buyukkucuk.setText("Tam Eşleşme");
        c_buyukkucuk.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chbTamEslesmeStateChanged(evt);
            }
        });

        b_kapat.setText("Kapat");
        b_kapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKapatActionPerformed(evt);
            }
        });

        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Yön"));
        panel.setToolTipText("");
        panel.setName(""); 

        r_yukari.setText("Yukarı");
        r_yukari.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdYukariStateChanged(evt);
            }
        });
        r_yukari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdYukariActionPerformed(evt);
            }
        });

        r_asagi.setText("Aşağı");
        r_asagi.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rdAsagiStateChanged(evt);
            }
        });
        r_asagi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdAsagiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel);
        panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(r_yukari)
                .addGap(18, 18, 18)
                .addComponent(r_asagi)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(r_yukari)
                    .addComponent(r_asagi))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(laranan)
                                .addGap(18, 18, 18)
                                .addComponent(t_aranan, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(b_ara, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(c_buyukkucuk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(b_kapat, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laranan)
                    .addComponent(t_aranan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_ara))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(c_buyukkucuk)
                    .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(b_kapat)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {
        cBul.degeriBul(metin_kutusu, t_aranan.getText(), buyuk_kucuk, yukari_yon);
    }

    private void btnKapatActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }

    private void chbTamEslesmeStateChanged(javax.swing.event.ChangeEvent evt) {
        if (c_buyukkucuk.isSelected()) {
            buyuk_kucuk = true;
        } else {
            buyuk_kucuk = false;
        }
    }

    private void rdYukariStateChanged(javax.swing.event.ChangeEvent evt) {

    }

    private void rdAsagiStateChanged(javax.swing.event.ChangeEvent evt) {

    }

    private void rdYukariActionPerformed(java.awt.event.ActionEvent evt) {
        if (r_yukari.isSelected()) {
            yukari_yon = true;
            r_asagi.setSelected(false);
        }
    }

    private void rdAsagiActionPerformed(java.awt.event.ActionEvent evt) {
        if (r_yukari.isSelected()) {
            yukari_yon = false;
            r_yukari.setSelected(false);
        }
    }


    private javax.swing.JButton b_ara;
    private javax.swing.JButton b_kapat;
    private javax.swing.JCheckBox c_buyukkucuk;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel laranan;
    private javax.swing.JRadioButton r_asagi;
    private javax.swing.JRadioButton r_yukari;
    private javax.swing.JTextField t_aranan;
}
