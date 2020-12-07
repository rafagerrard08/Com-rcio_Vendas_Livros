
package JDBC;

import JDBC.ConnectionUtils;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import registros.ItemAgenda;
import registros_Cadastro.ItemAgendaCadastro;
import registros_Pedido.ItemAgendaPedido;


public class ItemAgendaDAO {

    public static void main(String args[]) {

        try {
                   
                        //inserirCliente();
                    //inserirLivro();
                    //inserirPedido();
                    //excluirCliente();
                   // listarPedido();
                    //listarCliente();
                    //excluirCliente();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
      public static void  inserirCliente(ItemAgendaCadastro item) throws Exception {
          

        String sql = "INSERT INTO cliente (cpf,RG,nome,Data_nascimento, Tel, Email, Rua,complemento,Numero,Cep,Cidade,Bairro) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection conexao = ConnectionUtils.getConnection();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, item.cpf);
            comando.setString(2, item.rg);
            comando.setString(3, item.nome);
            comando.setDate(4,java.sql.Date.valueOf(item.data));
            comando.setString(5, item.celular);
            comando.setString(6, item.email);
            comando.setString(7, item.endereco);
            comando.setString(8, item.complemento);
            comando.setInt(9, item.numero);
            comando.setString(10, item.cep);
            comando.setString(11, item.cidade);
            comando.setString(12, item.bairro);

            comando.execute();
                    } 
        
        finally {
            conexao.close();
        }
    }
   public static void inserirPedido(ItemAgendaPedido item) throws Exception {

        String sql = "INSERT INTO pedido (num_pedido,valor_pedido,Data_Compra,qtde, desc_produto, Cliente_CPF,  Livro_Cod_livro) "
                + "VALUES (?,?,?,?,?,?,?)";

       Connection conexao = ConnectionUtils.getConnection();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, item.numeroPedido);
            comando.setBigDecimal(2, BigDecimal.valueOf(item.valor));
            comando.setDate(3,java. sql.Date.valueOf(item.data));
            comando.setInt(4,item.quantidade);
            comando.setString(5, item.descricao);
            comando.setString(6,item.cpf);
            comando.setString(7,item.livro);
            
                    
            
            comando.execute();
                   } 
        
       finally {
           conexao.close();
        }
    }
   public static void inserirLivro(ItemAgenda item) throws Exception {

        String sql = "INSERT INTO livro ( Titulo_Livro,Categoria, Qtd_Livro, cod_barras,autor, editora, valor ,desc_produto) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        Connection conexao = ConnectionUtils.getConnection();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1,item.nome );
            comando.setString(2, item.categoria);
            comando.setInt(3, item.quantidade);
            comando.setString(4, item.codbarras);
            comando.setString(5,item.autor);
            comando.setString(6, item.editora);
            comando.setBigDecimal(7,  BigDecimal.valueOf(item.valor));            
            comando.setString(8, item.descricao);
              
            comando.execute();
                    } 
        
        finally {
            conexao.close();
        }
    }

    public static  List<ItemAgendaCadastro> listarCliente() throws Exception {
        String sql = "SELECT * FROM cliente";
        Connection conexao = ConnectionUtils.getConnection();
        List<ItemAgendaCadastro> listaCadastro = new ArrayList();
        try {
            PreparedStatement comando = conexao.prepareStatement (sql);
            
            ResultSet dados = comando.executeQuery();
            
            while (dados.next()){
                ItemAgendaCadastro item  = new ItemAgendaCadastro();
                
                item.cpf= dados.getString("CPF");
                item.rg = dados.getString("RG");
                item.nome = dados.getString("Nome");
                item.data = dados.getString("Data_nascimento".toString());
                item.celular = dados.getString("Tel");
                item.email = dados.getString("Email");
                item.endereco= dados.getString("Rua");
                item.complemento = dados.getString("complemento");
                item.numero=dados.getInt("numero");
               item.cep= dados.getString("Cep");
                item.cidade = dados.getString("cidade");
                item.bairro = dados.getString("bairro");
            
                            listaCadastro.add(item);                            

                }
        }  
        finally {
            conexao.close();
        }
        return listaCadastro;
    }
    public  static   List<ItemAgenda> listarLivro() throws Exception {
        String sql = "SELECT * FROM livro";
                
        Connection conexao = ConnectionUtils.getConnection();
        List<ItemAgenda> listarLivros = new ArrayList();
        try {
            PreparedStatement comando = conexao.prepareStatement (sql);
            
            ResultSet dados = comando.executeQuery();
            
            while (dados.next()){
                ItemAgenda item = new ItemAgenda();
                item.nome = dados.getString("Titulo_Livro");
                item.valor = dados.getDouble("valor");
                item.codlivro = dados.getInt("Cod_Livro");
                item.categoria = dados.getString("Categoria");
                item.quantidade = dados.getInt("Qtd_livro");
                item.codbarras = dados.getString("cod_barras");
                item.autor = dados.getString("autor");
                item.editora = dados.getString("editora");
                item.descricao = dados.getString("desc_produto");
                
                listarLivros.add(item);
                }
        }
        finally {
            conexao.close();
        }
        return listarLivros;
    }
    public  static List<ItemAgendaPedido> listarPedidos()throws Exception {
        String sql = "SELECT * FROM pedido";
    
        Connection conexao = ConnectionUtils.getConnection();
        List<ItemAgendaPedido>listarPedido = new ArrayList();
        try {
            PreparedStatement comando = conexao.prepareStatement (sql);
            
            ResultSet dados = comando.executeQuery();
            
            while (dados.next()){
                ItemAgendaPedido item = new ItemAgendaPedido();
                
                String num_pedido = dados.getString("num_pedido");
                String valor_pedido = dados.getString("valor_pedido");
                Date  Data_Compra = dados.getDate("Data_Compra");
                String qtde = dados.getString("qtde");
                String desc_produto = dados.getString("Qtd_livro");
                String cod_livro = dados.getString("cod_livro");
                String cpf = dados.getString("CPF");
                
                listarPedido.add(item);
                
                }
        }
        finally {
            conexao.close();
        }
        return listarPedido;
    }
    
    public  static   List<ItemAgendaCadastro> pesquisarCliente(String cpf) throws Exception {
        String sql = "SELECT * FROM Cliente where cpf LIKE ?";
                
        Connection conexao = ConnectionUtils.getConnection();
        
        List<ItemAgendaCadastro> listarClientes = new ArrayList();
        
        try {
            PreparedStatement comando = conexao.prepareStatement (sql);
            comando.setString(1,"%"+ cpf +"%");
            ResultSet dados = comando.executeQuery();
            
            while (dados.next()){
                ItemAgendaCadastro  item = new ItemAgendaCadastro();
                item.cpf= dados.getString("CPF");
                item.rg = dados.getString("RG");
                item.nome = dados.getString("Nome");
                item.data = dados.getString("Data_nascimento".toString());
                item.celular = dados.getString("Tel");
                item.email = dados.getString("Email");
                item.endereco= dados.getString("Rua");
                item.complemento = dados.getString("complemento");
                item.numero=dados.getInt("numero");
               item.cep= dados.getString("Cep");
                item.cidade = dados.getString("cidade");
                item.bairro = dados.getString("bairro");
                
                listarClientes.add(item);
                }
        }
        finally {
            conexao.close();
        }
        return listarClientes;
    }
    
    public  static   List<ItemAgenda> pesquisarLivro(String livro) throws Exception {
        String sql = "SELECT * FROM livro where Titulo_Livro LIKE ?";
                
        Connection conexao = ConnectionUtils.getConnection();
        
        List<ItemAgenda> listarLivros = new ArrayList();
        
        try {
            PreparedStatement comando = conexao.prepareStatement (sql);
            comando.setString(1,"%"+ livro +"%");
            ResultSet dados = comando.executeQuery();
            
            while (dados.next()){
                 
                 ItemAgenda item = new ItemAgenda();
                item.nome = dados.getString("Titulo_Livro");
                item.valor = dados.getDouble("valor");
                item.categoria = dados.getString("Categoria");
                item.quantidade = dados.getInt("Qtd_livro");
                item.codbarras = dados.getString("cod_barras");
                item.autor = dados.getString("autor");
                item.editora = dados.getString("editora");
                item.descricao = dados.getString("desc_produto");
                
                listarLivros.add(item);
                }
        }
        finally {
            conexao.close();
        }
        return listarLivros;
    }
       
    public static List <ItemAgendaCadastro>excluirCliente(String cpf) throws Exception {

        String sql = "DELETE FROM cliente  WHERE cpf = ?";

        Connection conexao = ConnectionUtils.getConnection();
        
        List <ItemAgendaCadastro>listarClientes = new ArrayList();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
             
            comando.setString(1,cpf);
            
            

            comando.execute();
                    } 
        
        finally {
            conexao.close();
        }
        return listarClientes;
    }
     static void excluirPedido() throws Exception {

        String sql = "DELETE FROM pedido  WHERE num_pedido = ?"
                ;

        Connection conexao = ConnectionUtils.getConnection();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1,1);
            
            

            comando.execute();
                    } 
        
        finally {
            conexao.close();
        }
    }
     public static List <ItemAgenda>excluirLivro(Integer CodLivro) throws Exception {

        String sql = "DELETE FROM livro  WHERE Cod_livro = ?";

        Connection conexao = ConnectionUtils.getConnection();
        
        List <ItemAgenda>listarLivro = new ArrayList();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
             
            comando.setInt(1,CodLivro);
            
            

            comando.execute();
                    } 
        
        finally {
            conexao.close();
        }
        return listarLivro;
    }
public static  void editarCliente (ItemAgendaCadastro item) throws Exception {
    
String sql = "UPDATE Cliente SET RG= ? , nome= ? , Data_nascimento= ? ,  Tel= ?,   Email= ? ,  Rua= ? ,  complemento= ? , Numero= ?,Cep= ?,Cidade= ?,Bairro= ? "  + " WHERE cpf = ? ";

Connection conexao = ConnectionUtils.getConnection ();

try {
          PreparedStatement comando = conexao.prepareStatement(sql); 

           
            comando.setString(1, item.rg);
            comando.setString(2,item.nome );
            comando.setDate(3,java.sql.Date.valueOf(item.data));
            comando.setString(4, item.celular);
            comando.setString(5, item.email);
            comando.setString(6, item.endereco);
            comando.setString(7, item.complemento);
            comando.setInt(8,item.numero);
            comando.setString(9, item.cep);
            comando.setString(10, item.cidade);
            comando.setString(11, item.bairro);
             comando.setString(12, item.cpf);
            comando.execute();
}finally{
    conexao.close();
}
}
public static  void editarLivro (ItemAgenda item) throws Exception {
    
String sql = "UPDATE livro SET  Categoria = ? , Qtd_Livro = ? , cod_barras = ? ,autor = ? , editora = ? , valor  = ? ,desc_produto = ? ,Titulo_livro= ?  "  + "  WHERE Cod_livro = ? ";

Connection conexao = ConnectionUtils.getConnection ();

try {
          PreparedStatement comando = conexao.prepareStatement(sql); 

           
            comando.setString(1, item.categoria);
            comando.setInt(2,item.quantidade);
            comando.setString(3,item.codbarras);
            comando.setString(4, item.autor);
            comando.setString(5, item.editora);
            comando.setDouble(6, item.valor);
            comando.setString(7, item.descricao);
            comando.setString(8, item.nome);
            comando.setInt(9, item.codlivro);
            
           
            comando.execute();
}finally{
    conexao.close();
}

} 
}
  /* public static List<ItemAgenda> listar() throws Exception{
        String sql = "SELECT * FROM item_agenda";
    }
*/



   
