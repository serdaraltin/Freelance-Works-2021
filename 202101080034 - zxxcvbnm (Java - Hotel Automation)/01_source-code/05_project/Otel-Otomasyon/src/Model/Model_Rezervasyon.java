package Model;

public class Model_Rezervasyon extends Model_Main {

    private int oda_Id;
    private int musteri_Id;
    private String giris_tarih;
    private String cikis_tarih;

    public Model_Rezervasyon() {
        super.setTabloAd("rezervasyon");
    }

    public Model_Rezervasyon(int Id) {
        super(Id);
    }

    public Model_Rezervasyon(int Id, int oda_Id, int musteri_Id, String giris_tarih, String cikis_tarih) {
        super(Id);
        this.oda_Id = oda_Id;
        this.musteri_Id = musteri_Id;
        this.giris_tarih = giris_tarih;
        this.cikis_tarih = cikis_tarih;
    }

    public Model_Rezervasyon(int oda_Id, int musteri_Id, String giris_tarih, String cikis_tarih) {
        this.oda_Id = oda_Id;
        this.musteri_Id = musteri_Id;
        this.giris_tarih = giris_tarih;
        this.cikis_tarih = cikis_tarih;
    }

    public int getOda_Id() {
        return oda_Id;
    }

    public void setOda_Id(int oda_Id) {
        this.oda_Id = oda_Id;
    }

    public int getMusteri_Id() {
        return musteri_Id;
    }

    public void setMusteri_Id(int musteri_Id) {
        this.musteri_Id = musteri_Id;
    }

    public String getGiris_tarih() {
        return giris_tarih;
    }

    public void setGiris_tarih(String giris_tarih) {
        this.giris_tarih = giris_tarih;
    }

    public String getCikis_tarih() {
        return cikis_tarih;
    }

    public void setCikis_tarih(String cikis_tarih) {
        this.cikis_tarih = cikis_tarih;
    }

    public int getId() {
        return super.getId();
    }

    public void setId(int Id) {
        super.setId(Id);
    }

    @Override
    public String toString() {
        return "Model_Rezervasyon{" + "Id=" + super.getId() + "oda_Id=" + oda_Id + ", musteri_Id=" + musteri_Id + ", giris_tarih=" + giris_tarih + ", cikis_tarih=" + cikis_tarih + '}';
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), oda_Id,musteri_Id,giris_tarih,cikis_tarih};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Oda No", "Müşteri", "Giriş", "Çıkış"};
    }

   
}
