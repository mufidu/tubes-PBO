/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;
import Models.ChatModel;
import java.lang.Math;
/**
 *
 * @author johan
 */
public class ChatController {
    
    public ChatModel createChat(double member1, double member2){
        ChatModel c = new ChatModel(Math.random());
        c.addMembers(member1);
        c.addMembers(member2);
        
        return c;
    }
    
    public void findUserChats(double userid, ChatModel cl[]){
        int i=0;
        
        for(i=0;i<cl.length;i++){
            for(int j=0;j<cl[i].getMembercount();i++){
                if(userid == cl[i].getMembers()[j]){
                    System.out.println("Ada di chat room dengan: " + cl[i].getMembers());
                }
            }
        }
        
    }
    
    public void findChat(ChatModel cl[], double[] users){
        int i=0;
        int matches=0;
        
        for(i=0;i<cl.length;i++){
            for(int j=0;j<2;j++){
                if(users[0] == cl[i].getMembers()[j] || users[1] == cl[i].getMembers()[j]){
                   matches+=1;
                }
            }
            if(matches == 2){
                System.out.println("ChatID = " + cl[i].getId());
                break;
            } else {
                matches = 0;
            }
        }
        
    }
}
