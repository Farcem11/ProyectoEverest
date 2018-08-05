package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlConnection 
{
    private static final MySqlConnection instance = new MySqlConnection();
    private Connection connection;
    private final String filePath = "database/database.properties";
    private Properties databaseProperties= new Properties();
    private FileInputStream databaseFileProperty = null;
    
    private MySqlConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            databaseFileProperty = new FileInputStream(filePath);
            databaseProperties.load(databaseFileProperty);
            connection = DriverManager.getConnection(
                databaseProperties.getProperty("DB_URL"),
                databaseProperties.getProperty("DB_USERNAME"),
                databaseProperties.getProperty("DB_PASSWORD"));
        }
        catch(IOException e)
        {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, "IO Exception {0}", e.getMessage());
        } 
        catch(SQLException ex) 
        {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, "SQL Exception {0}", ex.getMessage());
        } 
        catch(ClassNotFoundException ex) 
        {
            Logger.getLogger(MySqlConnection.class.getName()).log(Level.SEVERE, "Class Not Found Exception {0}", ex.getMessage());
        }        
    }
    
    public static MySqlConnection getInstance()
    {
        return instance;
    }
    
    /**
     * @return the connection
     */
    public Connection getConnection() 
    {
        return connection;
    }
}

