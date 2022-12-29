/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.sql.DriverManager;

/**
 *
 * @author johan
 */
public class LoginController {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    
    public LoginController() {
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
    
    public void loginUser(String username, String password) {
        try {
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
