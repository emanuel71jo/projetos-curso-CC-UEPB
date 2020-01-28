package tad.fila;

public class MinhaFila implements FilaIF<Integer> {
	
	private int TAM = 10;
	private Integer array[];
	private Integer cauda = null, cabeca = null;
	private int posLivre = 0, indiceCabeca = 0;
	
	public MinhaFila() {
		this.array = new Integer[this.TAM];
		this.cabeca = this.cauda = this.array[this.indiceCabeca];
	}
	
	public MinhaFila(int tam) {
		this.TAM = tam;
		this.array = new Integer[tam];
		this.cabeca = this.cauda = this.array[this.indiceCabeca];
	}
	
	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		if(!isFull()) {
			this.array[this.posLivre++] = item;
			this.cabeca = this.array[this.indiceCabeca];
			if(isFull()) {
				this.cauda = this.cabeca;
				this.posLivre = this.indiceCabeca;
			}
			else
				this.cauda = this.array[this.posLivre];	
		}else {
			throw new FilaCheiaException();
		}
	}

	@Override
	public Integer desenfileirar() throws FilaVaziaException {
		if(!isEmpty()) {
			Integer objSai = this.cabeca;
			this.array[this.indiceCabeca++] = null;
			if(isEmpty()) {
				this.indiceCabeca = this.posLivre = 0;
				this.cabeca = this.cauda = this.array[this.indiceCabeca];
			} else {
				if(this.indiceCabeca == this.array.length)
					this.indiceCabeca = 0;
				this.cabeca = this.array[this.indiceCabeca];				
			}
			return objSai;
		}else {
			throw new FilaVaziaException();
		}
	}

	@Override
	public Integer verificarCauda() {
		if(isEmpty())
			return null;
		return this.cauda;
	}

	@Override
	public Integer verificarCabeca() {
		return this.cabeca;
	}

	@Override
	public boolean isEmpty() {
		if(this.indiceCabeca == this.TAM)
			this.indiceCabeca = 0;
		return this.array[this.indiceCabeca] == null;
	}

	@Override
	public boolean isFull() {
		return !this.isEmpty() && 
				(this.indiceCabeca == this.posLivre ||
				this.posLivre == this.TAM);
	}

}
