package ua.chmil.maxim.entity;

/**
 * Created by m.chmil on 22.05.2015.
 */
public class Move {
    long id;
    String date;
    String name;
    String departament;
    String type;
    String moveType;
    String info;
    String employee;
    String serialNumber;
    String inventoryNumber;

    public Move(){}

    public Move(long id, String date, String name, String departament, String type, String moveType, String info, String serialNumber, String inventoryNumber) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.departament = departament;
        this.type = type;
        this.moveType = moveType;
        this.info = info;
        this.serialNumber = serialNumber;
        this.inventoryNumber = inventoryNumber;
    }

    public Move(long id, String date, String name, String departament, String type, String moveType, String info, String employee, String serialNumber, String inventoryNumber) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.departament = departament;
        this.type = type;
        this.moveType = moveType;
        this.info = info;
        this.employee = employee;
        this.serialNumber = serialNumber;
        this.inventoryNumber = inventoryNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getmoveType() {
        return moveType;
    }

    public void setmoveType(String moveType) {
        this.moveType = moveType;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public void setInventoryNumber(String inventoryNumber) {
        this.inventoryNumber = inventoryNumber;
    }

    @Override
    public String toString() {
        return "MoveTMC{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", departament='" + departament + '\'' +
                ", type='" + type + '\'' +
                ", moveType='" + moveType + '\'' +
                ", info='" + info + '\'' +
                ", employee='" + employee + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", inventoryNumber='" + inventoryNumber + '\'' +
                '}';
    }
}
