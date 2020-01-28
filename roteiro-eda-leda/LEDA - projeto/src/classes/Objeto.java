package classes;

public class Objeto implements Comparable<Objeto>{
	public String senha, digito;
	public int ocorrencia;
	
	public Objeto(String[] obj) {
		this.setDigito(obj[0]);
		this.setOcorrencia(obj[1]);
		this.setSenha(obj[2]);
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(String ocorrencia) {
		this.ocorrencia = Integer.parseInt(ocorrencia);
	}

	public String getDigito() {
		return digito;
	}

	public void setDigito(String digito) {
		this.digito = digito;
	}

	/**
	 * Comparando por Ocorrencia
	 */
	@Override
	public int compareTo(Objeto o) {
		if(this.ocorrencia == o.ocorrencia)
			return 0;
		if(this.ocorrencia < o.ocorrencia)
			return -1;
		return 1;
	}
	
	/**
	 * Comparando por ordem alfabetica da senha
	 */
	/*@Override
	public int compareTo(Objeto o) {
		return this.senha.compareTo(o.senha);
	}*/

}
