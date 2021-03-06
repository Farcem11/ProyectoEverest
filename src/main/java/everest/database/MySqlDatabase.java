package everest.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Component;

@Component
public class MySqlDatabase
{
    private Connection connection;
    private static final String FILE_PATH = "database/database.properties";
    private Properties databaseProperties= new Properties();
    private FileInputStream databaseFileProperty = null;
    
    private MySqlDatabase()
    {
        try
        {
            databaseFileProperty = new FileInputStream(FILE_PATH);
            databaseProperties.load(databaseFileProperty);
            Class.forName(databaseProperties.getProperty("DB_DRIVER"));
            connection = DriverManager.getConnection(
                databaseProperties.getProperty("DB_URL"),
                databaseProperties.getProperty("DB_USERNAME"),
                databaseProperties.getProperty("DB_PASSWORD"));
        }
        catch(IOException e)
        {
            Logger.getLogger(MySqlDatabase.class.getName()).log(Level.SEVERE, "IO Exception {0}", e.getMessage());
        } 
        catch(SQLException ex) 
        {
            Logger.getLogger(MySqlDatabase.class.getName()).log(Level.SEVERE, "SQL Exception {0}", ex.getMessage());
        } 
        catch(ClassNotFoundException ex) 
        {
            Logger.getLogger(MySqlDatabase.class.getName()).log(Level.SEVERE, "Class Not Found Exception {0}", ex.getMessage());
        }        
    }
    
    public Connection getConnection() 
    {
        return connection;
    }
}

