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
    private double id;
    private double[] members;
    private int membercount;
    private MessageModel[] messageList;
    private int messagecount;
    
    public ChatModel(double id) {
        this.id = id;
        membercount = 0;
        messageList = new MessageModel[9999];
        messagecount = 0;
        members = new double[2];
    }
    
    public ChatModel(){
        membercount = 0;
        messageList = new MessageModel[9999];
        messagecount = 0;
        id = Math.random();
        members = new double[2];
    }
    
    public void addMembers(double id){
        members[membercount] = id;
        membercount += 1;
    }
    
    public void addMessageToChat(MessageModel m){
        messageList[messagecount] = m;
        messagecount += 1;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public double[] getMembers() {
        return members;
    }

    public void setMembers(double[] members) {
        this.members = members;
    }

    public int getMembercount() {
        return membercount;
    }

    public void setMembercount(int membercount) {
        this.membercount = membercount;
    }

    public MessageModel[] getMessageList() {
        return messageList;
    }

    public void setMessageList(MessageModel[] messageList) {
        this.messageList = messageList;
    }
}
