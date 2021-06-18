package Controller;

import Model.Musteri;

public class ControllerMusteri implements IController<Musteri> {

    ControllerAriza controllerAriza = new ControllerAriza();
    
    @Override
    public boolean Kontrol(Musteri[] kayitlar, Musteri kayit) {
        for (int i = 0; i < kayitlar.length; i++) {
            if (kayitlar[i] != null && kayitlar[i].getTcno().equals(kayit.getTcno())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int Ekle(Musteri[] kayitlar, int sonIndex, Musteri kayit) {
        kayitlar[sonIndex++] = kayit;
        return sonIndex - 1;
    }

    @Override
    public int Degistir(Musteri[] kayitlar, Musteri kayit) {
        int index = Getir(kayitlar, kayit);
        kayitlar[index] = kayit;
        return index;
    }

    @Override
    public int Sil(Musteri[] kayitlar, Musteri kayit) {
        int index = Getir(kayitlar, kayit);
        
        kayitlar[index] = null;
        return index;
    }

    @Override
    public int Getir(Musteri[] kayitlar, Musteri kayit) {
        for (int i = 0; i < kayitlar.length; i++) {
            if (kayitlar[i].getTcno().equals(kayit.getTcno())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void Listele(Musteri[] kayitlar) {
        if (kayitlar.length > 0) {
            System.out.println("\nMUSTERILER >>\n");
            for (Musteri musteri : kayitlar) {
                if (musteri != null) {
                    System.out.println(musteri + "\n");
                }
            }
            return;
        }
        System.out.println("Listelenecek kayit bulunmamakta");
    }


}
