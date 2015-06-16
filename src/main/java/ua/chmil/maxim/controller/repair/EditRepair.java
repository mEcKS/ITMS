package ua.chmil.maxim.controller.repair;

import ua.chmil.maxim.model.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by m.chmil on 21.05.2015.
 */
@WebServlet(name = "EditRepair",  urlPatterns = "/editrepair")
public class EditRepair extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String info = decodeGetParameter(request.getParameter("info"));
        String status = decodeGetParameter(request.getParameter("status"));
        String idString = request.getParameter("idrepair");

        System.out.println("POST " + idString + " " + info + " " + status);
        if (idString != null){
            try {
                Long id = new Long(idString);
                System.out.println("LONG ID" + id);
                    try {
                        Dao.updateRepair(id, status, info);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

            } catch (NumberFormatException e) {
                System.err.println("Неверный формат строки!");
            }
        }
        response.sendRedirect("/repairs");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        System.out.println("doGet " + id );
        //response.sendRedirect("/repairs");


    }

    public static String decodeGetParameter(String parameter) throws UnsupportedEncodingException {
        return new String(parameter.getBytes("ISO-8859-1"),"UTF8");
    }
}
