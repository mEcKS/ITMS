package ua.chmil.maxim.controller.move;

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
 * Created by m.chmil on 18.05.2015.
 */
@WebServlet(name = "DoMove", urlPatterns = "/domove" )
public class DoMove extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String movetype  = request.getParameter("movetype");
        String daterepair = request.getParameter("daterepair");
        String employee = decodeGetParameter(request.getParameter("employee"));
        String selectdepartament = decodeGetParameter(request.getParameter("selectdepartament"));
        String typeequipment = decodeGetParameter(request.getParameter("typeequipment"));
        String nameeq = decodeGetParameter(request.getParameter("nameeq"));
        String inventorynumber = decodeGetParameter(request.getParameter("inventorynumber"));
        String serialnumber   = decodeGetParameter(request.getParameter("serialnumber"));
        String info   = decodeGetParameter(request.getParameter("info"));
        //(String gK, String dateIn,String branches, String type, String name, String inventoryNumber, String serialNumber, String info)
        try {
            Dao.addMove(movetype, daterepair, employee, selectdepartament, typeequipment, nameeq, inventorynumber, serialnumber, info);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/moves");
        System.out.println("Данные "+ movetype+" "+daterepair +" "+employee+" "+selectdepartament+" "+typeequipment+" "+nameeq+" "+inventorynumber+" "+serialnumber+" "+info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.sendRedirect("/moves");
    }

    public static String decodeGetParameter(String parameter) throws UnsupportedEncodingException {
        return new String(parameter.getBytes("ISO-8859-1"),"UTF8");
    }

}
