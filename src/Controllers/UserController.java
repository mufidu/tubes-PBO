/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import java.util.Scanner;
import Models.UserModel;
import Views.chatList;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
/**
 *
 * @author johan
 */
public class UserController {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private ArrayList<UserModel> users;
    
    public UserController() {
        users = new ArrayList<>();
        try{
            connect();
            String sql = "SELECT * FROM users";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                addUser(rs.getString("username"), rs.getString("password"), 
                        rs.getInt("id"));
            }
            disconnect();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ArrayList<String> findFriends(String user_now){
        ArrayList<String> friends = new ArrayList<>();
        try{
            connect();
            String sql = "SELECT users.username FROM friends INNER JOIN users ON friends.id_user2=users.id WHERE friends.id_user1 = (SELECT id FROM users WHERE username = '" + user_now +"')";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                friends.add(rs.getString("username"));
            }
            disconnect();
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return friends;
    }
    
    public void addFriend(String user_now, String friend){
        boolean friendSwitch = false;
        String sql;
        
        //cek friend exists
        try{
            connect();
            sql = "SELECT * FROM users WHERE username='"+friend+"'";
            rs = stmt.executeQuery(sql);
            rs.next();
            if(friend.equals(rs.getObject(2).toString())) friendSwitch = true; System.out.println("friendSwitch TRUE!");
            disconnect();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "No such user in database!");
        }
        
        //cek if already friends
        try{
            sql = "SELECT * FROM friends WHERE id_user1 = (SELECT id FROM users WHERE username='" + user_now + "') AND id_user2 = (SELECT id FROM users WHERE username='" + friend + "')";
            connect();
            rs = stmt.executeQuery(sql);
            int i = 0;
            while(rs.next()) i++;
            disconnect();
            if(i>0){
                friendSwitch = false;
            }
            
            if(friendSwitch){
                try{
                    sql = "INSERT INTO friends VALUES ((SELECT id FROM users WHERE username='" + user_now + "'), (SELECT id FROM users WHERE username='" + friend + "'))";
                    connect();
                    stmt.executeUpdate(sql);
                    disconnect();
                    JOptionPane.showMessageDialog(null, "friend added succesfully!!");
                } catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error adding friend!");
                }
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void loginUser(String username, String password) {
        try {
            connect();
            String sql = "SELECT * FROM users where username='"+username+"' and password='"+password+"';";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                chatList landView = new chatList(username);
                landView.show();
            } else {
                JOptionPane.showMessageDialog(null, "username atau password salah");
            }
            disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void registerUser(String username, String password) {
        UserController x = new UserController();
        try {
            connect();
            if(x.findUser(username) == false){
                stmt.executeUpdate("INSERT INTO users (username, password) VALUES('"+username+"', '"+password+"');");
            } else {
                //placeholder, change later
                System.out.println("UDAH ADA USERNAME TERSIMPAN");
            }
            disconnect();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void addUser(String username, String password, long id){
        UserModel x = new UserModel(username, password, id);
        users.add(x);
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
    
    public void updateUser(int id, String username, String password) {
        try {
            connect();
            String sql = "UPDATE users SET username='"+username+"', password='"+password+"' WHERE id='"+id+"';";
            stmt.executeUpdate(sql);
            disconnect();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public boolean findUser(String username){
        
        boolean cek = false;
        try{
            connect();
            rs = stmt.executeQuery("SELECT * FROM users WHERE username='"+username+"'");
            while(rs.next()){
                cek = true;
            }
            disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
        
        
        return cek;
    }
//    public UserModel getUserById(UserModel[] users, double id){
//        for (UserModel user : users) {
//            if (user.getId() == id) {
//                return user;
//            }
//        }
//        return null;
//    }
//    
//    public UserModel getUserByUsername(UserModel[] users, String username){
//        for (UserModel user : users) {
//            if (user.getUsername().equals(username)) {
//                return user;
//            }
//        }
//        return null;
//    }
//    
//    public void updateUser(UserModel[] users, double id){
//        Scanner s = new Scanner(System.in);
//        for (UserModel user : users) {
//            if (user.getId() == id) {
//                System.out.print("\nUsername baru: ");
//                String newUsername = s.next();
//                user.setUsername(newUsername);
//                System.out.print("Password baru: ");
//                String newPassword = s.next();
//                user.setPassword(newPassword);
//                break;
//            }
//        }
//    }
//    
//    public UserModel[] deleteUser(UserModel[] users, double id){
//        UserModel[] newUsers = new UserModel[users.length-1];
//        
//        for(int i = 0, k = 0; i < users.length; i++){
//            if(users[i].getId() != id){
//                newUsers[k] = users[i];
//                k++;
//            }
//        }
//        
//        return newUsers;
//    }
//    
//    public void addFriends(UserModel currentUser, UserModel friend) {
//        double[] tempFriends = currentUser.getFriends();
//        double[] newFriends = new double[tempFriends.length+1];
//        for (int i = 0; i < tempFriends.length; i++) {
//            newFriends[i] = tempFriends[i];
//        }
//        newFriends[newFriends.length-1] = friend.getId();
//        currentUser.setFriends(newFriends);
//        
//    }
}
