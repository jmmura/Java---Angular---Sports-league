package be.JM.league.exception;

public class FormValidationException extends RuntimeException {
    public FormValidationException(String message) {
        super(message);
    }
}
