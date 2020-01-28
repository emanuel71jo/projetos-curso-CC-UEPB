package adt.arvoreBinaria;

public class ArvoreBinariaImpl<T extends Comparable<T>> implements ArvoreBinariaIF<T>{

	private NoArvoreBinaria<T> raiz = null;
	
	public ArvoreBinariaImpl() {
		
	}
		
	public ArvoreBinariaImpl(T root) {
		this.raiz = new NoArvoreBinaria<T>(root);
	}
	
	@Override
	public NoArvoreBinaria<T> buscar(T chave) throws ExceptionBST {
		return buscar(chave, this.raiz);
	}

	private NoArvoreBinaria<T> buscar(T chave, NoArvoreBinaria<T> root)
			throws ExceptionBST {
		if(root == null)
			throw new ExceptionBST("Nó não encontrado");		
		if(root.compareTo(chave) == 0)
			return root;
		if(root.compareTo(chave) > 0) // Esquerdo
			return buscar(chave, root.getFilhoEsquerdo());
		return buscar(chave, root.getFilhoDireito());
	}
	
	@Override
	public void inserir(T chave) throws ExceptionBST {
		if(this.raiz == null)
			this.raiz = new NoArvoreBinaria<T>(chave);
		else if(this.raiz.compareTo(chave) > 0) { // Esquerdo
			if(this.raiz.getFilhoEsquerdo() == null) {
				this.raiz.setFilhoEsquerdo(new NoArvoreBinaria<T>(chave));
				this.raiz.getFilhoEsquerdo().setPai(this.raiz);
			}
			else
				inserir(chave, this.raiz.getFilhoEsquerdo());
		}else if(this.raiz.compareTo(chave) < 0){ // Direito
			if(this.raiz.getFilhoDireito() == null) {
				this.raiz.setFilhoDireito(new NoArvoreBinaria<T>(chave));
				this.raiz.getFilhoDireito().setPai(this.raiz);
			}
			else
				inserir(chave, this.raiz.getFilhoDireito());
		}else {
			throw new ExceptionBST("Nó já existe");
		}
	}

	private void inserir(T chave, NoArvoreBinaria<T> root) throws ExceptionBST {
		if(root.compareTo(chave) > 0) { // Esquerdo
			if(root.getFilhoEsquerdo() == null) {
				root.setFilhoEsquerdo(new NoArvoreBinaria<T>(chave));
				root.getFilhoEsquerdo().setPai(root);
			}
			else
				inserir(chave, root.getFilhoEsquerdo());
		}else if(root.compareTo(chave) < 0){ // Direito
			if(root.getFilhoDireito() == null) {
				root.setFilhoDireito(new NoArvoreBinaria<T>(chave));
				root.getFilhoDireito().setPai(root);
			}
			else
				inserir(chave, root.getFilhoDireito());
		}else {
			throw new ExceptionBST("Nó já existe");
		}
	}

	@Override
	public NoArvoreBinaria<T> remover(T chave) throws ExceptionBST, ArvoreVaziaException {
		NoArvoreBinaria<T> root = buscar(chave);
		NoArvoreBinaria<T> aux = root;
		NoArvoreBinaria<T> right = null;
		NoArvoreBinaria<T> left = null;
		
		if(root == null)
			throw new ExceptionBST(null);
		
		if(root.getFilhoEsquerdo() == null || root.getFilhoDireito() == null)
			left = root;
		else
			left = sucessor(root.getChave());
		if(left.getFilhoEsquerdo() != null)
			right = left.getFilhoEsquerdo();
		else
			right = left.getFilhoDireito();
		if(right != null)
			right.setPai(left.getPai());
		if(left.getPai() == null)
			raiz = right;
		else if(left == left.getPai().getFilhoEsquerdo())
			left.getPai().setFilhoEsquerdo(right);
		else
			left.getPai().setFilhoDireito(right);
		if(left != root)
			root.setChave(left.getChave());
		return aux;
	}

	@Override
	public NoArvoreBinaria<T> sucessor(T chave) throws ExceptionBST, ArvoreVaziaException {
		NoArvoreBinaria<T> element = buscar(chave).getFilhoDireito();
		if(NodeEmpty(element))
			return null;
		if(NodeEmpty(element.getFilhoEsquerdo()))
			return element;
		return minimo(element);
	}

	private boolean NodeEmpty(NoArvoreBinaria<T> element) {
		return element == null;
	}

	@Override
	public NoArvoreBinaria<T> predecessor(T chave) throws ExceptionBST, ArvoreVaziaException {
		NoArvoreBinaria<T> element = buscar(chave).getFilhoEsquerdo();
		if(NodeEmpty(element))
			return null;
		if(NodeEmpty(element.getFilhoDireito()))
			return element;
		return maximo(element);
	}

	@Override
	public String imprimeEmOrdem(T chave) throws ExceptionBST {
		String str = "";
		str = readInOrder(chave, buscar(chave));
		return "[" + str + "]";
	}
	
	private String readInOrder(T chave, NoArvoreBinaria<T> root2) {
		if(root2 == null)
			return "";
		String str = "";
		if(root2.getFilhoEsquerdo() != null) {
			str += (str.isEmpty() ? "" : ", ");
			str += readInOrder(root2.getFilhoEsquerdo().getChave(), root2.getFilhoEsquerdo());
		}
		str += (str.isEmpty() ? "" : ", ") + root2.getChave();
		if(root2.getFilhoDireito() != null) {
			str += (str.isEmpty() ? "" : ", ");
			str += readInOrder(root2.getFilhoDireito().getChave(), root2.getFilhoDireito());
		}
		return str;
		
	}

	@Override
	public String imprimePreOrdem(T chave) throws ExceptionBST {
		String str = "";
		str = readPreOrder(chave, buscar(chave));
		return "[" + str + "]";
	}
	
	private String readPreOrder(T chave, NoArvoreBinaria<T> root2) {
		if(root2 == null)
			return "";
		String str = "" + root2.getChave();
		if(root2.getFilhoEsquerdo() != null)
			str += (str.isEmpty() ? "" : ", ") + 
			readPreOrder(root2.getFilhoEsquerdo().getChave(), root2.getFilhoEsquerdo());
		if(root2.getFilhoDireito() != null)
			str += (str.isEmpty() ? "" : ", ") +
			readPreOrder(root2.getFilhoDireito().getChave(), root2.getFilhoDireito());
		return str;
		
	}

	@Override
	public String imprimePosOrdem(T chave) throws ExceptionBST {
		String str = "";
		str = readPostOrder(chave, buscar(chave));
		return "[" + str + "]";
	}
	
	private String readPostOrder(T chave, NoArvoreBinaria<T> root2) {
		if(root2 == null)
			return "";
		String str = "";
		if(root2.getFilhoEsquerdo() != null) {
			str += (str.isEmpty() ? "" : ", ");
			str += readPostOrder(root2.getFilhoEsquerdo().getChave(), root2.getFilhoEsquerdo());
		}
		if(root2.getFilhoDireito() != null) {
			str += (str.isEmpty() ? "" : ", ");
			str += readPostOrder(root2.getFilhoDireito().getChave(), root2.getFilhoDireito());
		}
		str += (str.isEmpty() ? "" : ", ") + root2.getChave();
		return str;
	}

	@Override
	public String imprimeValoresOrdenados(T chave) throws ExceptionBST {
		return imprimeEmOrdem(chave);
	}

	@Override
	public NoArvoreBinaria<T> minimo(T chave) throws ArvoreVaziaException, ExceptionBST {
		return minimo(this.raiz);
	}
	public NoArvoreBinaria<T> minimo(NoArvoreBinaria<T> node) {
		if(NodeEmpty(node.getFilhoEsquerdo()))
			return node;
		return minimo(node.getFilhoEsquerdo());
	}

	@Override
	public NoArvoreBinaria<T> maximo(T chave) throws ArvoreVaziaException, ExceptionBST {
		return maximo(this.raiz);
	}

	public NoArvoreBinaria<T> maximo(NoArvoreBinaria<T> root2) {
		if(NodeEmpty(root2.getFilhoDireito()))
			return root2;
		return maximo(root2.getFilhoDireito());
	}


	public NoArvoreBinaria<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;
	}

	@Override
	public int tamanho() throws ExceptionBST {
		if(this.raiz == null)
			return 0;
		String str = this.imprimeEmOrdem(raiz.getChave());
		return str.split(", ").length;
	}


	@Override
	public boolean vazio() {
		return NodeEmpty(raiz);
	}

	@Override
	public int altura() {
		if(this.raiz == null || raiz.getFilhoDireito() == null && raiz.getFilhoEsquerdo() == null)
			return 0;
		return Math.max(altura(this.raiz.getFilhoDireito()), altura(raiz.getFilhoEsquerdo()));
	}

	protected int altura(NoArvoreBinaria<T> raiz2) {
		if(raiz2 == null)
			return 0;
		if((raiz2.getFilhoEsquerdo() == null && raiz2.getFilhoDireito() == null))
			return 1;
	   	if (altura(raiz2.getFilhoEsquerdo()) > altura(raiz2.getFilhoDireito())) 
	   		return ( 1 + altura(raiz2.getFilhoEsquerdo()));
	   	if (raiz2.getFilhoDireito() == null)
			return 1 + altura(raiz2.getFilhoEsquerdo());
		return 1 + Math.max(altura(raiz2.getFilhoEsquerdo()), 
				altura(raiz2.getFilhoDireito()));
	   	
	}
}
	   	
	   	
	   	
	   	
	   	