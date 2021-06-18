package View;

import Controller.Controller_Veritabani;
import javax.swing.JOptionPane;

public class View_Yonetim extends javax.swing.JFrame {

    public View_Yonetim() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        btnBilet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnFilm = new javax.swing.JButton();
        btnSeans = new javax.swing.JButton();
        btnSalon = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("YÖNETİM PANELİ");
        setResizable(false);

        btnBilet.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnBilet.setText("BİLET SATIŞI");
        btnBilet.setToolTipText("");
        btnBilet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBiletActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("YÖNETİM PANELİ");

        btnFilm.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnFilm.setText("FİLM YÖNETİM");
        btnFilm.setToolTipText("");
        btnFilm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilmActionPerformed(evt);
            }
        });

        btnSeans.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSeans.setText("SEANS YÖNETİM");
        btnSeans.setToolTipText("");
        btnSeans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeansActionPerformed(evt);
            }
        });

        btnSalon.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnSalon.setText("SALON YÖNETİM");
        btnSalon.setToolTipText("");
        btnSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalonActionPerformed(evt);
            }
        });

        jMenu1.setText("Dosya");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Kapat");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Veritabanı");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("Sıfırla");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBilet, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSeans, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(134, 134, 134))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBilet, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSeans, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        if (new Controller_Veritabani().Sıfırla()) {
            JOptionPane.showMessageDialog(null, "Veritabanı sıfılandı !");
            return;
        }
        JOptionPane.showMessageDialog(null, "İşlem başarısız");
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void btnBiletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBiletActionPerformed
        new View_Biletler().setVisible(true);
    }//GEN-LAST:event_btnBiletActionPerformed

    private void btnSeansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeansActionPerformed
        new View_Seanslar().setVisible(true);
    }//GEN-LAST:event_btnSeansActionPerformed

    private void btnFilmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilmActionPerformed
        new View_Filmler().setVisible(true);
    }//GEN-LAST:event_btnFilmActionPerformed

    private void btnSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalonActionPerformed
        new View_Salonlar().setVisible(true);
    }//GEN-LAST:event_btnSalonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBilet;
    private javax.swing.JButton btnFilm;
    private javax.swing.JButton btnSalon;
    private javax.swing.JButton btnSeans;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
