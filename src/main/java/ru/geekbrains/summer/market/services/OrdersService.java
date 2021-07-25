package ru.geekbrains.summer.market.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.summer.market.model.Order;
import ru.geekbrains.summer.market.repositories.OrdersRepository;

@Service
public class OrdersService {
    private OrdersRepository ordersRepository;

    @Autowired
    public void setOrdersRepository(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public Order saveOrder(Order order) {
        return ordersRepository.save(order);
    }
}
