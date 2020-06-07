package pl.teo.petshop.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class DeliveryDto {
    private Long id;
    @Size(max = 20, min = 3, message = "{Size.deliveryDto.name}")
    private String name;
    @Size(max = 20, min = 3, message = "{Size.deliveryDto.label}")
    private String label;
    @Digits(integer = 4, fraction = 2, message = "{Digits.deliveryDto.cost}")
    private BigDecimal cost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}
