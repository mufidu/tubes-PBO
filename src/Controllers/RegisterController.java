/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;
import java.sql.*;
/**
 *
 * @author johan
 */
public class RegisterController {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    
    public RegisterController() {
    }
    
    public void connect(){
         try {
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/socialife", 
                    "root",
                    "");
            this.stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void disconnect(){
        try{
            conn.close();
        stmt.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
    public void registerUser(String username, String password) {
        UserController x = new UserController();
        try {
            connect();
            if(x.findUser(username) == false){
                stmt.executeUpdate("INSERT INTO user (username, password) VALUES('"+username+"', '"+password+"');");
            } else {
                //placeholder, change later
                System.out.println("UDAH ADA USERNAME TERSIMPAN");
            }
            disconnect();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
