# ITMS
Demo IT Managment System

Requier:
IntelliJ,
JDK 1.8,
Tomcat 7.0.29,
MSSQL

Installation

1. Create Database "ITMS";

2. Run script src\sql\MSSQL.sql at your MSSQL server;

3. Chanche settings DB in DAO.java in package ua.chmil.maxim.model at line 17-20;

Example:
    private static final String DB_CONNECTION = "jdbc:jtds:sqlserver://"your MSSQL server":1433/itms";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "password";
    
Preview screenshot http://s017.radikal.ru/i425/1506/f0/ef92e92bf72f.png

