
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SozcukListe<T> implements List<T> {

    ArrayList<String> liste = new ArrayList<>();

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] liste) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        c.forEach((token) -> {
            this.liste.add(token.toString());
        });
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T element) {
        return null;
    }

    @Override
    public void add(int index, T element) {
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int size() {

        return liste.size();
    }

    @Override
    public boolean add(T e) {
        if (!((String) e).equals("")) {
            liste.add((String) e);
        }
        return false;
    }

    public void tokenizeValues(T values) {
        String token = values.toString().toLowerCase();
        char[] letters = token.toCharArray();
        token = "";
        for (char c : letters) {

            if (c != ' ' && c != ',' && c != '.' && c != '?') {
                token += c;
            } else {
                this.add((T) token);
                token = "";
            }
        }
        this.add((T) token);

    }

    public ArrayList<String> printValues(T value) {
        System.out.println(value);
        return liste;
    }

}
