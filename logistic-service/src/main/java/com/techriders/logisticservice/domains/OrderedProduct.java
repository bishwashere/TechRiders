package com.techriders.logisticservice.domains;


import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Transactional
public class OrderedProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Digits(integer = 100 /*precision*/, fraction = 2 /*scale*/)
    Float price;

    @NotNull
    @Digits(integer = 100 /*precision*/, fraction = 2 /*scale*/)
    Float tax;

    private Integer qty;

    @OneToOne
    @JoinColumn(name="product_id",nullable = false)
    private Product product;



    public OrderedProduct() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getTax() {
        return tax;
    }

    public void setTax(Float tax) {
        this.tax = tax;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
