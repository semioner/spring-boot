package com.semion.example.sample.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by heshuanxu on 2018/7/27.
 */
@Getter
@Setter
public class Customer {
    private Long id;
    private String name;
    private String state;
    private String country;
}
