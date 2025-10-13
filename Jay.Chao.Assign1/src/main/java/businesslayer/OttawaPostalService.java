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
import transferobjects.OttawaPostalDTO;

/**
 * Business logic for the OttawaPostal table.
 * Delegates data access to DAO and may apply validations or transformations.
 * @author Jay Chao
 */
public class OttawaPostalService {
    private OttawaPostalDAO dao;
    
    /** constructor */
    public OttawaPostalService(){
        dao = new OttawaPostalDAOImpl();
    }
    
    /**
     * Retrieves all OttawaPostal records from the database.
     * @return list of OttawaPostalDTO objects
     */
    public List<OttawaPostalDTO>getAllData(){
        return dao.getAllData();
    }
    
    /**
     * Retrieves a OttawaPostal record for the specified FSA.
     * @param fsa Forward Sortation Area (e.g., "K2G")
     * @return OttawaPostalDTO object if found, otherwise null
     */
    public OttawaPostalDTO getByFsa(String fsa){
        return dao.getByFsa(fsa);
    }
}
