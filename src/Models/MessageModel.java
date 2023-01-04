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
    private long id_user1;
    private long id_user2;
    private String message;
    private Date DATE;

    public MessageModel(long id_user1, long id_user2, String message, Date DATE) {
        this.id_user1 = id_user1;
        this.id_user2 = id_user2;
        this.message = message;
        this.DATE = DATE;
    }

    public long getId_user1() {
        return id_user1;
    }

    public void setId_user1(long id_user1) {
        this.id_user1 = id_user1;
    }

    public long getId_user2() {
        return id_user2;
    }

    public void setId_user2(long id_user2) {
        this.id_user2 = id_user2;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return DATE;
    }

    public void setDate(Date DATE) {
        this.DATE = DATE;
    }

    

    
}
