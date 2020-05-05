package org.example.controller;

import org.example.domain.Order;
import org.example.domain.Product;
import org.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/order/product/{pid}")
    public Order order(@PathVariable("pid") Integer pid){
        Product product = restTemplate.getForObject("http://localhost:8081/product/"+pid,Product.class);

        Order order = new Order();

        order.setUid(1);
        order.setUsername("test user");

        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());

        order.setNumber(1);

        orderService. createOrder(order);

        return order;
    }
}
