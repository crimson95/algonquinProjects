/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8288 012
 * Lab Professor: George Kriger
 * Lab number: Assignment 1
 */
package dataaccesslayer;

import java.util.List;
import transferobjects.JoinDTO;

/**
 * DAO interface defining methods to access postal code and EV count data
 * Implementations of this interface handle SQL queries and return DTO objects.
 * @author Jay Chao
 */
public interface JoinDAO {
    
   /**
    * Retrieves all postal code and EV count records
    * Joins the ottawapostalcodes and evcounts tables on the FSA column.
    * @return a list of objects
    */
    List<JoinDTO> getAllData();
   
    /**
    * Retrieves a single postal code record for the specified FSA
    * @param fsa the Forward Sortation Area (e.g., "K2G")
    * @return the matching, or null if not found
    */
    JoinDTO getByFsa(String fsa);
}
