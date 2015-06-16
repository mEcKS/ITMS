package ua.chmil.maxim.controller.move;

import ua.chmil.maxim.model.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by m.chmil on 25.05.2015.
 */
@WebServlet(name = "EitMove",  urlPatterns = "/editmove")
public class EditMove extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("movetype");

        if (type.equals("plus")){
            request.setAttribute("movetype", "plus");
            try {
                request.setAttribute("brancheses", Dao.getBranches());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                request.setAttribute("types", Dao.getTypes());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("move.jsp").forward(request,response);
        }else if (type.equals("minus")){
            request.setAttribute("movetype", "minus");
            try {
                request.setAttribute("brancheses", Dao.getBranches());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                request.setAttribute("types", Dao.getTypes());
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            request.getRequestDispatcher("move.jsp").forward(request,response);
        }
    }

}
