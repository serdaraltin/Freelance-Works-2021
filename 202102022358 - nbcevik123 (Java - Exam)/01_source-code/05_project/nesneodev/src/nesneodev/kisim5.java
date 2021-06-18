package nesneodev;

interface IPonderable {

    double getWeight();
}

class Item1 implements IPonderable {

    public double getWeight() {
        return 80;
    }

    public String toString() {
        return "Item1";
    }
}

class Item2 implements IPonderable {

    public double getWeight() {
        return 50;
    }

    public String toString() {
        return "Item2";
    }
}

public class kisim5 {

    public static void main(String[] args) {
        Item1 item1 = new Item1();
        Item2 item2 = new Item2();
        System.out.println("Heaviest item is " + findHeavies(item1, item2));
    }

    private static String findHeavies(IPonderable item1, IPonderable item2) {
        if (item1.getWeight() <= item2.getWeight()) {
            return item2.toString();
        } else if (item1.getWeight() > item2.getWeight()) {
            return item1.toString();
        }
        return null;
    }

}
