package registros;

/**
 * @author Thiago Gilabel de Souza
 */
public class ItemAgenda {

    public int id;
    public String nome;
   public String descricao;
   public String codbarras;
    public String autor;
    public String quantidade;
    public String valor;
    public String editora;

    public String getNome() {
        return nome;
    }

    public String getCodbarras() {
        return codbarras;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public String getDescricao() {
        return descricao;
    }
    public String getValor() {
        return valor;
    }

    public String getEditora() {
        return editora;
    }

    public String getAutor() {
        return autor;
}
}