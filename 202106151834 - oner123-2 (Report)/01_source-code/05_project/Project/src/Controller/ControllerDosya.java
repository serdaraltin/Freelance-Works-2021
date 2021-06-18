package Controller;

import Model.Ogrenci;
import Model.OgretimGorevlisi;
import Model.Talep;
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

    public boolean YazTalep(ArrayList<Talep> liste) {
        try {
            FileWriter dosyaYaz;

            File dosya = new File("talep.txt");
            if (dosya.exists()) {
                DosyaTemizle(dosya);
            }
            dosyaYaz = new FileWriter(dosya, true);
            try (BufferedWriter bw = new BufferedWriter(dosyaYaz)) {
                for (Talep eleman : liste) {
                    bw.write(eleman.toString());
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean YazOgrenci(ArrayList<Ogrenci> liste) {
        try {
            FileWriter dosyaYaz;

            File dosya = new File("ogrenci.txt");
            if (dosya.exists()) {
                DosyaTemizle(dosya);
            }
            dosyaYaz = new FileWriter(dosya, true);
            try (BufferedWriter bw = new BufferedWriter(dosyaYaz)) {
                for (Ogrenci eleman : liste) {
                    bw.write(eleman.toString());
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean YazOgretimGorevlisi(ArrayList<OgretimGorevlisi> liste) {
        try {
            FileWriter dosyaYaz;

            File dosya = new File("ogretimGorevlisi.txt");
            if (dosya.exists()) {
                DosyaTemizle(dosya);
            }
            dosyaYaz = new FileWriter(dosya, true);
            try (BufferedWriter bw = new BufferedWriter(dosyaYaz)) {
                for (OgretimGorevlisi eleman : liste) {
                    bw.write(eleman.toString());
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
        public ArrayList<Talep> OkuTalep() {
        try {
            File dosya = new File("talep.txt");
            if (!dosya.exists()) {
                System.out.println("Dosya bulunamadi !");
                return new ArrayList<>();
            }
            Scanner scanner = new Scanner(dosya);
            ArrayList<Talep> talepler = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] satir = scanner.nextLine().split(",");

                talepler.add(new Talep(satir));
            }

            return talepler;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Ogrenci> OkuOgrenci() {
        try {
            File dosya = new File("ogrenci.txt");
            if (!dosya.exists()) {
                System.out.println("Dosya bulunamadi !");
                return new ArrayList<>();
            }
            Scanner scanner = new Scanner(dosya);
            ArrayList<Ogrenci> ogrenciler = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] satir = scanner.nextLine().split(",");

                ogrenciler.add(new Ogrenci(satir));
            }

            return ogrenciler;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<OgretimGorevlisi> OkuOgretimGorevlisi() {
        try {
            File dosya = new File("ogretimGorevlisi.txt");
            if (!dosya.exists()) {
                System.out.println("Dosya bulunamadi !");
                return new ArrayList<>();
            }
            Scanner scanner = new Scanner(dosya);
            ArrayList<OgretimGorevlisi> ogretimGorevlileri = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] satir = scanner.nextLine().split(",");

                ogretimGorevlileri.add(new OgretimGorevlisi(satir));
            }

            return ogretimGorevlileri;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControllerDosya.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
