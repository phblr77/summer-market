package ru.geekbrains.summer.market.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;
import ru.geekbrains.summer.market.dto.OrderItemDto;
import ru.geekbrains.summer.market.utils.Cart;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    @OneToMany(mappedBy = "order")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<OrderItemDto> items;

    @Column(name = "price")
    private BigDecimal price;



    public Order(Cart cart) {
        this.items = new ArrayList<>();
        for (OrderItem oi : cart.getItems()) {
            oi.setOrder(this);
            this.items.add(oi);
        }
        this.price = new BigDecimal(cart.getPrice().doubleValue());
        cart.clear();
    }
}
