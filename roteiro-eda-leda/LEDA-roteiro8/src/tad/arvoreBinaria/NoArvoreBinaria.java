package tad.arvoreBinaria;

public class NoArvoreBinaria<T extends Comparable<T>> implements Comparable<NoArvoreBinaria<T>>{

	private T chave;
	private NoArvoreBinaria<T> pai;
	private NoArvoreBinaria<T> filhoEsquerdo;
	private NoArvoreBinaria<T> filhoDireito;
	
	public NoArvoreBinaria() {
		this.pai = null;
		this.filhoDireito = null;
		this.filhoEsquerdo = null;
		this.chave = null;
	}
	
	public NoArvoreBinaria(T chave) {
		this.pai = null;
		this.filhoDireito = null;
		this.filhoEsquerdo = null;
		this.chave = chave;
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

	@Override
	public int compareTo(NoArvoreBinaria<T> o) {
		return this.chave.compareTo(o.getChave());
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
		NoArvoreBinaria other = (NoArvoreBinaria) obj;
		if (chave == null) {
			if (other.chave != null)
				return false;
		} else if (!chave.equals(other.chave))
			return false;
		return true;
	}
	
}
