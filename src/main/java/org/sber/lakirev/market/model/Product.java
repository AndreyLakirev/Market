package org.sber.lakirev.market.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Access(AccessType.FIELD)
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = Product.GET_ALL, query = "SELECT p FROM Product p ORDER BY p.id"),
        @NamedQuery(name = Product.GET_BY_ID, query = "SELECT p FROM Product p WHERE p.id = :id"),
        @NamedQuery(name = Product.GET_BY_STATUS, query = "SELECT p FROM Product p WHERE p.status = :status")
})
public class Product {
    public static final String GET_ALL = "PRODUCTS.GET_ALL";
    public static final String GET_BY_ID = "PRODUCTS.GET_BY_ID";
    public static final String GET_BY_STATUS = "PRODUCTS.GET_BY_STATUS";

    public Product () {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 40)
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank
    @Size(max = 40)
    @Column(name = "status", nullable = false)
    private String status;

    @NotBlank
    @Size(max = 40)
    @Column(name = "material", nullable = false)
    private String material;

    @NotBlank
    @Column(name = "weight", nullable = false)
    private Integer weight;

    @NotBlank
    @Column(name = "cost", nullable = false)
    private Integer cost;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name) && material.equals(product.material) && weight.equals(product.weight) && cost.equals(product.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, material, weight, cost);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", material='" + material + '\'' +
                ", weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}