/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import sample.dtos.UserDTO;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class UserDAO {

    public UserDTO checkLogin(String userName, String password) throws SQLException {
        UserDTO result = null;
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.createStatement();
            if (conn != null) {
                String sql = "SELECT * FROM tblUsers WHERE userName='" + userName + "' AND password='" + password + "'";
                rs = stm.executeQuery(sql);
                if (rs.next()) {
                    result = new UserDTO(userName, rs.getNString("fullName"), "", rs.getNString("roleID"));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public boolean checkUserName(String userName) throws SQLException {
        boolean result = false;
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.createStatement();
            if (conn != null) {
                String sql = "SELECT * FROM tblUsers WHERE userName='" + userName + "'";
                rs = stm.executeQuery(sql);
                if (rs.next()) {
                    result = true;
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public void addNew(UserDTO user) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblUsers (userName, fullName, password, roleID) VALUES(?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getUserName());
                stm.setString(2, user.getFullName());
                stm.setString(3, user.getPassword());
                stm.setString(4, "RL002");
                stm.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
