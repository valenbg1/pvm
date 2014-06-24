package pvm.compiler.exceptions;

public class DuplicatedFieldException extends Exception {
	private static final long serialVersionUID = 4065545763106239033L;
	
	private String field;
	private int row;
	
	public DuplicatedFieldException(String field, int row) {
		this.field = field;
		this.row = row;
	}

	public String getField() {
		return field;
	}

	public int getRow() {
		return row;
	}
}