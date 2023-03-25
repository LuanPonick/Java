package com.Relacionamento.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
public class Product {
    @Id
    private int pid ;
    private String productName;
    private int price;
    private int qty;
}
