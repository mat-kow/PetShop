package pl.teo.petshop.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(long id) {
        super("Could not find product of id " + id);

    }
    public ProductNotFoundException() {
        super("Product could not be find");

    }

}
