package com.wez.study.swagger.ctrl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wez.study.swagger.vo.User;

@RestController
@RequestMapping("/api")
@Api
public class UserController {

    @GetMapping("/getUserById")
    @ApiOperation(value = "根据id获取用户", notes = "id必传", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "用户id",example = "1", required = true, dataType = "long", paramType = "query")
    public User getOne(Long id) {
        User user = new User();
        user.setId(10001L);
        user.setUserName("Tony");
        user.setUserSex("man");

        return user;
    }

}
