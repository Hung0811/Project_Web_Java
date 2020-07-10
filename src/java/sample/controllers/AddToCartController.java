/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.daos.BookDAO;
import sample.daos.CartDAO;
import sample.dtos.BookDTO;
import sample.dtos.CartDTO;
import sample.dtos.UserDTO;

/**
 *
 * @author Admin
 */
public class AddToCartController extends HttpServlet {

    private final String SUCCESS = "home.jsp";
    private final String ERROR = "login.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {

            HttpSession session = request.getSession();
            CartDAO cartDAO = new CartDAO();
            UserDTO user = (UserDTO) session.getAttribute("USER");

            if (user != null) {
                //create orderID
                String orderID = cartDAO.getOrderID(user.getUserName());
                if (orderID.equals("")) {
                    Date date = new Date();
                    orderID = (date.getYear() + 1900) + "" + (date.getMonth() + 1) + date.getDate() + "-" + date.getHours() + "" + date.getMinutes() + "" + date.getSeconds();
                    cartDAO.createNewOrder(user.getUserName(), orderID);
                }

                String bookID = request.getParameter("txtBookID");
                BookDAO dao = new BookDAO();
                BookDTO book = dao.getBook(bookID);
                book.setQuantity(1);

                CartDTO cart = (CartDTO) session.getAttribute("CART");
                if (cart == null) {
                    cart = (CartDTO) cartDAO.getCart(user.getUserName());      
                }
                if(cart==null){
                    cart = new CartDTO();
                }
                
                if (book != null) {
                    cart.add(book);
                    if (book.getQuantity() == 1) {
                        cartDAO.addItems(book, orderID);
                    } else {
                        cartDAO.updateItems(book, orderID);
                    }
                }
                session.setAttribute("CART", cart);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error in AddToCartController:" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
