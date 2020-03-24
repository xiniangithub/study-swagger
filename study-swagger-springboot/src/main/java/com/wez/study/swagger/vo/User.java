package com.wez.study.swagger.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@ApiModel(value = "UserEntity", description = "用户对象")
public class User {

    @ApiModelProperty(value ="用户id",name="id",dataType="Long",required = false,example = "1",hidden = false )
    private Long id;
    @ApiModelProperty(value ="用户名",name="userName",dataType="String",required = false,example = "关羽" )
    private String userName;
    @ApiModelProperty(value ="用户性别",name="userSex",dataType="String",required = false,example = "男" )
    private String userSex;

}
