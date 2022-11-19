/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.text.SimpleDateFormat;  
import java.util.Date;  

/**
 *
 * @author johan
 */
public class MessageModel {
    private double id;
    private double chatId;
    private double senderId;
    private String text;
    private Date timesent;

    public MessageModel(double id) {
        this.id = id;
    }
    public MessageModel(){
        
    }

    public double getChatId() {
        return chatId;
    }

    public void setChatId(double chatId) {
        this.chatId = chatId;
    }

    public double getSenderId() {
        return senderId;
    }

    public void setSenderId(double senderId) {
        this.senderId = senderId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTimesent() {
        return timesent;
    }

    public void setTimesent(Date timesent) {
        this.timesent = timesent;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }
    
    
    
    
}
