package pl.teo.petshop.dto;

import lombok.Getter;
import lombok.Setter;
import pl.teo.petshop.OrderStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Getter @Setter
public class OrderDto {
    private UserDto userDto;
    private List<OrderProductDto> productsDto;
    private DeliveryDto deliveryDto;
    private Long id;
    private Timestamp created;
    private OrderStatus status;

    public OrderDto(UserDto userDto, List<OrderProductDto> productsDto) {
        this.userDto = userDto;
        this.productsDto = productsDto;
    }

    public OrderDto() {
    }
    public BigDecimal getSum(){
        BigDecimal sum = new BigDecimal(0);
        for(OrderProductDto orderProductDto : this.productsDto){
            sum = sum.add(orderProductDto.getSum());
        }
        sum = sum.add(this.deliveryDto.getCost());
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(userDto, orderDto.userDto) &&
                Objects.equals(productsDto, orderDto.productsDto) &&
                Objects.equals(deliveryDto, orderDto.deliveryDto) &&
                Objects.equals(id, orderDto.id) &&
                Objects.equals(created, orderDto.created) &&
                status == orderDto.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userDto, productsDto, deliveryDto, id, created, status);
    }
}
