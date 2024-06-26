package com.dinhnguyendev.microservice.currencyexchangeservice.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyExchangeResponse {

    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
    private String  environment;

}
