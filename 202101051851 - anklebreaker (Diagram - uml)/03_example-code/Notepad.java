import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.undo.UndoManager;

public class Notepad extends javax.swing.JFrame {

    DosyaIslemleri cDosya = new DosyaIslemleri();
    YazimDenetimi cYazim = new YazimDenetimi();
    BulDegistir cBul = new BulDegistir();
    Bul vBul = new Bul();
    Degistir vDegistir = new Degistir();
    UndoManager geriAl = new UndoManager();

    boolean kayitD;
    boolean yDosya;
    String dosya_ad;
    String pencere_adi = "Proje-1";

    File file = null;
    JFileChooser choser;

    ArrayList<String> sozcuk_listesi = cDosya.dosyaOkuListe(new File("words.txt"));

    public Notepad() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle(pencere_adi);
        metin_kutusu.getDocument().addUndoableEditListener(geriAl);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        metin_kutusu = new javax.swing.JTextArea();
        jMenuBar2 = new javax.swing.JMenuBar();
        dosyaMenu = new javax.swing.JMenu();
        dosyac = new javax.swing.JMenuItem();
        dosyaolustur = new javax.swing.JMenuItem();
        dosyakaydet = new javax.swing.JMenuItem();
        dosyakapat = new javax.swing.JMenuItem();
        duzenleMenu = new javax.swing.JMenu();
        gerial = new javax.swing.JMenuItem();
        degeriBul = new javax.swing.JMenuItem();
        degeriDegistir = new javax.swing.JMenuItem();
        hatabul = new javax.swing.JMenuItem();
        duzelt = new javax.swing.JMenuItem();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        metin_kutusu.setColumns(20);
        metin_kutusu.setRows(5);
        jScrollPane1.setViewportView(metin_kutusu);

        dosyaMenu.setText("Dosya İşlemleri");

        dosyac.setText("Dosya Aç");
        dosyac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyacActionPerformed(evt);
            }
        });
        dosyaMenu.add(dosyac);

        dosyaolustur.setText("Dosya Oluştur");
        dosyaolustur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyaolusturActionPerformed(evt);
            }
        });
        dosyaMenu.add(dosyaolustur);

        dosyakaydet.setText("Dosya Kaydet");
        dosyakaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyakaydetActionPerformed(evt);
            }
        });
        dosyaMenu.add(dosyakaydet);

        dosyakapat.setText("Dosya Kapat");
        dosyakapat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosyakapatActionPerformed(evt);
            }
        });
        dosyaMenu.add(dosyakapat);

        jMenuBar2.add(dosyaMenu);

        duzenleMenu.setText("Metin İşlemleri");

        gerial.setText("Geri Al");
        gerial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gerialActionPerformed(evt);
            }
        });
        duzenleMenu.add(gerial);

        degeriBul.setText("Bul");
        degeriBul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bulActionPerformed(evt);
            }
        });
        duzenleMenu.add(degeriBul);

        degeriDegistir.setText("Değiştir");
        degeriDegistir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degistirActionPerformed(evt);
            }
        });
        duzenleMenu.add(degeriDegistir);

        hatabul.setText("Hataları Bul");
        hatabul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hatabulActionPerformed(evt);
            }
        });
        duzenleMenu.add(hatabul);

        duzelt.setText("Hataları Düzelt");
        duzelt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duzeltActionPerformed(evt);
            }
        });
        duzenleMenu.add(duzelt);

        jMenuBar2.add(duzenleMenu);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dosyacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyacActionPerformed
        file = cDosya.dosyaAc(file, metin_kutusu, this);

    }//GEN-LAST:event_dosyacActionPerformed

    private void dosyaolusturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyaolusturActionPerformed
        file = cDosya.dosyaOlustur(file, metin_kutusu.getText(), this);
    }//GEN-LAST:event_dosyaolusturActionPerformed

    private void dosyakapatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosyakapatActionPerformed
        if (file == null) {
            return;
        }
        file = cDosya.dosyaKapa(file, metin_kutusu, this);
    }

    private void dosyakaydetActionPerformed(java.awt.event.ActionEvent evt) {
        file = cDosya.dosyaKaydet(file, metin_kutusu.getText(), this);
    }

    private void bulActionPerformed(java.awt.event.ActionEvent evt) {

        vBul.metin_kutusu = this.metin_kutusu;
        vBul.setVisible(true);
    }

    private void degistirActionPerformed(java.awt.event.ActionEvent evt) {
        vDegistir.metin_kutusu = this.metin_kutusu;
        vDegistir.setVisible(true);
    }

    private void gerialActionPerformed(java.awt.event.ActionEvent evt) {
        geriAl.undo();
    }

    private void hatabulActionPerformed(java.awt.event.ActionEvent evt) {
        int hataAdet = cYazim.hatalariDenetle(metin_kutusu, sozcuk_listesi);
        if (hataAdet > 0) {
            JOptionPane.showMessageDialog(this, hataAdet + " adet yazım hatası bulundu.");
        }
    }

    private void duzeltActionPerformed(java.awt.event.ActionEvent evt) {
        int hataAdet = cYazim.hatalariDuzelt(metin_kutusu, sozcuk_listesi);
        if (hataAdet > 0) {
            JOptionPane.showMessageDialog(this, hataAdet + " adet yazım hatası düzeltildi.");
        }
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notepad.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new Notepad().setVisible(true);

    }

    private javax.swing.JMenuItem degeriBul;
    private javax.swing.JMenuItem degeriDegistir;
    private javax.swing.JMenu dosyaMenu;
    private javax.swing.JMenuItem dosyac;
    private javax.swing.JMenuItem dosyakapat;
    private javax.swing.JMenuItem dosyakaydet;
    private javax.swing.JMenuItem dosyaolustur;
    private javax.swing.JMenuItem duzelt;
    private javax.swing.JMenu duzenleMenu;
    private javax.swing.JMenuItem gerial;
    private javax.swing.JMenuItem hatabul;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea metin_kutusu;

}
