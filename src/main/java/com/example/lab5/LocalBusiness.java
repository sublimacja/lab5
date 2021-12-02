package com.example.lab5;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class LocalBusiness {
    private String name;
    private String telephone;
    private String email;
    private String sameAs;
    private BusinessAddress address;


}
