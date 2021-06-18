package Model;

public class Model_ParaYatirma extends Model_Main {

    private String kart_tur;
    private int kart_Id;
    private int miktar;
    private String tarih;

    public Model_ParaYatirma() {
        super.setTabloAd("para_yatirma");
    }

    public Model_ParaYatirma(int Id) {
        super(Id);
    }

    public Model_ParaYatirma(int Id, String kart_tur, int kart_Id, int miktar, String tarih) {
        super(Id);
        this.kart_tur = kart_tur;
        this.kart_Id = kart_Id;
        this.miktar = miktar;
        this.tarih = tarih;
    }

    public Model_ParaYatirma(String kart_tur, int kart_Id, int miktar, String tarih) {
        this.kart_tur = kart_tur;
        this.kart_Id = kart_Id;
        this.miktar = miktar;
        this.tarih = tarih;
    }

    public String getKart_tur() {
        return kart_tur;
    }

    public void setKart_tur(String kart_tur) {
        this.kart_tur = kart_tur;
    }

    public int getKart_Id() {
        return kart_Id;
    }

    public void setKart_Id(int kart_Id) {
        this.kart_Id = kart_Id;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    @Override
    public String toString() {
        return "Model_ParaCekme{" + "kart_tur=" + kart_tur + ", kart_Id=" + kart_Id + ", miktar=" + miktar + ", tarih=" + tarih + '}';
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), kart_tur, kart_Id, miktar, tarih};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Müsteri Ad", "Kart Tür", "Kart Id", "Miktar", "Tarih"};
    }

}
