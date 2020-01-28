/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netflixdeLivros;

/**
 *
 * @author Dijay, João e Pedro.
 */
public interface Funcionalidades {
	/***
	 * Metodo que realiza cadastro.
	 * 
	 * @return valores booleanos caso o cadastro realizado de maneira correta retorna true.
	 */
    public boolean create();
    /**
     * Metodo que exibe todos dados na rtela.
     * 
     * @param cod Codigo do objeto que desejo imprimir
     * @return
     */
    public boolean read(String cod);
    
    /***
     * Metodo que remove um objeto.
     * 
     * @return valores booleanos caso o a remocao do objeto seja realizada de maneira correta retorna true.
     */
    public boolean delete();
}