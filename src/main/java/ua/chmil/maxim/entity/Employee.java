package ua.chmil.maxim.entity;

/**
 * Created by m.chmil on 15.05.2015.
 */
public class Employee {
    private long id;
    private String fio;
    private String position;

    public Employee(){};

    public Employee(long id, String fio, String position) {
        this.id = id;
        this.fio = fio;
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        if (!fio.equals(employee.fio)) return false;
        if (!position.equals(employee.position)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + fio.hashCode();
        result = 31 * result + position.hashCode();
        return result;
    }
}
