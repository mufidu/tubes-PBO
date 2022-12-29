/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.lang.Math;
import java.util.*;
/**
 *
 * @author johan
 */
public class UserModel {
    private long id;
    private String username;
    private String password;
    private long friendlist_id;
    private ArrayList<UserModel> friends;
    
    public UserModel(String username, String password, long id, long friendlist_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.friends = new ArrayList<>();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFriendlist_id() {
        return friendlist_id;
    }

    public void setFriendlist_id(long friendlist_id) {
        this.friendlist_id = friendlist_id;
    }
    
    public void input_friend(UserModel m){
        friends.add(m);
    }

    
}
