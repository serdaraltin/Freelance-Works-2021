
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CBankaKart extends Abs_C_Ana {

    public CBankaKart() {
        super(new MBankaKart());
    }

    @Override
    public ArrayList<Abs_M_Ana> Listele(JTable Tablo) {
        try {
            String sorgu = "Select * From " + super.getTabloAd();
            connection = new CVeritabani().Baglanti();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Abs_M_Ana> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                MBankaKart kayit = new MBankaKart(
                        resultSet.getInt("Id"),
                        resultSet.getInt("musteri_Id"),
                        resultSet.getInt("bakiye")
                );
                MMusteri musteri = new CMusteri().Getir(new MMusteri(kayit.getMusteri_Id()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    musteri.getAd() + " " + musteri.getSoyad(),
                    kayit.getBakiye()
                }
                );

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(CBankaKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<Abs_M_Ana> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where "
                    + "musteri_Id=" + aranan;
            
            connection = new CVeritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);

            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Abs_M_Ana> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                MBankaKart kayit = new MBankaKart(
                        resultSet.getInt("Id"),
                        resultSet.getInt("musteri_Id"),
                        resultSet.getInt("bakiye")
                );

                MMusteri musteri = new CMusteri().Getir(new MMusteri(kayit.getMusteri_Id()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    musteri.getAd() + " " + musteri.getSoyad(),
                    kayit.getBakiye()
                }
                );
                arrayList.add(kayit);
            }
            resultSet.close();
            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(CBankaKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean Ekle(Abs_M_Ana model) {
        MBankaKart model2 = (MBankaKart) model;
        String sorgu = "Insert Into " + super.getTabloAd() + " ("
                + "musteri_Id,bakiye) values("
                + model2.getMusteri_Id() + ","
                + model2.getBakiye() + ""
                + ")";

        return new CVeritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Abs_M_Ana model) {
        MBankaKart model2 = (MBankaKart) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "musteri_Id=" + model2.getMusteri_Id()
                + ",bakiye=" + model2.getBakiye()
                + " Where Id=" + model2.getId();
        return new CVeritabani().Sorgu(sorgu);
    }

    @Override
    public MBankaKart Getir(Abs_M_Ana model) {
        MBankaKart model2 = (MBankaKart) model;
        try {
            String sorgu = "Select * From " + super.getTabloAd()
                    + " Where Id=" + model.getId();
            connection = new CVeritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
            while (resultSet.next()) {
                model2.setId(resultSet.getInt("Id"));
                model2.setMusteri_Id(resultSet.getInt("musteri_Id"));
                model2.setBakiye(resultSet.getInt("bakiye"));
            }
            resultSet.close();
            connection.close();
            return model2;
        } catch (SQLException ex) {
            Logger.getLogger(CBankaKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Guncelle(int Id) {
        new VBankaKart(Id).setVisible(true);
    }

    @Override
    public void Ac() {
        new VBankaKart().setVisible(true);
    }
}
