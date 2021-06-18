
import java.util.Scanner;


public class soru3 {

    
    public static void main(String[] args) {
        //ekrandan okuma için scanner nesnesi tanımlama
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Celcius: ");
        //float türünde kullanıcıdan celcius değerinin okunması
        float celcius = scanner.nextFloat();
        
        //celcius değerine göre fahrenheit değerinin hesaplanması
        float fahrenheit = ((celcius*9)/5)+32;
        
        //mevcut olan fahrenheit değerine göre kelvin değerinin hesaplanması
        float kelvin = (float)((fahrenheit+459.67)/1.8);
        
        //mevcut olan fahrenheit değerine göre reaumur değerinin hesaplanması
        float reaumur = (float)((fahrenheit-32)/2.25);
        
        
        //ilgili değerlerin ekrana bastırılması
        System.out.println("\nKelvin: "+kelvin);
        System.out.println("Fahrenheit: "+fahrenheit);
        System.out.println("Reaumur: "+reaumur);
    }
}
