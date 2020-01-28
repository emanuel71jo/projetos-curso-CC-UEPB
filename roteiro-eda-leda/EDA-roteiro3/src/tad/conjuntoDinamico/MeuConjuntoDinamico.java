package tad.conjuntoDinamico;

public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer>{
	private Integer[] array;
	private int posLivre = 0, TAM = 5;
	private Integer minimum = null, maximum = null;
	
	public MeuConjuntoDinamico() {
		this.array = new Integer[this.TAM];
	}
	
	public MeuConjuntoDinamico(int tam) {
		this.array = new Integer[tam];
		this.TAM = tam;
	}
	
	
	@Override
	public void inserir(Integer item) {
		if(isEmpty()) {
			this.minimum = item;
			this.maximum = item;
		}else {
			if(item.compareTo(this.minimum) < 0)
				this.minimum = item;
			else if(item.compareTo(this.maximum) > 0)
				this.maximum = item;
		}
		if(isFull())
			aumentaArray();
		this.array[posLivre++] = item;		
	}

	private boolean isEmpty() {
		return this.posLivre == 0;
	}

	private void aumentaArray() {
		Integer aux[] = new Integer[++this.TAM];
		for(int i = 0; i < this.TAM - 1; i ++) {
			aux[i] = this.array[i];
		}
		this.array = aux;
	}

	private boolean isFull() {
		return this.TAM == this.posLivre;
	}

	@Override
	public Integer remover(Integer item) throws Exception {
		Integer objSai = null;
		for(int i = 0; i < this.posLivre; i++) {
			if(this.array[i].equals(item)) {
				objSai = this.array[i];
				organizarArray(i);
				this.posLivre--;
				break;
			}
				
		}
		if(objSai == null)
			throw new Exception();
		return objSai;	
	}

	private void organizarArray(int i) {
		for(int j = i; j < this.posLivre; j++) {	
			this.array[j] = this.array[j + 1];
		}
	}

	@Override
	public Integer predecessor(Integer item) throws Exception {
		for(int i = 0; i < this.posLivre; i++) {
			if(this.array[i].equals(item)) {
				if(i == 0)
					return null;
				return this.array[i - 1];
			}
		}
		throw new Exception();
	}

	@Override
	public Integer sucessor(Integer item) throws Exception {
		for(int i = 0; i < this.posLivre; i++) {
			if(this.array[i].equals(item)) {
				if(this.posLivre == this.TAM)
					throw new Exception();
				return this.array[i + 1];
			}
		}
		throw new Exception();
	}

	@Override
	public int tamanho() {
		return this.posLivre;
	}

	@Override
	public Integer buscar(Integer item) throws Exception {
		for(int i = 0; i < this.posLivre; i++) {
			if(this.array[i].equals(item))
				return this.array[i];
		}
		throw new Exception();
	}

	@Override
	public Integer minimum() throws Exception {
		if(isEmpty())
			throw new Exception();
		return this.minimum;
	}

	@Override
	public Integer maximum() throws Exception {
		if(isEmpty())
			throw new Exception();
		return this.maximum;
	}

}
