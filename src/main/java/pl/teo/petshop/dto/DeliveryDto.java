package pl.teo.petshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

@Getter @Setter @NoArgsConstructor
public class DeliveryDto {
    private Long id;
    @Size(max = 20, min = 3, message = "{Size.deliveryDto.name}")
    private String name;
    @Size(max = 20, min = 3, message = "{Size.deliveryDto.label}")
    private String label;
    @Digits(integer = 4, fraction = 2, message = "{Digits.deliveryDto.cost}")
    private BigDecimal cost;

    public DeliveryDto(String name, String label, BigDecimal cost) {
        this.name = name;
        this.label = label;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryDto that = (DeliveryDto) o;
        return Objects.equals(id, that.id) &&
                name.equals(that.name) &&
                label.equals(that.label) &&
                cost.equals(that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, label, cost);
    }
}
