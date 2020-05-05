package org.example.controller;

import org.example.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.service.ProductService;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid){
        Product product = productService.findByPid(pid);
        return product;
    }
}
