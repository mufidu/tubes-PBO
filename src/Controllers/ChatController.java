/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.ChatModel;
import Models.UserModel;
import java.lang.Math;
/**
 *
 * @author johan
 */
public class ChatController {
    
    public ChatModel createChat(double member1, double member2) {
        ChatModel c = new ChatModel(Math.random());
        c.addMembers(member1);
        c.addMembers(member2);
        
        return c;
    }
    
    public void findUserChats(UserModel[] users, double userId, ChatModel chatList[], int chatCount) {
        System.out.println("\nAnda ada di chat dengan Chat ID: ");
        
        for (int i = 0; i < chatCount; i++) {
            for (int j = 0; j < chatList[i].getMembers().length; j++) {
                if (userId == chatList[i].getMembers()[j]) {
                    int angka = i + 1;
                    System.out.print(angka + ". " + chatList[i].getId());
                    System.out.print(" dengan user: ");
                    for (int k = 0; k < chatList[i].getMembers().length; k++) {
                        if (userId != chatList[i].getMembers()[k]) {
                            double otherUserId = chatList[i].getMembers()[k];
                            UserController uc = new UserController();
                            System.out.println(uc.getUserById(users, otherUserId).getUsername());
                        }
                    }
                }
            }
        }
        
        System.out.println();
    }
    
    public void findChat(ChatModel chatList[], double[] users) {
        int matches=0;
        
        for (int i = 0; i < chatList.length; i++){
            for (int j = 0; j < 2; j++){
                if (users[0] == chatList[i].getMembers()[j] || users[1] == chatList[i].getMembers()[j]){
                   matches+=1;
                }
            }
            if(matches == 2){
                System.out.println("Chat ID = " + chatList[i].getId());
                break;
            } else {
                matches = 0;
            }
        }
        
    }
}
