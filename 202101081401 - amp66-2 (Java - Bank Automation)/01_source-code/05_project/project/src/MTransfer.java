

public class MTransfer extends Abs_M_Ana {

    private String gonderici_kart_tur;
    private int gonderici_kart_Id;
    private String alici_kart_tur;
    private int alici_kart_Id;
    private int miktar;
    private String tarih;

    public MTransfer() {
        super.setTabloAd("transfer");
    }

    public MTransfer(int Id) {
        super(Id);
    }

    public MTransfer(int Id, String gonderici_kart_tur, int gonderici_kart_Id, String alici_kart_tur, int alici_kart_Id, int miktar, String tarih) {
        super(Id);
        this.gonderici_kart_tur = gonderici_kart_tur;
        this.gonderici_kart_Id = gonderici_kart_Id;
        this.alici_kart_tur = alici_kart_tur;
        this.alici_kart_Id = alici_kart_Id;
        this.miktar = miktar;
        this.tarih = tarih;
    }

    public MTransfer(String gonderici_kart_tur, int gonderici_kart_Id, String alici_kart_tur, int alici_kart_Id, int miktar, String tarih) {
        this.gonderici_kart_tur = gonderici_kart_tur;
        this.gonderici_kart_Id = gonderici_kart_Id;
        this.alici_kart_tur = alici_kart_tur;
        this.alici_kart_Id = alici_kart_Id;
        this.miktar = miktar;
        this.tarih = tarih;
    }

    public String getGonderici_kart_tur() {
        return gonderici_kart_tur;
    }

    public void setGonderici_kart_tur(String gonderici_kart_tur) {
        this.gonderici_kart_tur = gonderici_kart_tur;
    }

    public int getGonderici_kart_Id() {
        return gonderici_kart_Id;
    }

    public void setGonderici_kart_Id(int gonderici_kart_Id) {
        this.gonderici_kart_Id = gonderici_kart_Id;
    }

    public String getAlici_kart_tur() {
        return alici_kart_tur;
    }

    public void setAlici_kart_tur(String alici_kart_tur) {
        this.alici_kart_tur = alici_kart_tur;
    }

    public int getAlici_kart_Id() {
        return alici_kart_Id;
    }

    public void setAlici_kart_Id(int alici_kart_Id) {
        this.alici_kart_Id = alici_kart_Id;
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
    public Object[] getObject() {
        return new Object[]{super.getId(), gonderici_kart_tur, gonderici_kart_Id, alici_kart_tur, alici_kart_Id, miktar, tarih};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Gönderici", "Alıcı", "Miktar", "Tarih"};
    }

}
