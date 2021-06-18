
import java.util.Scanner;

public class soru9 {
    
    //gelen parametre(puan degeri) ye gore harf notu hesabi yapan ve bu degeri geriye donen method
    static String basariNotu(int puan) {
        //puanlar arasi deger eslesiyorsa ilgili basari notu donulmektedir
        if (puan >= 90 && puan <= 100) {
            return "AA";
        }
        if (puan >= 85 && puan <= 89) {
            return "BA";
        }
        if (puan >= 75 && puan <= 84) {
            return "BB";
        }
        if (puan >= 65 && puan <= 74) {
            return "CB";
        }
        if (puan >= 60 && puan <= 64) {
            return "CC";
        }
        if (puan >= 55 && puan <= 59) {
            return "DC";
        }
        if (puan >= 50 && puan <= 54) {
            return "DD";
        }
        if (puan >= 45 && puan <= 49) {
            return "FD";
        }
        if (puan >= 0 && puan <= 44) {
            return "FF";
        }
        //yukaridaki sartlarin hicbiri saglanmiyorsa
        return "--";
    }
    
    public static void main(String[] args) {
        //ekrandan deger okuma icin scanner nesnesi tanimlanmasi
        Scanner scanner = new Scanner(System.in);
        
        //ilgili not degerleri icin degisken tanimlamalari
        float vize1, vize2, vize, sfinal, odev1, odev2, odev3, odev;
        
        System.out.print("Vize1: ");
        //ilgili notun kullanicidan okunmasi (vize1)
        vize1 = scanner.nextInt();
        
        System.out.print("Vize2: ");
        //ilgili notun kullanicidan okunmasi (vize2)
        vize2 = scanner.nextInt();
        
        System.out.print("Final: ");
        //ilgili notun kullanicidan okunmasi (final)
        sfinal = scanner.nextInt();
        
        System.out.print("Odev1: ");
        //ilgili notun kullanicidan okunmasi (odev1)
        odev1 = scanner.nextInt();
        
        System.out.print("Odev2: ");
        //ilgili notun kullanicidan okunmasi (odev2)
        odev2 = scanner.nextInt();
        
        System.out.print("Odev3: ");
        //ilgili notun kullanicidan okunmasi (odev3)
        odev3 = scanner.nextInt();
        
        //odev notlarinin ortalamasinin hesaplanmasi
        odev = (odev1 + odev2 + odev3) / 3;
        
        //vize notlarinin ortalamasinin hesaplanmasi
        vize = (vize1 + vize2) / 2;
        
        //nihayi not degerine vize nin %30 unun eklenmesi
        float not = (vize / 100) * 30;
        
        //nihayi not degerine final in %40 unun eklenmesi
        not += (sfinal / 100) * 40;
        
        //nihayi not degerine odev in %30 unun eklenmesi
        not += (odev / 100) * 30;
        
        //son notun ekrana yazdirilmasi
        System.out.println("Puan: " + not);
        //harf notunu hesaplayan methoda not degerinin gonderilmesi ve donen harf notunun ekrana bastirilmasi
        System.out.println("Basari Notu: " + basariNotu((int)not));
    }
}
