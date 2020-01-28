package adt.hashtable.hashfunction;

import adt.hashtable.hashfunction.closed.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.closed.HashFunctionDivisionMethod;
import adt.hashtable.hashfunction.closed.HashFunctionMultiplicationMethod;

/**
 * This class is responsible to create hash functions suitable to each kind of
 * hash table.
 * 
 * @author Adalberto
 *
 */
public class HashFunctionFactory<T> {

	@SuppressWarnings("rawtypes")
	public static HashFunction createHashFunction(
			HashFunctionClosedAddressMethod method, int tableSize) {
		HashFunction result = null;
		switch (method) {
		case DIVISION:
			result = new HashFunctionDivisionMethod(tableSize);
			break;
		case MULTIPLICATION:
			result = new HashFunctionMultiplicationMethod(tableSize);
			break;
		}

		return result;
	}

}
