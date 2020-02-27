/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author bodi4
 */
public class sql_connection {
    
    public static Connection getConnection() throws SQLException{
    try {
     Class.forName("org.sqlite.JDBC");
     return DriverManager.getConnection("jdbc:sqlite:new.db");
     }  
     catch(Exception e){
        System.out.println(e.getMessage());
       
     }  
       
 return null;
   }
    
   
    
}
