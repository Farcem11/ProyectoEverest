package dao;

import java.util.List;

public interface DataAcessObject<T> 
{
    public List<T> get();
    public void save(T object);
    public void update(T object);
}
