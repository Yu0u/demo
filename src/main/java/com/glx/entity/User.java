package com.glx.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class User {
    /**
     * id 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * username 用户名唯一
     */
    @NotNull(message = "用户名不能为空。")
    @Column(unique = true)
    @Length(min = 6,max = 12,message = "用户名长度为6-12位。")
    private String username;

    /**
     * password 密码
     */
    private String password;

}
