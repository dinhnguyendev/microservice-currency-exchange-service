package com.dinhnguyendev.microservice.currencyexchangeservice.controller;


import com.dinhnguyendev.microservice.currencyexchangeservice.dto.request.TestRecord;
import com.dinhnguyendev.microservice.currencyexchangeservice.dto.response.CurrencyExchangeResponse;
import com.dinhnguyendev.microservice.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("currency-exchange")
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("from/{from}/to/{to}")
    public CurrencyExchangeResponse retrieve(@PathVariable String from, @PathVariable String to) {

        String port = this.environment.getProperty("local.server.port");

        return this.currencyExchangeRepository.findByFromAndTo(from, to)
                .map(e -> {
                    CurrencyExchangeResponse response = new CurrencyExchangeResponse();
                    BeanUtils.copyProperties(e, response);
                    return response;
                })
                .orElse(null);
    }

    @GetMapping("record")
    public TestRecord getRecord(){
        TestRecord result=
                new TestRecord();
        result.age =24
        result.setId(10L);
        result.setName("nguyen ngoc dinh");
        return result;
    }
}
