package pl.teo.petshop.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

@Entity @Data
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

    public boolean equals(Delivery delivery) {
        try {
            if (this.id == null && delivery.getId() == null) {
                return this.name.equals(delivery.getName())
                        && this.cost.equals(delivery.getCost())
                        && this.label.equals(delivery.getLabel());
            }
            return this.name.equals(delivery.getName())
                    && this.id.equals(delivery.getId())
                    && this.cost.equals(delivery.getCost())
                    && this.label.equals(delivery.getLabel());
        }catch (NullPointerException e){
            return false;
        }
    }
}
