package lessons.lesson2.exceptions;

public class InvalidAmountException extends RuntimeException{
    public InvalidAmountException(String s) {
        super(s);
    }
}
