package Interface;

import java.util.ArrayList;

public interface IController<T> {

    public boolean Add(ArrayList<T> list, T data);

    public boolean Delete(ArrayList<T> list,int Id);

    public boolean Update(ArrayList<T> list, T data);

    public void List(ArrayList<T> list);

    public T Select(ArrayList<T> list, int Id);
}
