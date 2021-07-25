package ru.geekbrains.summer.market.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.summer.market.dto.OrderItemDto;
import ru.geekbrains.summer.market.model.Category;
import ru.geekbrains.summer.market.model.Order;
import ru.geekbrains.summer.market.model.OrderItem;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.services.OrdersService;
import ru.geekbrains.summer.market.utils.Cart;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrdersController {
    private OrdersService ordersService;
    private Cart cart;


    @PostMapping("/create")
    public Order createOrder(@RequestParam Cart cart) {
        for (OrderItemDto i : cart.getItems()) {
            Product product = new Product();
            OrderItem oi = new OrderItem();
            oi.setPrice(i.getPrice());
            oi.setQuantity(i.getQuantity());
            oi.setProduct(product);
           // oi.setOrder();
        }
        Order order = new Order(cart);
        order = ordersService.saveOrder(order);
        return new Order(cart);
    }
}