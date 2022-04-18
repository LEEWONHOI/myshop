package leewonhoi.myshop.web.exception;

public class NotFoundItem extends RuntimeException {

    public NotFoundItem() {
        super();
    }

    public NotFoundItem(String message) {
        super(message);
    }

    public NotFoundItem(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundItem(Throwable cause) {
        super(cause);
    }

    protected NotFoundItem(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
