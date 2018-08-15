package everest.dao;

import java.sql.SQLException;
import java.util.List;

public interface DataAcessObject<T> 
{
    public List<T> get() throws SQLException;
    public Long save(T object) throws SQLException;
    public void update(T object) throws SQLException;
    public void delete(Long id) throws SQLException;
}