/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
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
public class UpdateCartController extends HttpServlet {

    private final String SUCCESS = "viewCart.jsp";
    private final String ERROR = "viewCart.jsp";

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
            String bookID = request.getParameter("txtBookID");
            int amount = Integer.parseInt(request.getParameter("txtQuantity"));
            HttpSession session = request.getSession();
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            CartDAO dao = new CartDAO();
            String msg = dao.checkValid(bookID, amount, cart.getCart().get(bookID).getQuantity());
            if (!msg.equals("")) {
                String[] split = msg.split("-");
                msg = split[0] + " has only " + split[1] + " books in library!";
                session.setAttribute("ERROR_VIEW_CART", msg);
            } else {

                cart.update(amount, bookID);

                String userID = ((UserDTO) session.getAttribute("USER")).getUserName();

                CartDAO cartDAO = new CartDAO();
                String orderID = cartDAO.getOrderID(userID);
                cartDAO.updateItems(cart.getCart().get(bookID), orderID);
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error in UpdateCartController: " + e.toString());
        } finally {
            response.sendRedirect(url);
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
