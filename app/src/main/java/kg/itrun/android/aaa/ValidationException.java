package kg.itrun.android.aaa;

/**
 * Exception class for throw on input
 * field validation error.
 */
public class ValidationException extends Exception {
    private int viewId;

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(int viewId, String message) {
        super(message);
        this.viewId = viewId;
    }

    public int getViewId() {
        return viewId;
    }

    public void setViewId(int viewId) {
        this.viewId = viewId;
    }
}
