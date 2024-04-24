package com.dinhnguyendev.microservice.currencyexchangeservice.dto.request;


import lombok.Data;

//@Data
//public class TestRecord {
//
//    private Long id;
//    private String name;
//    private String description;
//    private Integer age;
//}
public record TestRecord (
    Long id,
     String name,
     String description,
     Integer age
){

}
