package Controller;

import Model.Customer;
import Model.DrawingTablet;
import Model.Phone;
import Model.Product;
import Model.Purchases;
import Model.Tv;
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

public class Controller_File {

    public void Clear(File file) {
        try (PrintWriter pwriter = new PrintWriter(file)) {
            pwriter.print("");
            pwriter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller_File.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean WriteCustomer(ArrayList<Customer> list) {
        try {
            FileWriter dosyaYaz;

            File file = new File("customer.txt");
            if (file.exists()) {
                Clear(file);
            }
            dosyaYaz = new FileWriter(file, true);
            try (BufferedWriter bw = new BufferedWriter(dosyaYaz)) {
                for (Customer item : list) {
                    bw.write(item.toString());
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Controller_File.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean WritePurchases(ArrayList<Purchases> list) {
        try {
            FileWriter dosyaYaz;

            File file = new File("purchases.txt");
            if (file.exists()) {
                Clear(file);
            }
            dosyaYaz = new FileWriter(file, true);
            try (BufferedWriter bw = new BufferedWriter(dosyaYaz)) {
                for (Purchases item : list) {
                    bw.write(item.toString());
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Controller_File.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean WriteProduct(ArrayList<Product> list) {
        try {
            FileWriter dosyaYaz;

            File file = new File("product.bin");
            if (file.exists()) {
                Clear(file);
            }
            dosyaYaz = new FileWriter(file, true);
            try (BufferedWriter bw = new BufferedWriter(dosyaYaz)) {
                for (Product item : list) {
                    bw.write(item.toString());
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Controller_File.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public ArrayList<Customer> ReadCustomer() {
        try {
            File file = new File("customer.txt");
            if (!file.exists()) {
                System.out.println("File not found !");
                return new ArrayList<>();
            }
            Scanner scanner = new Scanner(file);
            ArrayList<Customer> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] satir = scanner.nextLine().split(",");

                list.add(new Customer(satir));
            }

            return list;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller_File.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Product> ReadProduct() {
        try {
            File file = new File("product.bin");
            if (!file.exists()) {
                System.out.println("File not found !");
                return new ArrayList<>();
            }
            Scanner scanner = new Scanner(file);
            ArrayList<Product> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] satir = scanner.nextLine().split(",");
                if (satir[4].equals("1")) {
                    list.add(new Tv(satir));
                }
                if (satir[4].equals("2")) {
                    list.add(new Phone(satir));
                }
                if (satir[4].equals("3")) {
                    list.add(new DrawingTablet(satir));
                }

            }

            return list;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller_File.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ArrayList<Purchases> ReadPurchases() {
        try {
            File file = new File("purchases.txt");
            if (!file.exists()) {
                System.out.println("File not found !");
                return new ArrayList<>();
            }
            Scanner scanner = new Scanner(file);
            ArrayList<Purchases> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] satir = scanner.nextLine().split(",");

                list.add(new Purchases(satir));
            }

            return list;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Controller_File.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
