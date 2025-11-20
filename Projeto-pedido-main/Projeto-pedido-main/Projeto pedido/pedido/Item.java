public class Item {

    private Integer qde;
    private Produto produto;
   

    public Integer getQde() {
        return qde;
    }

    public void setQde(Integer qde) {
        this.qde = qde;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Float getValorTotal() {
        return produto.getValor() * getQde();
    }
}
