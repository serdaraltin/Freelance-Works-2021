package View;

import Controller.Controller_Bilet;
import Controller.Controller_Film;
import Controller.Controller_Salon;
import Controller.Controller_Seans;
import Model.Model_Salon;
import Model.Model_Bilet;
import Model.Model_Seans;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class View_Bilet extends javax.swing.JFrame {

    //ilgili Id değerlerinin tutulması için değişken tanımları
    int Id = 0, seansId = 0;
    //başlık bilgisi değişkeni
    String baslik = "BİLET";
    //kullanılacak kontrol sınıflarından nesne üretimi
    Controller_Bilet controller = new Controller_Bilet();
    Controller_Film controller_Film = new Controller_Film();
    Controller_Salon controller_Salon = new Controller_Salon();
    Controller_Seans controller_Seans = new Controller_Seans();

    //kurucu method (ekle işlemi için)
    public View_Bilet() {
        initComponents();
        //başlık değerinin ayarlanması
        setTitle(baslik);
        //pencerenin ortalanmasi
        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);
        Listele();
    }

    //kurucu method (güncelle işlemi için) Id değerini alır
    public View_Bilet(int _Id) {
        initComponents();
        this.Id = _Id;
        //başlığa güncellenecek olan Id ddğerinin yazdırılması
        setTitle("GÜNCELLE (" + Id + ")");

        setLocationRelativeTo(null);
        lbBaslik.setText(baslik);
        //kaydet butonu metninin değiştirilmesi
        btnKaydet.setText("GÜNCELLE");
        Getir();
    }
    //tablo alanlarının yapılandırılması ve ilgili tablodaki verilerin listelenmesi
    public void Listele() {
        tbKayitlar.setModel(new DefaultTableModel(new Object[][]{}, new String[]{
            "ID",
            "FILM AD",
            "SALON AD",
            "TARİH"
        }));
        controller_Seans.Listele(tbKayitlar);
    }

    //Id bilgisine göre tablodan ilgili alanın seçili hale getirilmesi
    public void Getir() {
        Listele();
        Model_Bilet model = controller.Getir(new Model_Bilet(Id));
        Model_Seans seans = controller_Seans.Getir(new Model_Seans(model.getSeansId()));
        ArrayList<Model_Seans> seanslar = controller_Seans.Listele(new JTable());
        int i;
        for (i = 0; i < seanslar.size(); i++) {
            if (seanslar.get(i).getId() == seans.getId()) {
                break;
            }
        }
        tbKayitlar.setRowSelectionInterval(i, i);
    }
    //seçilen satırdaki Id bilgisinin ilgili alana atanması
    public void SatirSec(ListSelectionEvent evt) {
        try {
            seansId = Integer.valueOf(tbKayitlar.getValueAt(tbKayitlar.getSelectedRow(), 0).toString());
        } catch (Exception ex) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBaslik = new javax.swing.JLabel();
        btnKaydet = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbMusteriTip = new javax.swing.JComboBox<>();
        jsKoltukNo = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKayitlar = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtAra = new javax.swing.JTextField();
        btnAra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lbBaslik.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbBaslik.setText("...");

        btnKaydet.setText("KAYDET");
        btnKaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKaydetActionPerformed(evt);
            }
        });

        jLabel1.setText("Müşteri Tipi");

        cbMusteriTip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Öğrenci" }));

        jsKoltukNo.setValue(1);

        jLabel2.setText("Koltuk No");

        tbKayitlar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbKayitlar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbKayitlarKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbKayitlar);

        jLabel3.setText("Ara");

        btnAra.setText("Ara");
        btnAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAraActionPerformed(evt);
            }
        });
        tbKayitlar.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent evt){
            SatirSec(evt);
        }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(btnKaydet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBaslik)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cbMusteriTip, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel2)
                                .addGap(38, 38, 38)
                                .addComponent(jsKoltukNo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAra, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAra)))
                        .addGap(0, 102, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBaslik)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnAra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMusteriTip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jsKoltukNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnKaydet, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKaydetActionPerformed
        //koltuk değerinin 0 dan küçük olması kontrolü
        if ((int) jsKoltukNo.getValue() < 1) {
            JOptionPane.showMessageDialog(this, "Koltuk değeri 0 dan küçük olamaz !");
            jsKoltukNo.setValue(1);
            return;
        }

        Model_Seans seans = controller_Seans.Getir(new Model_Seans(seansId));
        int koltukAdet = controller_Salon.Getir(new Model_Salon(seans.getSalonId())).getKoltukAdet();
        
        //koltuk değerinin salondaki koltuk sayısından büyük olması kontrolü
        if ((int) jsKoltukNo.getValue() > koltukAdet) {
            JOptionPane.showMessageDialog(this, "Koltuk değeri mevcut salonun koltuk sayısını geçemez ! (" + koltukAdet + ")");
            jsKoltukNo.setValue(1);
            return;
        }
        
        //tablodan bir seçim yapılmamışsa
        if (seansId == 0) {
            JOptionPane.showMessageDialog(this, "Seans seçiniz !");
            return;
        }

        //aynı kaydın olması durumunun kontrolü
        if (controller.Kontrol(new Model_Bilet(seansId, (int) jsKoltukNo.getValue()))) {
            JOptionPane.showMessageDialog(null, "Koltuk dolu !");
            return;
        }
        
        //ekleme işlemi yapılması
        if (Id == 0) {
            //ilgili kontrol sınıfından ilgili değerler ile yeni kaydın oluşturulması ve durumun değişkene atanması
            boolean sonuc = controller.Ekle(new Model_Bilet(
                    cbMusteriTip.getSelectedItem().toString(),
                    seansId,
                    (int) jsKoltukNo.getValue()
            ));
            //ekleme durumunun kontrolü
            if (sonuc) {
                JOptionPane.showMessageDialog(null, "Kayıt eklendi.");
            } else {
                JOptionPane.showMessageDialog(null, "Kayıt ekleme başarısız.");
            }
        }
        //güncelleme işlemi yapılması
        else {
            //ilgili kontrol sınıfından ilgili değerler ile güncelleme işleminin yapılması ve durumun değişkene atanması
            boolean sonuc = controller.Guncelle(new Model_Bilet(
                    Id,
                    cbMusteriTip.getSelectedItem().toString(),
                    seansId,
                    (int) jsKoltukNo.getValue()
            ));
            //güncelleme durumunun kontrolü
            if (sonuc) {
                JOptionPane.showMessageDialog(null, "Kayıt güncellendi.");
            } else {
                JOptionPane.showMessageDialog(null, "Kayıt güncelleme başarısız.");
            }
        }
    }//GEN-LAST:event_btnKaydetActionPerformed

    private void tbKayitlarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbKayitlarKeyReleased

    }//GEN-LAST:event_tbKayitlarKeyReleased
    
    //arama işlemi yapılması (boş değilse)
    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAraActionPerformed
        if (txtAra.getText().equals("")) {
            Listele();
            return;
        }
        controller_Seans.Ara(tbKayitlar, txtAra.getText());
    }//GEN-LAST:event_btnAraActionPerformed
    //ilgili nesnelerin tanımlanması
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAra;
    private javax.swing.JButton btnKaydet;
    private javax.swing.JComboBox<String> cbMusteriTip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jsKoltukNo;
    private javax.swing.JLabel lbBaslik;
    private javax.swing.JTable tbKayitlar;
    private javax.swing.JTextField txtAra;
    // End of variables declaration//GEN-END:variables
}
