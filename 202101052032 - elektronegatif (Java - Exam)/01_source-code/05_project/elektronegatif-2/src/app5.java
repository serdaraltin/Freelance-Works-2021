
public class app5 {

    static void KumeYazdir(String[] dizi, int a) {
        if (a > 0) {
            System.out.print("(),");
            KumeYazdir(dizi, 0);
        }
        if (a == 0) {
            for (int i = 0; i < dizi.length; i++) {
                System.out.print("(" + dizi[i] + "),");
            }
            KumeYazdir(dizi, -1);
        }
        if (a < 0) {
            System.out.print("(");
            for (String string : dizi) {
                System.out.print(string + "");
                if (string.equals(dizi[0])) {
                    System.out.print(",");
                }
            }
            System.out.println(")");
            return;
        }
    }

    public static void main(String[] args) {
        String[] array = {"ali", "ayşe"};
        KumeYazdir(array, 1);
    }

}
