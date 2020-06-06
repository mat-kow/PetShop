package pl.teo.petshop.entity;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column (length = 20)
    private String name;
    @Column (length = 20)
    private String label;
//    @Column(precision = 6, scale = 4)
    @Digits (integer = 4, fraction = 2)
    private BigDecimal cost;

    public String getLabel() {
        return label;
    }

    public void setLabel(String description) {
        this.label = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
