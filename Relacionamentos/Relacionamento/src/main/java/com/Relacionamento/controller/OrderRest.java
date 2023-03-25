package com.Relacionamento.controller;

import com.Relacionamento.dto.OrderRequest;
import com.Relacionamento.entities.Custumer;
import com.Relacionamento.repository.CustomerRepository;
import com.Relacionamento.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderRest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/placeOrder")
    public Custumer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustumer());
    }

    @GetMapping("/findAll")
    public List<Custumer> findAllOrcder(){
        return customerRepository.findAll();
    }
}
