package tad.hashFunction;

public class HashFunctionDivisionMethod<T> implements HashFunctionClosedAdress<T> {
	
	protected int tableSize;
	
	public HashFunctionDivisionMethod(int tableSize) {
		this.tableSize = tableSize;
	}

	@Override
	public int hash(T element) {
		int hashKey = -1;
		int key = element.hashCode();

		hashKey = (int) key % tableSize;

		return hashKey;
	}

}
