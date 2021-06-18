package Model;

public class MInvoice extends MMain {

    private String kart_tur;
    private int kart_Id;
    private String kurum;
    private int miktar;
    private String tarih;

    public MInvoice() {
        super.setTabloAd("fatura_odeme");
    }

    public MInvoice(int Id) {
        super(Id);
    }

    public MInvoice(String kart_tur, int kart_Id, String kurum, int miktar, String tarih) {
        this.kart_tur = kart_tur;
        this.kart_Id = kart_Id;
        this.kurum = kurum;
        this.miktar = miktar;
        this.tarih = tarih;
    }

    public MInvoice(int Id, String kart_tur, int kart_Id, String kurum, int miktar, String tarih) {
        super(Id);
        this.kart_tur = kart_tur;
        this.kart_Id = kart_Id;
        this.kurum = kurum;
        this.miktar = miktar;
        this.tarih = tarih;
    }

    public String getKurum() {
        return kurum;
    }

    public void setKurum(String kurum) {
        this.kurum = kurum;
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
        return "MFatura{" + "kart_tur=" + kart_tur + ", kart_Id=" + kart_Id + ", kurum=" + kurum + ", miktar=" + miktar + ", tarih=" + tarih + '}';
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), kart_tur, kart_Id, kurum, miktar, tarih};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Müsteri Ad", "Kart Tür", "Kart Id", "Kurum", "Miktar", "Tarih"};
    }

}
