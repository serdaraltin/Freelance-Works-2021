package Model;

import javax.swing.JTextArea;

public class Model_Degistir {

    private JTextArea metin;
    private String eskiDeger;
    private String yeniDeger;
    private boolean yukari = false;
    private boolean tamEslesme = false;

    public JTextArea getMetin() {
        return metin;
    }

    public void setMetin(JTextArea metin) {
        this.metin = metin;
    }

    public String getEskiDeger() {
        return eskiDeger;
    }

    public void setEskiDeger(String eskiDeger) {
        this.eskiDeger = eskiDeger;
    }

    public String getYeniDeger() {
        return yeniDeger;
    }

    public void setYeniDeger(String yeniDeger) {
        this.yeniDeger = yeniDeger;
    }

    public boolean isYukari() {
        return yukari;
    }

    public void setYukari(boolean yukari) {
        this.yukari = yukari;
    }

    public boolean isTamEslesme() {
        return tamEslesme;
    }

    public void setTamEslesme(boolean tamEslesme) {
        this.tamEslesme = tamEslesme;
    }

    public Model_Degistir() {
    }

    public Model_Degistir(JTextArea metin, String eskiDeger, String yeniDeger, boolean yukari, boolean tamEslesme) {
        this.metin = metin;
        this.eskiDeger = eskiDeger;
        this.yeniDeger = yeniDeger;
        this.yukari = yukari;
        this.tamEslesme = tamEslesme;
    }

    public Model_Degistir(JTextArea metin, String eskiDeger, String yeniDeger) {
        this.metin = metin;
        this.eskiDeger = eskiDeger;
        this.yeniDeger = yeniDeger;
        this.yukari = false;
        this.tamEslesme = false;
    }

    public Model_Degistir(JTextArea metin, String eskiDeger, String yeniDeger, boolean tamEslesme) {
        this.metin = metin;
        this.eskiDeger = eskiDeger;
        this.yeniDeger = yeniDeger;
        this.tamEslesme = tamEslesme;
        this.yukari = false;
    }

    @Override
    public String toString() {
        return "Model_Degistir{" + "metin=" + metin + ", eskiDeger=" + eskiDeger + ", yeniDeger=" + yeniDeger + ", yukari=" + yukari + ", tamEslesme=" + tamEslesme + '}';
    }

}
