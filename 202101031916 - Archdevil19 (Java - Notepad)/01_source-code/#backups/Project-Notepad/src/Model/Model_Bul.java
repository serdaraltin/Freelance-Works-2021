package Model;

import javax.swing.JTextArea;

public class Model_Bul {

    private JTextArea metin;
    private String aranan;
    private boolean yukari;
    private boolean tamEslesme;

    public JTextArea getMetin() {
        return metin;
    }

    public void setMetin(JTextArea metin) {
        this.metin = metin;
    }

    public String getAranan() {
        return aranan;
    }

    public void setAranan(String aranan) {
        this.aranan = aranan;
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

    public Model_Bul(JTextArea metin, String aranan, boolean yukari, boolean tamEslesme) {
        this.metin = metin;
        this.aranan = aranan;
        this.yukari = yukari;
        this.tamEslesme = tamEslesme;
    }

    public Model_Bul() {
    }

    public Model_Bul(JTextArea metin, String aranan) {
        this.metin = metin;
        this.aranan = aranan;
        this.yukari = false;
        this.tamEslesme = false;
    }

    @Override
    public String toString() {
        return "Model_Bul{" + "metin=" + metin + ", aranan=" + aranan + ", yukari=" + yukari + ", tamEslesme=" + tamEslesme + '}';
    }
    
    
    

}
