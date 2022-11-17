
import Controllers.AuthController;
import Controllers.UserController;
import Models.UserModel;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author johan
 */
public class Main {
    
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numOfUser = 0;
        
        UserController user = new UserController();
        AuthController auth = new AuthController();
        UserModel[] userList = new UserModel[numOfUser];
        
        System.out.println("SociaLife");
        
//        while(true){
//            System.out.println("1. Register");
//            System.out.println("2. Login");
//        
//            System.out.print("Pilihan: ");
//            int pil = s.nextInt();
//        
//            if(pil == 1){
//                auth.registerUser(userList);
//            } else if(pil == 2){
//                int id = auth.loginUser(userList);
//                if (id != -1){
//                    System.out.println("Selamat Datang");
//                    user.getUser(userList, id);
//                } else {
//                    System.out.println("Username atau Password yang dimasukkan salah!");
//                }
//            }
//        }    
        while(true){
            System.out.println("1. Register");
            System.out.println("2. Login");
        
            System.out.print("Pilihan: ");
            int pil = s.nextInt();
        
            if(pil == 1){
                numOfUser++;
                userList = new UserModel[numOfUser];
                auth.registerUser(userList);
            } else if(pil == 2) {
                int userId = auth.loginUser(userList);
                if (userId != -1){
                    System.out.println("Selamat Datang!");
                    user.getUser(userList, userId);
                }
                else {
                    System.out.println("Username atau password yang dimasukkan salah!");
                }
            }
        }
        
    }
}
