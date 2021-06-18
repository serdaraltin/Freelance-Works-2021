/*
    "Template Method" ile "Strategy" desenleri arasındaki farklar;
    
Strategy deseninde her yontem için bir sınıf implemente edilmektedir.
Template Method deseninde islemler soyut olarak tanımlanmaktadır.
Template Methodda ana sınıf abstract(soyut) iken Stategy deseninde ise interface(arayüz)
olarak tanımlanmaktadır.
Template Method deseninde soyut sınıf icerisinde methodlar soyut olarak tanımlanırken,
Strategy deseninde methodlar interface olduğundan sadece başlık şeklinde tanımlanmaktadır.

*/

//Base(Temel) sınıf, burada baslat methodu final turundedir
abstract class Oyun {

    public abstract void hazirlik();

    public abstract void oyunuBaslat();

    public abstract void oyunuBitir();

    public final void Baslat() {
        hazirlik();
        oyunuBaslat();
        oyunuBitir();
    }
}

//Oyun Soyut sınıfından kalıtım alan ve sınıftaki methodları somutlayan Futbol sınıfı
class Futbol extends Oyun {

    //hazilirlik methodunun govdesi icin bilgi verici hazirlanmistir
    @Override
    public void hazirlik() {
        System.out.println("Oyun hazirlandi (Futbol).");
    }

    //oyunuBaslat methodunun govdesi icin bilgi verici hazirlanmistir
    @Override
    public void oyunuBaslat() {
        System.out.println("Oyun baslatildi (Futbol).");
    }

    //oyunuBitir methodunun govdesi icin bilgi verici hazirlanmistir
    @Override
    public void oyunuBitir() {
        System.out.println("Oyun bitirildi (Futbol).");
    }

}

//Oyun Soyut sınıfından kalıtım alan ve sınıftaki methodları somutlayan Basketbol sınıfı
class Basketbol extends Oyun {

    //hazilirlik methodunun govdesi icin bilgi verici hazirlanmistir
    @Override
    public void hazirlik() {
        System.out.println("Oyun hazirlandi (Basketbol).");
    }

    //oyunuBaslat methodunun govdesi icin bilgi verici hazirlanmistir
    @Override
    public void oyunuBaslat() {
        System.out.println("Oyun baslatildi (Basketbol).");
    }

    //oyunuBitir methodunun govdesi icin bilgi verici hazirlanmistir
    @Override
    public void oyunuBitir() {
        System.out.println("Oyun bitirildi (Basketbol).");
    }

}

public class Soru2 {

    public static void main(String[] args) {
        //Oyun sinifi turunda Bir futbol sinifi nesnesi olusturulmustur
        Oyun futbol = new Futbol();
        //futbol nesnesinin ust sinifinda bulunana Baslat methodu cagrilmistir
        futbol.Baslat();

        //Oyun sinifi turunda Bir basketbol sinifi nesnesi olusturulmustur
        Oyun basketbol = new Basketbol();
        //basketbol nesnesinin ust sinifinda bulunana Baslat methodu cagrilmistir
        basketbol.Baslat();
    }
}
