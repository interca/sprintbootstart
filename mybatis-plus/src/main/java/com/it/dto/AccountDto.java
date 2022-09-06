package com.it.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("account")
public class AccountDto {
    int uid;
    String name;
    int money;

}
