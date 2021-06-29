package org.sber.lakirev.market.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Access(AccessType.FIELD)
@Table(name = "purchases")
@NamedQueries({
        @NamedQuery(name = Purchase.GET_ALL, query = "SELECT p FROM Purchase p ORDER BY p.id"),
        @NamedQuery(name = Purchase.GET_BY_ID, query = "SELECT p FROM Purchase p WHERE p.id = :id")
})
public class Purchase {
    public static final String GET_ALL = "PURCHASES.GET_ALL";
    public static final String GET_BY_ID = "PURCHASES.GET_BY_ID";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "datetime", nullable = false)
    private Timestamp datetime;

    @NotBlank
    @Column(name = "productID", nullable = false)
    private Integer productID;

    @NotBlank
    @Column(name = "customerID", nullable = false)
    private Integer customerID;

    @NotBlank
    @Column(name = "employeeID", nullable = false)
    private Integer employeeID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return datetime.equals(purchase.datetime) && productID.equals(purchase.productID) && customerID.equals(purchase.customerID) && employeeID.equals(purchase.employeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datetime, productID, customerID, employeeID);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", productID=" + productID +
                ", customerID=" + customerID +
                ", employeeID=" + employeeID +
                '}';
    }
}
