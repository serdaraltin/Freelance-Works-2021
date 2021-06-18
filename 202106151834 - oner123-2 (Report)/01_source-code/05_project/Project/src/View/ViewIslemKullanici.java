package View;


import Controller.ControllerTalep;
import Model.Talep;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ViewIslemKullanici extends javax.swing.JFrame {

    ArrayList<Talep> talepler;

    ControllerTalep controllerTalep = new ControllerTalep();
    private int tur;
    private int no;
    private int hesapNo;

    private void Listele() {
        controllerTalep.Listele(talepler, tbVeriler, hesapNo, tur);
    }

    public ViewIslemKullanici(ArrayList<Talep> talepler, int hesapNo, int tur) {
        this.talepler = talepler;
        this.tur = tur;
        this.hesapNo = hesapNo;
        initComponents();

        tbVeriler.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {

                tabloSatirSec(evt);
            }
        });

        setLocationRelativeTo(null);
        Listele();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbVeriler = new javax.swing.JTable();
        btnYenile = new javax.swing.JButton();
        btnEkle = new javax.swing.JButton();
        btnEkle1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kullanıcı İşlemler");
        setResizable(false);

        tbVeriler.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

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

        btnEkle1.setText("Görüntüle");
        btnEkle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEkle1ActionPerformed(evt);
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEkle1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnYenile)
                    .addComponent(btnEkle)
                    .addComponent(btnEkle1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkleActionPerformed
        new ViewTalep(talepler, hesapNo, tur).setVisible(true);

        Listele();
    }//GEN-LAST:event_btnEkleActionPerformed

    private void btnYenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYenileActionPerformed
        Listele();
    }//GEN-LAST:event_btnYenileActionPerformed

    private void btnEkle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEkle1ActionPerformed
        new ViewTalep(talepler, no).setVisible(true);
    }//GEN-LAST:event_btnEkle1ActionPerformed

    private void tabloSatirSec(ListSelectionEvent evt) {
        try {
            no = Integer.parseInt(tbVeriler.getValueAt(tbVeriler.getSelectedRow(), 0).toString());
        } catch (Exception exception) {

        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEkle;
    private javax.swing.JButton btnEkle1;
    private javax.swing.JButton btnYenile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVeriler;
    // End of variables declaration//GEN-END:variables
}
