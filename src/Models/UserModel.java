/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author johan
 */
public class UserModel {
    private int id;
    private String username;
    private String password;
    private int[] friends;
    
    private int i = 0;

    public UserModel(String username, String password) {
        this.id = i;
        this.username = username;
        this.password = password;
        i++;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setFriends(int[] friends) {
        this.friends = friends;
    }

    public int[] getFriends() {
        return friends;
    }
}
