package Dosya;

import Kayit.Kargo;
import Kayit.Kisi;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DosyaOku {

    public ArrayList<Kisi> OkuKisiler() {
        try {

            File dosyaKisiler = new File("kisiler.txt");
            if (!dosyaKisiler.exists()) {
                return null;
            }
            Scanner scanner = new Scanner(dosyaKisiler);
            ArrayList<Kisi> data = new ArrayList<Kisi>();
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("	");
                Kisi kisi = new Kisi(Integer.parseInt(line[0]), line[1], line[2], line[3]);
                data.add(kisi);
            }
            return data;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DosyaOku.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Kargo> OkuKargolar() {
        try {
            File dosyaKargo = new File("kargo.txt");
            if (!dosyaKargo.exists()) {
                return null;
            }
            Scanner scanner = new Scanner(dosyaKargo);
            ArrayList<Kargo> data = new ArrayList<Kargo>();
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("	");
                Kargo kargo = new Kargo(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]), line[3], line[4], Float.parseFloat(line[5]));
                data.add(kargo);
            }
            return data;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DosyaOku.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Kisi KisiBul(int id) {
        try {
            File dosyaKisiler = new File("kisiler.txt");
            Scanner scanner = new Scanner(dosyaKisiler);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("	");
                if (Integer.parseInt(line[0]) == id) {

                    Kisi kisi = new Kisi(Integer.parseInt(line[0]), line[1], line[2], line[3]);
                    return kisi;
                }
            }
            return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DosyaOku.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Kargo KargoBul(int id) {
        try {
            File dosyaKargolar = new File("kargo.txt");
            Scanner scanner = new Scanner(dosyaKargolar);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("	");
                if (Integer.parseInt(line[0]) == id) {

                    Kargo kargo = new Kargo(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]), line[3], line[4], Float.parseFloat(line[5]));

                    return kargo;
                }
            }
            return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DosyaOku.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
     public Kargo KargoBul(int id,int kid) {
        try {
            File dosyaKargolar = new File("kargo.txt");
            Scanner scanner = new Scanner(dosyaKargolar);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("	");
                if (Integer.parseInt(line[0]) == id && (Integer.parseInt(line[1]) == kid || Integer.parseInt(line[2]) == kid)) {

                    Kargo kargo = new Kargo(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]), line[3], line[4], Float.parseFloat(line[5]));

                    return kargo;
                }
            }
            return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DosyaOku.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   public DefaultTableModel Kisiler(javax.swing.JTable tablo) {
        try {
            File dosyaKargo = new File("kisiler.txt");
            if (!dosyaKargo.exists()) {
                return null;
            }
            Scanner scanner = new Scanner(dosyaKargo);
            DefaultTableModel model = (DefaultTableModel) tablo.getModel();

            model.setRowCount(0);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("	");

                model.addRow(new Object[]{
                    Integer.parseInt(line[0]),
                    line[1],
                    line[2],
                    line[3]
                });

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DosyaOku.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
   
    public DefaultTableModel Kargolar(javax.swing.JTable tablo) {
        try {
            File dosyaKargo = new File("kargo.txt");
            if (!dosyaKargo.exists()) {
                return null;
            }
            Scanner scanner = new Scanner(dosyaKargo);
            DefaultTableModel model = (DefaultTableModel) tablo.getModel();

            model.setRowCount(0);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("	");

                model.addRow(new Object[]{
                    Integer.parseInt(line[0]),
                    Integer.parseInt(line[1]),
                    Integer.parseInt(line[2]),
                    line[3],
                    line[4],
                    Float.parseFloat(line[5])
                });

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DosyaOku.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }

    public DefaultTableModel Kargolar(javax.swing.JTable tablo, int id) {
        try {
            File dosyaKargo = new File("kargo.txt");
            if (!dosyaKargo.exists()) {
                return null;
            }
            Scanner scanner = new Scanner(dosyaKargo);
            DefaultTableModel model = (DefaultTableModel) tablo.getModel();

            model.setRowCount(0);

            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split("	");
                if (Integer.parseInt(line[1]) == id || Integer.parseInt(line[2]) == id) {
                    model.addRow(new Object[]{
                        Integer.parseInt(line[0]),
                        line[3],
                        line[4],
                        Float.parseFloat(line[5])
                    });
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DosyaOku.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
}
