/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.util.Date;  

/**
 *
 * @author johan
 */
public class MessageModel {
    private long id;
    private long chatId;
    private long senderId;
    private String text;
    private Date timesent;

    public MessageModel(long id, long chatId, long senderId, String text, Date timesent) {
        this.id = id;
        this.chatId = chatId;
        this.senderId = senderId;
        this.text = text;
        this.timesent = timesent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
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

    
}
