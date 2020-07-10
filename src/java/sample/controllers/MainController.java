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

/**
 *
 * @author Admin
 */
public class MainController extends HttpServlet {
    private final String ERROR="invalid.html";
    private final String LOGIN="LoginController";
    private final String REGISTER_PAGE="register.jsp";
    private final String REGISTER="RegisterController";
    private final String LOGOUT="LogoutController";
    private final String ADD_TO_CART="AddToCartController";
    private final String UPDATE_CART="UpdateCartController";
    private final String REMOVE_ITEM="RemoveItemController";
    private final String SUBMIT_CART="SubmitCartController";
    private final String DETAIL="DetailController";
    private final String SEARCH="SearchController";
    private final String NEW_BOOK="newBook.jsp";
    private final String ADD_NEW_BOOK="AddNewBookController";
    private final String UPDATE_BOOK_PAGE="updateBook.jsp";
    private final String UPDATE_BOOK="UpdateBookController";
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
        String url=ERROR;
        String action=request.getParameter("btnAction");
        try {
            if(action.equals("Login")){
                url=LOGIN;
            }else if(action.equals("Register")){
                url=REGISTER_PAGE;
            }else if(action.equals("Register Now")){
                url=REGISTER;
            }else if(action.equals("Logout")){
                url=LOGOUT;
            }else if(action.equals("Add to Cart")){
                url=ADD_TO_CART;
            }else if(action.equals("Update Cart")){
                url=UPDATE_CART;
            }else if(action.equals("Remove Item")){
                url=REMOVE_ITEM;
            }else if(action.equals("Submit Cart")){
                url=SUBMIT_CART;
            }else if(action.equals("Detail")){
                url=DETAIL;
            }else if(action.equals("Search")){
                url=SEARCH;
            }else if(action.equals("Add New Book")){
                url=NEW_BOOK;
            }else if(action.equals("Submit New Book")){
                url=ADD_NEW_BOOK;
            }else if(action.equals("Update Book")){
                url=UPDATE_BOOK_PAGE;
            }else if(action.equals("Submit Update Book")){
                url=UPDATE_BOOK;
            }     
        } catch (Exception e) {
            log("Error in MainController:" +e.toString());
        }finally{
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
