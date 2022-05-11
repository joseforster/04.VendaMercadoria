package interfaces;

import java.util.ArrayList;

public interface Idao <T> {
    
    public boolean create(T objeto);
    
    public boolean update(T objeto);
    
    public ArrayList<T> GetAll();
    
    public T GetById(int id);
    
    public boolean delete(T objeto);
    
}