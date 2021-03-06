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
 * Created by m.chmil on 22.05.2015.
 */
@WebServlet(name = "GetMoves",  urlPatterns = "/moves")
public class GetMoves extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("moves", Dao.getMoves());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("moves.jsp").forward(request,response);
    }
}
