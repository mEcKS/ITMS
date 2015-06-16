package ua.chmil.maxim.controller.repair;

import ua.chmil.maxim.entity.Repair;
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
@WebServlet(name = "GetRepair", urlPatterns = "/repair")

public class GetRepair extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idRepair = request.getParameter("id");
        try {
            Repair repair = Dao.getRepair(idRepair);
            System.out.println(repair.toString());
            request.setAttribute("repair",repair);
            if (repair.getStatus().equals("Принято в ремонт")){
                request.getRequestDispatcher("editrepair.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("viewrepair.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
