package Arayuz;

import Dosya.DosyaOku;
import Dosya.DosyaYaz;
import Kayit.Kargo;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ARKargolar extends javax.swing.JFrame {

    int id = 0;

    DosyaYaz dosyaYaz = new DosyaYaz();
    DosyaOku dosyaOku = new DosyaOku();

    public ARKargolar() {
        initComponents();

    }

    private void Listele() {
        dosyaOku.Kargolar(tablo);
    }

    private void initComponents() {

        btnSil = new javax.swing.JButton();
        btnYenile = new javax.swing.JButton();
        btnGuncelle = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JFormattedTextField();
        btnAra = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablo = new javax.swing.JTable();
        btnYeniEkle = new javax.swing.JButton();

        //setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSil.setText("Sil");
        btnSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSilActionPerformed(evt);
            }
        });
        getContentPane().add(btnSil, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 120, 40));

        btnYenile.setText("Yenile");
        btnYenile.setToolTipText("");
        btnYenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYenileActionPerformed(evt);
            }
        });
        getContentPane().add(btnYenile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 120, 40));

        btnGuncelle.setText("Güncelle");
        btnGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuncelleActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuncelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 120, 40));

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
                    "Id", "Gönderici Id", "Gönderici Adres", "Alıcı Id", "Alıcı Adres", "Ücret"
                }
        ));
        jScrollPane1.setViewportView(tablo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 730, 390));

        btnYeniEkle.setText("Yeni Ekle");
        btnYeniEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYeniEkleActionPerformed(evt);
            }
        });
        getContentPane().add(btnYeniEkle, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 120, 40));

        tablo.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                tabloSatirSec(evt);
            }
        });

        pack();
        setTitle("Kargolar");
        setSize(770, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        Listele();
    }

    private void btnYenileActionPerformed(java.awt.event.ActionEvent evt) {
        Listele();
    }

    private void btnYeniEkleActionPerformed(java.awt.event.ActionEvent evt) {
        ARKargo kargo = new ARKargo();
        Listele();
    }

    private void btnGuncelleActionPerformed(java.awt.event.ActionEvent evt) {
        if (id != 0) {
            ARKargo kargo = new ARKargo(id);
            Listele();
        }
    }

    private void btnSilActionPerformed(java.awt.event.ActionEvent evt) {
        if (id != 0) {
            if (dosyaYaz.SilKargo(id)) {
                JOptionPane.showMessageDialog(null, "Kayıt Silindi");
                Listele();
            }
        }
    }

    private void btnAraActionPerformed(java.awt.event.ActionEvent evt) {
        Kargo kargo = dosyaOku.KargoBul(Integer.parseInt(txtId.getText()));
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
    private javax.swing.JButton btnGuncelle;
    private javax.swing.JButton btnSil;
    private javax.swing.JButton btnYeniEkle;
    private javax.swing.JButton btnYenile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablo;
    private javax.swing.JFormattedTextField txtId;

}
