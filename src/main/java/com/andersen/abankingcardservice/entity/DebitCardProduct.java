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
public class DebitCardProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "debit_product_id")
    private Long debitCardProductId;
    private String debitCardProductTitle;

    @OneToMany
    @ToString.Exclude
    private List<Card> debitCardsProductList;
}
