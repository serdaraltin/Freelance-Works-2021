
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CKrediKart extends Abs_C_Ana {

    public CKrediKart() {
        super(new MKrediKart());
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
                MKrediKart kayit = new MKrediKart(
                        resultSet.getInt("Id"),
                        resultSet.getInt("musteri_Id"),
                        resultSet.getInt("bakiye"),
                        resultSet.getInt("kart_limit")
                );
                MMusteri musteri = new CMusteri().Getir(new MMusteri(kayit.getMusteri_Id()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    musteri.getAd() + " " + musteri.getSoyad(),
                    kayit.getBakiye(),
                    kayit.getKart_limit()
                }
                );

                arrayList.add(kayit);
            }

            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(CKrediKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    @Override
    public ArrayList<Abs_M_Ana> Ara(JTable Tablo, String aranan) {
        try {
            String sorgu = "Select * From " + super.getTabloAd() + " Where musteri_Id=" + aranan;
            connection = new CVeritabani().Baglanti();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sorgu);
   
            DefaultTableModel model = (DefaultTableModel) Tablo.getModel();
            model.setRowCount(0);
            ArrayList<Abs_M_Ana> arrayList = new ArrayList<>();

            while (resultSet.next()) {
                MKrediKart kayit = new MKrediKart(
                        resultSet.getInt("Id"),
                        resultSet.getInt("musteri_Id"),
                        resultSet.getInt("bakiye"),
                        resultSet.getInt("kart_limit")
                );
           
                MMusteri musteri = new CMusteri().Getir(new MMusteri(kayit.getMusteri_Id()));
                model.addRow(new Object[]{
                    kayit.getId(),
                    musteri.getAd() + " " + musteri.getSoyad(),
                    kayit.getBakiye(),
                    kayit.getKart_limit()
                }
                );
                arrayList.add(kayit);
            }
            resultSet.close();
            connection.close();
            return arrayList;
        } catch (SQLException ex) {
            Logger.getLogger(CKrediKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public boolean Ekle(Abs_M_Ana model) {
        MKrediKart model2 = (MKrediKart) model;
        String sorgu = "Insert Into " + super.getTabloAd() + " ("
                + "musteri_Id,bakiye,kart_limit) values("
                + model2.getMusteri_Id() + ","
                + model2.getBakiye() + ","
                + model2.getKart_limit() + ""
                + ")";

        return new CVeritabani().Sorgu(sorgu);
    }

    @Override
    public boolean Guncelle(Abs_M_Ana model) {
        MKrediKart model2 = (MKrediKart) model;
        String sorgu = "Update " + super.getTabloAd() + " set "
                + "musteri_Id=" + model2.getMusteri_Id()
                + ",bakiye=" + model2.getBakiye()
                + ",kart_limit=" + model2.getKart_limit()
                + " Where Id=" + model2.getId();
        return new CVeritabani().Sorgu(sorgu);
    }

    @Override
    public MKrediKart Getir(Abs_M_Ana model) {
        MKrediKart model2 = (MKrediKart) model;
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
                model2.setKart_limit(resultSet.getInt("kart_limit"));
            }
            resultSet.close();
            connection.close();
            return model2;
        } catch (SQLException ex) {
            Logger.getLogger(CKrediKart.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void Guncelle(int Id) {
        new VKrediKart(Id).setVisible(true);
    }

    @Override
    public void Ac() {
        new VKrediKart().setVisible(true);
    }
}
