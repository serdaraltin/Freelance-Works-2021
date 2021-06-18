
class Insan {//insan sınıfının tanımlanması

    private String ad; //ad değişkeni
    private String soyad; //soyad değişkeni
    private int yas; //yas değişkeni
    private String gozRengi; //gozRengi değişkeni
    private float boy; //boy değişkeni

    public Insan(String ad, String soyad, int yas, String gozRengi, float boy) {//kurucu method, sınıfa ait özellikleri parametre almakta
        this.ad = ad; //parametre olarak gelen değerin ilgili değişkene atanması
        this.soyad = soyad; //parametre olarak gelen değerin ilgili değişkene atanması
        this.yas = yas; //parametre olarak gelen değerin ilgili değişkene atanması
        this.gozRengi = gozRengi; //parametre olarak gelen değerin ilgili değişkene atanması
        this.boy = boy; //parametre olarak gelen değerin ilgili değişkene atanması
    }
    
    public int DogumYili() {//Dogum yili değerini geriye döndüren method
        return 2021 - this.yas; //2021 baz alınarak yaş değerinden doğum yılının hesaplanması ve geriye döndürülmesi
    }

}

public class Soru1 {

    public static void main(String[] args) {
        
        Insan insan1 = new Insan("Ahmet", "Bal", 20, "Mavi", 180); //Insan sınıfından yeni bir nesne tanımlanması ve değerlerinin verilmesi
        Insan insan2 = new Insan("Kadir", "Korkmaz", 21, "Yeşil", 170); //Insan sınıfından yeni bir nesne tanımlanması ve değerlerinin verilmesi
        Insan insan3 = new Insan("Selin", "Gürbüz", 18, "Kahverengi", 150); //Insan sınıfından yeni bir nesne tanımlanması ve değerlerinin verilmesi

        System.out.println(insan1.DogumYili()); //insan1 nesnesinin DogumYili methodu çağrılarak çıktısının ekrana bastırılması
        System.out.println(insan2.DogumYili()); //insan2 nesnesinin DogumYili methodu çağrılarak çıktısının ekrana bastırılması
        System.out.println(insan3.DogumYili()); //insan3 nesnesinin DogumYili methodu çağrılarak çıktısının ekrana bastırılması
    }
}
