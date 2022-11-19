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
    private int memberCount;
    private MessageModel[] messageList;
    private int messageCount;
    
    public ChatModel(double id) {
        this.id = id;
        memberCount = 0;
        messageList = new MessageModel[9999];
        messageCount = 0;
        members = new double[2];
    }
    
    public ChatModel(){
        memberCount = 0;
        messageList = new MessageModel[9999];
        messageCount = 0;
        id = Math.random();
        members = new double[2];
    }
    
    public void addMembers(double id){
        members[memberCount] = id;
        memberCount += 1;
    }
    
    public void addMessageToChat(MessageModel m){
        messageList[messageCount] = m;
        messageCount += 1;
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

    public int getMemberCount() {
        return memberCount;
    }

    public void setmemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public MessageModel[] getMessageList() {
        return messageList;
    }

    public void setMessageList(MessageModel[] messageList) {
        this.messageList = messageList;
    }
}
