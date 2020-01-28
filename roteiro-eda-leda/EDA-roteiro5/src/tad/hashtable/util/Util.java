package tad.hashtable.util;

public class Util {
	
	public static <T> T[] makeArray(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[size];
		return array;
	}
	
	public static boolean isPrime(int value) {
		return false;
	}

}
