package upao.Transa.Exception;

public class UserNotAuthenticatedException extends RuntimeException {
    public UserNotAuthenticatedException() {
        super();
    }
    public UserNotAuthenticatedException(String message) {
        super(message);
    }
}
