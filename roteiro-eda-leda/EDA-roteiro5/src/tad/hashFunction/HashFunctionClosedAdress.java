package tad.hashFunction;

public interface HashFunctionClosedAdress<T> extends HashFunction<T> {
	
	public int hash(T element);

}
