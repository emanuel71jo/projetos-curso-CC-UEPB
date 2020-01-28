package Exceptions;

public class NodeNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3740948964626823643L;
	
	public NodeNotFoundException() {
		super("Node Not Found!");
	}
	
	public NodeNotFoundException(String message) {
		super(message);
	}

}
