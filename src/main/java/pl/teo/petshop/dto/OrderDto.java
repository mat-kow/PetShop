package pl.teo.petshop.dto;

import pl.teo.petshop.OrderStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class OrderDto {
    private UserDto userDto;
    private List<OrderProductDto> productsDto;
    private DeliveryDto deliveryDto;
    private long id;
    private Timestamp created;
    private OrderStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public List<OrderProductDto> getProductsDto() {
        return productsDto;
    }

    public void setProductsDto(List<OrderProductDto> productsDto) {
        this.productsDto = productsDto;
    }

    public DeliveryDto getDeliveryDto() {
        return deliveryDto;
    }

    public void setDeliveryDto(DeliveryDto deliveryDto) {
        this.deliveryDto = deliveryDto;
    }
}
