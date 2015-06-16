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
import java.text.SimpleDateFormat;

/**
 * Created by m.chmil on 18.05.2015.
 */
@WebServlet(name = "DoAddRepair", urlPatterns = "/doaddrepair")
public class DoAddRepair extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String daterepair = request.getParameter("daterepair");
        String numbergk = decodeGetParameter(request.getParameter("numbergk"));
        String selectdepartament = decodeGetParameter(request.getParameter("selectdepartament"));
        String typeequipment = decodeGetParameter(request.getParameter("typeequipment"));
        String nameeq = decodeGetParameter(request.getParameter("nameeq"));
        String inventorynumber = decodeGetParameter(request.getParameter("inventorynumber"));
        String serialnumber   = decodeGetParameter(request.getParameter("serialnumber"));
        String info   = decodeGetParameter(request.getParameter("info"));
        //(String gK, String dateIn,String branches, String type, String name, String inventoryNumber, String serialNumber, String info)
        try {
            Dao.addRepair(numbergk, daterepair, selectdepartament, typeequipment, nameeq, inventorynumber, serialnumber, info);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/repairs");
        System.out.println("Дата "+daterepair +" "+numbergk+" "+selectdepartament+" "+typeequipment+" "+nameeq+" "+inventorynumber+" "+serialnumber+" "+info);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/repairs");
    }

    public static String decodeGetParameter(String parameter) throws UnsupportedEncodingException {
        return new String(parameter.getBytes("ISO-8859-1"),"UTF8");
    }

    private java.util.Date convertDate(String dateIn) throws Exception{
        java.util.Date dateInSQL = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");
            dateInSQL = format.parse(dateIn);
            System.out.println(dateInSQL);

        } catch (Exception e ){

        }
        return dateInSQL;
    }

}
