package com.wez.study.swagger.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
@Setter
@Getter
@ApiModel(description="产品类VO")
public class Product {
    
    /**ID*/
    @ApiModelProperty(name="id", value="ID")
    private Long id;

    /**产品名称*/
    @ApiModelProperty(name="name", value="产品名称")
    private String name;

    /**产品型号*/
    @ApiModelProperty(name="productClass", value="产品型号")
    private String productClass;

    /**产品编码*/
    @ApiModelProperty(name="productCode", value="产品编码")
    private String productCode;

}
