package com.example.springboot.validate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RspDTO {
    private Integer code;
    private String msg;
}
