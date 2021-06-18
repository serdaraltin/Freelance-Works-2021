package Controller;

import java.util.ArrayList;
import javax.swing.JTable;

public interface ISub<T> {

    public ArrayList<T> List(JTable table);

    public ArrayList<T> Search(JTable table, String want);

    public boolean Add(T oModel);

    public boolean Update(T oModel);

    public T Get(T oModel);

}
