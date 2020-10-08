package com.example.springboot.validate.controller;

import com.example.springboot.validate.entity.RspDTO;
import com.example.springboot.validate.entity.UserDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/validate")
public class ValidateController {
    @PostMapping("/save")
    public RspDTO save(@RequestBody @Validated UserDTO userDTO){
        return new RspDTO(0,"操作成功");
    }
    @GetMapping("/test")
    public RspDTO save(@RequestParam("userId") @NotNull(message = "用户Id不能为空")long userId){
        System.out.println(userId);
        return new RspDTO(0,"操作成功");
    }
}
