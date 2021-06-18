

public class mlFaturaOdeme extends amlMain {

    private String ktur;
    private int kID;
    private String kKurum;
    private int kMiktar;
    private String kTarih;

    public mlFaturaOdeme() {
        super.setblad("fatura_odeme");
    }

    public mlFaturaOdeme(int id) {
        super(id);
    }

    public mlFaturaOdeme(String ktur, int kID, String kKurum, int kMiktar, String kTarih) {
        this.ktur = ktur;
        this.kID = kID;
        this.kKurum = kKurum;
        this.kMiktar = kMiktar;
        this.kTarih = kTarih;
    }

    public mlFaturaOdeme(int id, String ktur, int kID, String kKurum, int kMiktar, String kTarih) {
        super(id);
        this.ktur = ktur;
        this.kID = kID;
        this.kKurum = kKurum;
        this.kMiktar = kMiktar;
        this.kTarih = kTarih;
    }

    public String getKkurum() {
        return kKurum;
    }

    public void setKkurum(String kKurum) {
        this.kKurum = kKurum;
    }

    public String getKart_tur() {
        return ktur;
    }

    public void setKart_tur(String ktur) {
        this.ktur = ktur;
    }

    public int getKart_Id() {
        return kID;
    }

    public void setKart_Id(int kID) {
        this.kID = kID;
    }

    public int getMiktar() {
        return kMiktar;
    }

    public void setMiktar(int kMiktar) {
        this.kMiktar = kMiktar;
    }

    public String getTarih() {
        return kTarih;
    }

    public void setTarih(String kTarih) {
        this.kTarih = kTarih;
    }

    @Override
    public String toString() {
        return "Model_FaturaOdeme{" + "ktur=" + ktur + ", kID=" + kID + ", kKurum=" + kKurum + ", kMiktar=" + kMiktar + ", kTarih=" + kTarih + '}';
    }

    @Override
    public Object[] getveri() {
        return new Object[]{super.getId(), ktur, kID, kKurum, kMiktar, kTarih};
    }

    @Override
    public String[] gettablokolon() {
        return new String[]{"id", "Müsteri Ad", "Kart Tür", "Kart id", "Kurum", "Miktar", "Tarih"};
    }

}
