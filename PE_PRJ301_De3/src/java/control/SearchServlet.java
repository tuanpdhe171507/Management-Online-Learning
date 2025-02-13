/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dao.TblCapstonesDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.TblCapstones;
import model.TblUsers;

/**
 *
 * @author G5 5590
 */
public class SearchServlet  extends BaseAuthenticationCotroller{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp, TblUsers account) throws ServletException, IOException {
                
                String name = req.getParameter("searchname");
                TblCapstonesDBContext tblCapstonesDBContext = new TblCapstonesDBContext();
                ArrayList<TblCapstones> listsByName = tblCapstonesDBContext.searchByName(name);
                req.setAttribute("lists", listsByName);               
                req.getRequestDispatcher("captstonesList.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp, TblUsers account) throws ServletException, IOException {

             req.getRequestDispatcher("captstonesList.jsp").forward(req, resp);
    }
    
}
