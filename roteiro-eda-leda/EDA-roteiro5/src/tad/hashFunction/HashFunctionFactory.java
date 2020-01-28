package tad.hashFunction;

public class HashFunctionFactory {

	public static HashFunction createHashFunction(HashFunctionClosedAddressMethod method, int tableSize) {
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
