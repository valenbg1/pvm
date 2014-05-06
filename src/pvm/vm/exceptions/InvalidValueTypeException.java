package pvm.vm.exceptions;

public class InvalidValueTypeException extends Exception {
	private static final long serialVersionUID = 6594598736578438664L;

	public InvalidValueTypeException() {
		super();
	}

	public InvalidValueTypeException(String message) {
		super(message);
	}
}