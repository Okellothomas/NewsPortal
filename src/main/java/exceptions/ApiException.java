package exceptions;

public class ApiException extends RuntimeException{

    private final int status;

    public ApiException(int status) {
        this.status = status;
    }

    public ApiException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public ApiException(String message, Throwable cause, int status) {
        super(message, cause);
        this.status = status;
    }

    public ApiException(Throwable cause, int status) {
        super(cause);
        this.status = status;
    }

    public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int status) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.status = status;
    }
}
