package com.wrh.swaggertest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
@Entity
@Table(name = "USERS")
@ApiModel(description = "用户Model")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "id必须为空")
    @ApiModelProperty(value = "用户ID", name = "id")
    @JsonIgnore //在实体类向前台返回数据时用来忽略不想传递给前台的属性或接口
    private Integer id;

    @Column
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", name = "username", required = true, example = "zhaoliu")
    private String username;

    @Column
    @ApiModelProperty(value = "密码", name = "password", required = true, example = "123456")
    private String password;

}
