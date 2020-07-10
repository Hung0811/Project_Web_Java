/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sample.dtos.BookDTO;
import sample.dtos.CartDTO;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class CartDAO {

    public String getOrderID(String userID) throws Exception {
        String result = "";
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.createStatement();
            if (conn != null) {
                String sql = "SELECT * FROM tblOrder WHERE userID='" + userID + "' AND status=0";
                rs = stm.executeQuery(sql);
                if (rs.next()) {
                    result = rs.getNString("orderID");
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

    public void createNewOrder(String userID, String orderID) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrder (orderID, userID, status) VALUES (?,?,0)";
                stm = conn.prepareStatement(sql);

                stm.setString(1, orderID);
                stm.setString(2, userID);
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

    public void addItems(BookDTO book, String orderID) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblOrderDetail (bookID, orderID, amount) VALUES (?,?,?)";
                stm = conn.prepareStatement(sql);

                stm.setString(1, book.getId());
                stm.setString(2, orderID);
                stm.setInt(3, book.getQuantity());
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

    public void updateItems(BookDTO book, String orderID) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblOrderDetail SET amount=? WHERE orderID=? AND bookID=?";
                stm = conn.prepareStatement(sql);

                stm.setString(3, book.getId());
                stm.setString(2, orderID);
                stm.setInt(1, book.getQuantity());
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

    public void removeItems(String bookID, String orderID) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM tblOrderDetail WHERE bookID=? AND orderID=?";
                stm = conn.prepareStatement(sql);

                stm.setString(1, bookID);
                stm.setString(2, orderID);
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

    public void submit(String orderID, Date rentDate, Date returnDate) throws Exception {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "UPDATE tblOrder SET status=1, rentDate=? AND returnDate=? WHERE orderID=?";
                stm = conn.prepareStatement(sql);
                
                stm.setDate(1, rentDate);
                stm.setDate(2, returnDate);
                stm.setString(3, orderID);
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

    public CartDTO getCart(String userID) throws Exception {
        CartDTO cart = new CartDTO();
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.createStatement();
            if (conn != null) {
                String sql = "SELECT OD.bookID, amount \n"
                        + "FROM tblOrder O, tblOrderDetail OD, tblBooks B\n"
                        + "WHERE O.orderID=OD.orderID AND OD.bookID=B.bookID AND O.status=0 AND O.userID='" + userID + "'";
                rs = stm.executeQuery(sql);

                BookDAO dao = new BookDAO();
                while (rs.next()) {

                    BookDTO book = dao.getBook(rs.getNString("bookID"));
                    int amount = rs.getInt("amount");
                    book.setQuantity(amount);
                    cart.add(book);
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
        return cart;
    }

    public CartDTO getHistory(String userID) throws Exception {
        CartDTO cart = new CartDTO();
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stm = conn.createStatement();
            if (conn != null) {
                String sql = "SELECT OD.bookID, amount \n"
                        + "FROM tblOrder O, tblOrderDetail OD, tblBooks B\n"
                        + "WHERE O.orderID=OD.orderID AND OD.bookID=B.bookID AND O.status=1 AND O.userID='" + userID + "'";
                rs = stm.executeQuery(sql);

                BookDAO dao = new BookDAO();
                while (rs.next()) {

                    BookDTO book = dao.getBook(rs.getNString("bookID"));
                    int amount = rs.getInt("amount");
                    book.setQuantity(amount);
                    cart.add(book);
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
        return cart;
    }

    public String checkValid(String bookID, int amount, int orginalAmount) throws Exception {
        String result = "";
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql="SELECT bookID, SUM(amount) AS total FROM tblOrderDetail WHERE bookID=? GROUP BY bookID";
                stm=conn.prepareStatement(sql);
                stm.setString(1, bookID);
                
                rs=stm.executeQuery();
                int total=0;
                if(rs.next()){
                    total=rs.getInt("total")-orginalAmount;
                }
                
                sql="SELECT quantity FROM tblBooks WHERE bookID=?";
                stm=conn.prepareStatement(sql);
                stm.setString(1, bookID);
                rs=stm.executeQuery();
                int quantity=0;
                if(rs.next()){
                    quantity=rs.getInt("quantity");
                }
                
                if(amount>quantity-total){
                    BookDAO dao=new BookDAO();
                    result=dao.getBook(bookID).getName()+"-"+(quantity-total);
                }    
            }
        } catch (Exception e) {
            System.out.println(e.toString());
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
}
