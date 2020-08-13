package rabbitmq.domains;


import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.warehouseService.rabbitmq.domains.Product;

import java.io.Serializable;

@Entity
@Transactional
public class OrderedProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private com.warehouseService.rabbitmq.domains.Product product;

    public OrderedProduct() {

    }

//    public OrderedProduct(String price, String quantity, String tax) {
//    	this.price = Float.parseFloat(price);
//    	this.qty = Integer.parseInt(quantity);
//    	this.tax = Float.parseFloat(tax);
//    }

//    public OrderedProduct(String message) throws JsonMappingException, JsonProcessingException {
//    	System.out.println("Inside OrderedProduct 1");
//    	ObjectMapper mapper = new ObjectMapper();
//	    JsonNode actualObj = mapper.readTree(message);
//    	
//	    System.out.println("Inside OrderedProduct 2");
//	    Gson gson = new Gson();
//	    JsonNode OrderedProductJson = actualObj.get("orderedProducts");
//		System.out.println("Inside OrderedProduct 3");
//
//		this.price = Double.valueOf(OrderedProductJson.get("price").asDouble()).floatValue();
//		System.out.println("Inside OrderedProduct 3");
//		this.qty = actualObj.get("quantity").get("price").asInt();
//		this.tax = Double.valueOf(actualObj.get("orderedProducts").get("tax").asDouble()).floatValue();
//		System.out.println("Inside OrderedProduct 4");
//	}

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

    public com.warehouseService.rabbitmq.domains.Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
