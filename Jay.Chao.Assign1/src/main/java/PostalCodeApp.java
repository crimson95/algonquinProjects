/*
 * Student Name: Jay Chao
 * Student ID: 041168332
 * Section: CST8288 012
 * Lab Professor: George Kriger
 * Lab number: Assignment 1
 */


import businesslayer.JoinService;
import dataaccesslayer.*;
import transferobjects.*;
import java.sql.*;
import java.util.List;

/**
 * Console application entry point for Assignment 1.
 * Loads data using the DAO pattern, displays metadata, table output,
 * and calculates totals for Bev, Phev, and TotalEv columns.
 * @author Jay Chao
 */
public class PostalCodeApp {
    
    /** default constructor */
    public PostalCodeApp(){}
   
   /**
    * Entry point of the program.
    * Executes database queries, prints metadata and results to the console.
    * @param args command-line arguments (not used)
    */
    public static void main(String[] args) {
        
        JoinService js = new JoinService();
        
        // Retrieve all records from database
        List<JoinDTO> joinList = js.getAllData();      
        String dash = "-".repeat(108);
        int sumBev = 0, sumPhev = 0, sumTotalEv = 0;
        
        // Print formatted table header
        String rowFmt = "%-5s %-68s %8s %8s %10s";
        String header = String.format(rowFmt, "FSA", "City",  "BEV", "PHEV", "TotalEV");
        
        System.out.printf("EV Counts for Ontario: %n");
        System.out.printf(header);
        System.out.println();


        // Print each row and calculate totals
        for(JoinDTO jdto: joinList){
            System.out.printf(rowFmt,  jdto.getFsa(), jdto.getCity(), jdto.getBev(), jdto.getPhev(), jdto.getTotalEv());
            System.out.println();
            
            sumBev += jdto.getBev();
            sumPhev += jdto.getPhev();
            sumTotalEv += jdto.getTotalEv();
        }
        
        // Print totals at the end
        System.out.println(dash);
        System.out.printf(rowFmt, "Total", "", sumBev, sumPhev, sumTotalEv);
        System.out.println();
        
        
        // Print search result
        String searchFmt = "%-5s %-68s %-10s %-20s %-10s";
        String headerSearch = String.format(searchFmt, "FSA", "City", "Province", "Latitude", "Longitude");

        JoinDTO result = js.getByFsa("K2G");
        if(result != null){
            System.out.println();
            System.out.printf("FSA for Algonquin College: %n");
            System.out.printf(headerSearch);
            System.out.println();
            System.out.printf(searchFmt, result.getFsa(), result.getCity(), result.getProvince(), result.getLatitude(), result.getLongitude());
        }else{
            System.out.printf("%nNo matches for K2G%n");
        }
    } //main()
} //class()
