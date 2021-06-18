package Controller;

import java.util.ArrayList;
import Interface.IController;
import Model.Customer;

public class Controller_Customer implements IController<Customer> {

    @Override
    public boolean Add(ArrayList<Customer> list, Customer data) {
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
    public boolean Delete(ArrayList<Customer> list, int Id) {
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
    public boolean Update(ArrayList<Customer> list, Customer data) {
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
    public void List(ArrayList<Customer> list) {
        for (Customer item : list) {
            System.out.println(item.getString()+"\n");
        }
    }

    @Override
    public Customer Select(ArrayList<Customer> list, int Id) {
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

    public void Write(ArrayList<Customer> list) {
        new Controller_File().WriteCustomer(list);
    }

    public Customer Get(ArrayList<Customer> list, String name, String password) {
        if (list == null) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name) && list.get(i).getPassword().equals(password)) {
                return list.get(i);
            }
        }
        return null;
    }

    public Customer Exist(ArrayList<Customer> list, String name) {
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
