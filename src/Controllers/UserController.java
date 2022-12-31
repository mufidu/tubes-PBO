/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import java.util.Scanner;
import Models.UserModel;
import java.sql.*;
import java.util.*;
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
            String sql = "SELECT * FROM user";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                addUser(rs.getString("username"), rs.getString("password"), 
                        rs.getInt("id"), rs.getInt("friendlist_id"));
            }
            disconnect();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void addUser(String username, String password, long id, long friendlist_id){
        UserModel x = new UserModel(username, password, id , friendlist_id);
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
            String sql = "UPDATE user SET username='"+username+"', password='"+password+"' WHERE id='"+id+"';";
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
            rs = stmt.executeQuery("SELECT * FROM user WHERE username='"+username+"'");
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
