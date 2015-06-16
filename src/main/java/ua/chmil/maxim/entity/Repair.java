package ua.chmil.maxim.entity;


/**
 * Created by m.chmil on 15.05.2015.
 */
public class Repair implements java.io.Serializable {
    private long id;
    private String dateIn;
    private String invNumder;
    private String sNNumber;
    private String name;
    private String branches;
    private String type;
    private String dateOut;
    private String status;
    private String employee;
    private String info;
    private String gk;

    public Repair(){}

    public Repair(long id, String dateIn, String invNumder, String sNNumber, String name, String branches, String type, String dateOut, String status, String employee, String info, String gk) {
        this.id = id;
        this.dateIn = dateIn;
        this.invNumder = invNumder;
        this.sNNumber = sNNumber;
        this.name = name;
        this.branches = branches;
        this.type = type;
        this.dateOut = dateOut;
        this.status = status;
        this.employee = employee;
        this.info = info;
        this.gk = gk;
    }

    public Repair(String dateIn, String invNumder, String sNNumber, String name, String branches, String type, String dateOut, String status, String employee, String info, String gk) {
        this.dateIn = dateIn;
        this.invNumder = invNumder;
        this.sNNumber = sNNumber;
        this.name = name;
        this.branches = branches;
        this.type = type;
        this.dateOut = dateOut;
        this.status = status;
        this.employee = employee;
        this.info = info;
        this.gk = gk;
    }

    public Repair(String dateIn, String invNumder, String sNNumber, String name, String branches, String type, String dateOut, String status, String info, String gk) {
        this.dateIn = dateIn;
        this.invNumder = invNumder;
        this.sNNumber = sNNumber;
        this.name = name;
        this.branches = branches;
        this.type = type;
        this.dateOut = dateOut;
        this.status = status;
        this.info = info;
        this.gk = gk;
    }

    public Repair(long id, String dateIn, String invNumder, String sNNumber, String name, String branches, String type, String dateOut, String status, String info, String gk) {
        this.id = id;
        this.dateIn = dateIn;
        this.invNumder = invNumder;
        this.sNNumber = sNNumber;
        this.name = name;
        this.branches = branches;
        this.type = type;
        this.dateOut = dateOut;
        this.status = status;
        this.info = info;
        this.gk = gk;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getBranches() {
        return branches;
    }

    public void setBranches(String branches) {
        this.branches = branches;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getInvNumder() {
        return invNumder;
    }

    public void setInvNumder(String invNumder) {
        this.invNumder = invNumder;
    }

    public String getsNNumber() {
        return sNNumber;
    }

    public void setsNNumber(String sNNumber) {
        this.sNNumber = sNNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getGk() {
        return gk;
    }

    public void setGk(String gk) {
        this.gk = gk;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", dateIn=" + dateIn +
                ", invNumder='" + invNumder + '\'' +
                ", sNNumber='" + sNNumber + '\'' +
                ", name='" + name + '\'' +
                ", branches=" + branches +
                ", type=" + type +
                ", dateOut=" + dateOut +
                ", status='" + status + '\'' +
                ", employee=" + employee +
                ", info='" + info + '\'' +
                ", gk='" + gk + '\'' +
                '}';
    }
}
