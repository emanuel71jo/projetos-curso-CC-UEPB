package adt.arvoreBinaria;

public class NoArvoreBinaria<T extends Comparable<T>> implements Comparable<T>{

	private T chave;
	private NoArvoreBinaria<T> pai;
	private NoArvoreBinaria<T> filhoEsquerdo;
	private NoArvoreBinaria<T> filhoDireito;
	
	public NoArvoreBinaria() {
		this.chave = null;
		this.pai = null;
		this.filhoEsquerdo = null;
		this.filhoDireito = null;
	}
	
	public NoArvoreBinaria(T chave) {
		this.chave = chave;
		this.pai = null;
		this.filhoEsquerdo = null;
		this.filhoDireito = null;
	}
	
	public NoArvoreBinaria(T chave, NoArvoreBinaria<T> pai, NoArvoreBinaria<T> filhoEsquerdo,
			NoArvoreBinaria<T> filhoDireito) {
		this.chave = chave;
		this.pai = pai;
		this.filhoEsquerdo = filhoEsquerdo;
		this.filhoDireito = filhoDireito;
	}

	public T getChave() {
		return chave;
	}

	public void setChave(T chave) {
		this.chave = chave;
	}

	public NoArvoreBinaria<T> getPai() {
		return pai;
	}

	public void setPai(NoArvoreBinaria<T> pai) {
		this.pai = pai;
	}

	public NoArvoreBinaria<T> getFilhoEsquerdo() {
		return filhoEsquerdo;
	}

	public void setFilhoEsquerdo(NoArvoreBinaria<T> filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}

	public NoArvoreBinaria<T> getFilhoDireito() {
		return filhoDireito;
	}

	public void setFilhoDireito(NoArvoreBinaria<T> filhoDireito) {
		this.filhoDireito = filhoDireito;
	}
	
	public boolean estahVazio() {
		return this.getChave() == null;
	}
	
	public boolean ehFolha() {
		return !estahVazio() && this.getFilhoEsquerdo() != null && this.getFilhoDireito() != null;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null && this.chave == null)
			return true;
		else if(obj == null && this.chave != null)
			return false;
		@SuppressWarnings("unchecked")
		NoArvoreBinaria<T> aComparar = (NoArvoreBinaria<T>)obj;
		
		if (this.getChave().equals(aComparar.getChave()) 
			&& this.getFilhoDireito().equals(aComparar.getFilhoDireito()) 
			&& this.getFilhoEsquerdo().equals(aComparar.getFilhoEsquerdo()) ) {
					
			return true;
					
		}
		
		return false;
	}

	@Override
	public String toString() {
		String nil = "NIL";
		return ( this.estahVazio() ? nil : chave.toString());
	}

	@Override
	public int compareTo(T o) {
		return this.chave.compareTo(o);
	}
	
	
}
