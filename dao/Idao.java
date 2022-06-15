package dao;

import java.util.ArrayList;

public interface Idao<T> {

	public boolean create(T object);
	public ArrayList<T> read();
	public ArrayList<T> readee(T object);
	public ArrayList<T> findby (String email, String password);
		
	
}
