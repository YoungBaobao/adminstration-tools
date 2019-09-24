package com.yangbaobao.administrationtools.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "tb_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String description;
    @Column(name="pay_price")
    private BigDecimal payPrice;
    @Column(name = "tag_price")
    private BigDecimal tagPrice;
    private BigInteger stock;
    private String delivery;
    @Column(name = "main_image")
    private String mainImage;
    @Column(name = "detail_image")
    private String detailImage;
    private String category;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public BigDecimal getTagPrice() {
        return tagPrice;
    }

    public void setTagPrice(BigDecimal tagPrice) {
        this.tagPrice = tagPrice;
    }

    public BigInteger getStock() {
        return stock;
    }

    public void setStock(BigInteger stock) {
        this.stock = stock;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public String getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(String detailImage) {
        this.detailImage = detailImage;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
