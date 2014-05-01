package pvm.vm.exceptions;

public class InvalidMemoryPosException extends Exception {
	private static final long serialVersionUID = 5598908315219230911L;

	public InvalidMemoryPosException() {
		super();
	}

	public InvalidMemoryPosException(String message) {
		super(message);
	}
}