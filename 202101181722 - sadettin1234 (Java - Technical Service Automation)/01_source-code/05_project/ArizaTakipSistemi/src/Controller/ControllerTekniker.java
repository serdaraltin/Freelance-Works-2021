package Controller;

import Model.Ariza;
import Model.Tekniker;

public class ControllerTekniker implements IController<Tekniker> {

    ControllerAriza controllerAriza = new ControllerAriza();

    @Override
    public boolean Kontrol(Tekniker[] kayitlar, Tekniker kayit) {
        for (int i = 0; i < kayitlar.length; i++) {
            if (kayitlar[i] != null && kayitlar[i].getTcno().equals(kayit.getTcno())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int Ekle(Tekniker[] kayitlar, int sonIndex, Tekniker kayit) {
        kayitlar[sonIndex++] = kayit;
        return sonIndex - 1;
    }

    @Override
    public int Degistir(Tekniker[] kayitlar, Tekniker kayit) {
        int index = Getir(kayitlar, kayit);
        kayitlar[index] = kayit;
        return index;
    }

    @Override
    public int Sil(Tekniker[] kayitlar, Tekniker kayit) {
        int index = Getir(kayitlar, kayit);

        kayitlar[index] = null;
        return index;
    }

    @Override
    public int Getir(Tekniker[] kayitlar, Tekniker kayit) {
        for (int i = 0; i < kayitlar.length; i++) {
            if (kayitlar[i].getTcno().equals(kayit.getTcno())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void Listele(Tekniker[] kayitlar) {
        if (kayitlar.length > 0) {
            System.out.println("\nTEKNIKERLER >>\n");
            for (Tekniker tekniker : kayitlar) {
                if (tekniker != null) {
                    System.out.println(tekniker + "\n");
                }
            }
            return;
        }
        System.out.println("Listelenecek kayit bulunmamakta");
    }

    public boolean arizaKontrol(Tekniker[] kayitlar, Tekniker kayit) {
        for (Tekniker tekniker : kayitlar) {
            if (tekniker != null && tekniker.getTcno().equals(kayit.getTcno())) {
                for (Ariza ariza : tekniker.getArizalar()) {
                    if (ariza != null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
