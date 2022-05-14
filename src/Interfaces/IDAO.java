package Interfaces;

import java.util.ArrayList;

public interface IDAO <T> {
    
    
    public boolean create(T objeto);
    
    public boolean update(T objeto);
    
    public String[][] GetAll();
    
    public T GetById(int id);
    
    public boolean delete(T objeto);
   
    
}