import Controllers.AuthController;
import Controllers.UserController;
import Models.UserModel;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author johan
 */
public class Main {
    
    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int numOfUser = 0;
        
        UserController user = new UserController();
        AuthController auth = new AuthController();
        UserModel[] userList = new UserModel[numOfUser];
        UserModel[] tempUserList = userList;
        double currentId = 0;
        UserModel currentUser = new UserModel(null, null);
        
        BufferedImage image = new BufferedImage(144, 32, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setFont(new Font("Dialog", Font.PLAIN, 24));
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                graphics.drawString("SociaLife", 6, 24);
                ImageIO.write(image, "png", new File("text.png"));

        for (int y = 0; y < 32; y++) {
            StringBuilder sb = new StringBuilder();
            for (int x = 0; x < 144; x++)
                sb.append(image.getRGB(x, y) == -16777216 ? " " : image.getRGB(x, y) == -1 ? "#" : "*");
            if (sb.toString().trim().isEmpty()) continue;
            System.out.println(sb);
        }
        System.out.println("");
        
        OUTER:
        while (true) {
            System.out.println("Apa yang ingin Anda lakukan?");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Next menu");
            System.out.print("Pilihan (1-3): ");
            int pil = s.nextInt();
            
            switch (pil) {
                case 1:
                    numOfUser++;
                    tempUserList = userList;
                    userList = new UserModel[numOfUser];
                    System.arraycopy(tempUserList, 0, userList, 0, tempUserList.length);
                    auth.registerUser(userList, numOfUser);
                    break;
                case 2:
                    double userId = auth.loginUser(userList);
                    if (userId != -1){
                        System.out.println("");
                        System.out.println("=======Selamat Datang!======");
                        UserModel u = user.getUserById(userList, userId);
                        System.out.println("Username: " + u.getUsername());
                        System.out.println("Friends: " + Arrays.toString(u.getFriends()));
                        System.out.println("");
                        currentId = userId;
                        currentUser = user.getUserById(userList, currentId);
                    }
                    else {
                        System.out.println("\nUsername atau password yang dimasukkan salah!\n");
                    }   break;
                case 3:
                    if (currentId == 0) {
                        System.out.println("\nMaaf Anda harus login terlebih dahulu!\n");
                    } else {
                        System.out.println("\n============================\n");
                        break OUTER;
                    }
                    break;
                default:
                    break;
            }
        }
        
        while (true) {            
            System.out.println("Apa yang ingin Anda lakukan?");
            System.out.println("1. Tambah teman");
            System.out.println("2. Info profil");
            
            System.out.print("Pilihan (1): ");
            int pil = s.nextInt();
            
            if (pil == 1) {
                System.out.print("Apa username teman Anda? ");
                String friendUsername = s.next();
                UserModel friend = user.getUserByUsername(userList, friendUsername);
                user.addFriends(currentUser, friend);
            } else if (pil == 2) {
                UserModel u = user.getUserById(userList, currentId);
                System.out.println("\nHalo, "+u.getUsername()+"!");
                System.out.println("Username: " + u.getUsername());
                System.out.println("Friends: " + Arrays.toString(u.getFriends()));
                System.out.println("");
            }
        }
    }
}
