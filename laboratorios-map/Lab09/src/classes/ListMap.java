package classes;

public class ListMap implements MapIF{
	
	Lista lista;
	
	public ListMap() {
		lista = new Lista();
	}

	@Override
	public void clear() {
		lista.clear();		
	}

	@Override
	public boolean containsKey(int indice) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsValue(int elemento) {
		boolean resposta = lista.contains(elemento);
		if (resposta) {
			System.out.println(elemento + " estah presente.");
		}else {
			System.out.println(elemento + " nao estah presente.");
		}
		return resposta;
	}
	
	@Override
	public boolean equals(Object elemento) {
		boolean resposta = lista.equals(elemento);
		if (resposta) {
			System.out.println(elemento + " eh igual.");
		}else {
			System.out.println(elemento + " nao eh igual.");
		}
		return resposta;
	}

	@Override
	public int get(int indice) {
		try {
			int resposta = lista.get(indice);
			System.out.println("Elemento da chave " + indice + ": " + resposta);
			return resposta;			
		} catch (Exception e) {
			System.out.println("Chave " + indice + " nao existe: " + e);
			return -1;
		}
	}

	@Override
	public boolean isEmpty() {
		boolean resposta = lista.isEmpty();
		if (resposta) {
			System.out.println("Vazia.");
		}else {
			System.out.println("Nao vazia.");
		}
		return resposta;
	}

	@Override
	public void put(int indice, int elemento) {
		try {
			lista.add(indice, elemento);
			System.out.println(elemento + " adicionado.");
		} catch (Exception e) {
			System.out.println(elemento + " nao adicionado: " + e);
		}		
	}

	@Override
	public boolean remove(int indice) {
		try {
			lista.remove(indice);
			System.out.println("elemento de chave " + indice + " removido.");
			return true;			
		} catch (Exception e) {
			System.out.println("elemento de chave " + indice + " nao removido: " + e);
			return false;
		} 
	}

	@Override
	public int size() {
		int tamanho = lista.size();
		System.out.println("tamanho: " + tamanho);
		return tamanho;
	}

	@Override
	public Object[] values() {
		String arrayStr = "[";
		lista.toArray();
		for (Object i : lista.toArray()) {
			arrayStr += i + ", ";
		}
		arrayStr += "]";
		System.out.println(arrayStr);
		return lista.toArray();
	}


}
