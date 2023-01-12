/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.UserModel;
import java.lang.Math;
import java.sql.*; 
import java.util.ArrayList;
import javax.swing.JTextArea;
/**
 *
 * @author johan
 */
public class MessageController {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private int msg = 0;

    public MessageController() {
        try{
            connect();
            String sql = "SELECT * FROM users";
            rs = stmt.executeQuery(sql);
            disconnect();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void connect(){
        try {
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://root:uDpMRxFNGts2C5BbSeA7@containers-us-west-115.railway.app:6887/railway", 
                    "root",
                    "uDpMRxFNGts2C5BbSeA7");
            this.stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
    
    public void sendMessage(String text, String username, String usernameFriend) {
        String sql = "INSERT INTO `MESSAGES` (`id_user1`, `id_user2`, `message`, `DATE`) VALUES ((SELECT id FROM users WHERE username='" + username + "'), (SELECT id FROM users WHERE username='" + usernameFriend + "'), '" + text + "', CURRENT_TIMESTAMP)";
        
        try {
            connect();
            stmt.executeUpdate(sql);
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        msg = -5;
    }
    
    public void fillMessage(String username, String usernameFriend, JTextArea chat_window) {
        String sql = "SELECT users.username, MESSAGES.DATE, MESSAGES.message FROM MESSAGES INNER JOIN users ON users.id = MESSAGES.id_user1 WHERE (MESSAGES.id_user1 = (SELECT id FROM users WHERE username = '" + username +"') AND MESSAGES.id_user2 = (SELECT id FROM users WHERE username = '" + usernameFriend +"')) OR (MESSAGES.id_user1 = (SELECT id FROM users WHERE username = '" + usernameFriend +"') AND MESSAGES.id_user2 = (SELECT id FROM users WHERE username = '" + username +"')) ORDER BY MESSAGES.DATE ASC";
        
        try {
            connect();
            rs = stmt.executeQuery(sql);
            rs.next();
            rs.last();
            if (msg < rs.getRow()){
                rs.first();
                chat_window.setText("");
                do {
                    chat_window.append(rs.getObject(1).toString() + ", " + rs.getObject(2).toString() + ": \n" + rs.getObject(3).toString() + "\n \n");
                } while (rs.next());
                rs.last();
                msg = rs.getRow();
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
