/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author johan
 */
public class ChatModel {
    private long id;
    private long member1;
    private long member2;
    
    public ChatModel(long chat_id, long member1, long member2) {
        this.id = id;
        this.member1 = member1;
        this.member2 = member2;
    }
    
    public ChatModel(long member1, long member2){
        id = Math.round(Math.random());
        this.member1 = member1;
        this.member2 = member2;
    }

    public double getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMember1() {
        return member1;
    }

    public void setMember1(long member1) {
        this.member1 = member1;
    }
    
    public long getMember2() {
        return member1;
    }

    public void setMember2(long member2) {
        this.member2 = member2;
    }
}
