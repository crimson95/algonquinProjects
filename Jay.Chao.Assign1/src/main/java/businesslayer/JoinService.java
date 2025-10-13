/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8288 012
 * Lab Professor: George Kriger
 * Lab number: Assignment 1
 */
package businesslayer;

import dataaccesslayer.*;
import java.util.List;
import transferobjects.JoinDTO;

/**
 * Business logic for the JOIN table (ottawapostalcodes × evcounts).
 * Handles data retrieval and total calculations.
 * @author Jay Chao
 */
public class JoinService {  
    private JoinDAO dao;
    
    /** constructor */
    public JoinService(){
        dao = new JoinDAOImpl();
    }
    
    /**
     * Retrieves all JOIN records from the database.
     * @return list of JoinDTO objects
     */
    public List<JoinDTO> getAllData(){
        return dao.getAllData();
    }
    
    /**
     * Retrieves a JOIN record for the specified FSA.
     * @param fsa Forward Sortation Area (e.g., "K2G")
     * @return JoinDTO object if found, otherwise null
     */
    public JoinDTO getByFsa(String fsa){
        return dao.getByFsa(fsa);
    }
}
