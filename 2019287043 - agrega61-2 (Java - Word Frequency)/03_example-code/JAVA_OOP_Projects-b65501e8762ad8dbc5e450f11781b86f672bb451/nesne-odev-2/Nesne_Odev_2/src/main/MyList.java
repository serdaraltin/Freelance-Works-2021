package main;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



public class MyList<T> implements List<T> {
	ArrayList<String> a= new ArrayList<String>();
	//creating my list with the help of arraylist
	public void tokenizeValues(T values)
	{
		String token=values.toString().toLowerCase();
		char  [] letters=token.toCharArray();
		token="";
		for(char c : letters)
		{	
			
			if(c!=' '&&c!=','&&c!='.'&&c!='?')
			{
				token+=c;//tokenize every word the if statement is not that complex
			}
				
			else
			{
				this.add((T) token);//if char equals any of the above that means it is a token now and it will be added to the list
				token="";	
			}		
		}
		this.add((T) token);
		
	}
	
	public ArrayList<String> printValues(T value)
	{
		System.out.println(value);
		return a;//printing all the tokens with the given text value
	}
	@Override
	public int size() {
		
		return a.size();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		if((String)e!="")//add the tokens if it's not null or empty
			a.add((String) e);
		return false;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		for(Object token:c) {
			this.a.add(token.toString());//adding all the tokens to the list
		}
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
	

