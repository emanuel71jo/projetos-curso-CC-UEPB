package roteiro3;

public class Produto implements Comparable<Produto>{
    private String descricao, codProduto;
    private double precoProduto;

    public Produto(String descricao, String codProduto, double precoProduto) {
            this.descricao = descricao;
            this.codProduto = codProduto;
            this.precoProduto = precoProduto;
    }

    public String getDescricao() {
            return descricao;
    }

    public void setDescricao(String descricao) {
            this.descricao = descricao;
    }

    public String getCodProduto() {
            return codProduto;
    }

    public void setCodProduto(String codProduto) {
            this.codProduto = codProduto;
    }

    public double getPrecoProduto() {
            return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
            this.precoProduto = precoProduto;
    }
    
    @Override
    public int compareTo(Produto o) {
        return this.descricao.compareTo(o.descricao);
    }

    @Override
    public String toString() {
        return "Produto{" + "descricao=" + descricao + ", codProduto=" + codProduto + ", precoProduto=" + precoProduto + '}';
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        return true;
    }

	
}
