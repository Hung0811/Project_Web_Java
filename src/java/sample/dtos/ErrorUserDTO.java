/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class ErrorUserDTO {
    private String errorUserName, errorFullName, errorPassword, errorRoleID, errorRePassword;

    public ErrorUserDTO() {
    }

    public ErrorUserDTO(String errorUserID, String errorFullName, String errorPassword, String errorRoleID, String errorRePassword) {
        this.errorUserName = errorUserID;
        this.errorFullName = errorFullName;
        this.errorPassword = errorPassword;
        this.errorRoleID = errorRoleID;
        this.errorRePassword = errorRePassword;
    }

    public String getErrorUserName() {
        return errorUserName;
    }

    public void setErrorUserName(String errorUserID) {
        this.errorUserName = errorUserID;
    }

    public String getErrorFullName() {
        return errorFullName;
    }

    public void setErrorFullName(String errorFullName) {
        this.errorFullName = errorFullName;
    }

    public String getErrorPassword() {
        return errorPassword;
    }

    public void setErrorPassword(String errorPassword) {
        this.errorPassword = errorPassword;
    }

    public String getErrorRoleID() {
        return errorRoleID;
    }

    public void setErrorRoleID(String errorRoleID) {
        this.errorRoleID = errorRoleID;
    }

    public String getErrorRePassword() {
        return errorRePassword;
    }

    public void setErrorRePassword(String errorRePassword) {
        this.errorRePassword = errorRePassword;
    }
    
    
}
