package rabbitmq.ErrorClass;

import com.warehouseService.rabbitmq.ErrorClass.DomainError;

import java.util.ArrayList;
import java.util.List;

public class DomainErrors {

    private String errorType;
    private String message;

    public List<com.warehouseService.rabbitmq.ErrorClass.DomainError> getErrors() {
        return errors;
    }

    public void setErrors(List<com.warehouseService.rabbitmq.ErrorClass.DomainError> errors) {
        this.errors = errors;
    }

    private List<com.warehouseService.rabbitmq.ErrorClass.DomainError> errors = new ArrayList<com.warehouseService.rabbitmq.ErrorClass.DomainError>();

    public void addError(DomainError error) {
        errors.add(error);
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
