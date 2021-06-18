package Part_I;

import java.util.Scanner;

//ana sınıf
public class VaccineStock {
    //her bir öğe için tanımlı değişkenler
    public int serialNumber;
    public String countryName;
    public int numberOfVaccines;
    
    //sınıfın kurucu methodu (boş)
    public VaccineStock() {
        this.serialNumber = 0;
        this.countryName = "";
        this.numberOfVaccines = 0;
    }
    //sınıfın 2. kurucu methodu ilgili değerler parametre olarak
    public VaccineStock(int serialNumber, String countryName, int numberOfVaccines) {
        super();
        this.serialNumber = serialNumber;
        this.countryName = countryName;
        this.numberOfVaccines = numberOfVaccines;
    }
    //toString methodu aşırı yüklenerek sınıfın String olarak çağrılma işleminde ilgili değeri döndürmesi
    @Override
    public String toString() {
        return serialNumber + ", " + countryName + ", " + numberOfVaccines;
    }
    
    //myStack sınıfından VaccineStock türünde bir nesne tanımlama
    static myStack<VaccineStock> vStock = new myStack<VaccineStock>();

    //ekrandan okuma işlemleri için scanner nesnesi tanımlama
    static Scanner scanner = new Scanner(System.in);

    //stack ten çıkarma işlemi
    static void popItem() {
        VaccineStock deleted = vStock.pop();
        System.out.println(deleted.serialNumber + ", " + deleted.countryName + ", " + deleted.numberOfVaccines);
        return;
    }
    
    //stack e ekleme işlemi
    static void pushItem() {

        VaccineStock newVacSt = new VaccineStock();

        System.out.println("Enter ITEM DATA?");
        newVacSt.serialNumber = scanner.nextInt();
        scanner.nextLine();
        newVacSt.countryName = scanner.nextLine();
        newVacSt.numberOfVaccines = scanner.nextInt();

        vStock.push(newVacSt);
        return;
    }
    //seçim işlemleri için geriye değer döndürme
    static int action() {

        System.out.println("Enter COMMAND?");
        String command = scanner.nextLine();
        switch (command) {
            case "ADD":
                return 1;
            case "DELETE":
                return 2;
            case "EXIT":
                return 3;
            default:
                break;
        }
        return 0;
    }
    //main methodu, programın başlangıcı
    public static void main(String[] args) {
        //EXIT komutu verilene kadar dönen döngü
        while (true) {
            //action methodundan dönen değerin kontrolü ve ilgili işlemin yapılması
            int rvalue = action();
            switch (rvalue) {
                case 1:
                    pushItem();
                    scanner.nextLine();
                    break;
                case 2:
                    popItem();
                    break;
                case 3:
                    vStock.print();
                    System.exit(0);
                    break;

                default:
                    System.exit(0);
            }

        }
    }

}
