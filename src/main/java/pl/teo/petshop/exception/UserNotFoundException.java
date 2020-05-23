package pl.teo.petshop.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(long id) {
        super("Could not find user of id " + id);

    }
    public UserNotFoundException() {
        super("User could not be find");

    }
}
