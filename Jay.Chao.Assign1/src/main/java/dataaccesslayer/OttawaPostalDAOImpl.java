/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8288 012
 * Lab Professor: George Kriger
 * Lab number: Assignment 1
 */
package dataaccesslayer;

import java.sql.*;
import java.util.*;
import transferobjects.OttawaPostalDTO;

/**
 * Implementation of the interface.
 * Uses JDBC to execute SQL queries on the ottawapostalcodes tables.
 * Each method retrieves data from the database and maps it to DTO objects.
 * @author Jay Chao
 */
public class OttawaPostalDAOImpl implements OttawaPostalDAO{
    // SQL query ottawapostalcodes tables
    private static final String QUERY = "SELECT City, Province, Latitude, Longitude FROM ottawapostalcodes";
    private static final String QUERY_FSA = "SELECT City, Province, Latitude, Longitude FROM ottawapostalcodes WHERE Fsa = ?";
    
    /** default constructor */
    public OttawaPostalDAOImpl(){}
    
    /**
     * Retrieves all postal code and EV count records.
     * Joins the ottawapostalcodes tables on the FSA column.
     * @return a list of objects
     */
    @Override
    public List<OttawaPostalDTO> getAllData(){
        List<OttawaPostalDTO> postalList = new ArrayList<>();
        
        // Use try-with-resources to automatically close resources
        try(Connection con = DBConnection.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery()){ 
                      
            // Loop through result set and populate DTO objects
            while (rs.next()){
                OttawaPostalDTO opdto = new OttawaPostalDTO();
                
                String fsa = rs.getString("Fsa");  // assign postal code
                opdto.setFsa(fsa);
                
                String city = rs.getString("City");  // assign city name
                opdto.setCity(city);
                
                String province =rs.getString("Province");  // assign province
                opdto.setProvince(province);
               
                double latitude = rs.getDouble("Latitude");  // assign latitude
                opdto.setLatitude(latitude);
                
                double longitude = rs.getDouble("Longitude"); // assign longitude
                opdto.setLongitude(longitude);
                
                postalList.add(opdto);  // add DTO to list
            }
        }
        catch (SQLException e){
            e.printStackTrace(); // print SQL errors if query fails
        }
        return postalList; // return list of all records
    }

   /**
    * Retrieves a single postal code record for the specified FSA.
    * @param fsa the Forward Sortation Area (e.g., "K2G")
    * @return the matching, or null if not found
    */
    @Override
    public OttawaPostalDTO getByFsa(String fsa) {
        OttawaPostalDTO opdto = null;
        
        // Use try-with-resources to ensure con/ps/rs are closed automatically
        // Map each row from ResultSet to DTO, then add to list
        // Bind parameter to the WHERE clause to avoid SQL injection
        try(Connection con = DBConnection.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(QUERY_FSA)){
            ps.setString(1, fsa);
            try(ResultSet rs = ps.executeQuery()){
             if(rs.next()){
                 opdto = new OttawaPostalDTO();
                 opdto.setFsa(rs.getString("Fsa"));
                 opdto.setCity(rs.getString("City"));
                 opdto.setProvince(rs.getString("Province"));
                 opdto.setLatitude(rs.getDouble("Latitude"));
                 opdto.setLongitude(rs.getDouble("Longitude"));
             }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return opdto;
    }
}
