package pvm.compiler.exceptions;

public class UndeclaredIdException extends Exception {
	private static final long serialVersionUID = 627323466721812385L;
	
	private String id;
	
	public UndeclaredIdException(String id) {
		this.id = id;
	}
	
	@Override
	public String getMessage() {
		return id;
	}
}