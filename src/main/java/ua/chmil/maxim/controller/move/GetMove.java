package ua.chmil.maxim.controller.move;

import ua.chmil.maxim.entity.Move;
import ua.chmil.maxim.model.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by m.chmil on 20.05.2015.
 */
@WebServlet(name = "GetMove", urlPatterns = "/move")

public class GetMove extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idMove = request.getParameter("id");
        try {
            Move move = Dao.getMove(idMove);
            System.out.println(move.toString());
            request.setAttribute("move",move);
                request.getRequestDispatcher("viewmove.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
