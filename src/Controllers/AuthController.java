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
public class AuthController {
    Scanner s = new Scanner(System.in);
    
    public void registerUser(UserModel[] userList, int numOfUser){
        System.out.println("");
        System.out.println("============================");
        System.out.println("==========REGISTER==========");
        System.out.println("============================");
        System.out.print("Username: ");
        String username = s.next();
        System.out.print("Password: ");
        String password = s.next();
        System.out.print("Confirm Password: ");
        String confirmPass = s.next();
        
        if (password.equals(confirmPass)){
            userList[numOfUser-1]  = new UserModel(username, password);
            System.out.println("Registrasi berhasil!\n");
        }
        else{
            System.out.println("Confirm Password tidak sesuai");
        }
    }
    
    public int loginUser(UserModel[] userList){
        System.out.println("");
        System.out.println("============================");
        System.out.println("============LOGIN===========");
        System.out.println("============================");
        System.out.print("Username: ");
        String username = s.next();
        System.out.print("Password: ");
        String password = s.next();
        
        for(int idx = 0; idx < userList.length; idx++){
            if((userList[idx].getUsername().equals(username)) && (userList[idx].getPassword().equals(password))){
                return userList[idx].getId();
            }
        }
        return -1;
    }
    
}