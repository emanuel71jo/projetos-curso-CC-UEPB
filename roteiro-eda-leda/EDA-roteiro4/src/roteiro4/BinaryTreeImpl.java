package roteiro4;

public class BinaryTreeImpl<T extends Comparable<T>> implements BinaryTreeIF<T>{
	
	private NodoBinaryTree<T> root = null;
	
	@Override
	public NodoBinaryTree<T> search(T chave) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insert(NodoBinaryTree<T> element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public NodoBinaryTree<T> remove(T chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodoBinaryTree<T> successor(T chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NodoBinaryTree<T> predecessor(T chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String printInOrder(T chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String printPreOrder(T chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String printPostOrder(T chave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String printSortedValues(T chave) {
		// TODO Auto-generated method stub
		return null;
	}

	public NodoBinaryTree<T> getRoot() {
		return root;
	}

	public void setRoot(NodoBinaryTree<T> root) {
		this.root = root;
	}
}
