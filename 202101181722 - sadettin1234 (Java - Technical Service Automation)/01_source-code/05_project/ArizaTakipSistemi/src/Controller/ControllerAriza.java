package Controller;

import Model.Ariza;
import Model.Musteri;

public class ControllerAriza implements IController<Ariza> {

    @Override
    public boolean Kontrol(Ariza[] kayitlar, Ariza kayit) {
        for (int i = 0; i < kayitlar.length; i++) {
            if (kayitlar[i] != null && kayitlar[i].getMusteri().getTcno().equals(kayit.getMusteri().getTcno())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int Ekle(Ariza[] kayitlar, int sonIndex, Ariza kayit) {
        kayitlar[sonIndex++] = kayit;
        return sonIndex - 1;
    }

    @Override
    public int Degistir(Ariza[] kayitlar, Ariza kayit) {
        int index = Getir(kayitlar, kayit);
        kayitlar[index] = kayit;
        return index;
    }

    @Override
    public int Sil(Ariza[] kayitlar, Ariza kayit) {
        int index = Getir(kayitlar, kayit);
        kayitlar[index] = null;
        return index;
    }

    @Override
    public int Getir(Ariza[] kayitlar, Ariza kayit) {
        for (int i = 0; i < kayitlar.length; i++) {
            if (kayitlar[i] != null && kayitlar[i].getMusteri().getTcno().equals(kayit.getMusteri().getTcno())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void Listele(Ariza[] kayitlar) {
        System.out.println("\nARIZALAR >>\n");
        for (int i = 0; i < kayitlar.length; i++) {
            if (kayitlar[i] != null) {
                System.out.println("Ariza Numarasi : " + (i + 1) + "\n" + kayitlar[i] + "\n");
            }
        }
    }

    public boolean musteriKontrol(Ariza[] kayitlar, Musteri musteri) {
        for (Ariza ariza : kayitlar) {
            if (ariza != null && ariza.getMusteri().getTcno().equals(musteri.getTcno())) {
                return true;
            }
        }
        return false;
    }

}
