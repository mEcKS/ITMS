package ua.chmil.maxim.entity;

/**
 * Created by m.chmil on 25.05.2015.
 */
public class Users implements java.io.Serializable {

     private Integer id = null;
     int tabNum;
     String firstNameRUS;
     String lastNameRUS;
     String patronymicRUS;
     String firstNameENG;
     String lastNameENG;
     String branchCode;
     String departmentName;
     String positionName;
     String codeDepartmentCFO;
     String city;
     String country;
     String birthDay;
     String employmentData;
     String dateDischarge;
     String funcManager;
     String manager;
     String email;

    public Users() {}

    public Users(int tabNum, String firstNameRUS, String lastNameRUS, String patronymicRUS, String firstNameENG, String lastNameENG, String branchCode, String departmentName, String positionName, String codeDepartmentCFO, String city, String country, String birthDay, String employmentData, String dateDischarge, String funcManager, String manager, String email) {
        this.tabNum = tabNum;
        this.firstNameRUS = firstNameRUS;
        this.lastNameRUS = lastNameRUS;
        this.patronymicRUS = patronymicRUS;
        this.firstNameENG = firstNameENG;
        this.lastNameENG = lastNameENG;
        this.branchCode = branchCode;
        this.departmentName = departmentName;
        this.positionName = positionName;
        this.codeDepartmentCFO = codeDepartmentCFO;
        this.city = city;
        this.country = country;
        this.birthDay = birthDay;
        this.employmentData = employmentData;
        this.dateDischarge = dateDischarge;
        this.funcManager = funcManager;
        this.manager = manager;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTabNum() {
        return tabNum;
    }

    public void setTabNum(int tabNum) {
        this.tabNum = tabNum;
    }

    public String getFirstNameRUS() {
        return firstNameRUS;
    }

    public void setFirstNameRUS(String firstNameRUS) {
        this.firstNameRUS = firstNameRUS;
    }

    public String getLastNameRUS() {
        return lastNameRUS;
    }

    public void setLastNameRUS(String lastNameRUS) {
        this.lastNameRUS = lastNameRUS;
    }

    public String getPatronymicRUS() {
        return patronymicRUS;
    }

    public void setPatronymicRUS(String patronymicRUS) {
        this.patronymicRUS = patronymicRUS;
    }

    public String getFirstNameENG() {
        return firstNameENG;
    }

    public void setFirstNameENG(String firstNameENG) {
        this.firstNameENG = firstNameENG;
    }

    public String getLastNameENG() {
        return lastNameENG;
    }

    public void setLastNameENG(String lastNameENG) {
        this.lastNameENG = lastNameENG;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getCodeDepartmentCFO() {
        return codeDepartmentCFO;
    }

    public void setCodeDepartmentCFO(String codeDepartmentCFO) {
        this.codeDepartmentCFO = codeDepartmentCFO;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmploymentData() {
        return employmentData;
    }

    public void setEmploymentData(String employmentData) {
        this.employmentData = employmentData;
    }

    public String getDateDischarge() {
        return dateDischarge;
    }

    public void setDateDischarge(String dateDischarge) {
        this.dateDischarge = dateDischarge;
    }

    public String getFuncManager() {
        return funcManager;
    }

    public void setFuncManager(String funcManager) {
        this.funcManager = funcManager;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserArgis{" +
                "tabNum=" + tabNum +
                ", firstNameRUS='" + firstNameRUS + '\'' +
                ", lastNameRUS='" + lastNameRUS + '\'' +
                ", patronymicRUS='" + patronymicRUS + '\'' +
                ", firstNameENG='" + firstNameENG + '\'' +
                ", lastNameENG='" + lastNameENG + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", positionName='" + positionName + '\'' +
                ", codeDepartmentCFO='" + codeDepartmentCFO + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", employmentData='" + employmentData + '\'' +
                ", dateDischarge='" + dateDischarge + '\'' +
                ", funcManager='" + funcManager + '\'' +
                ", manager='" + manager + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
