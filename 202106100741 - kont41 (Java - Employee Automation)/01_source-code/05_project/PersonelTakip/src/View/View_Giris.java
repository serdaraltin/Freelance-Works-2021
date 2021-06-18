package View;

import Controller.Controller_Kullanici;
import Controller.Controller_Personel;
import Model.Model_Kullanici;
import javax.swing.JOptionPane;

public class View_Giris extends javax.swing.JFrame {
    
    public View_Giris() {
        initComponents();
        setLocationRelativeTo(null);
    }

    //13-83 satırları arası netbeans idesi ile arayüz tasarlanması sonucu otomatik oluşturulmaktadır
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtKullaniciAd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtParola = new javax.swing.JTextField();
        btnGiris = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Giriş");
        setResizable(false);

        jLabel1.setText("Kullanıcı Adı");

        jLabel2.setText("Parola");

        btnGiris.setText("GİRİŞ");
        btnGiris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGirisActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setText("GİRİŞ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtParola, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtKullaniciAd, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKullaniciAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGiris, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //btnGiris isimli butona tıklandığında Giris methodunun çağrılması
    private void btnGirisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGirisActionPerformed
        Giris();
    }//GEN-LAST:event_btnGirisActionPerformed
    
    public void Giris() {
        //ilgili alanların boş olma durunumun kontrolü
        if (txtKullaniciAd.getText().equals("") || txtParola.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Gerekli alanları doldurunuz !");
            return;
        }
        //ilgili değerlerin kontrolü ardından ilgili pencerennin açılması

        if (new Controller_Kullanici().Kontrol(txtKullaniciAd.getText(), txtParola.getText())) {
            Model_Kullanici kullanici = new Controller_Kullanici().Getir(txtKullaniciAd.getText(), txtParola.getText());
            if (kullanici.getYetki() == 1) {
                new View_MenuAdmin().setVisible(true);
            } else {
                new View_PersonelMenu(kullanici.getPersonelId()).setVisible(true);
            }
            this.dispose();
            return;
        }
        JOptionPane.showMessageDialog(this, "Hatalı kullanıcı adı veya parola !");
    }
    
    public static void main(String[] args) {
        //new Controller.Controller_Veritabani().TabloOlustur();
        new View_Giris().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGiris;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtKullaniciAd;
    private javax.swing.JTextField txtParola;
    // End of variables declaration//GEN-END:variables
}
