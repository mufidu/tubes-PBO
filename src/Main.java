import Controllers.AuthController;
import Controllers.UserController;
import Controllers.ChatController;
import Controllers.MessageController;
import Models.UserModel;
import Models.ChatModel;
import Models.MessageModel;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author johan
 */
public class Main {
    
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner s = new Scanner(System.in);
        int numOfUser = 0;
        UserController user = new UserController();
        AuthController auth = new AuthController();
        ChatController cc = new ChatController();
        UserModel[] userList = new UserModel[numOfUser];
        UserModel[] tempUserList;
        double currentId = 0;
        UserModel currentUser = new UserModel(null, null);
        ChatModel[] chatList = new ChatModel[9999];
        int chatCount = 0;
        
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
        
        APP:
        while (true) {
            MENU:
            while (true) {
                System.out.println("Apa yang ingin Anda lakukan?");
                System.out.println("1. Register");
                System.out.println("2. Login");
                System.out.println("3. Next menu");
                System.out.println("4. Exit");
                System.out.print("Pilihan (1-4): ");
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
                            System.out.println(u.getUsername()
                            + " berhasil login!");
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
                            break MENU;
                        }
                        break;
                    case 4:
                        System.out.println("\nSelamat tinggal!\n");
                        break APP;
                    default:
                        System.out.println("\nPilihan invalid!\n");
                        break;
                }
            }

            LOGGED_IN:            
            while (true) {
                System.out.println("Apa yang ingin Anda lakukan?");
                System.out.println("1. Tambah teman");
                System.out.println("2. Info profil");
                System.out.println("3. Edit user");
                System.out.println("4. Hapus user");
                System.out.println("5. Buat Room Chat");
                System.out.println("6. Masuk Room Chat");
                System.out.println("7. Cari Teman Chat");
                System.out.println("8. Cari Room Chat ID");
                System.out.println("9. Log out");
                System.out.print("Pilihan (1-9): ");
                int pil = s.nextInt();

                switch (pil) {
                    case 1:
                        System.out.print("Apa username teman Anda? ");
                        String friendUsername = s.next();
                        UserModel friend = user.getUserByUsername(userList, friendUsername);
                        user.addFriends(currentUser, friend);
                        System.out.println("\n"+friend.getUsername()
                                +" berhasi ditambahkan sebagai teman.\n");
                        break;
                    case 2:
                        UserModel u = user.getUserById(userList, currentId);
                        System.out.println("\nHalo, "+u.getUsername()+"!");
                        System.out.println("Username: " + u.getUsername());
                        System.out.println("Username teman-teman: ");
                        double[] friends = u.getFriends();
                        if (friends.length == 0) {
                            System.out.println("Anda belum punya teman!");
                        } else {
                            for (int i = 0; i < friends.length; i++) {
                                int no = i+1;
                                System.out.println(no+". "
                                        + user.getUserById(userList, friends[i]).getUsername());
                            }   
                        }
                        System.out.println("");
                        break;
                    case 3:
                        user.updateUser(userList, currentId);
                        System.out.println("\nUser berhasil diubah!\n");
                        break;
                    case 4:
                        System.out.print("Yakin ingin menghapus user? (y/n): ");
                        String yakin = s.next();
                        if ("y".equals(yakin)) {
                            userList = user.deleteUser(userList, currentId);
                            System.out.println("\nUser berhasil dihapus.\n");
                            break LOGGED_IN;
                        } else {
                            System.out.println("\nUser tidak jadi dihapus\n");
                            break;
                        }
                    case 5:
                        System.out.println("");
                        System.out.print("Masukkan username teman anda: ");
                        String teman = s.next();
                        // Memastikan user dengan username tersebut ada
                        UserModel temanChat = user.getUserByUsername(userList, teman);
                        if(temanChat != null){
                            // Memastikan current user berteman dengan user tersebut
                            double[] listTeman = currentUser.getFriends();
                            boolean berteman = false;
                            for (int i = 0; i < listTeman.length; i++) {
                                if (temanChat.getId() == temanChat.getId()) {
                                    berteman = true;
                                    break;
                                }
                            }
                            if (berteman == true) {
                                System.out.println("Teman ditemukan!");
                                double idTeman = temanChat.getId();
                                System.out.println("Current Id: " + currentId);
                                System.out.println("Id Teman: " + idTeman);
                                System.out.println("\nMembuat room chat...");
                                Thread.sleep(500);
                                chatList[chatCount] = cc.createChat(currentId, idTeman);
                                chatCount++;
                                System.out.println("\nChat berhasil dibuat!");
                                System.out.println("Chat ID: " + chatList[chatCount-1].getId() + "\n");
                            } else {
                                System.out.println("Anda tidak berteman dengan "
                                        + temanChat.getUsername() + "!\n");
                            }
                        } else {
                            System.out.println("\nUser tidak ditemukan!\n");
                        }
                        break;
                    case 6:
                        ChatModel c = new ChatModel();
                        System.out.print("\nMasukkan username teman anda: ");
                        String teman2 = s.next();
                        s.nextLine();
                        UserModel temanChat2 = user.getUserByUsername(userList, teman2);
                        double[] idUsers = new double[] { currentId, temanChat2.getId() };
                        double id_chat = cc.findChat(chatList, idUsers);

                        boolean ketemu = false;
                        for(int i = 0; i < chatCount; i++){
                            if(chatList[i].getId() == id_chat){
                                c = chatList[i];
                                ketemu = true;
                                System.out.println("\nChat ditemukan, memasukkan user ke room chat...");
                                Thread.sleep(500);
                                break;
                            }
                        }
                        if (ketemu == true) {
                            System.out.println("\nChat dimulai!");
                            System.out.println("Untuk keluar, silahkan ketik 'exit'");
                            // Tampilkan chat sebelumnya
                            MessageModel[] messageList = c.getMessageList();
                            for (MessageModel messageList1 : messageList) {
                                if (messageList1 != null) {
                                    String username = user.getUserById(userList, messageList1.getSenderId()).getUsername();
                                    System.out.println(username + ": " + messageList1.getText());
                                }
                            }
                            // Mulai chat baru
                            MessageModel m;
                            String message;
                            MessageController mc = new MessageController();
                            CHAT:
                            while (true) {
                                System.out.print("Apakah Anda ingin mengirim pesan? (y/n): ");
                                if ("y".equals(s.next())) {
                                    System.out.print("Pesan: ");
                                    s.nextLine();
                                    message = s.nextLine();
                                    m = mc.addMessage(message, id_chat, currentId);
                                    c.addMessageToChat(m);
                                    System.out.println("Pesan berhasil dikirim!");
                                } else {
                                    System.out.println("\nAnda telah keluar dari room chat...\n");
                                    break CHAT;
                                }
                            }
                        } else {
                            System.out.println("Chat tidak ditemukan!");
                        }
                        break;
                    case 7:
                        Thread.sleep(500);
                        cc.findUserChats(userList, currentId, chatList, chatCount);
                        break;
                    case 8:
                        System.out.print("Masukkan username teman yang ada di room chat: ");
                        String friend_name = s.next();
                        double[] ids = new double[2];
                        
                        Thread.sleep(500);
                        UserModel friendf = user.getUserByUsername(userList, friend_name);
                        System.out.println("\nFriend ID: " + friendf.getId());
                        ids[0] = currentId;
                        ids[1] = friendf.getId();
                        
                        double chatIdDicari = cc.findChat(chatList, ids);
                        System.out.println("Chat ID: " + chatIdDicari + '\n');
                        break;
                    case 9:
                        currentId = 0;
                        System.out.println("\nAnda telah log out.\n");
                        break LOGGED_IN;
                    default:
                        System.out.println("\nPilihan invalid!\n");
                        break;
                }
            }
        }
    }
}
