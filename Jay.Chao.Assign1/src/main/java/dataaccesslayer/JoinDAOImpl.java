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
import transferobjects.JoinDTO;

/**
 * Implementation of the interface.
 * Uses JDBC to execute SQL JOIN queries on the ottawapostalcodes and evcounts tables.
 * Each method retrieves data from the database and maps it to DTO objects.
 * @author Jay Chao
 */
public class JoinDAOImpl implements JoinDAO {
    // SQL query joins ottawapostalcodes and evcounts tables on Fsa column
    private static final String QUERY = "SELECT ott.City, ott.Province, ott.Latitude, ott.Longitude, ev.Fsa, ev.Bev, ev.Phev, ev.TotalEv FROM evontario.ottawapostalcodes ott JOIN evontario.evcounts ev ON ott.Fsa = ev.Fsa";
    private static final String QUERY_FSA = "SELECT ott.City, ott.Province, ott.Latitude, ott.Longitude, ev.Fsa, ev.Bev, ev.Phev, ev.TotalEv FROM evontario.ottawapostalcodes ott JOIN evontario.evcounts ev ON ott.Fsa = ev.Fsa WHERE ott.Fsa = ?";
    /** default constructor */
    public JoinDAOImpl(){}
    
    /**
     * Retrieves all postal code and EV count records.
     * Joins the ottawapostalcodes and evcounts tables on the FSA column.
     * @return a list of objects
     */
    @Override
    public List<JoinDTO> getAllData(){
        List<JoinDTO> postalList = new ArrayList<>();
        

        // Use try-with-resources to automatically close resources
        try(Connection con = DBConnection.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(QUERY);
            ResultSet rs = ps.executeQuery()){ 
                      
            // Loop through result set and populate DTO objects
            while (rs.next()){
                JoinDTO jdto = new JoinDTO();
                
                String fsa = rs.getString("Fsa");  // assign postal code
                jdto.setFsa(fsa);
                
                String city = rs.getString("City");  // assign city name
                jdto.setCity(city);
                
                String province =rs.getString("Province");  // assign province
                jdto.setProvince(province);
               
                int bev = rs.getInt("Bev"); // assign bev
                jdto.setBev(bev);
                
                int phev = rs.getInt("Phev"); // assign phev
                jdto.setPhev(phev);
                
                int totalev = rs.getInt("TotalEv");  // assign totalev
                jdto.setTotalEv(totalev);
                
                double latitude = rs.getDouble("Latitude");  // assign latitude
                jdto.setLatitude(latitude);
                
                double longitude = rs.getDouble("Longitude"); // assign longitude
                jdto.setLongitude(longitude);
                
                postalList.add(jdto);  // add DTO to list
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
    * @return the matching {@link transferobjects.JoinDTO}, or null if not found
    */
    @Override
    public JoinDTO getByFsa(String fsa) {
        JoinDTO jdto = null;
        
        // Use try-with-resources to ensure con/ps/rs are closed automatically
        // Map each row from ResultSet to DTO, then add to list
        // Bind parameter to the WHERE clause to avoid SQL injection
        try(Connection con = DBConnection.getInstance().getConnection();
            PreparedStatement ps = con.prepareStatement(QUERY_FSA)){
            ps.setString(1, fsa);
            try(ResultSet rs = ps.executeQuery()){
             if(rs.next()){
                 jdto = new JoinDTO();
                 jdto.setFsa(rs.getString("Fsa"));
                 jdto.setCity(rs.getString("City"));
                 jdto.setProvince(rs.getString("Province"));
                 jdto.setBev(rs.getInt("Bev"));
                 jdto.setPhev(rs.getInt("Phev"));
                 jdto.setTotalEv(rs.getInt("TotalEv"));
                 jdto.setLatitude(rs.getDouble("Latitude"));
                 jdto.setLongitude(rs.getDouble("Longitude"));
             }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return jdto;
    }
}
