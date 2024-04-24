package com.dinhnguyendev.microservice.currencyexchangeservice.repository;

import com.dinhnguyendev.microservice.currencyexchangeservice.entity.CurrencyExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CurrencyExchangeRepository  extends JpaRepository<CurrencyExchangeEntity,Long> {

    Optional<CurrencyExchangeEntity> findByFromAndTo(String from, String to);
}
