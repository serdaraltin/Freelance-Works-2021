
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

class Hesap {

    double bakiye;

    public Hesap() {
    }

    public Hesap(double bakiye) {
        this.bakiye = bakiye;
    }

    public boolean paraCek(double miktar) {
        if (miktar <= bakiye) {
            bakiye -= miktar;
            System.out.println("Bakiyeden " + miktar + " TL cekildi.");
            return true;
        }
        return false;
    }

    public void paraYatir(double miktar) {
        bakiye += miktar;
        System.out.println("Bakiyeye " + miktar + " TL eklendi.");
    }

    public void bakiyeOgren() {
        System.out.println("Bakiye Bilgisi : " + bakiye + " TL");
    }
}

class Bankaci extends Thread {

    Hesap hesap;

    public Bankaci(Hesap hesap) {
        this.hesap = hesap;
    }

    @Override
    public void run() {
        int tekrar = 0;

        Random random = new Random();
        while (tekrar <= 4) {
            try {
                int islemNo = random.nextInt(3) + 1;
                int uykuMiktar;
                switch (islemNo) {
                    case 1:
                        uykuMiktar = random.nextInt(1000) + 1;
                        System.out.println("Rastgele uyku zamani (" + uykuMiktar + " ms)");
                        Thread.sleep(uykuMiktar);
                        double yatirilacakMiktar = random.nextInt(5000) + 1;
                        hesap.paraYatir(yatirilacakMiktar);
                        break;
                    case 2:
                        uykuMiktar = random.nextInt(1000) + 1;
                        System.out.println("Rastgele uyku zamani (" + uykuMiktar + " ms)");
                        Thread.sleep(uykuMiktar);
                        double cekilicekMiktar = random.nextInt(1000) + 1;
                        hesap.paraCek(cekilicekMiktar);
                        break;
                    case 3:
                        uykuMiktar = random.nextInt(1000) + 1;
                        System.out.println("Rastgele uyku zamani (" + uykuMiktar + " ms)");
                        Thread.sleep(uykuMiktar);
                        hesap.bakiyeOgren();
                        break;
                }
                tekrar++;
            } catch (InterruptedException ex) {
                Logger.getLogger(Bankaci.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}

public class Soru1 {

    public static void main(String[] args) {
        Hesap hesap = new Hesap(5000);
        Bankaci Bankaci1 = new Bankaci(hesap);
        Bankaci Bankaci2 = new Bankaci(hesap);

        Bankaci1.start();
        Bankaci2.start();

    }
}
