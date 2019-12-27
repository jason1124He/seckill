package com.seckill.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author hej
 * @since 2019-12-27
 */
@TableName("order_info")
public class OrderInfoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private Integer goodsId;

    private Integer deliverAddrId;

    private String goodsName;

    private Integer goodsCount;

    private BigDecimal goodsPrice;

    private String orderChannel;

    private String status;

    private Date createDate;

    private Date payDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    public Integer getDeliverAddrId() {
        return deliverAddrId;
    }

    public void setDeliverAddrId(Integer deliverAddrId) {
        this.deliverAddrId = deliverAddrId;
    }
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }
    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public String getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(String orderChannel) {
        this.orderChannel = orderChannel;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    @Override
    public String toString() {
        return "OrderInfoEntity{" +
            "id=" + id +
            ", userId=" + userId +
            ", goodsId=" + goodsId +
            ", deliverAddrId=" + deliverAddrId +
            ", goodsName=" + goodsName +
            ", goodsCount=" + goodsCount +
            ", goodsPrice=" + goodsPrice +
            ", orderChannel=" + orderChannel +
            ", status=" + status +
            ", createDate=" + createDate +
            ", payDate=" + payDate +
        "}";
    }
}
