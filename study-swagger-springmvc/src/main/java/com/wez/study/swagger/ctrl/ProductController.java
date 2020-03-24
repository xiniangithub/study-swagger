package com.wez.study.swagger.ctrl;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wez.study.swagger.vo.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = { "/api/product/" })
@Api(tags = "Product接口")
public class ProductController {

    
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 401, message = "要求用户的身份认证"),
            @ApiResponse(code = 403, message = "拒绝执行此请求"),
            @ApiResponse(code = 404, message = "系统资源未发现"),
            @ApiResponse(code = 500, message = "系统错误"),
            @ApiResponse(code = 200, message = "成功,其它为错误,返回格式：{code:0,data[{}]},data中的属性参照下方Model", response = Product.class) })
    @ApiOperation(value = "根据id获取产品信息", notes = "根据id获取产品信息", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> get(@PathVariable Long id) {
        Product product = new Product();
        product.setName("七级滤芯净水器");
        product.setId(1L);
        product.setProductClass("seven_filters");
        product.setProductCode("T12345");
        return ResponseEntity.ok(product);
    }

    @ApiOperation(value = "添加一个新的产品")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "已创建。成功请求并创建了新的资源"),
            @ApiResponse(code = 401, message = "要求用户的身份认证"),
            @ApiResponse(code = 403, message = "拒绝执行此请求"),
            @ApiResponse(code = 404, message = "系统资源未发现"),
            @ApiResponse(code = 405, message = "参数错误"),
            @ApiResponse(code = 200, message = "成功,其它为错误,返回格式：{code:0,data[{}]},data中的属性参照下方Model", response = String.class) })
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> add(Product product) {
        return ResponseEntity.ok("SUCCESS");
    }

    @ApiOperation(value = "更新一个产品")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功,其它为错误,返回格式：{code:0,data[{}]},data中的属性参照下方Model", response = String.class),
            @ApiResponse(code = 201, message = "已创建。成功请求并创建了新的资源"), @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 401, message = "要求用户的身份认证"), @ApiResponse(code = 403, message = "拒绝执行此请求"),
            @ApiResponse(code = 404, message = "系统资源未发现") })
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<String> update(Product product) {
        return ResponseEntity.ok("SUCCESS");
    }

    @ApiOperation(value = "获取所有产品信息", notes = "获取所有产品信息", httpMethod = "GET", response = Product.class, responseContainer = "List")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProducts() {
        Product product = new Product();
        product.setName("七级滤芯净水器");
        product.setId(1L);
        product.setProductClass("seven_filters");
        product.setProductCode("T12345");
        return ResponseEntity.ok(Arrays.asList(product, product));
    }

    @ApiOperation(value = "删除某个产品信息", notes = "删除某个产品信息")
    /*
     * @ApiImplicitParams(@ApiImplicitParam(name="carOwnerName",value="产品id", dataType="Long"))
     */
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "无内容。服务器成功处理，但未返回内容！"),
            @ApiResponse(code = 400, message = "参数错误"),
            @ApiResponse(code = 401, message = "要求用户的身份认证"),
            @ApiResponse(code = 403, message = "拒绝执行此请求"),
            @ApiResponse(code = 500, message = "系统错误"),
            @ApiResponse(code = 200, message = "成功,其它为错误,返回格式：{code:0,data[{}]},data中的属性参照下方Model", response = String.class) })
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        } else {
            return ResponseEntity.ok("SUCCESS");
        }

    }
}
