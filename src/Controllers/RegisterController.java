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
        try {
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/socialife", 
                    "root",
                    "");
            this.stmt = conn.createStatement();
            System.out.println("Connection Berhasil");
        } catch (Exception E) {
            System.out.println("Connection Gagal!");
        }
    }
    
    public void registerUser(String username, String password) {
        try {
            stmt.executeUpdate("INSERT INTO user (username, password) VALUES('"+username+"', '"+password+"');");
            System.out.println("Registrasi Berhasil");
        } catch (SQLException e){
            System.out.println("Registrasi Gagal");
            e.printStackTrace();
        }
    }
}
