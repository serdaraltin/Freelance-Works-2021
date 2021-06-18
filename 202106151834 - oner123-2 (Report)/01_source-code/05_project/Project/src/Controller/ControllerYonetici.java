package Controller;

import Model.Yonetici;
import java.util.ArrayList;

public class ControllerYonetici {

    private ArrayList<Yonetici> liste;

    public ControllerYonetici(ArrayList<Yonetici> liste) {
        this.liste = liste;
    }

    public boolean Kontrol(Yonetici yonetici) {
        for (Yonetici yonetici1 : liste) {
            if (yonetici1.getKullaniciAd().equals(yonetici.getKullaniciAd())
                    && yonetici1.getParola().equals(yonetici.getParola())) {
                return true;
            }
        }
        return false;
    }
}
