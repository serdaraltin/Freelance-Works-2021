
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

//diğer arayüz sınıflarında aynı işlemler olduğu için tekrar açıklama yapılmamıştır
public final class pAtm extends javax.swing.JFrame {

    //controller nesneleri
    cParaCekme cpcekme = new cParaCekme();
    cParaYatirma cpyatirma = new cParaYatirma();
    cFaturaOdeme cfodeme = new cFaturaOdeme();
    //model
    mlMusteri mMusteri;

    //sınıfa ait özellikler
    int kID = 0;
    String ktur;

    //kurucu method
    public pAtm(mlMusteri mm) {
        //arayüz nesnelerinin tanımlanması
        initComponents();
        /*pencerenin ortalanmasi*/ setLocationRelativeTo(null);
        setTitle("ATM");
        this.mMusteri = mm;
        //ilgili lablele ilgili bilginin aktarılması
        lbMusteri.setText(mMusteri.getAd() + " " + mMusteri.getSoyad());
        //kart bilgilerinin listelenmesi
        KartListele();
    }

    //kart bilgilerinin listelenmesi
    public void KartListele() {
        ktur = cbKartTuru.getSelectedItem().toString();
        if (ktur.equals("Banka Kartı")) {
            tbKartlar.setModel(new DefaultTableModel(new Object[][]{}, new mlBankaKart().gettablokolon()));
            new cBankaKart().KayitAra(tbKartlar, String.valueOf(mMusteri.getId()));
            return;
        }
        tbKartlar.setModel(new DefaultTableModel(new Object[][]{}, new mlKrediKart().gettablokolon()));
        new cKrediKart().KayitAra(tbKartlar, String.valueOf(mMusteri.getId()));
    }

    public void SatirSec(ListSelectionEvent evt) {
        //o an tablodan seçilen satırdaki id değerinin ilgili değişkene atanması
        try {
            kID = Integer.valueOf(tbKartlar.getValueAt(tbKartlar.getSelectedRow(), 0).toString());
        } catch (Exception ex) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	//nesnelerin tanımlanması
        lbMusteri = new javax.swing.JLabel();
        cbKartTuru = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnParaYatir = new javax.swing.JButton();
        btnParaCek = new javax.swing.JButton();
        btnFaturaOde = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKartlar = new javax.swing.JTable();

		//varsayılan kapatma eylemi
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        //pencerenin boyutlandırılması (boyutlandırılamaz)
        setResizable(false);

        //ilgili labelin özelliklerinin tanımlanması
        lbMusteri.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lbMusteri.setText("...");
        lbMusteri.setToolTipText("");

        //ilgili tablonun özelliklerinin tanımlanması
        cbKartTuru.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Banka Kartı", "Kredi Kartı" }));
        cbKartTuru.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKartTuruItemStateChanged(evt);
            }
        });

        jLabel1.setText("KART");
        //ilgili butonun özelliklerinin tanımlanması
        btnParaYatir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnParaYatir.setText("PARA YATIRMA");
        btnParaYatir.setToolTipText("");
        btnParaYatir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParaYatirActionPerformed(evt);
            }
        });
		//ilgili butonun özelliklerinin tanımlanması
        btnParaCek.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnParaCek.setText("PARA ÇEKME");
        btnParaCek.setToolTipText("");
        btnParaCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParaCekActionPerformed(evt);
            }
        });
		//ilgili butonun özelliklerinin tanımlanması
        btnFaturaOde.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnFaturaOde.setText("FATURA ÖDEME");
        btnFaturaOde.setToolTipText("");
        btnFaturaOde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFaturaOdeActionPerformed(evt);
            }
        });
        //tablonun modelinin ayarlanması (boş)
        tbKartlar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
         //tablodan değer seçilmesi durumunun kontrolü
        tbKartlar.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent evt){
            SatirSec(evt);
        }
        });
        //tablodan değer seçilmesi durumunun kontrolü
        tbKartlar.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent evt){
            SatirSec(evt);
        }
        });
        jScrollPane1.setViewportView(tbKartlar);

        //nesnelerin konumlandırılması
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMusteri)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cbKartTuru, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnParaYatir, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnParaCek, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnFaturaOde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMusteri)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbKartTuru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnParaYatir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnParaCek, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnFaturaOde, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //combobox nesnesinin seçili index değerinin değişmesi
    private void cbKartTuruItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKartTuruItemStateChanged
        KartListele();
    }//GEN-LAST:event_cbKartTuruItemStateChanged

    //butona tıklanması
    private void btnParaYatirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParaYatirActionPerformed
        if (kID == 0) {
            JOptionPane.showMessageDialog(this, "Kart seçin !");
            return;
        }
        cpyatirma.PencereAc(ktur, kID);
    }//GEN-LAST:event_btnParaYatirActionPerformed
    //butona tıklanması
    private void btnParaCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParaCekActionPerformed
        if (kID == 0) {
            JOptionPane.showMessageDialog(this, "Kart seçin !");
            return;
        }
        cpcekme.PencereAc(ktur, kID);
    }//GEN-LAST:event_btnParaCekActionPerformed
    //butona tıklanması
    private void btnFaturaOdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFaturaOdeActionPerformed
        if (kID == 0) {
            JOptionPane.showMessageDialog(this, "Kart seçin !");
            return;
        }
        cfodeme.PencereAc(ktur, kID);
    }//GEN-LAST:event_btnFaturaOdeActionPerformed


    //nesnelerin oluşturulması
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFaturaOde;
    private javax.swing.JButton btnParaCek;
    private javax.swing.JButton btnParaYatir;
    private javax.swing.JComboBox<String> cbKartTuru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbMusteri;
    private javax.swing.JTable tbKartlar;
    // End of variables declaration//GEN-END:variables
}
