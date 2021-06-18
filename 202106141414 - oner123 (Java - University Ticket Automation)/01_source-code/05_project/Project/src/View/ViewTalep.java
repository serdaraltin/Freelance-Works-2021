package View;

import Controller.ControllerTalep;
import Model.Talep;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ViewTalep extends javax.swing.JFrame {

    ControllerTalep controller = new ControllerTalep();
    private ArrayList<Talep> liste = new ArrayList<>();
    private Talep kayit = new Talep();
    private int tip;

    public ViewTalep(ArrayList<Talep> liste, int hesapNo, int tip) {
        initComponents();
        setLocationRelativeTo(null);
        this.liste = liste;
        btnSil.setVisible(false);

        if (liste.size() > 0) {
            txtNo.setText(String.valueOf(liste.get(liste.size() - 1).getNo() + 1));
        } else {
            txtNo.setText("1");
        }
        this.tip = tip;
        this.txtYanit.setEditable(false);
        kayit.setHesapNo(hesapNo);

    }

    public ViewTalep(ArrayList<Talep> liste, int no, boolean admin) {
        initComponents();
        setLocationRelativeTo(null);

        btnEkle.setText("Güncelle");
        btnSil.setVisible(true);
        this.liste = liste;
        this.kayit = controller.Sec(liste, no);

        txtNo.setText(String.valueOf(kayit.getNo()));
        txtBaslik.setText(kayit.getBaslik());
        txtIcerik.setText(kayit.getIcerik());
        txtYanit.setText(kayit.getYanit());
        this.tip = kayit.getTip();


    }

    public ViewTalep(ArrayList<Talep> liste, int no) {
        initComponents();
        setLocationRelativeTo(null);

        btnEkle.setText("Güncelle");
        btnSil.setVisible(true);
        this.liste = liste;
        this.kayit = controller.Sec(liste, no);

        txtNo.setText(String.valueOf(kayit.getNo()));
        txtBaslik.setText(kayit.getBaslik());
        txtIcerik.setText(kayit.getIcerik());
        txtYanit.setText(kayit.getYanit());
        this.tip = kayit.getTip();

        this.txtBaslik.setEditable(false);
        this.txtIcerik.setEditable(false);
        this.txtYanit.setEditable(false);

        this.btnEkle.setVisible(false);
        this.btnSil.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIcerik = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtYanit = new javax.swing.JTextField();
        btnSil = new javax.swing.JButton();
        btnEkle = new javax.swing.JButton();
        txtBaslik = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Talep");
        setResizable(false);

        jLabel1.setText("No");

        txtNo.setEnabled(false);

        jLabel2.setText("İçerik");

        jLabel3.setText("Yanıt");

        btnSil.setText("SİL");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });

        btnEkle.setText("EKLE");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        jLabel8.setText("Başlık");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(54, 54, 54)
                        .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBaslik, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                            .addComponent(txtIcerik)
                            .addComponent(txtYanit)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnEkle, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBaslik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIcerik, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtYanit, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSil, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSilActionPerformed
        if (controller.Sil(liste, kayit.getNo())) {
            JOptionPane.showMessageDialog(null, "Silindi.");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Silinemedi !.");
        }
    }//GEN-LAST:event_btnSilActionPerformed

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed

        kayit.setBaslik(txtBaslik.getText());
        kayit.setIcerik(txtIcerik.getText());

        kayit.setTip(tip);

        if (kayit.getNo() != 0) {
            kayit.setNo(Integer.valueOf(txtNo.getText()));
            kayit.setYanit(txtYanit.getText());
            if (controller.Guncelle(liste, kayit)) {
                JOptionPane.showMessageDialog(null, "Güncellendi.");
            } else {
                JOptionPane.showMessageDialog(null, "Güncellenemedi !");
            }
        } else {

            kayit.setNo(Integer.valueOf(txtNo.getText()));

            if (controller.Ekle(liste, kayit)) {
                JOptionPane.showMessageDialog(null, "Eklendi.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Eklenemedi !");
            }
        }

    }//GEN-LAST:event_btnEkleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnSil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtBaslik;
    private javax.swing.JTextField txtIcerik;
    private javax.swing.JTextField txtNo;
    private javax.swing.JTextField txtYanit;
    // End of variables declaration//GEN-END:variables
}
