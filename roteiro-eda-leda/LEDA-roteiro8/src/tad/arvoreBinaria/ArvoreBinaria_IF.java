package tad.arvoreBinaria;

public interface ArvoreBinaria_IF<T extends Comparable<T>> {
	
	public NoArvoreBinaria<T> buscar(T chave) throws ExceptionBST;
	public void inserir(T chave) throws ExceptionBST;
	public NoArvoreBinaria<T> remover(T chave) throws ExceptionBST, ArvoreVaziaException;
	public NoArvoreBinaria<T> sucessor(T chave) throws ExceptionBST, ArvoreVaziaException;
	public NoArvoreBinaria<T> predecessor(T chave) throws ExceptionBST, ArvoreVaziaException;
	public String imprimeEmOrdem(T chave) throws ExceptionBST;
	public String imprimePreOrdem(T chave) throws ExceptionBST;
	public String imprimePosOrdem(T chave) throws ExceptionBST;
	public String imprimeValoresOrdenados(T chave) throws ExceptionBST;
	public NoArvoreBinaria<T> minimo(T chave) throws ArvoreVaziaException, ExceptionBST;
	public NoArvoreBinaria<T> maximo(T chave) throws ArvoreVaziaException, ExceptionBST;
}