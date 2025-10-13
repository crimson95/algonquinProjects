/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8288 012
 * Lab Professor: George Kriger
 * Lab number: Assignment 1
 */
package transferobjects;

/**
 * Represents a postal code record
 * Acts as a Data Transfer Object (DTO) between DAO and business layers.
 * @author Jay Chao
 */
public class OttawaPostalDTO {
    private String city;
    private String fsa;
    private String province;
    private double latitude;
    private double longitude;
    
    /** default constructor */
    public OttawaPostalDTO(){}
    
       /**
    * Returns the city name.
    * @return city
    */
    public String getCity(){
        return city;
    }
    
   /**
    * Sets the city name.
    * @param city the name of the city to assign
    */
    public void setCity(String city){
        this.city = city;
    }
    
    /**
    * Returns the fsa.
    * @return fsa
    */
    public String getFsa(){
        return fsa;
    }
    
   /**
    * Sets the fsa.
    * @param fsa the fsa to assign
    */
    public void setFsa(String fsa){
        this.fsa = fsa;
    }
    
   /**
    * Returns the province name.
    * @return province
    */
    public String getProvince(){
        return province;
    }
    
   /**
    * Sets the province name.
    * @param province the name of the province to assign
    */
    public void setProvince(String province){
        this.province= province;
    }
    
   /**
    * Returns the latitude.
    * @return latitude
    */
    public double getLatitude(){
        return latitude;
    }
    
   /**
    * Sets the latitude.
    * @param latitude the latitude to assign
    */
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    
   /**
    * Returns the longitude.
    * @return longitude
    */
    public double getLongitude(){
        return longitude;
    }
    
   /**
    * Sets the longitude.
    * @param longitude the longitude to assign
    */
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
}
