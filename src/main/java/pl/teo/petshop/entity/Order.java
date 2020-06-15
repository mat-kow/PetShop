package pl.teo.petshop.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import pl.teo.petshop.OrderStatus;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity @Getter @Setter
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @OneToMany
    private List<OrderProduct> products;
    @CreationTimestamp
    private Timestamp created;
    private OrderStatus status;
    @ManyToOne
    private Delivery delivery;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                user.equals(order.user) &&
                products.equals(order.products) &&
                Objects.equals(created, order.created) &&
                status == order.status &&
                delivery.equals(order.delivery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, products, created, status, delivery);
    }
}
