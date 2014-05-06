package pvm.vm.exceptions;

public class NoHeapSpaceException extends Exception {
	private static final long serialVersionUID = 4911265575550022215L;

	public NoHeapSpaceException() {
		super();
	}

	public NoHeapSpaceException(String message) {
		super(message);
	}
}