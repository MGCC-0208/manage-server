package com.example.canteen.form;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserForm {

    @NotNull(message = "用户id不可为空")
    private Integer id;

    @NotNull(message = "用户名不可为空")
    @Size(min = 2,max = 12,message = "昵称长度应在2-12之间")
    private String name;

    @NotNull(message = "用户手机号码不可为空")
    @Size(min = 11,max = 11,message = "手机号码格式错误")
    private String phone;

    @NotNull(message = "省市信息不可为空")
    private String cities;

    private String detailedAddress;

    @DecimalMax(value = "999",message = "年龄格式错误")
    @DecimalMin(value = "1", message = "年龄格式错误")
    private Integer age;

    @NotNull(message = "性别不可为空")
    private String gender;
    
    private String address;

}
