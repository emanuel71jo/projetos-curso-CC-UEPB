package roteiro4;

public interface BinaryTreeIF<T extends Comparable<T>> {
	
	public NodoBinaryTree<T> search (T chave);
	
	public void insert (NodoBinaryTree<T> element);
	
	public NodoBinaryTree<T> remove (T chave);
	
	public NodoBinaryTree<T> successor (T chave);
	
	public NodoBinaryTree<T> predecessor (T chave);
	
	public String printInOrder (T chave);
	
	public String printPreOrder (T chave);
	
	public String printPostOrder (T chave);
	
	public String printSortedValues (T chave);
	
}
