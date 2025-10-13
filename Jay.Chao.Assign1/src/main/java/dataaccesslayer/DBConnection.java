/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8288 012
 * Lab Professor: George Kriger
 * Lab number: Assignment 1
 */
package dataaccesslayer;

import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.Properties;

/**
 * Singleton class providing a single shared database connection.
 * Reads connection info from database.properties file.
 * @author Jay Chao
 */
public class DBConnection {   
        private static DBConnection instance;
        private String url;
        private String username;
        private String password;
        
    private DBConnection(){
        // Load database connection info from database.properties
        String[] info = openPropsFile();
        this.url = info[0];
        this.username = info[1];
        this.password = info[2];
    }
    
   /**
    * Returns the single instance of the DBConnection class.
    * @return the only DBConnection instance in the application
    */
    public static synchronized DBConnection getInstance(){       
        if(instance == null){
                instance = new DBConnection();
            }
        return instance;
    }
    
   /**
    * Creates and returns a new database connection.
    * @return a new {@link java.sql.Connection} to the MySQL database
    * @throws SQLException if the connection cannot be established
    */
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url, username, password);
    }
    
    private static String[] openPropsFile(){
        Properties props = new Properties();
        
        try (InputStream in = Files.newInputStream(Paths.get("src/main/java/database.properties"));){
            props.load(in);

        } catch (IOException e) {
            
            e.printStackTrace();
        }//catch()
        
        String url = props.getProperty("jdbc.url");
        String username = props.getProperty("jdbc.username");
        String password = props.getProperty("jdbc.password");
        
        return new String[]{url, username, password};
    }
}//class