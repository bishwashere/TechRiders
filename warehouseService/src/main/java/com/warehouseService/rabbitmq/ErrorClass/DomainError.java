<<<<<<< HEAD:warehouseService/src/main/java/com/techriders/logisticservice/ErrorClass/DomainError.java
package com.techriders.logisticservice.ErrorClass;
=======
package com.warehouseService.rabbitmq.ErrorClass;
>>>>>>> 74e49a5e86fbe11f21dd98e2f840978f217ebe7a:warehouseService/src/main/java/com/warehouseService/rabbitmq/ErrorClass/DomainError.java

public class DomainError {

    private String message;

    public DomainError() {
    }

    public DomainError(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
