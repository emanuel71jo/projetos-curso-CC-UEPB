package adt.avltree;

import adt.arvoreBinaria.ArvoreBinariaImpl;
import adt.arvoreBinaria.ArvoreVaziaException;
import adt.arvoreBinaria.ExceptionBST;
import adt.arvoreBinaria.NoArvoreBinaria;

public class AVLTreeImpl<T extends Comparable<T>> extends ArvoreBinariaImpl<T> implements AVLTree<T>{

	// TODO Do not forget: you must override the methods insert and remove
	// conveniently.

	// AUXILIARY
	protected int calculateBalance(NoArvoreBinaria<T> node) {
		if(node == null)
			return 0;
		return altura(node.getFilhoDireito()) - altura(node.getFilhoEsquerdo());
	}

	// AUXILIARY
	protected NoArvoreBinaria<T> rebalance(NoArvoreBinaria<T> node) {
		if(calculateBalance(node) == 2) {
			if(calculateBalance(node.getFilhoEsquerdo()) > 0)
				node = rotacaoDireta(node);
			else
				node = rotacaoDuplaDireita(node);
		}else if(calculateBalance(node) == -2) {
			if(calculateBalance(node.getFilhoDireito()) < 0)
				node = rotacaoEsquerda(node);
			else
				node = rotacaoDuplaEsquerda(node);
		}
		return node;
	}

	private NoArvoreBinaria<T> rotacaoDuplaDireita(NoArvoreBinaria<T> node) {
		node.setFilhoDireito(rotacaoDireta(node.getFilhoDireito()));
		return rotacaoEsquerda(node);
	}

	private NoArvoreBinaria<T> rotacaoDuplaEsquerda(NoArvoreBinaria<T> node) {
		node.setFilhoEsquerdo(rotacaoEsquerda(node.getFilhoEsquerdo()));
		return rotacaoDireta(node);
	}

	private NoArvoreBinaria<T> rotacaoEsquerda(NoArvoreBinaria<T> node) {
		NoArvoreBinaria<T> pivo = node.getFilhoDireito();
		pivo.setPai(node.getPai());
		node.setFilhoDireito((pivo.getFilhoEsquerdo()));
		pivo.setFilhoEsquerdo(node);
		node.setPai(pivo);
		return pivo;
	}

	private NoArvoreBinaria<T> rotacaoDireta(NoArvoreBinaria<T> node) {
		NoArvoreBinaria<T> pivo = node.getFilhoEsquerdo();
		pivo.setPai(node.getPai());
		node.setFilhoEsquerdo(pivo.getFilhoDireito());
		pivo.setFilhoDireito(node);
		node.setPai(pivo);
		return pivo;
	}

	// AUXILIARY
	protected void rebalanceUp(NoArvoreBinaria<T> node) {
		// TODO: Método não implementando pois foi discutido em sala que não seria necessario.
	}
	
	@Override
	public void inserir(T chave) throws ExceptionBST {
		super.inserir(chave);
		this.rebalance(super.getRaiz());
	}
	
	@Override
	public NoArvoreBinaria<T> remover(T chave) throws ExceptionBST, ArvoreVaziaException{
		NoArvoreBinaria<T> node = super.remover(chave);
		if(tamanho() > 2)
			setRaiz(rebalance(node.getPai()));
		return node;
	}
}


















