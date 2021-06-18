package View;

import Controller.ControllerOgrenci;
import Model.Ogrenci;
import Model.OgretimGorevlisi;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ViewIslemTalepNormal extends javax.swing.JFrame {

    ControllerOgrenci controller = new ControllerOgrenci();
    private ArrayList<Ogrenci> ogrenciler = null;
    private ArrayList<OgretimGorevlisi> ogrGorevlileri = null;
    private int no;
    private int tur = 0;

    private void Listele() {
        controller.Listele(ogrenciler, tbVeriler);
    }

    public ViewIslemTalepNormal(ArrayList<Ogrenci> liste) {
        initComponents();

        tbVeriler.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {

                tabloSatirSec(evt);
            }
        });

        setLocationRelativeTo(null);
        this.ogrenciler = liste;
        Listele();
    }

    public ViewIslemTalepNormal(ArrayList<OgretimGorevlisi> liste, int tur) {
        initComponents();

        tbVeriler.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {

                tabloSatirSec(evt);
            }
        });
        this.tur = 1;
        setLocationRelativeTo(null);
        this.ogrGorevlileri = liste;
        Listele();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbVeriler = new javax.swing.JTable();
        btnYenile = new javax.swing.JButton();
        btnEkle = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ürün İşlemleri");
        setResizable(false);

        tbVeriler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "Ad", "Birim", "Fiyat"
            }
        ));
        jScrollPane1.setViewportView(tbVeriler);

        btnYenile.setText("Yenile");
        btnYenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYenileActionPerformed(evt);
            }
        });

        btnEkle.setText("Ekle");
        btnEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnYenile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEkle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnYenile)
                    .addComponent(btnEkle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        
        Listele();
    }//GEN-LAST:event_btnEkleActionPerformed

    private void btnYenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYenileActionPerformed
        Listele();
    }//GEN-LAST:event_btnYenileActionPerformed

    private void tabloSatirSec(ListSelectionEvent evt) {
        try {
            no = Integer.parseInt(tbVeriler.getValueAt(tbVeriler.getSelectedRow(), 0).toString());
        } catch (NumberFormatException ex) {

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnYenile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVeriler;
    // End of variables declaration//GEN-END:variables
}
