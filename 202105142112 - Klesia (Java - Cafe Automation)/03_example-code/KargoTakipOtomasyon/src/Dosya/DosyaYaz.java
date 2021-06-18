package Dosya;

import Kayit.Kargo;
import Kayit.Kisi;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DosyaYaz {

    DosyaOku dosyaOku = new DosyaOku();

    public boolean YazKisi(Kisi kisi) {
        ArrayList<Kisi> kisiler = dosyaOku.OkuKisiler();
        if (kisiler == null) {
            kisiler = new ArrayList<Kisi>();
        }
        kisiler.add(kisi);
        if (YazKisiler(kisiler)) {
            return true;
        }
        return false;
    }

    public boolean YazKargo(Kargo kargo) {
        ArrayList<Kargo> kargolar = dosyaOku.OkuKargolar();
        if (kargolar == null) {
            kargolar = new ArrayList<Kargo>();
        }
        kargolar.add(kargo);
        if (YazKargolar(kargolar)) {
            return true;
        }
        return false;
    }

    public boolean YazKisiler(ArrayList<Kisi> kisiler) {
        FileWriter fileWriter = null;
        try {
            File file = new File("kisiler.txt");
            if (file.exists()) {
                PrintWriter pwriter = new PrintWriter(file);
                pwriter.print("");
                pwriter.close();
            } else {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file, true);
            try (BufferedWriter bWriter = new BufferedWriter(fileWriter)) {
                for (Kisi kisi : kisiler) {
                    bWriter.write(kisi.toString());
                    bWriter.newLine();
                }
                return true;
            }
        } catch (IOException ex) {
            Logger.getLogger(DosyaYaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean YazKargolar(ArrayList<Kargo> kargolar) {
        FileWriter fileWriter = null;
        try {
            File file = new File("kargo.txt");
            if (file.exists()) {
                PrintWriter pwriter = new PrintWriter(file);
                pwriter.print("");
                pwriter.close();
            } else {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file, true);
            try (BufferedWriter bWriter = new BufferedWriter(fileWriter)) {
                for (Kargo kargo : kargolar) {
                    bWriter.write(kargo.toString());
                    bWriter.newLine();
                }
                return true;
            }
        } catch (IOException ex) {
            Logger.getLogger(DosyaYaz.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean GuncelleKisi(Kisi kisi) {

        ArrayList<Kisi> kisiler = dosyaOku.OkuKisiler();

        for (int i = 0; i < kisiler.size(); i++) {
            if (kisiler.get(i).getId() == kisi.getId()) {
                kisiler.set(i, kisi);
            }
        }
        if (YazKisiler(kisiler)) {
            return true;
        }
        return false;
    }

    public boolean GuncelleKargo(Kargo kargo) {

        ArrayList<Kargo> kargolar = dosyaOku.OkuKargolar();

        for (int i = 0; i < kargolar.size(); i++) {
            if (kargolar.get(i).getId() == kargo.getId()) {
                kargolar.set(i, kargo);
            }
        }
        if (YazKargolar(kargolar)) {
            return true;
        }
        return false;
    }

    public boolean SilKisi(int id) {

        ArrayList<Kisi> kisiler = dosyaOku.OkuKisiler();

        for (int i = 0; i < kisiler.size(); i++) {
            if (kisiler.get(i).getId() == id) {
                kisiler.remove(i);
            }
        }
        if (YazKisiler(kisiler)) {
            return true;
        }
        return false;
    }

    public boolean SilKargo(int id) {

        ArrayList<Kargo> kargolar = dosyaOku.OkuKargolar();

        for (int i = 0; i < kargolar.size(); i++) {
            if (kargolar.get(i).getId() == id) {
                kargolar.remove(i);
            }
        }
        if (YazKargolar(kargolar)) {
            return true;
        }
        return false;
    }
}
