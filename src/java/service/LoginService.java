/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.object.Pengguna;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author acer
 */
public class LoginService extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        Pengguna pengguna = new dao.PenggunaDAO().login(username, password);
        
        if (pengguna != null) {     
            HttpSession session = request.getSession();
            
            session.setAttribute("E_TOKO_NAMA", pengguna.getNama());
            session.setAttribute("E_TOKO_ROLE", pengguna.getRole());
            
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp?error");
        }
    }
}
