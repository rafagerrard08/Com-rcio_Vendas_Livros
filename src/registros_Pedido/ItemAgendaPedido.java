package registros_Pedido;

public class ItemAgendaPedido {

    public int id;
    public String numero;
    public String cpf;
    public Double valor;
    public String numeroPedido;
    public Integer quantidade;
    public String data;
    public String livro;
    public String descricao;

    public String getNumeroPedido() {
        return numeroPedido;
    }

    public String getDescProduto() {
        return descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String  getCpf() {
        return cpf;
    }

    public Double getValor() {
        return valor;
    }

    public String getLivro() {
        return livro;
    }

    public String getData() {
        return data;
    }
    
}
