package utils.exceptions;

public class EmptyValueException extends Exception {
	private static final long serialVersionUID = 1L;

	private String message;

	public EmptyValueException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
