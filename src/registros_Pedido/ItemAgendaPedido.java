package registros_Pedido;

public class ItemAgendaPedido {

    public int id;
    
    public String cpf;
    public Double valor;
    public Integer numeroPedido;
    public Integer quantidade;
    public String data;
    public Integer codlivro;
    public String descricao;

    public Integer getNumeroPedido() {
        return numeroPedido;
    }

    public String getDescProduto() {
        return descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    
    public Integer getCodLivro() {
        return codlivro;
    }

    public String  getCpf() {
        return cpf;
    }

    public Double getValor() {
        return valor;
    }

    public String getData() {
        return data;
    }
    
}
