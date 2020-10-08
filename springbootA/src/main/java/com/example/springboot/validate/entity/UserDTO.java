package com.example.springboot.validate.entity;

import com.example.springboot.validate.definedInterface.IdentityCardNumber;
import lombok.Data;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "用户id不能为空")
    private Long userId;

    @NotBlank(message = "用户名不能为空")
    @Length(max = 20,message = "用户名不能超过20字符")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9\\*]*$",message = "用户名限制，必须为字母、汉字、数字",groups = {})
    private String username;

    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$",message = "手机号格式有误")
    private String mobile;

    private String sex;

    private String password;

    @Future(message = "时间必须是将来的时间")
    private Date createTime;

    @IdentityCardNumber()
    private String cardNo;

}
