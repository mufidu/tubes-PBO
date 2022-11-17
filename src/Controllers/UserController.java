/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import java.util.Scanner;
import Models.UserModel;
/**
 *
 * @author johan
 */
public class UserController {
    
    public void getUser(UserModel[] users, int id){
        for(int i = 0; i < users.length; i++){
            if(users[i].getId() == id){
                System.out.println("Username: " + users[i].getUsername());
                System.out.println("Friends: ");
                break;
            }
        }
    }
    
    public void updateUser(UserModel[] users, int id){
        Scanner s = new Scanner(System.in);
        for(int i = 0; i < users.length; i++){
            if(users[i].getId() == id){
                System.out.print("Username baru: ");
                String newUsername = s.next();
                users[i].setUsername(newUsername);
                System.out.println("Password baru: ");
                String newPassword = s.next();
                users[i].setPassword(newPassword);
                break;
            }
        }
    }
    
    public void deleteUser(UserModel[] users, int id){
        for(int i = 0; i < users.length; i++){
            if(users[i].getId() == id){
                users[i] = null;
                break;
            }
        }
    }
    
    public void addUser(UserModel[] users, int id){
        for(int i = 0; i < users.length; i++){
            if(users[i].getId() == id){
                
                break;
            }
        }
    }
    
    public void removeUser(UserModel[] users, int id){
        
    }
    
}
