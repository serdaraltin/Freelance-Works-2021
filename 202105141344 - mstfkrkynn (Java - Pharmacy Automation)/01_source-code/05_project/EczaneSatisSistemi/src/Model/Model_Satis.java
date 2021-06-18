package Model;

public class Model_Satis extends Model_Main {

    private int ilac_id;
    private int musteri_id;
    private int personel_id;
    private String tarih;

    public Model_Satis() {
        super.setTabloAd("satis");
    }

    public Model_Satis(int Id) {
        super(Id);
    }

    public Model_Satis(int Id, int ilac_id, int musteri_id, int personel_id, String tarih) {
        super(Id);
        this.ilac_id = ilac_id;
        this.musteri_id = musteri_id;
        this.personel_id = personel_id;
        this.tarih = tarih;
    }

    public Model_Satis(int ilac_id, int musteri_id, int personel_id, String tarih) {
        this.ilac_id = ilac_id;
        this.musteri_id = musteri_id;
        this.personel_id = personel_id;
        this.tarih = tarih;
    }

    public int getIlac_id() {
        return ilac_id;
    }

    public void setIlac_id(int ilac_id) {
        this.ilac_id = ilac_id;
    }

    public int getMusteri_id() {
        return musteri_id;
    }

    public void setMusteri_id(int musteri_id) {
        this.musteri_id = musteri_id;
    }

    public int getPersonel_id() {
        return personel_id;
    }

    public void setPersonel_id(int personel_id) {
        this.personel_id = personel_id;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    @Override
    public String toString() {
        return "Model_Satis{" + "ilac_id=" + ilac_id + ", musteri_id=" + musteri_id + ", personel_id=" + personel_id + ", tarih=" + tarih + '}';
    }

    @Override
    public Object[] getObject() {
        return new Object[]{super.getId(), ilac_id, musteri_id, personel_id, tarih};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Ilac Id", "Müşteri Id", "Personel Id", "Tarih"};
    }

}
