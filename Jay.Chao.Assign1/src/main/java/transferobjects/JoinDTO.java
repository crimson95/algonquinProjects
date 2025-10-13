/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8288 012
 * Lab Professor: George Kriger
 * Lab number: Assignment 1
 */
package transferobjects;

/**
 * Represents a postal code record with electric vehicle counts.
 * Acts as a Data Transfer Object (DTO) between DAO and business layers.
 * @author Jay Chao
 */
public class JoinDTO {
    private String city;
    private String province;
    private double latitude;
    private double longitude;
    private String fsa;
    private int bev;
    private int phev;
    private int totalev;
    
    /** default constructor */
    public JoinDTO(){}
    
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
    * Returns the bev.
    * @return bev
    */
    public int getBev(){
        return bev;
    }
    
   /**
    * Sets the bev.
    * @param bev the bev to assign
    */
    public void setBev(int bev){
        this.bev = bev;
    }
    
   /**
    * Returns the phev.
    * @return phev
    */
    public int getPhev(){
        return phev;
    }
    
   /**
    * Sets the phev.
    * @param phev the phev to assign
    */
    public void setPhev(int phev){
        this.phev = phev;
    }
    
   /**
    * Returns the totalev.
    * @return totalev
    */
    public int getTotalEv(){
        return totalev;
    }
    
       /**
    * Sets the totalev.
    * @param totalev the totalev to assign
    */
    public void setTotalEv(int totalev){
        this.totalev = totalev;
    }
}
