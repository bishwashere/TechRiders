package com.techriders.wirehouseservice.domains;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Size(min = 4, max = 50, message = "{Size.name.validation}")
    String name;

    @NotNull
    @Digits(integer = 100 /*precision*/, fraction = 2 /*scale*/)
    @Positive
    Float price;

    @NotNull
    @Digits(integer = 100 /*precision*/, fraction = 2 /*scale*/)
    @Positive
    Float tax;

    @NotNull
    Integer catId;


    @Column(name="description", length=800)
    private String description;

    private String productImage;

    private boolean soldStatus = false;

    //@NotNull

    Long addedBy;



    private Integer qty;


    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public boolean isSoldStatus() {
        return soldStatus;
    }

    public void setSoldStatus(boolean soldStatus) {
        this.soldStatus = soldStatus;
    }

    public Long getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Long addedBy) {
        this.addedBy = addedBy;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Product(Long id, @NotBlank @Size(min = 4, max = 50, message = "{Size.name.validation}") String name, @NotNull @Digits(integer = 100 /*precision*/, fraction = 2 /*scale*/) Float price, @NotNull @Digits(integer = 100 /*precision*/, fraction = 2 /*scale*/) Float tax, @NotNull Integer catId, @Size(max = 65535) String description, String productImage, boolean soldStatus, Long addedBy, Integer qty) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tax = tax;
        this.catId = catId;
        this.description = description;
        this.productImage = productImage;
        this.soldStatus = soldStatus;
        this.addedBy = addedBy;
        this.qty = qty;
    }
}
