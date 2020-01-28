package Exceptions;

public class EmptyBinaryTreeException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4316409647991980214L;

	public EmptyBinaryTreeException() {
		super("Empty Binary Tree!");
	}
	
	public EmptyBinaryTreeException(String message) {
		super(message);
	}
	

}
