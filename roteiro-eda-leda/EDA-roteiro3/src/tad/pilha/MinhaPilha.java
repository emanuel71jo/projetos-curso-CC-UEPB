package tad.pilha;

import tad.fila.FilaCheiaException;

public class MinhaPilha implements PilhaIF<Integer> {
	
	private int TAM = 5;
	private Integer array[];
	private Integer topo = null;
	private int indiceTopo = 0, posLivre = 0;
	
	public MinhaPilha() {
		this.array = new Integer[this.TAM];
	}
	
	public MinhaPilha(int tam) {
		this.TAM = tam;
		this.array = new Integer[tam];		
	}
	
	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		if(!this.isFull()) {
			if(!this.isEmpty())
				this.indiceTopo++;
			this.array[this.posLivre++] = item;
			this.topo = this.array[this.indiceTopo];
		}else {
			throw new PilhaCheiaException();
		}
	}


	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		if(!this.isEmpty()) {
			Integer objSai = this.topo;
			this.array[this.indiceTopo--] = null;
			if(this.isEmpty())
				this.indiceTopo++;
			this.topo = this.array[this.indiceTopo];
			this.posLivre--;
			return objSai;
		}else {
			throw new PilhaVaziaException();
		}
	}

	@Override
	public Integer topo() {
		if(this.isEmpty())
			return null;			
		return this.topo;
	}

	@Override
	public PilhaIF<Integer> multitop(int k) {
		throw new UnsupportedOperationException("Implementar");
	}

	@Override
	public boolean isFull() {
		return this.posLivre == this.TAM;
	}

	@Override
	public boolean isEmpty() {
		return this.array[0] == null;
	}


}
