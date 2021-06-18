package View;

import Controller.Controller_Customer;
import Controller.Controller_File;
import Controller.Controller_Product;
import Controller.Controller_Purchases;
import Model.Customer;
import Model.DrawingTablet;
import Model.Phone;
import Model.Product;
import Model.Purchases;
import Model.Tv;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Controller_File fileOperation = new Controller_File();

    static ArrayList<Customer> customers;
    static ArrayList<Purchases> purchaseses;
    static ArrayList<Product> products;

    static Controller_Customer controllerCustomer = new Controller_Customer();
    static Controller_Product controllerProduct = new Controller_Product();
    static Controller_Purchases controllerPurchases = new Controller_Purchases();

    public static void main(String[] args) {
        customers = fileOperation.ReadCustomer();
        purchaseses = fileOperation.ReadPurchases();
        products = fileOperation.ReadProduct();
        menu();
    }

    public static void menu() {
        System.out.println("1) Customer Login");
        System.out.println("2) Admin Login");
        System.out.println("0) Exit");
        System.out.print("Choice : ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            case 1:
                Customer customer = customerLogin();
                if (customer == null) {
                    break;
                }
                customerMenu(customer);
                break;
            case 2:
                System.out.print("Name: ");
                String name = scanner.next();
                System.out.print("Password: ");
                String password = scanner.next();

                if (!(name.equals("admin") && password.equals("admin"))) {
                    System.out.println("Wrong name or password !");
                    break;
                }
                System.out.println();
                adminMenu();
                break;
            default:
                System.out.println("Wrong choice !");
                break;
        }
        System.out.println("");
        menu();
    }

    private static Customer customerLogin() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();

        Customer customer = controllerCustomer.Get(customers, name, password);
        if (customer == null) {
            System.out.println("Wrong name or password !");
        }
        System.out.println();
        return customer;
    }

    private static void customerMenu(Customer customer) {

        System.out.println("1) Purchases List");
        System.out.println("2) Purchases Add");
        System.out.println("3) Purchases Cancel");
        System.out.println("4) Change Password");
        System.out.println("0) Back Main Menu");
        System.out.print("Choice : ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                return;
            case 1:
                purchasesList(customer.getId());
                break;
            case 2:
                purchasesAdd(customer.getId());
                break;
            case 3:
                purchasesDelete(customer.getId());
                break;
            case 4:
                System.out.print("New Password : ");
                String password = scanner.next();
                customer.setPassword(password);
                controllerCustomer.Update(customers, customer);
                System.out.println("Password updated.");
                break;
            default:
                System.out.println("Wrong choice !");
                break;
        }
        System.out.println();
        customerMenu(customer);
    }

    private static void adminMenu() {

        System.out.println("1) Customer Operations");
        System.out.println("2) Product Operations");
        System.out.println("3) Purchases Operations");
        System.out.println("0) Back Main Menu");
        System.out.print("Choice : ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                return;
            case 1:
                customerOperations();
                break;
            case 2:
                productOperations();
                break;
            case 3:
                purchasesOperations();
                break;
            default:
                System.out.println("Wrong choice !");
                break;
        }
        System.out.println();
        adminMenu();
    }

    private static void customerOperations() {

        System.out.println("1) Customer Add");
        System.out.println("2) Customer Update");
        System.out.println("3) Customer Delete");
        System.out.println("4) Customer List");
        System.out.println("0) Back Admin Menu");
        System.out.print("Choice : ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                return;
            case 1:
                customerAdd();
                break;
            case 2:
                customerUpdate();
                break;
            case 3:
                customerDelete();
                break;
            case 4:
                customerList();
                break;
            default:
                System.out.println("Wrong choice !");
                break;
        }
        System.out.println("");
        customerOperations();
    }

    private static void customerAdd() {
        System.out.print("Name: ");
        String name = scanner.next();
        if (controllerCustomer.Exist(customers, name) != null) {
            System.out.println("Already exitst !");
            return;
        }
        System.out.print("Password: ");
        String password = scanner.next();
        controllerCustomer.Add(customers, new Customer(name, password));
        System.out.println("Added.");
    }

    private static void customerUpdate() {
        System.out.print("Name: ");
        String name = scanner.next();

        if (controllerCustomer.Exist(customers, name) == null) {
            System.out.println("Not found !");
            return;
        }

        System.out.print("Password: ");
        String password = scanner.next();
        Customer customer = controllerCustomer.Exist(customers, name);
        customer.setPassword(password);
        controllerCustomer.Update(customers, customer);
        System.out.println("Updated.");
    }

    private static void customerDelete() {
        System.out.print("Name: ");
        String name = scanner.next();

        if (controllerCustomer.Exist(customers, name) == null) {
            System.out.println("Not found !");
            return;
        }
        Customer customer = controllerCustomer.Exist(customers, name);
        controllerCustomer.Delete(customers, customer.getId());
        System.out.println("Deleted.");
    }

    private static void customerList() {
        System.out.println("\n--- Customer List ---\n");
        controllerCustomer.List(customers);
        System.out.println("\n--- Customer List ---\n");
    }

    private static void productOperations() {

        System.out.println("1) Product Add");
        System.out.println("2) Product Update");
        System.out.println("3) Product Delete");
        System.out.println("4) Product List");
        System.out.println("0) Back Admin Menu");
        System.out.print("Choice : ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                return;
            case 1:
                productAdd();
                break;
            case 2:
                productUpdate();
                break;
            case 3:
                productDelete();
                break;
            case 4:
                productList();
                break;
            default:
                System.out.println("Wrong choice !");
                break;
        }
        System.out.println("");
        productOperations();
    }

    private static void productAdd() {
        System.out.print("Name: ");
        String name = scanner.next();
        if (controllerProduct.Exist(products, name) != null) {
            System.out.println("Already exitst !");
            return;
        }

        System.out.print("Price: ");
        float price = scanner.nextFloat();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();

        System.out.print("Type [TV=1,Phone=2,Drawing Tablet=3] : ");
        int type = scanner.nextInt();

        switch (type) {
            case 1:
                System.out.print("Screen Size : ");
                String screenSize = scanner.next();
                controllerProduct.Add(products, new Tv(name, price, stock, screenSize));
                break;
            case 2:
                System.out.print("Camera Resolution : ");
                String cameraResolution = scanner.next();
                controllerProduct.Add(products, new Phone(name, price, stock, cameraResolution));
                break;
            case 3:
                System.out.print("Battery Less : ");
                Byte batteryLess = scanner.nextByte();
                controllerProduct.Add(products, new DrawingTablet(name, price, stock, batteryLess));
                break;
            default:
                System.out.println("Wrong choice !");
                return;
        }

        System.out.println("Added.");
    }

    private static void productUpdate() {
        System.out.print("Name: ");
        String name = scanner.next();

        if (controllerProduct.Exist(products, name) == null) {
            System.out.println("Not found !");
            return;
        }
        Product item = controllerProduct.Exist(products, name);

        System.out.print("Price: ");
        float price = scanner.nextFloat();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();

        System.out.print("Type [TV=1,Phone=2,Drawing Tablet=3] : ");
        int type = scanner.nextInt();

        switch (type) {
            case 1:
                System.out.print("Screen Size : ");
                String screenSize = scanner.next();
                controllerProduct.Update(products, new Tv(item.getId(), name, price, stock, screenSize));
                break;
            case 2:
                System.out.print("Camera Resolution : ");
                String cameraResolution = scanner.next();
                controllerProduct.Update(products, new Phone(item.getId(), name, price, stock, cameraResolution));
                break;
            case 3:
                System.out.print("Battery Less : ");
                Byte batteryLess = scanner.nextByte();
                controllerProduct.Update(products, new DrawingTablet(item.getId(), name, price, stock, batteryLess));
                break;
            default:
                System.out.println("Wrong choice !");
                return;
        }

        System.out.println("Updated.");
    }

    private static void productDelete() {
        System.out.print("Name: ");
        String name = scanner.next();

        if (controllerProduct.Exist(products, name) == null) {
            System.out.println("Not found !");
            return;
        }
        Product item = controllerProduct.Exist(products, name);
        controllerProduct.Delete(products, item.getId());
        System.out.println("Deleted.");
    }

    private static void productList() {
        System.out.println("\n--- Product List ---\n");
        controllerProduct.List(products);
        System.out.println("\n--- Product List ---\n");
    }

    private static void purchasesOperations() {
        System.out.println("1) Purchases Add");
        System.out.println("2) Purchases Update");
        System.out.println("3) Purchases Delete");
        System.out.println("4) Purchases List");
        System.out.println("0) Back Admin Menu");
        System.out.print("Choice : ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                return;
            case 1:
                purchasesAdd();
                break;
            case 2:
                purchasesUpdate();
                break;
            case 3:
                purchasesDelete();
                break;
            case 4:
                purchasesList();
                break;
            default:
                System.out.println("Wrong choice !");
                break;
        }
        System.out.println("");
        purchasesOperations();
    }

    private static void purchasesAdd() {
        customerList();
        System.out.print("Customer Id: ");
        int customerId = scanner.nextInt();
        Customer customer = controllerCustomer.Select(customers, customerId);
        if (customer == null) {
            System.out.println("Not found !");
            return;
        }
        productList();
        System.out.print("Product Id : ");
        int productId = scanner.nextInt();
        Product product = controllerProduct.Select(products, productId);
        if (product == null) {
            System.out.println("Not found !");
            return;
        }

        if (product.getStock() == 0) {
            System.out.println("No stock !");
            return;
        }

        System.out.print("Piece (Max=" + product.getStock() + "): ");
        int piece = scanner.nextInt();
        if (piece > product.getStock()) {
            System.out.println("Piece out of stock !");
            piece = product.getStock();
            System.out.println("New Piece > " + piece);
        }

        product.setStock(product.getStock() - piece);
        controllerProduct.Update(products, product);

        controllerPurchases.Add(purchaseses, new Purchases(customer.getId(), product.getId(),
                piece, (piece * product.getPrice())));
        System.out.println("Added.");
    }

    private static void purchasesAdd(int customerId) {
        productList();
        System.out.print("Product Name : ");
        String productName = scanner.next();
        Product product = controllerProduct.Exist(products, productName);
        if (product == null) {
            System.out.println("Not found !");
            return;
        }

        if (product.getStock() == 0) {
            System.out.println("No stock !");
            return;
        }

        System.out.print("Piece (Max=" + product.getStock() + "): ");
        int piece = scanner.nextInt();
        if (piece > product.getStock()) {
            System.out.println("Piece out of stock !");
            piece = product.getStock();
            System.out.println("New Piece > " + piece);
        }

        product.setStock(product.getStock() - piece);
        controllerProduct.Update(products, product);

        controllerPurchases.Add(purchaseses, new Purchases(customerId, product.getId(),
                piece, (piece * product.getPrice())));
        System.out.println("Added.");
    }

    private static void purchasesUpdate() {
        purchasesList();
        System.out.print("Id: ");
        int Id = scanner.nextInt();

        Purchases purchases = controllerPurchases.Select(purchaseses, Id);
        if (purchases == null) {
            System.out.println("Not found !");
            return;
        }
        Product oldProduct = controllerProduct.Select(products, purchases.getProductId());
        oldProduct.setStock(oldProduct.getStock() + purchases.getPiece());

        customerList();
        System.out.print("Customer Id: ");
        int customerId = scanner.nextInt();
        Customer customer = controllerCustomer.Select(customers, customerId);
        if (customer == null) {
            System.out.println("Not found !");
            return;
        }

        productList();
        System.out.print("Product Id : ");
        int productId = scanner.nextInt();
        Product product = controllerProduct.Select(products, productId);
        if (product == null) {
            System.out.println("Not found !");
            return;
        }

        if (productId != oldProduct.getId() && product.getStock() == 0) {
            System.out.println("No stock !");
            return;
        }

        int maxPiece = product.getStock();
        if (productId == oldProduct.getId()) {
            maxPiece = oldProduct.getStock();
        }

        System.out.print("Piece (Max=" + maxPiece + "): ");
        int piece = scanner.nextInt();
        if (piece > maxPiece) {
            System.out.println("Piece out of stock !");
            piece = maxPiece;
            System.out.println("New Piece > " + piece);
        }

        if (productId == oldProduct.getId()) {
            oldProduct.setStock(product.getStock() - piece);
            controllerProduct.Update(products, oldProduct);
            controllerPurchases.Update(purchaseses, new Purchases(Id, customer.getId(), oldProduct.getId(),
                    piece, (piece * oldProduct.getPrice())));
        } else {
            controllerProduct.Update(products, oldProduct);
            product.setStock(product.getStock() - piece);
            controllerProduct.Update(products, product);
            controllerPurchases.Update(purchaseses, new Purchases(Id, customer.getId(), product.getId(),
                    piece, (piece * product.getPrice())));
        }

        System.out.println("Uptaded.");
    }

    private static void purchasesDelete() {
        purchasesList();
        System.out.print("Id: ");
        int Id = scanner.nextInt();
        Purchases purchases = controllerPurchases.Select(purchaseses, Id);
        if (purchases == null) {
            System.out.println("Not found !");
            return;
        }
        Product product = controllerProduct.Select(products, purchases.getProductId());
        product.setStock(product.getStock() + purchases.getPiece());
        controllerProduct.Update(products, product);
        controllerPurchases.Delete(purchaseses, Id);
        System.out.println("Deleted and Product stock updated");
    }

    private static void purchasesDelete(int customerId) {
        purchasesList(customerId);
        System.out.print("Id: ");
        int Id = scanner.nextInt();
        Purchases purchases = controllerPurchases.Select(purchaseses, Id);
        if (purchases == null || purchases.getCustomerId() != customerId) {
            System.out.println("Not found !");
            return;
        }

        Product product = controllerProduct.Select(products, purchases.getProductId());
        product.setStock(product.getStock() + purchases.getPiece());
        controllerProduct.Update(products, product);
        controllerPurchases.Delete(purchaseses, Id);
        System.out.println("Purchases canceled.");
    }

    private static void purchasesList() {
        System.out.println("\n--- Purchaseses List ---\n");
        controllerPurchases.List(purchaseses, customers, products);
        System.out.println("\n--- Purchaseses List ---\n");
    }

    private static void purchasesList(int customerId) {
        System.out.println("\n--- Purchaseses List ---\n");
        controllerPurchases.List(purchaseses, customers, products, customerId);
        System.out.println("\n--- Purchaseses List ---\n");
    }
}
