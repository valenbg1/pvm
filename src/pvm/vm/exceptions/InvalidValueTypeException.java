package pvm.vm.exceptions;

public class InvalidValueTypeException extends Exception {
	private static final long serialVersionUID = 5003100092755254944L;
	
	public InvalidValueTypeException() {
		super();
	}

	public InvalidValueTypeException(String message) {
		super(message);
	}
}