package Arayuz;

import Dosya.DosyaOku;
import Dosya.DosyaYaz;
import Kayit.Kargo;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ARKargolarKisi extends javax.swing.JFrame {

    int kid = 0;
    int id = 0;

    DosyaYaz dosyaYaz = new DosyaYaz();
    DosyaOku dosyaOku = new DosyaOku();

    public ARKargolarKisi(int _id) {
        initComponents();
        kid = _id;
         Listele();
    }

    private void Listele() {
        dosyaOku.Kargolar(tablo, kid);
    }

    private void initComponents() {

        btnYenile = new javax.swing.JButton();
        btnBilgiGuncelle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JFormattedTextField();
        btnAra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo = new javax.swing.JTable();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnYenile.setText("Yenile");
        btnYenile.setToolTipText("");
        btnYenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYenileActionPerformed(evt);
            }
        });
        getContentPane().add(btnYenile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 40));
        
        btnBilgiGuncelle.setText("Bilgileri Güncelle");
        btnBilgiGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               ARKisi kisi = new ARKisi(kid);
            }
        });
        getContentPane().add(btnBilgiGuncelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 160, 40));

        jLabel1.setText("Id");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, 30));

        txtId.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 90, 30));

        btnAra.setText("Ara");
        btnAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAraActionPerformed(evt);
            }
        });
        getContentPane().add(btnAra, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));

        tablo.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Id", "Gönderici Adres", "Alıcı Adres", "Ücret"
                }
        ));
        jScrollPane1.setViewportView(tablo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 730, 390));

        tablo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                tabloSatirSec(evt);
            }
        });

        pack();
        setTitle("Kargolar > " + kid);
        setSize(770, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        Listele();
    }

    private void btnYenileActionPerformed(java.awt.event.ActionEvent evt) {
        Listele();
    }
    

    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {
        Kargo kargo = dosyaOku.KargoBul(Integer.parseInt(txtId.getText()),kid);
        if (kargo != null) {
            DefaultTableModel model = (DefaultTableModel) tablo.getModel();

            model.setRowCount(0);
            model.addRow(new Object[]{
                kargo.getId(),
                kargo.getGondericiId(),
                kargo.getAliciId(),
                kargo.getGondericiAdres(),
                kargo.getAliciAdres(),
                kargo.getUcret()

            });
        } else {
            JOptionPane.showMessageDialog(null, "Aranan Id numarasına sahip kargo bulunamadı !");
        }
    }

    private void tabloSatirSec(ListSelectionEvent evt) {
        try {
            id = Integer.parseInt(tablo.getValueAt(tablo.getSelectedRow(), 0).toString());
        } catch (Exception ex) {

        }
    }

    private javax.swing.JButton btnAra;

    private javax.swing.JButton btnYenile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablo;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JButton btnBilgiGuncelle;
}
