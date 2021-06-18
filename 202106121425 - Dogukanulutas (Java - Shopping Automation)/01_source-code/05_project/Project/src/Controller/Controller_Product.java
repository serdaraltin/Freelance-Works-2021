package Controller;

import java.util.ArrayList;
import Interface.IController;
import Model.Product;

public class Controller_Product implements IController<Product> {
    @Override
    public boolean Add(ArrayList<Product> list, Product data) {
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
    public boolean Delete(ArrayList<Product> list, int Id) {
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
    public boolean Update(ArrayList<Product> list, Product data) {
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
    public void List(ArrayList<Product> list) {
        for (Product item : list) {
            System.out.println(item.getString()+"\n");
        }
    }

    @Override
    public Product Select(ArrayList<Product> list, int Id) {
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

    public void Write(ArrayList<Product> list) {
        new Controller_File().WriteProduct(list);
    }

    public Product Exist(ArrayList<Product> list, String name) {
        if (list == null) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return list.get(i);
            }
        }
        return null;
    }

}
