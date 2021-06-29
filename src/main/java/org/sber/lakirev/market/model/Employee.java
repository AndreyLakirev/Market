package org.sber.lakirev.market.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Access(AccessType.FIELD)
@Table(
        name = "employees",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "surname"})})
@NamedQueries({
        @NamedQuery(name = Employee.GET_ALL, query = "SELECT e FROM Employee e ORDER BY e.id"),
        @NamedQuery(name = Employee.GET_BY_ID, query = "SELECT e FROM Employee e WHERE e.id = :id"),
        @NamedQuery(name = Employee.GET_BY_STATUS, query = "SELECT e FROM Employee e WHERE e.status = :status")
})
public class Employee {
    public static final String GET_ALL = "EMPLOYEES.GET_ALL";
    public static final String GET_BY_ID = "EMPLOYEES.GET_BY_ID";
    public static final String GET_BY_STATUS = "EMPLOYEES.GET_BY_STATUS";

    public Employee () {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 40)
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank
    @Size(max = 40)
    @Column(name = "surname", nullable = false)
    private String surname;

    @NotBlank
    @Size(max = 40)
    @Column(name = "status", nullable = false)
    private String status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name) && surname.equals(employee.surname) && status.equals(employee.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, status);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
