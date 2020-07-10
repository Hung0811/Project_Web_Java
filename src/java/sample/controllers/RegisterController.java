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
import sample.daos.UserDAO;
import sample.dtos.ErrorUserDTO;
import sample.dtos.UserDTO;

/**
 *
 * @author Admin
 */
public class RegisterController extends HttpServlet {
    private final String SUCCESS = "login.jsp";
    private final String ERROR = "register.jsp";

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
            ErrorUserDTO errorDTO = new ErrorUserDTO();
            boolean check = true;

            String userName = request.getParameter("txtUserName");
            String fullName = request.getParameter("txtFullName");
            String password = request.getParameter("txtPassword");
            String rePassword = request.getParameter("txtRepassword");

            if (userName.length() < 6 || userName.length() > 20) {
                errorDTO.setErrorUserName("Username must be 6-20 digits");
                check = false;
            }
            if (fullName.length() < 6 || fullName.length() > 50) {
                errorDTO.setErrorFullName("FullName must be 6-50 digits");
                check = false;
            }
            if (password.length() < 5 || password.length() > 20) {
                errorDTO.setErrorPassword("FullName must be 5-20 digits");
                check = false;
            }
            if(rePassword.isEmpty()){
                 errorDTO.setErrorRePassword("Confirm password is required");
            }
            if (!password.equals(rePassword)) {
                errorDTO.setErrorRePassword("Confirm password is not the same as password");
                check = false;
            }
            UserDAO dao = new UserDAO();
            boolean exits = dao.checkUserName(userName);
            if (exits) {
                errorDTO.setErrorUserName("Username is duplicated");
                check = false;
            }
            
            if(check){
                url=SUCCESS;
                UserDTO user=new UserDTO(userName, fullName, password, "");
                dao.addNew(user);
            }else{
                HttpSession session=request.getSession();
                session.setAttribute("ERROR_USER", errorDTO);
            }

        } catch (Exception e) {
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
