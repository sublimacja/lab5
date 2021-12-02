package com.example.lab5;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;


@Getter
@Data
@ToString
public class BusinessAddress {

        private String streetAddress;
        private String addressLocality;
        private String postalCode;
        private String addressCountry;

}
