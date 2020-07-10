/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.daos;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import sample.dtos.BookDTO;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class BookDAO {

    public List<BookDTO> getListBook() throws Exception {
        List<BookDTO> result = new ArrayList<BookDTO>();
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.createStatement();
            if (conn != null) {
                String sql = "SELECT * FROM tblBooks";
                rs = stm.executeQuery(sql);
                while (rs.next()) {
                    String bookID = rs.getNString("bookID");
                    String bookName = rs.getNString("bookName");
                    String author = rs.getNString("author");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    Date datePublic = rs.getDate("datePublic");
                    String linkImage = rs.getNString("linkImage");

                    result.add(new BookDTO(bookID, bookName, author, price, quantity, datePublic, linkImage));
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

    public List<BookDTO> getListBook(String txtSearch) throws Exception {
        List<BookDTO> result = new ArrayList<BookDTO>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT * FROM tblBooks WHERE bookName LIKE ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + txtSearch + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String bookID = rs.getNString("bookID");
                    String bookName = rs.getNString("bookName");
                    String author = rs.getNString("author");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    Date datePublic = rs.getDate("datePublic");
                    String linkImage = rs.getNString("linkImage");

                    result.add(new BookDTO(bookID, bookName, author, price, quantity, datePublic, linkImage));
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

    public BookDTO getBook(String bookID) throws Exception {
        BookDTO result = null;
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.createStatement();
            if (conn != null) {
                String sql = "SELECT * FROM tblBooks WHERE bookID='" + bookID + "'";
                rs = stm.executeQuery(sql);
                if (rs.next()) {
                    String bookName = rs.getNString("bookName");
                    String author = rs.getNString("author");
                    int price = rs.getInt("price");
                    int quantity = rs.getInt("quantity");
                    Date datePublic = rs.getDate("datePublic");
                    String linkImage = rs.getNString("linkImage");
                    result = new BookDTO(bookID, bookName, author, price, quantity, datePublic, linkImage);
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

    public void addBook(BookDTO book) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();

            if (conn != null) {
                String sql = "INSERT INTO tblBooks (bookID, bookName, author, price, quantity, datePublic, linkImage) VALUES(?,?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, book.getId());
                stm.setString(2, book.getName());
                stm.setString(3, book.getAuthor());
                stm.setInt(4, book.getPrice());
                stm.setInt(5, book.getQuantity());
                stm.setDate(6, book.getDatePublic());
                stm.setString(7, book.getLinkImage());

                rs = stm.executeQuery();

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
    }

    public void updateBook(BookDTO book) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();

            if (conn != null) {
                String sql = "UPDATE tblBooks SET bookName=?, author=?, price=?, quantity=?, datePublic=?, linkImage=? WHERE bookID=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, book.getName());
                stm.setString(2, book.getAuthor());
                stm.setInt(3, book.getPrice());
                stm.setInt(4, book.getQuantity());
                stm.setDate(5, book.getDatePublic());
                stm.setString(6, book.getLinkImage());
                stm.setString(7, book.getId());

                rs = stm.executeQuery();

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
    }
    
}
