package pl.teo.petshop.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;
import java.util.Objects;

@Entity @Getter @Setter @NoArgsConstructor
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length = 20)
    private String name;
    @Column (length = 20)
    private String label;
//    @Column(precision = 6, scale = 4)
    @Digits (integer = 4, fraction = 2)
    private BigDecimal cost;

    public Delivery(String name, String label, BigDecimal cost) {
        this.name = name;
        this.label = label;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return Objects.equals(id, delivery.id) &&
                name.equals(delivery.name) &&
                label.equals(delivery.label) &&
                cost.equals(delivery.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, label, cost);
    }
}
