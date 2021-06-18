

public class mlParaCekme extends amlMain {

    private String ktur;
    private int kID;
    private int kMiktar;
    private String kTarih;

    public mlParaCekme() {
        super.setblad("para_cekme");
    }

    public mlParaCekme(int id) {
        super(id);
    }

    public mlParaCekme(int id, String ktur, int kID, int kMiktar, String kTarih) {
        super(id);
        this.ktur = ktur;
        this.kID = kID;
        this.kMiktar = kMiktar;
        this.kTarih = kTarih;
    }

    public mlParaCekme(String ktur, int kID, int kMiktar, String kTarih) {
        this.ktur = ktur;
        this.kID = kID;
        this.kMiktar = kMiktar;
        this.kTarih = kTarih;
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
        return "Model_ParaCekme{" + "ktur=" + ktur + ", kID=" + kID + ", kMiktar=" + kMiktar + ", kTarih=" + kTarih + '}';
    }

    @Override
    public Object[] getveri() {
        return new Object[]{super.getId(), ktur, kID, kMiktar, kTarih};
    }

    @Override
    public String[] gettablokolon() {
        return new String[]{"id", "Müsteri Ad", "Kart Tür", "Kart id", "Miktar", "Tarih"};
    }

}
