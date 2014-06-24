package pvm.compiler.exceptions;

public class NodeTypeErrorException extends Exception {
	private static final long serialVersionUID = -3641556605861375091L;
	
	private String node_t;
	
	public NodeTypeErrorException(String node_t) {
		this.node_t = node_t;
	}
	
	@Override
	public String getMessage() {
		return node_t;
	}
}