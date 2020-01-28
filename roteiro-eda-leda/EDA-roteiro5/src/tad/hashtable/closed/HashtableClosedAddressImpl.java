package tad.hashtable.closed;

import java.math.BigInteger;
import java.util.LinkedList;

import tad.hashFunction.HashFunction;
import tad.hashFunction.HashFunctionClosedAddressMethod;
import tad.hashFunction.HashFunctionFactory;

public class HashtableClosedAddressImpl<T> extends AbstractHashtableClosedAddress<T> {

	public HashtableClosedAddressImpl(int desiredSize, HashFunctionClosedAddressMethod method) {
		int realSize = desiredSize;

		if (method == HashFunctionClosedAddressMethod.DIVISION) {
			realSize = this.getUpperPrime(desiredSize); // real size must the
			// the immediate prime
			// above
		}
		initiateInternalTable(realSize);
		HashFunction function = HashFunctionFactory.createHashFunction(method, realSize);
		this.hashFunction = function;
	}

	private boolean inputIsValid(T element) {
		boolean validInput = true;

		if (element == null) {
			validInput = false;
		}

		return validInput;
	}

	@Override
	public void insert(T element) {
		if(inputIsValid(element)) {
			int hash = getHashFunction().hash(element);
			getTable()[hash].add(element);
			elements++;
			if(getTable()[hash].size() > 1)
				COLLISIONS++;
		}
	}

	@Override
	public void remove(T element) {
		if(inputIsValid(element)) {
			int hash = getHashFunction().hash(element);
			getTable()[hash].remove(element);
			elements--;
			if(getTable()[hash].size() > 0)
				COLLISIONS--;
		}
	}

	@Override
	public T search(T element) {
		if(inputIsValid(element)) {
			int hash = getHashFunction().hash(element);
			LinkedList ll = getTable()[hash];
			for (Object object : ll) {
				if(object.equals(element))
					return (T) object;
			}
		}
		return null;
	}

	@Override
	public int indexOf(T element) {
		if(inputIsValid(element)) {
			if(search(element) != null)
				return getHashFunction().hash(element);
		}
		return -1;
	}

	/**
	 * Retorna o número primo mais alto que o valor passado. Método útil para
	 * criação de tabelas hash calculo do tamanho.
	 * 
	 * @param size
	 * @return
	 */
	public int getUpperPrime(int size) {
		BigInteger b = new BigInteger(String.valueOf(size)); 
        return Integer.parseInt(b.nextProbablePrime().toString());
	}

}
