package Model;

import Controller.Controller_Personel;

public class Model_Izin extends Model_Main {

    private int personelId;
    private String tur;
    private String aciklama;
    private String baslangicTarih;
    private String bitisTarih;

    public Model_Izin() {
        super.setTabloAd("izin");
    }

    public Model_Izin(int Id, int personelId, String tur, String aciklama, String baslangicTarih, String bitisTarih) {
        super(Id);
        this.personelId = personelId;
        this.tur = tur;
        this.aciklama = aciklama;
        this.baslangicTarih = baslangicTarih;
        this.bitisTarih = bitisTarih;
    }

    public Model_Izin(int personelId, String tur, String aciklama, String baslangicTarih, String bitisTarih) {
        this.personelId = personelId;
        this.tur = tur;
        this.aciklama = aciklama;
        this.baslangicTarih = baslangicTarih;
        this.bitisTarih = bitisTarih;
    }

    @Override
    public Object[] getObject() {

        Model_Personel model_Personel = new Controller_Personel().Getir(personelId);
        return new Object[]{super.getId(), model_Personel.getTcno(), tur, aciklama, baslangicTarih, bitisTarih};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Personel", "Tür", "Açıklama", "Başlangıç", "Bitiş"};
    }

    @Override
    public String toString() {
        return "Model_Izin{" + "personelId=" + personelId + ", tur=" + tur + ", aciklama=" + aciklama + ", baslangicTarih=" + baslangicTarih + ", bitisTarih=" + bitisTarih + '}';
    }

    public int getPersonelId() {
        return personelId;
    }

    public void setPersonelId(int personelId) {
        this.personelId = personelId;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getBaslangicTarih() {
        return baslangicTarih;
    }

    public void setBaslangicTarih(String baslangicTarih) {
        this.baslangicTarih = baslangicTarih;
    }

    public String getBitisTarih() {
        return bitisTarih;
    }

    public void setBitisTarih(String bitisTarih) {
        this.bitisTarih = bitisTarih;
    }

}
