package com.dinhnguyendev.microservice.currencyexchangeservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchangeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "from_exchange")
    private String from;
    @Column(name = "to_exchange")
    private String to;
    private BigDecimal conversionMultiple;
    private String environment;
}