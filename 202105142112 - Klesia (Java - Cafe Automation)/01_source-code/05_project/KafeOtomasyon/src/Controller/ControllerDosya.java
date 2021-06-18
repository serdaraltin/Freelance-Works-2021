package Controller;

import Model.Garson;
import Model.Satis;
import Model.Urun;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerDosya {

    public void DosyaTemizle(File dosya) {
        try (PrintWriter pwriter = new PrintWriter(dosya)) {
            pwriter.print("");
            pwriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean YazGarson(ArrayList<Garson> garsonlar) {
        try {
            FileWriter dosyaYaz;

            File dosya = new File("garson.txt");
            if (dosya.exists()) {
                DosyaTemizle(dosya);
            }
            dosyaYaz = new FileWriter(dosya, true);
            try (BufferedWriter bw = new BufferedWriter(dosyaYaz)) {
                for (Garson garson : garsonlar) {
                    bw.write(garson.toString());
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Garson> OkuGarson() {
        try {
            File dosya = new File("garson.txt");
            if (!dosya.exists()) {
                System.out.println("Dosya bulunamadi !");
                return new ArrayList<>();
            }
            Scanner scanner = new Scanner(dosya);
            ArrayList<Garson> garsonlar = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] satir = scanner.nextLine().split(",");
                Garson garson = new Garson(satir[0], satir[1], satir[2], satir[3], satir[4], satir[5]);

                garsonlar.add(garson);
            }

            return garsonlar;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean YazUrun(ArrayList<Urun> urunler) {
        try {
            FileWriter dosyaYaz;

            File dosya = new File("urun.txt");
            if (dosya.exists()) {
                DosyaTemizle(dosya);
            }
            dosyaYaz = new FileWriter(dosya, true);
            try (BufferedWriter bw = new BufferedWriter(dosyaYaz)) {
                for (Urun urun : urunler) {
                    bw.write(urun.toString());
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Urun> OkuUrun() {
        try {
            File dosya = new File("urun.txt");
            if (!dosya.exists()) {
                System.out.println("Dosya bulunamadi !");
                return new ArrayList<>();
            }
            Scanner scanner = new Scanner(dosya);
            ArrayList<Urun> urunler = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] satir = scanner.nextLine().split(",");
                Urun urun = new Urun(Integer.parseInt(satir[0]), satir[1], satir[2], Integer.parseInt(satir[3]));
                urunler.add(urun);
            }

            return urunler;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean YazSatis(ArrayList<Satis> satislar) {
        try {
            FileWriter dosyaYaz;

            File dosya = new File("satis.txt");
            if (dosya.exists()) {
                DosyaTemizle(dosya);
            }
            dosyaYaz = new FileWriter(dosya, true);
            try (BufferedWriter bw = new BufferedWriter(dosyaYaz)) {
                for (Satis satis : satislar) {
                    bw.write(satis.toString());
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Satis> OkuSatis() {
        try {
            File dosya = new File("satis.txt");
            if (!dosya.exists()) {
                System.out.println("Dosya bulunamadi !");
                return new ArrayList<>();
            }
            Scanner scanner = new Scanner(dosya);
            ArrayList<Satis> satislar = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] satir = scanner.nextLine().split(",");
                Satis satis = new Satis(Integer.parseInt(satir[0]), satir[1], Integer.parseInt(satir[2]), Integer.parseInt(satir[3]), Integer.parseInt(satir[4]), satir[5]);
                satislar.add(satis);
            }

            return satislar;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean RaporOlustur(ArrayList<Satis> satislar, ArrayList<Garson> garsonlar, ArrayList<Urun> urunler) {
        ControllerUrun controllerUrun = new ControllerUrun();
        ControllerGarson controllerGarson = new ControllerGarson();

        try {
            FileWriter dosyaYaz;

            File dosya = new File("rapor.txt");
            if (dosya.exists()) {
                DosyaTemizle(dosya);
            }
            dosyaYaz = new FileWriter(dosya, true);
            try (BufferedWriter bw = new BufferedWriter(dosyaYaz)) {
                for (Satis satis : satislar) {
                    Urun urun = controllerUrun.Sec(urunler, new Urun(satis.getUrunNo()));
                    Garson garson = controllerGarson.Sec(garsonlar, new Garson(satis.getGarsonTcNo()));

                    bw.write("Tarih  : " + satis.getTarih() + "\n");
                    bw.write("Garson : " + garson.getAd() + " " + garson.getSoyad() + " (" + garson.getTcNo() + ")" + "\n");
                    bw.write("Urun   : " + urun.getAd() + "\n");
                    bw.write("Adet   : " + satis.getAdet() + "\n");
                    bw.write("Tutar  : " + satis.getTutar() + " TL\n");
                    bw.write("-------------------------------------------\n");

                }
            }

            return true;
        } catch (IOException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

}
