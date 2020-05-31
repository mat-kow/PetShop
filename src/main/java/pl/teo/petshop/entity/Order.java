package pl.teo.petshop.entity;

import org.hibernate.annotations.CreationTimestamp;
import pl.teo.petshop.OrderStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity @Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    @OneToMany
    private List<OrderProduct> products;
    @CreationTimestamp
    private Timestamp created;
    private OrderStatus status;
    @ManyToOne
    private Delivery delivery;
    public Order(User user, List<OrderProduct> products) {
        this.user = user;
        this.products = products;
        this.status = OrderStatus.CREATED;
    }

    public Order() {
        this.status = OrderStatus.CREATED;
    }

    @Transient
    public BigDecimal getSum(){
        BigDecimal sum = new BigDecimal(0);
        for(OrderProduct orderProduct : this.products){
            sum = sum.add(orderProduct.getSum());
        }
        sum = sum.add(this.delivery.getCost());
        return sum;
    }

    public Timestamp getCreated() {
        return created;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderProduct> getProducts() {
        return products;
    }

    public void setProducts(List<OrderProduct> products) {
        this.products = products;
    }
}
