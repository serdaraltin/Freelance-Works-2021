
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DosyaIslemleri {

    JFileChooser dosyaSec;
    FileNameExtensionFilter filtre = new FileNameExtensionFilter("Metin Dosyaları", "txt", "Metin Belgesi");

 
    public File dosyaOlustur(File dosya, String metin, JFrame pencere) {
        dosyaSec = new JFileChooser();
        dosyaSec.setDialogTitle("Dosya Kaydet");
        dosyaSec.setFileFilter(filtre);
        int sonuc = dosyaSec.showSaveDialog(pencere);
        if (sonuc == JFileChooser.APPROVE_OPTION) {
            try {
                dosya = dosyaSec.getSelectedFile();

                if (dosya.createNewFile()) {
                    JOptionPane.showMessageDialog(pencere, dosya.getName() + " dosyası oluşturuldu.");
                } else {
                    JOptionPane.showMessageDialog(pencere, dosya.getName() + " dosyası zaten var.");
                }

                return dosyaYaz(dosya, metin);
            } catch (IOException ex) {
                Logger.getLogger(DosyaIslemleri.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return null;
    }

    public File dosyaAc(File dosya, JTextArea txt, JFrame pencere) {
        dosyaSec = new JFileChooser();
        dosyaSec.setFileFilter(filtre);
        dosyaSec.setDialogTitle("Dosya Aç");
        dosyaSec.setCurrentDirectory(new File(System.getProperty("user.home")));
        int sonuc = dosyaSec.showOpenDialog(pencere);
        if (sonuc == JFileChooser.APPROVE_OPTION) {
            dosya = dosyaSec.getSelectedFile();
            pencere.setTitle("Proje-1 - " + dosya.getName());
            txt.setText(dosyaOku(dosya));
            return dosya;
        }
        //JOptionPane.showMessageDialog(((JFrame) pencere), "Dosya açılamadı!");
        return null;
    }


    public File dosyaKapa(File dosya, JTextArea txt, JFrame pencere) {
        dosya = null;
        pencere.setTitle("Project-1");
        txt.setText("");
        return dosya;
    }

    public File dosyaKaydet(File dosya, String metin, JFrame pencere) {
        if (dosya == null) {
            dosyaSec = new JFileChooser();
            dosyaSec.setDialogTitle("Dosya Oluştur");
            dosyaSec.setFileFilter(filtre);
            int sonuc = dosyaSec.showSaveDialog(pencere);
            if (sonuc == JFileChooser.APPROVE_OPTION) {
                dosya = dosyaSec.getSelectedFile();
                pencere.setTitle("Proje-1 - " + dosya.getName());
                return dosyaYaz(dosya, metin);
            }
        } else {
            try {
                if (dosya.createNewFile()) {
                    return dosyaYaz(dosya, metin);
                } else {
                    return dosyaYaz(dosya, metin);
                }
            } catch (IOException ex) {
                Logger.getLogger(DosyaIslemleri.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return null;
    }

   
    public File dosyaYaz(File dosya, String metin) {
        try {
            FileWriter fileWriter = new FileWriter(dosya);
            fileWriter.write(metin);
            fileWriter.close();
            return dosya;
        } catch (IOException hata) {
            JOptionPane.showMessageDialog(null, "Dosya yazılamadı !");
            return null;
        }
    }

  
    public String dosyaOku(File dosya) {
        try {
            Scanner scanner = new Scanner(dosya);
            String metin = "";
            while (scanner.hasNextLine()) {
                metin += scanner.nextLine() + "\n";
            }
            scanner.close();
            return metin;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DosyaIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }

  
    public ArrayList<String> dosyaOkuListe(File dosya) {
        ArrayList<String> satirlar = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(dosya);
            while (scanner.hasNextLine()) {
                satirlar.add(scanner.nextLine());
            }
            scanner.close();
            return satirlar;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DosyaIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
