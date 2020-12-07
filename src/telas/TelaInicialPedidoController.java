package telas;

import JDBC.ItemAgendaDAO;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import registros.ItemAgenda;
import registros_Pedido.ItemAgendaPedido;

/**
 * FXML Controller class

*/
public class TelaInicialPedidoController implements Initializable {

    @FXML
    private TextField editPesquisar;
    @FXML
    private TextField editPedido;
    @FXML
    private TextField editCpf;
    @FXML
    private TextField editValor;
    @FXML
    private TextField editData;
    @FXML
    private TextField editCodLivro;
    @FXML
    private TextField editQuant;
    @FXML
    private TextField editDescProduto;
    @FXML
    private TableView<ItemAgendaPedido> tabela;
    @FXML
    private TableColumn<ItemAgendaPedido, String> colunaNumPed;
    @FXML
    private TableColumn<ItemAgendaPedido, String> colunaCpf;
    @FXML
    private TableColumn<ItemAgendaPedido, String> colunaValor;
    @FXML
    private TableColumn<ItemAgendaPedido, String> colunaData;
    @FXML
    private TableColumn<ItemAgendaPedido, String> colunaLivro;
    @FXML
    private TableColumn<ItemAgendaPedido, String> colunaQuant;
   @FXML
    private TableColumn<ItemAgendaPedido, String> colunaDescProduto;

    List<ItemAgendaPedido> ListaAgenda = new ArrayList();
    int totalItens = 0;
    boolean modoEdicao = false;
    ItemAgendaPedido itemAgendaEdicao = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaNumPed.setCellValueFactory(new PropertyValueFactory("numeroPedido"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
        colunaValor.setCellValueFactory(new PropertyValueFactory("valor"));
        colunaData.setCellValueFactory(new PropertyValueFactory("data"));
        colunaLivro.setCellValueFactory(new PropertyValueFactory("codlivro"));
        colunaQuant.setCellValueFactory(new PropertyValueFactory("quantidade"));
        colunaDescProduto.setCellValueFactory(new PropertyValueFactory("descricao"));
    }

    @FXML
    private void acaoconfirmar(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validação");
        alert.setHeaderText("");
        alert.setContentText("Confirmado com sucesso!");
        alert.showAndWait();

        ItemAgendaPedido item = new ItemAgendaPedido();
        
        
        item.numeroPedido = Integer.parseInt( editPedido.getText());
        item.cpf = editCpf.getText();
        item.data = editData.getText();
        item.quantidade = Integer.parseInt(editQuant.getText());
        item.descricao = editDescProduto.getText();
        item.valor =Double.parseDouble( editValor.getText());
        item.codlivro = Integer.parseInt(editCodLivro.getText());
         if(modoEdicao == false){
        ItemAgendaDAO.inserirPedido(item);
         }else{
         ItemAgendaDAO.editarPedido(item);
         }
    }

    @FXML
    private void acaoApagar(ActionEvent event) {
        editValor.clear();
        editCpf.clear();
        editPedido.clear();
        editData.clear();
        editCodLivro.clear();
        editQuant.clear();
        editDescProduto.clear();

    }

    @FXML
    private void acaoExcluir(ActionEvent event) {
        ItemAgendaPedido itemSelecionado = tabela.getSelectionModel().getSelectedItem();

        if(itemSelecionado != null){
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirma remoção");
            alert.setHeaderText("Confirmação de remoção ");
            alert.setContentText("Remover o pedido" + itemSelecionado.numeroPedido);
            Optional<ButtonType> resultado = alert.showAndWait();
            if(resultado.get() == ButtonType.OK){
                try{
                ItemAgendaDAO.excluirPedido(itemSelecionado.numeroPedido);
                Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
                alert2.setTitle("Validação");
                alert2.setHeaderText("Excluido com sucesso! ");
                alert2.setContentText("Pesquise para confirmar a exclusão!");
                alert2.showAndWait();
                }catch(Exception e){
                        e.printStackTrace();
                       
                }
                
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validação");
        alert.setHeaderText("Excluido com sucesso! ");
        alert.setContentText("Pesquise para confirmar a exclusão!");
        alert.showAndWait();
    }

    @FXML
    private void acaoEditar(ActionEvent event) {
        ItemAgendaPedido itemSelecionado = tabela.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Pesquisando ...");
        alert.setHeaderText("Comece a edição! ");
        alert.showAndWait();
        
        if (itemSelecionado != null) {

            modoEdicao = true;

            itemAgendaEdicao = itemSelecionado;

            editValor.setText(itemSelecionado.valor.toString());
            editCpf.setText(itemSelecionado.cpf);
            editPedido.setText(itemSelecionado.numeroPedido.toString());
            editData.setText(itemSelecionado.data);
            editCodLivro.setText(itemSelecionado.codlivro.toString());
            editQuant.setText(itemSelecionado.quantidade.toString());
            editDescProduto.setText(itemSelecionado.descricao);
        }

    }

    @FXML
    private void acaoPesquisar(ActionEvent event) {
        if (editPesquisar.getText().equals("")) {
            try {
                List<ItemAgendaPedido> resultado = ItemAgendaDAO.listarPedidos();
                tabela.setItems(FXCollections.observableArrayList(resultado));
                tabela.refresh();
                
              /*  Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Verificando o armazenamento ...");
                alert.setHeaderText("");
                alert.setContentText("Dados  encontrados!");
                alert.showAndWait();
             */   
            } catch (Exception e) {
                e.printStackTrace();
                  Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Verificando o armazenamento ...");
                alert.setHeaderText("");
                alert.setContentText("Nenhum dado encontrado");
            }
           
            
        }else{
            try {
                List<ItemAgendaPedido> resultado = ItemAgendaDAO.pesquisarPedido(Integer.parseInt(editPesquisar.getText()));
                tabela.setItems(FXCollections.observableArrayList(resultado));
                tabela.refresh();
               if(resultado.isEmpty()){
               Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Verificando o armazenamento ...");
                alert.setHeaderText("");
                alert.setContentText("Nenhum resultado encontrado");
                alert.showAndWait();
               
               }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Verificando o armazenamento ...");
                alert.setHeaderText("");
                alert.setContentText("Dados encontrados!");
                alert.showAndWait();
               }
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Verificando o armazenamento ...");
                alert.setHeaderText("");
                alert.setContentText("Nenhum dado encontrado");
                e.printStackTrace(); 
            }
        }
    }

    @FXML
    private void acaoSair(ActionEvent event) {
        System.exit(0);
    }
}
