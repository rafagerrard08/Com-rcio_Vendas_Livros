package registros;

/**
 * @author Thiago Gilabel de Souza
 */
public class ItemAgenda {

    public int id;
    public String nome;
   public Integer codlivro; 
   public String categoria;
   public String descricao;
   public String codbarras;
    public String autor;
    public Integer quantidade;
    public Double valor;
    public String editora;

    public String getNome() {
        return nome;
    }

    public String getCodbarras() {
        return codbarras;
    }
     public Integer getCodLivro() {
        return codlivro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getCategoria() {
        return categoria;
    }
    public String getDescricao() {
        return descricao;
    }
    public Double getValor() {
        return valor;
    }

    public String getEditora() {
        return editora;
    }

    public String getAutor() {
        return autor;
}
}