
public class Soru5 {

    public static void main(String[] args) {
        String metin = "Bu benim özgeçmiş metnimdir"; //test için string türünde örnek bir metin tanımalaması
        
        System.out.println("Normal Metin >>\n");
        System.out.println(metin); //metnin içeriğinin ekrana bastırılması
        
        
        System.out.println("\n\nParcalanmis Metin >>\n");
        String[] parcalar = metin.split(" "); //String sınıfının split methodu ile metni " " karakerlerinden parçalara ayırma ve dönen değeri diziye atma
        
        for (String parca : parcalar) { //parcalar dizisindeki her bir elemani donen dongu
            System.out.println(parca); //o anki parcayi ekrana yazdirma
        }
    }
}
