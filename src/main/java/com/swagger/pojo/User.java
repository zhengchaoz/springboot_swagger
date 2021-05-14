package com.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 郑超
 * @date 2021-05-14 21:34
 */
@ApiModel("用户类")
@Data
public class User {

    @ApiModelProperty("用户名")
    private String name;
    @ApiModelProperty("密码")
    private String pwd;

}
