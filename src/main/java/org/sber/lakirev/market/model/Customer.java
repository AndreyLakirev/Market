package org.sber.lakirev.market.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Access(AccessType.FIELD)
@Table(
        name = "customers",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "surname"})})
@NamedQueries({
        @NamedQuery(name = Customer.GET_ALL, query = "SELECT c FROM Customer c ORDER BY c.id"),
        @NamedQuery(name = Customer.GET_BY_ID, query = "SELECT c FROM Customer c WHERE c.id = :id")
})
public class Customer {
    public static final String GET_ALL = "CUSTOMERS.GET_ALL";
    public static final String GET_BY_ID = "CUSTOMERS.GET_BY_ID";

    public Customer () {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name.equals(customer.name) && surname.equals(customer.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
