/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import java.util.Scanner;
import Models.UserModel;
import java.sql.*;
/**
 *
 * @author johan
 */
public class UserController {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    
    public UserController() {
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
    
    public void updateUser(int id, String username, String password) {
        try {
            String sql = "UPDATE user SET username='"+username+"', password='"+password+"' WHERE id='"+id+"';";
            stmt.executeUpdate(sql);
        } catch (SQLException e){
            e.printStackTrace();
        }
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
