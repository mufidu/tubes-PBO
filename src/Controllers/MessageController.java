/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Models.MessageModel;
import Models.ChatModel;
import java.lang.Math;
import java.text.SimpleDateFormat;  
import java.util.Date;  
/**
 *
 * @author johan
 */
public class MessageController {

    public MessageModel addMessage(String message, double chatid, double senderid){
        MessageModel m = new MessageModel(Math.random());
        m.setChatId(chatid);
        m.setSenderId(senderid);
        m.setText(message);
        Date date = new Date();
        m.setTimesent(date);   
        
        return m;
    }
    
    public void getMessage(double chatid, ChatModel cl[]){
        boolean isFound = false;
        int i=0;
        while(isFound == false){
            if(chatid == cl[i].getId()){
                //get apa?
                for (MessageModel messagel : cl[i].getMessagel()) {
                    System.out.println(messagel.getSenderId() + ": " + messagel.getText());
                }
                isFound = true;
            } else {
                i++;
            }
        }
    }
    
    
}
