package com.example.canteen.vo;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
public class UserVO {

    private Integer id;

    private String name;

    private String phone;

    private String cities;

    private String detailedAddress;

    private Integer age;

    private String gender;

    private String address;
}
