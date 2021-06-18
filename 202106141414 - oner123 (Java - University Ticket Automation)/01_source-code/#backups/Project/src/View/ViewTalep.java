package View;

import Controller.ControllerOgrenci;
import Controller.ControllerTalep;
import Model.Ogrenci;
import Model.Talep;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ViewTalep extends javax.swing.JFrame {

    ControllerTalep controller = new ControllerTalep();
    private ArrayList<Talep> talepler = new ArrayList<>();
    private Talep talep = new Talep();
    private int tur = 0;

    public ViewTalep(ArrayList<Talep> liste, ArrayList<Ogrenci> ogrenciler) {
        initComponents();
        setLocationRelativeTo(null);
        this.talepler = liste;
       
        if (liste.size() > 0) {
            txtNo.setText(String.valueOf(liste.get(liste.size() - 1).getNo() + 1));
        } else {
            txtNo.setText("1");
        }
    }

    public ViewTalep(ArrayList<Talep> liste, ArrayList<Ogrenci> ogrenciler, int no) {
        initComponents();
        setLocationRelativeTo(null);

        this.talepler = liste;
        this.talep = controller.Sec(liste, no);

        txtNo.setText(String.valueOf(talep.getNo()));
        txtBaslik.setText(talep.getBaslik());
        txtIcerik.setText(talep.getIcerik());
        txtTarih.setText(talep.getTarih());
        
        this.btnEkle.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIcerik = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTarih = new javax.swing.JTextField();
        btnEkle = new javax.swing.JButton();
        txtBaslik = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDurum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("No");

        txtNo.setEnabled(false);

        jLabel2.setText("İçerik");

        jLabel3.setText("Tarih");

        btnEkle.setText("EKLE");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        jLabel8.setText("Başlık");

        jLabel9.setText("Durum");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDurum, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(txtIcerik, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(txtBaslik, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(txtTarih, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEkle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
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
                    .addComponent(jLabel2)
                    .addComponent(txtIcerik, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTarih, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDurum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed

        talep.setParola(txtHesapNo.getText());
        talep.setTcNo(txtBaslik.getText());
        talep.setAd(txtIcerik.getText());
        talep.setSoyad(txtTarih.getText());
        talep.setCinsiyet(txtDurum.getText());

        talep.setNo(Integer.valueOf(txtNo.getText()));
        if (controllerMain.Ekle(talepler, talep)) {
            JOptionPane.showMessageDialog(null, "Eklendi.");
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Eklenemedi !");
        }


    }//GEN-LAST:event_btnEkleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEkle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtBaslik;
    private javax.swing.JTextField txtDurum;
    private javax.swing.JTextField txtIcerik;
    private javax.swing.JTextField txtNo;
    private javax.swing.JTextField txtTarih;
    // End of variables declaration//GEN-END:variables
}
