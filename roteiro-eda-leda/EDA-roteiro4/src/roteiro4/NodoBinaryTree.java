package roteiro4;

public class NodoBinaryTree<T extends Comparable<T>>{
	
	private NodoBinaryTree<T> left = null;
	private NodoBinaryTree<T> right = null;
	private NodoBinaryTree<T> dad = null;
	private T chave = null;
	
	public NodoBinaryTree(T chave) {
		this.setChave(chave);
	}
	
	public NodoBinaryTree<T> getLeft() {
		return left;
	}
	public void setLeft(NodoBinaryTree<T> left) {
		this.left = left;
	}
	public NodoBinaryTree<T> getRight() {
		return right;
	}
	public void setRight(NodoBinaryTree<T> right) {
		this.right = right;
	}
	public NodoBinaryTree<T> getRoot() {
		return dad;
	}
	public void setRoot(NodoBinaryTree<T> root) {
		this.dad = root;
	}
	public T getChave() {
		return chave;
	}
	public void setChave(T chave) {
		this.chave = chave;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chave == null) ? 0 : chave.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodoBinaryTree<T> other = (NodoBinaryTree<T>) obj;
		if (chave == null) {
			if (other.chave != null)
				return false;
		} else if (!chave.equals(other.chave))
			return false;
		return true;
	}

	
}
