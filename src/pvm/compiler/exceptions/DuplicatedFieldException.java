package pvm.compiler.exceptions;

public class DuplicatedFieldException extends Exception {
	private static final long serialVersionUID = 4065545763106239033L;
	
	private String field;
	
	public DuplicatedFieldException(String field) {
		this.field = field;
	}
	
	@Override
	public String getMessage() {
		return field;
	}
}