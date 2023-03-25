package com.Relacionamento.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Data
public class Custumer {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String gender;

    @OneToMany(targetEntity = Product.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pro_cus",referencedColumnName = "id")
    private List<Product> products;
}
