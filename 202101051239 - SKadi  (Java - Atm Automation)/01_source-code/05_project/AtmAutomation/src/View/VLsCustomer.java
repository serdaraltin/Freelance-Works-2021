package View;

import Controller.CMain;
import Model.MMain;
import Model.MCustomer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class VLsCustomer extends javax.swing.JFrame {

    //kullanılacak sınıftan nesne üretilmesi
    static CMain controller;
    //tablodan seçilen kaydın Id değerini tutan değişken
    static int Id = 0;
    static String baslik;
    MCustomer customer;

    //kurucu method
    public VLsCustomer(CMain controller, MCustomer customer) {
        initComponents();
        //pencerenin ortalanmasi
        setLocationRelativeTo(null);
        this.controller = controller;
        this.customer = customer;
        MMain oModel = controller.getModel();
        BaslikAyarla(oModel);
        setTitle(baslik);
        lb_Baslik.setText(baslik);
        //tablo alanlarının belirlenmesi
        tb_Kayitlar.setModel(new DefaultTableModel(new Object[][]{}, oModel.getKolonlar()));
        List();
    }

    public static void BaslikAyarla(MMain oModel) {
        baslik = oModel.getClass().getName().substring(12);
    }

    public void List() {
        //mevcut bilet adedinin ilgili labele yazıdırılması
        controller.Search(tb_Kayitlar, customer.getTcno());
    }

    public void SatirSec(ListSelectionEvent evt) {
        //o an tablodan seçilen satırdaki Id değerinin ilgili değişkene atanması
        try {
            Id = Integer.valueOf(tb_Kayitlar.getValueAt(tb_Kayitlar.getSelectedRow(), 0).toString());
        } catch (Exception ex) {

        }
    }

    //bütün nesne tanımlama ve konumlandırma işlemleri diğer sınıflarda aynı olduğundan tekrar açıklama eklenmemiştir
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_Baslik = new javax.swing.JLabel();
        btnYenile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Kayitlar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Filmler");

        lb_Baslik.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lb_Baslik.setText("...");

        btnYenile.setText("YENİLE");
        btnYenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYenileActionPerformed(evt);
            }
        });

        tb_Kayitlar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tb_Kayitlar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 964, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnYenile, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lb_Baslik)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lb_Baslik)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnYenile, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnYenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYenileActionPerformed
        //List methodunun çağrılması
        List();
    }//GEN-LAST:event_btnYenileActionPerformed

    //ilgili nesnelerin tanımlanması işlemi
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnYenile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_Baslik;
    private javax.swing.JTable tb_Kayitlar;
    // End of variables declaration//GEN-END:variables
}
