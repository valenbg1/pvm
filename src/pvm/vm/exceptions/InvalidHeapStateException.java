package pvm.vm.exceptions;

public class InvalidHeapStateException extends Exception {
	private static final long serialVersionUID = 6893116326901947426L;

	public InvalidHeapStateException() {
		super();
	}

	public InvalidHeapStateException(String message) {
		super(message);
	}
}