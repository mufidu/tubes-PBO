/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;
import java.lang.Math;

/**
 *
 * @author johan
 */
public class UserModel {
    private double id;
    private String username;
    private String password;
    private double[] friends;
    
    public UserModel(String username, String password) {
        this.id = Math.random();
        this.username = username;
        this.password = password;
        this.friends = new double[0];
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

    public double getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setFriends(double[] friends) {
        this.friends = friends;
    }

    public double[] getFriends() {
        return this.friends;
    }
}
