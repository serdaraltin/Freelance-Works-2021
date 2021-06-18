
public class app6 {

    static boolean Karilastir(String a, String b) {
        boolean kontrol = true;
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        int len = arrayA.length;
        if (arrayA.length != arrayB.length) {
            kontrol = false;
            if (arrayA.length < arrayB.length) {
                len = arrayB.length;
            }
        }

        if (kontrol) {
            for (int i = 0; i < arrayA.length; i++) {
                if (arrayA[i] != arrayB[i]) {
                    kontrol = false;
                    System.out.println("[" + (i+1) + "] " + arrayA[i] + " <> " + arrayB[i]);
                }
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (arrayA.length <= i) {
                    System.out.println("[" + (i+1) + "] " + arrayB[i]);
                } else {
                    if (arrayA[i] != arrayB[i]) {
                        System.out.println("[" + (i+1) + "] " + arrayA[i] + " <> " + arrayB[i]);
                    }
                }
            }
        }
        return kontrol;
    }

    public static void main(String[] args) {
        String a = "Ali", b = "Aliye";
        System.out.println("a : " + a);
        System.out.println("b : " + b);
        if (Karilastir(a, b)) {
            System.out.println("Aynidir");
        } else {
            System.out.println("Farkidir");
        }
    }
}
