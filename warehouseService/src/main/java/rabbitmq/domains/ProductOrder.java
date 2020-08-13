package rabbitmq.domains;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.warehouseService.rabbitmq.domains.BillingAddress;
import com.warehouseService.rabbitmq.domains.OrderedProduct;
import com.warehouseService.rabbitmq.domains.ShippingAddress;
import com.warehouseService.rabbitmq.domains.User;
import com.warehouseService.rabbitmq.services.BillingAddressService;
import com.warehouseService.rabbitmq.services.UserService;
import com.warehouseService.rabbitmq.configs.OrderStatusEnum;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long transactionId;

    @OneToOne
    @JoinColumn(name="buyer_id",nullable = false)
    private com.warehouseService.rabbitmq.domains.User buyer;

    private OrderStatusEnum orderStatus;
    @OneToOne
    @JoinColumn(name="bAddr_id",nullable = false)
    private BillingAddress billingAddress;
    @JoinColumn(name="sAddr_id",nullable = false)
    @OneToOne
    private ShippingAddress shippingAddress;

    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "productOrder_id")
    private List<OrderedProduct> orderedProducts;

    public ProductOrder() {
    }
    
//    @Autowired
//    UserService userService;
//    
//    @Autowired
//    BillingAddressService billingAddressService;

//    public ProductOrder(String message) throws JsonMappingException, JsonProcessingException {
//    	ObjectMapper mapper = new ObjectMapper();
//	    JsonNode actualObj = mapper.readTree(message);
//	    this.transactionId=actualObj.get("transactionId").asLong();
//	    this.buyer= userService.findById(actualObj.get("buyer").asInt());
//	    this.billingAddress=billingAddressService.findById(actualObj.get("billingAddress").asInt());
////	    String orderStatus = actualObj.get("orderStatus").textValue();
////	    this.orderStatus=OrderStatusEnum.orderStatus
//	    this.orderStatus=OrderStatusEnum.PENDING;
//	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public com.warehouseService.rabbitmq.domains.User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public OrderStatusEnum getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusEnum orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<OrderedProduct> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }
    
    @Override
	public String toString() {
    	// email
    	// Username
    	// transaction ID
    	// price
    	// quantity
    	// tax
		return "{" +
	        "\"transactionId\":\"" + transactionId + "\"" +
	        ", \"email\":\"" + buyer.getEmail() + "\"" +
	        ", \"name\":\"" + buyer.getUserName() + "\"" +
	        ", \"billingAddress\":\"" + billingAddress.getAddressL1() + "\"" +
	        ", \"shippingAddress\":\"" + shippingAddress.getAddressL1() + "\"" +
	        ", \"orderStatus\":\"" + orderStatus + "\"" +
	        ", \"orderedProducts\":\"" + orderedProducts.toString() + "\"" +
        "}";
	}
}
