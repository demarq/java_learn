package lessons.lesson2.exceptions;

public class OverdraftLimitViolationException extends RuntimeException {
    public OverdraftLimitViolationException(String message) {
        super(message);
    }
}
