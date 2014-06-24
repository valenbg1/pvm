package pvm.compiler.exceptions;

public class DuplicatedIdException extends Exception {
	private static final long serialVersionUID = 5353530700376034967L;
	
	private String id;
	
	public DuplicatedIdException(String id) {
		this.id = id;
	}
	
	@Override
	public String getMessage() {
		return id;
	}
}