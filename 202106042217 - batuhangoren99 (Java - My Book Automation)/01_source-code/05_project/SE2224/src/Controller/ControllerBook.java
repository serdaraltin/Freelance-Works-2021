package Controller;

import Model.Book;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControllerBook {

    public int NewId(ArrayList<Book> list) {
        if (list.isEmpty()) {
            return 1;
        }
        return list.get(list.size() - 1).getBookId() + 1;
    }

    public int GetIndex(ArrayList<Book> list, int Id) {
        if (list.isEmpty()) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBookId() == Id) {
                return i;
            }
        }
        return -1;
    }

    public Book Get(ArrayList<Book> list, int Id) {
        if (list.isEmpty()) {
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBookId() == Id) {
                return list.get(i);
            }
        }
        return null;
    }

    public boolean List(ArrayList<Book> list, JTable table) {
        if (list.isEmpty()) {
            return false;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Book book : list) {
            model.addRow(book.toObject());
        }
        table.setModel(model);
        return true;
    }

    public boolean Add(ArrayList<Book> list, Book item) {
        if (item == null) {
            return false;
        }
        int newId = NewId(list);
        item.setBookId(newId);
        list.add(item);
        return true;
    }

    public boolean Update(ArrayList<Book> list, Book item) {
        if (item == null) {
            return false;
        }
        int index = GetIndex(list, item.getBookId());
        if (index == -1) {
            return false;
        }
        list.set(index, item);
        return true;
    }

    public boolean Delete(ArrayList<Book> list, Book item) {
        if (item == null) {
            return false;
        }
        int index = GetIndex(list, item.getBookId());
        if (index == -1) {
            return false;
        }
        list.remove(index);
        return true;
    }

    public boolean Search(ArrayList<Book> list, JTable table, String value) {
        if (list.isEmpty()) {
            return false;
        }
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Book book : list) {
            if (book.getTitle().toLowerCase().contains(value)
                    || book.getCategory().toLowerCase().contains(value)
                    || book.getAward().toLowerCase().contains(value)
                    || book.getAuthor().toLowerCase().contains(value)
                    || Integer.toString(book.getYear()).toLowerCase().contains(value)
                    || Float.toString(book.getRating()).toLowerCase().contains(value)
                    || Integer.toString(book.getNumberOfPages()).toLowerCase().contains(value)
                    || Integer.toString(book.getYear()).toLowerCase().contains(value)) {
                model.addRow(book.toObject());
            }

        }

        table.setModel(model);

        return true;
    }

}
