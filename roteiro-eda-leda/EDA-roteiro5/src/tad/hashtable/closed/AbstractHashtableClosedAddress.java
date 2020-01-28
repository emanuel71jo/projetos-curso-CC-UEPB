package tad.hashtable.closed;

import java.util.LinkedList;

import tad.hashFunction.HashFunctionClosedAdress;
import tad.hashtable.AbstractHashtable;
import tad.hashtable.util.Util;
import tad.listasEncadeadas.ListaEncadeadaIF;
import tad.listasEncadeadas.ListaEncadeadaImpl;

public abstract class AbstractHashtableClosedAddress<T> extends AbstractHashtable<T> {

	public AbstractHashtableClosedAddress() {
		super();
	}

	@Override
	protected void initiateInternalTable(int size) {

		this.table = new LinkedList[size];//TODO: usar a sua lista simplesmente encadeada aqui!!!
		//this.table = Util.<LinkedList>makeArray(size);
		for(int i = 0; i < size; i++)
			table[i] = new LinkedList<T>();
		
		//this.table = new ListaEncadeadaImpl[size];
		//this.table = Util.<ListaEncadeadaIF<T>>makeArray(size);
		//for(int i = 0; i < size; i++)
		//	table[i] = new ListaEncadeadaImpl<T>();
		
	}
	
	public HashFunctionClosedAdress<T> getHashFunction(){
		return (HashFunctionClosedAdress<T>) super.hashFunction;
	}
	
	@Override
	public LinkedList[] getTable() {
		return (LinkedList[]) super.table;
	}
}
