package pvm.compiler.exceptions;

public class UndeclaredIdException extends Exception {
	private static final long serialVersionUID = 627323466721812385L;
	
	private String id;
	private int row;
	
	public UndeclaredIdException(String id, int row) {
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