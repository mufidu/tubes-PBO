/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.chatList;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author johan
 */
public class LoginController {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    
    public LoginController() {
        
    }
    
    public void connect(){
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
    
    public void disconnect(){
        try{
            conn.close();
            stmt.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void loginUser(String username, String password) {
        try {
            connect();
            String sql = "SELECT * FROM user where username='"+username+"' and password='"+password+"';";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                chatList landView = new chatList();
                landView.show();
            } else {
                JOptionPane.showMessageDialog(null, "username atau password salah");
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
