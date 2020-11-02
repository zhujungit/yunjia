package com.hp.projo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Smbms_Bill {
    private Integer  id;  //主键ID
    private String    billCode; // '账单编码',
    private String  productName; //商品名称',
    private String  productDesc;//商品描述',
    private String productUnit;//单位',
    private BigDecimal productCount;//商品数量',
    private BigDecimal totalPrice;//账单总金额',
    private Integer isPayment;//是否付款（1 未支付 2 已支付）',
    private  Integer providerId ;//供应商ID'
    private  Integer creationDat;//创建时间',
    private Integer createdBy;//创建者',
    private Date modifyDate;//更新时间',
    private  String  modifyBy;//更新者

}
