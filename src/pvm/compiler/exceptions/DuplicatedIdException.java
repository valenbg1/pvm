package pvm.compiler.exceptions;

public class DuplicatedIdException extends Exception {
	private static final long serialVersionUID = 5353530700376034967L;
	
	private String id;
	private int row;
	
	public DuplicatedIdException(String id, int row) {
		this.id = id;
		this.row = row;
	}

	public String getId() {
		return id;
	}

	public int getRow() {
		return row;
	}
}