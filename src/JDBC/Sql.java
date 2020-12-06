package JDBC;

import JDBC.ConnectionUtils;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Sql {

    public static void main(String args[]) {

        try {
                    //inserirCliente();
                    //inserirLivro();
                    //inserirPedido();
                    excluirCliente();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    static void inserirCliente() throws Exception {

        String sql = "INSERT INTO cliente (cpf,RG,nome,Data_nascimento, Tel, Email, Rua,complemento,Numero,Cep,Cidade,Bairro) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection conexao = ConnectionUtils.getConnection();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, "123");
            comando.setString(2, "");
            comando.setString(3, "");
            comando.setString(4,"");
            comando.setString(5, "");
            comando.setString(6, "");
            comando.setString(7, "");
            comando.setString(8, "");
            comando.setInt(9, 5);
            comando.setString(10, "");
            comando.setString(11, "");
            comando.setString(12, "");

            comando.execute();
                    } 
        
        finally {
            conexao.close();
        }
    }
    static void inserirPedido() throws Exception {

        String sql = "INSERT INTO pedido (num_pedido,valor_pedido,Data_Compra,qtde, desc_produto,Cliente_id_cliente, Cliente_CPF, Livro_id_livro, Livro_Cod_livro) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";

       Connection conexao = ConnectionUtils.getConnection();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setInt(1, 12);
            comando.setBigDecimal(2, BigDecimal.valueOf(50.25));
            comando.setString(3, "asdasd");
            comando.setInt(4,5);
            comando.setString(5, "asdasd");
            comando.setInt(6,1);
            comando.setString(7,"123");
            comando.setInt(8,1);
            comando.setString(9,"123");
                    
            
            comando.execute();
                   } 
        
       finally {
           conexao.close();
        }
    }
    static void inserirLivro() throws Exception {

        String sql = "INSERT INTO livro (Cod_livro, Titulo_Livro,Categoria, Qtd_Livro, cod_barras,autor, editora) "
                + "VALUES (?,?,?,?,?,?,?)";

        Connection conexao = ConnectionUtils.getConnection();
        
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);

            comando.setString(1, "123");
            comando.setString(2, "abc");
            comando.setString(3, "abc");
            comando.setInt(4,0);
            comando.setString(5, "123");
            comando.setString(6, "abc");
            comando.setString(7, "abc");
            
            comando.execute();
                    } 
        
        finally {
            conexao.close();
        }
    }

    static void listarCliente()throws Exception {
        String sql = "SELECT * FROM cliente";
    
        Connection conexao = ConnectionUtils.getConnection();
        try {
            PreparedStatement comando = conexao.prepareStatement (sql);
            
            ResultSet dados = comando.executeQuery();
            
            while (dados.next()){
                String cpf = dados.getString("CPF");
                String RG = dados.getString("RG");
                String nome = dados.getString("Nome");
                String Data_nascimento = dados.getString("Data_nascimento");
                String Tel = dados.getString("Tel");
                String Email = dados.getString("Email");
                String Rua = dados.getString("Rua");
                String Complmemento = dados.getString("complemento");
                String  Numero=dados.getString("numero");
                String Cep = dados.getString("Cep");
                String Cidade = dados.getString("cidade");
                String Bairro = dados.getString("bairro");
            
                
                }
        }  
        finally {
            conexao.close();
        }
    }
    static void listarLivro()throws Exception {
        String sql = "SELECT * FROM livro";
    
        Connection conexao = ConnectionUtils.getConnection();
        try {
            PreparedStatement comando = conexao.prepareStatement (sql);
            
            ResultSet dados = comando.executeQuery();
            
            while (dados.next()){
                String cpf = dados.getString("cpf");
                String cod_livro = dados.getString("cod_livro");
                String Titulo_Livro = dados.getString("Titulo_Livro");
                String Categoria = dados.getString("Categoria");
                String Qtd_livro = dados.getString("Qtd_livro");
                String cod_barras = dados.getString("cod_barras");
                String autor = dados.getString("autor");
                String editora = dados.getString("editora");
                
                
                }
        }
        finally {
            conexao.close();
        }
    }
    static void listarPedido()throws Exception {
        String sql = "SELECT * FROM pedido";
    
        Connection conexao = ConnectionUtils.getConnection();
        try {
            PreparedStatement comando = conexao.prepareStatement (sql);
            
            ResultSet dados = comando.executeQuery();
            
            while (dados.next()){
                String num_pedido = dados.getString("num_pedido");
                String valor_pedido = dados.getString("valor_pedido");
                String Data_Compra = dados.getString("Titulo_Livro");
                String qtde = dados.getString("qtde");
                String desc_produto = dados.getString("Qtd_livro");
                String cod_livro = dados.getString("cod_livro");
                String cpf = dados.getString("CPF");
                
                
                
                }
        }
        finally {
            conexao.close();
        }
    }
       
    static void excluirCliente() throws Exception {

        String sql = "DELETE FROM cliente  WHERE id_cliente = ?"
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
     static void excluirLivro() throws Exception {

        String sql = "DELETE FROM livro  id_livro = ?"
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
}
  /* public static List<ItemAgenda> listar() throws Exception{
        String sql = "SELECT * FROM item_agenda";
    }

public static editar (itemAgenda item) throws Exception {
    
String sql = "UPDATE item_agenda SET ( cpf,RG,nome,Data_nascimento, Tel, Email, Rua,complemento,Numero,Cep,Cidade,Bairro)"

Connection conexao = ConnectionUtils.getConnection ();

Try {
          PreparedStatement comando = conexao.prepareStatement(sql); 

            comando.setString(1, item.cpf);
            comando.setString(2, item.RG);
            comando.setString(3,item.nome );
            comando.setString(4,item.Data_nascimento);
            comando.setString(5, item.Tel);
            comando.setString(6, item.Email);
            comando.setString(7, item.Rua);
            comando.setString(8, item.complemento);
            comando.setInt(9,item.Numero);
            comando.setString(10, item.Cep);
            comando.setString(11, item.Cidade);
            comando.setString(12, item.Bairro);
            
}
}
}*/