package com.andersen.abankingcardservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class CreditCardProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "credit_product_id")
    private Long creditCardProductId;
    private String creditCardProductTitle;

    @OneToMany
    @ToString.Exclude
    private List<Card> creditCardsProductList;

}
