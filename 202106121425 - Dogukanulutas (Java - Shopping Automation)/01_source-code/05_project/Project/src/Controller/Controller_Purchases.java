package Controller;

import java.util.ArrayList;
import Interface.IController;
import Model.Customer;
import Model.Product;
import Model.Purchases;

public class Controller_Purchases implements IController<Purchases> {

    Controller_Product controller_Product = new Controller_Product();
    Controller_Customer controller_Customer = new Controller_Customer();

    @Override
    public boolean Add(ArrayList<Purchases> list, Purchases data) {
        if (list.isEmpty()) {
            data.setId(1);
        } else {
            data.setId(list.get(list.size() - 1).getId() + 1);
        }
        list.add(data);
        Write(list);
        return true;
    }

    @Override
    public boolean Delete(ArrayList<Purchases> list, int Id) {
        if (list == null) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == Id) {
                list.remove(i);
                Write(list);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean Update(ArrayList<Purchases> list, Purchases data) {
        if (list == null) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == data.getId()) {
                Write(list);
                return true;
            }
        }
        return false;
    }

    @Override
    public void List(ArrayList<Purchases> list) {
        for (Purchases item : list) {
            System.out.println(item.getString());
        }
    }

    public void List(ArrayList<Purchases> list, ArrayList<Customer> customers, ArrayList<Product> products) {
        for (Purchases item : list) {
            System.out.println("Id            : " + item.getId());
            System.out.println("Customer Name : " + controller_Customer.Select(customers, item.getCustomerId()).getName());
            System.out.println("Product  Name : " + controller_Product.Select(products, item.getProductId()).getName());
            System.out.println("Piece         : " + item.getPiece());
            System.out.println("Price         : " + item.getPrice() + "\n");
        }
    }

    public void List(ArrayList<Purchases> list, ArrayList<Customer> customers, ArrayList<Product> products, int customerId) {
        for (Purchases item : list) {
            if (item.getCustomerId() == customerId) {
                System.out.println("Id            : " + item.getId());
                System.out.println("Customer Name : " + controller_Customer.Select(customers, item.getCustomerId()).getName());
                System.out.println("Product  Name : " + controller_Product.Select(products, item.getProductId()).getName());
                System.out.println("Piece         : " + item.getPiece());
                System.out.println("Price         : " + item.getPrice() + "\n");
            }
        }
    }

    @Override
    public Purchases Select(ArrayList<Purchases> list, int Id) {
        if (list == null) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == Id) {
                return list.get(i);
            }
        }
        return null;
    }

    public void Write(ArrayList<Purchases> list) {
        new Controller_File().WritePurchases(list);
    }

}
