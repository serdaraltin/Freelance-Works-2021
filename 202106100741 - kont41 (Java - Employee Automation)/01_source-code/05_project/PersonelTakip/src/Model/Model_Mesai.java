package Model;

import Controller.Controller_Personel;

public class Model_Mesai extends Model_Main {

    private int personelId;
    private String tarih;
    private int sure;
    private int ucret;

    public Model_Mesai() {
        super.setTabloAd("mesai");
    }

    public Model_Mesai(int Id, int personelId, String tarih, int sure, int ucret) {
        super(Id);
        this.personelId = personelId;
        this.tarih = tarih;
        this.sure = sure;
        this.ucret = ucret;
    }

    public Model_Mesai(int personelId, String tarih, int sure, int ucret) {
        this.personelId = personelId;
        this.tarih = tarih;
        this.sure = sure;
        this.ucret = ucret;
    }

    @Override
    public Object[] getObject() {

        Model_Personel model_Personel = new Controller_Personel().Getir(personelId);
        return new Object[]{super.getId(), model_Personel.getTcno(), tarih, sure, ucret};
    }

    @Override
    public String[] getKolonlar() {
        return new String[]{"Id", "Personel", "Tarih", "Süre", "Ücret"};
    }

    @Override
    public String toString() {
        return "Model_Izin{" + "personelId=" + personelId + ", tarih=" + tarih + ", sure=" + sure + ", ucret=" + ucret + '}';
    }

    public int getPersonelId() {
        return personelId;
    }

    public void setPersonelId(int personelId) {
        this.personelId = personelId;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public int getSure() {
        return sure;
    }

    public void setSure(int sure) {
        this.sure = sure;
    }

    public int getUcret() {
        return ucret;
    }

    public void setUcret(int ucret) {
        this.ucret = ucret;
    }

}
