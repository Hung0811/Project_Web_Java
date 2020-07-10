/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

/**
 *
 * @author Admin
 */
public class UserDTO {
     private String userName, fullName, password, roleID;

    public UserDTO(String userName, String fullName, String password, String roleID) {
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.roleID = roleID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userID) {
        this.userName = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }
    
}
