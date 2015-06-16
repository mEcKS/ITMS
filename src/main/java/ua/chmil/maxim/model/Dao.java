package ua.chmil.maxim.model;

import ua.chmil.maxim.entity.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by m.chmil on 14.05.2015.
 */
public class Dao {

    private static final String DB_CONNECTION = "jdbc:jtds:sqlserver://192.168.120.4:1433/itms2";
    private static final String DB_USER = "ITMS";
    private static final String DB_PASSWORD = "8uSTn7zgU92H";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
        return DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
    }

    public static Connection getConnectionHR() throws ClassNotFoundException, SQLException{
        DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
        return DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/","", "");
    }

    public static List<Repair> getRepairs() throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT DocRepair.id as Rid\n" +
                     "      ,[dateIn] as RDateIn\n" +
                     "      ,[InvNumder] as RInvNumber\n" +
                     "      ,[SNNumber] as RSNNumber\n" +
                     "      ,[Name] as RName\n" +
                     "      ,[Branches] as RBranches\n" +
                     "      ,[Type] as RType\n" +
                     "      ,[dateOut] as RDateOut\n" +
                     "      ,[Status] as RStatus\n" +
                     "      ,[Info] as RInfo\n" +
                     "      ,[GK] as RGK\n" +
                     "  FROM [DocRepair]\n" +
                     "  ORDER BY RDateIn DESC, DocRepair.id");
             ResultSet rs = ps.executeQuery();) {

            ArrayList<Repair> repairs = new ArrayList<Repair>();
            while (rs.next()) {
                long rId = rs.getLong("Rid");
                String rDateIn = rs.getString("RDateIn");
                String rInvNumber = rs.getString("RInvNumber");
                String rSNNumber = rs.getString("RSNNumber");
                String rName = rs.getString("RName");
                String rBranches = rs.getString("RBranches");
                String rType = rs.getString("RType");
                String rDateOut = rs.getString("RDateOut");
                String rStatus = rs.getString("RStatus");
                String rITMaster = "1";
                String rGK = rs.getString("RGK");
                String rInfo = rs.getString("RInfo");

                repairs.add(new Repair(rId, rDateIn, rInvNumber, rSNNumber, rName, rBranches, rType, rDateOut, rStatus, rITMaster, rInfo, rGK));
            }
            return repairs;
        }
    }

    public static Repair getRepair(String idRepair) throws SQLException, ClassNotFoundException {
        Repair repair = new Repair();
        try {
            Long idLong = new Long(idRepair);
            System.out.println(idLong);

        try (Connection c = getConnection();) {
            String sql = "SELECT [dateIn] as RDateIn\n" +
                    "      ,[InvNumder] as RInvNumber\n" +
                    "      ,[SNNumber] as RSNNumber\n" +
                    "      ,[Name] as RName\n" +
                    "      ,[Branches] as RBranches\n" +
                    "      ,[Type] as RType\n" +
                    "      ,[dateOut] as RDateOut\n" +
                    "      ,[Status] as RStatus\n" +
                    "      ,[Info] as RInfo\n" +
                    "      ,[GK] as RGK\n" +
                    "  FROM [DocRepair]\n" +
                    "   WHERE [id] = " + idRepair + "";
            System.out.println(sql);
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String rDateIn = rs.getString("RDateIn");
                String rInvNumber = rs.getString("RInvNumber");
                String rSNNumber = rs.getString("RSNNumber");
                String rName = rs.getString("RName");
                String rBranches = rs.getString("RBranches");
                String rType = rs.getString("RType");
                String rDateOut = rs.getString("RDateOut");
                String rStatus = rs.getString("RStatus");
                String rGK = rs.getString("RGK");
                String rInfo = rs.getString("RInfo");


                repair = new Repair(idLong, rDateIn, rInvNumber, rSNNumber, rName, rBranches, rType, rDateOut, rStatus, rInfo, rGK);

                System.out.println(idLong+" "+ rDateIn+" "+ rInvNumber+" "+ rSNNumber+" "+ rName+" "+ rBranches+" "+ rType+" "+ rDateOut+" "+ rStatus+" "+ rInfo+" "+ rGK);
            } else {
                System.out.println("Repair not found!");
            }
        }
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }
        return repair;
    }

    public static void main(String[] args) {
        System.out.println();
    }

    public static void deletePosts(int id) {

    }

    public static void addPost(String txt) throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("INSERT INTO docrepair (datein, invnumber, SNNumber, name, dirbranches_id, dirtype_id, dateout, status, causeoffailure, diremployee_id, info, gk) VALUES ('2015-05-15', '05', '24116', ?, '1', '1', '2015-05-15', 'Принято в ремонт', 'Не включается', '1', 'инфо', 'гк2')");) {
            ps.setString(1, txt);
            ps.executeUpdate();
        }
    }

    public static List<Department> getBranches() throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT code as codedep\n" +
                     "   ,name as DepName\n" +
                     "   ,type as typedep\n" +
                     " FROM DirBranches\n" +
                     " ORDER BY type DESC, name");
             ResultSet rs = ps.executeQuery();) {

            ArrayList<Department> brancheses = new ArrayList<Department>();
            while (rs.next()) {
                String bCode = rs.getString("codedep");
                String bName = rs.getString("DepName");
                brancheses.add(new Department(bName, bCode));
            }
            return brancheses;
        }

    }

    public static List<Type> getTypes() throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT id\n" +
                     "      ,name as TypeName\n" +
                     "      ,info\n" +
                     "  FROM DirTypeEquipment\n" +
                     "  ORDER BY name");
             ResultSet rs = ps.executeQuery();) {

            ArrayList<Type> types = new ArrayList<Type>();
            while (rs.next()) {
                Long tId = rs.getLong("id");
                String tName = rs.getString("TypeName");
                types.add(new Type(tId, tName));
            }
            return types;
        }

    }

    public static void addRepair(String gK, String dateIn, String branches, String type, String name, String inventoryNumber, String serialNumber, String info) throws SQLException, ClassNotFoundException {
        Boolean bool = false;
        String sql = "Insert into docrepair (GK, dateIn, Branches, Type, Name, InvNumder, SNNumber, Info, AcceptedForRepair, Status) values (?,?,?,?,?,?,?,?,?,?)";
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, gK);
            ps.setString(2, dateIn);
            ps.setString(3, branches);
            ps.setString(4, type);
            ps.setString(5, name);
            ps.setString(6, inventoryNumber);
            ps.setString(7, serialNumber);
            ps.setString(8, info);
            ps.setInt(9, 1);
            ps.setString(10, "Принято в ремонт");
            String tmp = "Принято в ремонт";
            System.out.println("Insert into DocRepair (GK, dateIn, Branches, Type, Name, InvNumder, SNNumber, Info, AcceptedForRepair, Status) values (" + gK + "," + dateIn + "," + branches + "," + type + "," + name + "," + inventoryNumber + "," + serialNumber + "," + info + "," + 1 + "," + tmp + ")");
            if (!ps.execute()) {
                bool = true;
            }

        } catch (Exception e) {
        } finally {
            System.out.println(bool);
        }

    }

    public static void updateRepair(long id, String status, String info) throws SQLException, ClassNotFoundException {
        Boolean bool = false;

        Calendar cal = new GregorianCalendar();
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        String dateOut = formater.format(cal.getTime());

        String sql = "Update DocRepair SET Status = '" + status + "' , dateOut='" + dateOut + "' , info='" + info + "'  WHERE  id = " + id + "";

        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            System.out.println(sql);
            if (!ps.execute()) {
                bool = true;

            }
        } catch (Exception e) {
        } finally {
            System.out.println(bool);
        }
    }

    public static List<Move> getMoves() throws SQLException, ClassNotFoundException {
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement("SELECT [id]\n" +
                     "      ,[date]\n" +
                     "      ,[name]\n" +
                     "      ,[department]\n" +
                     "      ,[type]\n" +
                     "      ,[status]\n" +
                     "      ,[info]\n" +
                     "      ,[employee]\n" +
                     "      ,[inventorynumber]\n" +
                     "      ,[serialnumber]\n" +
                     "  FROM [DocMove]\n" +
                     "  ORDER BY [date] DESC, [id]");
             ResultSet rs = ps.executeQuery();) {

            ArrayList<Move> moveTMCs = new ArrayList<Move>();
            while (rs.next()) {
                long rId = rs.getLong("id");
                String date = rs.getString("date");
                String name = rs.getString("name");
                String department = rs.getString("department");
                String type = rs.getString("type");
                String status = rs.getString("status");
                String info = rs.getString("info");
                String employee = rs.getString("employee");
                String serialnumber = rs.getString("serialnumber");
                String inventorynumber = rs.getString("inventorynumber");

                moveTMCs.add(new Move(rId, date, name, department, type, status, info, employee, serialnumber, inventorynumber));
            }
            return moveTMCs;
        }

    }

    public static Move getMove(String idMove) throws SQLException, ClassNotFoundException {
        Move move = new Move();
        try {
            Long idLong = new Long(idMove);
            System.out.println(idLong);

            try (Connection c = getConnection();) {
                String sql = "SELECT [id] as idM\n" +
                        "      ,[date] as dateM\n" +
                        "      ,[name] as nameM\n" +
                        "      ,[department] as departmentM \n" +
                        "      ,[type] as typeM\n" +
                        "      ,[status] as statusM \n" +
                        "      ,[info] as infoM\n" +
                        "      ,[employee] as employeeM \n" +
                        "      ,[inventorynumber] as inventorynumberM\n" +
                        "      ,[serialnumber] as serialnumberM\n" +
                        "  FROM [DocMove]\n" +
                        "   WHERE [id] = " + idMove + "";
                System.out.println(sql);
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    String dateM = rs.getString("dateM");
                    String inventorynumberM = rs.getString("inventorynumberM");
                    String serialnumberM = rs.getString("serialnumberM");
                    String nameM = rs.getString("nameM");
                    String departmentM = rs.getString("departmentM");
                    String typeM = rs.getString("typeM");
                    String statusM = rs.getString("statusM");
                    String infoM = rs.getString("infoM");
                    String employeeM = rs.getString("employeeM");


                    move = new Move(idLong, dateM, nameM, departmentM, typeM, statusM, infoM, employeeM, serialnumberM, inventorynumberM);

                    System.out.println(move.toString());
                } else {
                    System.out.println("Move not found!");
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }
        return move;
    }

    public static void addMove(String movetype, String daterepair, String employee, String selectdepartament, String typeequipment, String nameeq, String inventorynumber, String serialnumber, String info) throws SQLException, ClassNotFoundException {
        Boolean bool = false;
        String sql = "Insert into docmove (status, date, employee, department, type, name, inventorynumber, serialnumber, info) values (?,?,?,?,?,?,?,?,?)";
        try (
                Connection c = getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
        ) {
            ps.setString(1, movetype);
            ps.setString(2, daterepair);
            ps.setString(3, employee);
            ps.setString(4, selectdepartament);
            ps.setString(5, typeequipment);
            ps.setString(6, nameeq);
            ps.setString(7, inventorynumber);
            ps.setString(8, serialnumber);
            ps.setString(9, info);
            if (!ps.execute()) {
                bool = true;
            }
            System.out.println("Insert into docmove (status, date, employee, department, type, name, inventorynumber, serialnumber, Info) values ("+movetype+","+daterepair+","+employee+","+selectdepartament+","+typeequipment+","+nameeq+","+inventorynumber+","+serialnumber+","+info+")");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println(bool);
            System.out.println("Insert into docmove (status, date, employee, department, type, name, inventorynumber, serialnumber, Info) values ("+movetype+","+daterepair+","+employee+","+selectdepartament+","+typeequipment+","+nameeq+","+inventorynumber+","+serialnumber+","+info+")");
        }

    }

    public static List<Users> getUserArgis() throws SQLException, ClassNotFoundException {
        try (Connection c = getConnectionHR();
             PreparedStatement ps = c.prepareStatement("SELECT [TabNum]\n" +
                     "      ,[FirstNameRUS]\n" +
                     "      ,[LastNameRUS]\n" +
                     "      ,[PatronymicRUS]\n" +
                     "      ,[FirstNameENG]\n" +
                     "      ,[LastNameENG]\n" +
                     "      ,[BranchCode]\n" +
                     "      ,[DepartmentName]\n" +
                     "      ,[PositionName]\n" +
                     "      ,[CodeDepartmentCFO]\n" +
                     "      ,[City]\n" +
                     "      ,[Country]\n" +
                     "      ,[BirthDay]\n" +
                     "      ,[EmploymentData]\n" +
                     "      ,[DateDischarge]\n" +
                     "      ,[FuncManager]\n" +
                     "      ,[Manager]\n" +
                     "      ,[Email]\n" +
                     "  FROM [kadry_new].[dbo].[View_HR_for_AD]");
             ResultSet rs = ps.executeQuery();) {

            ArrayList<Users> userArgis = new ArrayList<Users>();
            while (rs.next()) {
                int tabNum = rs.getInt("TabNum");
                String firstNameRUS = rs.getString("FirstNameRUS");
                String lastNameRUS = rs.getString("LastNameRUS");
                String patronymicRUS = rs.getString("PatronymicRUS");
                String firstNameENG = rs.getString("FirstNameENG");
                String lastNameENG = rs.getString("LastNameENG");
                String branchCode = rs.getString("BranchCode");
                String departmentName = rs.getString("DepartmentName");
                String positionName = rs.getString("PositionName");
                String codeDepartmentCFO = rs.getString("CodeDepartmentCFO");
                String city = rs.getString("City");
                String country = rs.getString("Country");
                String birthDay = rs.getString("BirthDay");
                String employmentData = rs.getString("EmploymentData");
                String dateDischarge = rs.getString("DateDischarge");
                String funcManager = rs.getString("FuncManager");
                String manager = rs.getString("Manager");
                String email = rs.getString("Email");

                userArgis.add(new Users(tabNum, firstNameRUS, lastNameRUS, patronymicRUS, firstNameENG, lastNameENG, branchCode, departmentName, positionName, codeDepartmentCFO, city, country, birthDay, employmentData, dateDischarge, funcManager, manager, email));
            }
            return userArgis;
        }

    }

}
