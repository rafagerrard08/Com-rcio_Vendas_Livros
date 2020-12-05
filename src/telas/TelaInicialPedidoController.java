package telas;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
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
    private TextField editValorItens;
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
    private TableColumn<ItemAgendaPedido, String> colunaValorItens;

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
        colunaLivro.setCellValueFactory(new PropertyValueFactory("livro"));
        colunaQuant.setCellValueFactory(new PropertyValueFactory("quantidade"));
        colunaValorItens.setCellValueFactory(new PropertyValueFactory("valorItens"));
    }

    @FXML
    private void acaoconfirmar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validação");
        alert.setHeaderText("");
        alert.setContentText("Confirmado com sucesso!");
        alert.showAndWait();

        ItemAgendaPedido item = new ItemAgendaPedido();
        int idItem = 1;
        if (idItem == 1) {
            idItem++;
        }
        item.id = idItem;
        item.numeroPedido = editPedido.getText();
        item.cpf = editCpf.getText();
        item.data = editData.getText();
        item.quantidade = editQuant.getText();
        item.valorItens = editValorItens.getText();
        item.valor = editValor.getText();
        item.livro = editCodLivro.getText();
         
         item.id = totalItens;

        totalItens++;

        ListaAgenda.add(item);
    }

    @FXML
    private void acaoApagar(ActionEvent event) {
        editValor.clear();
        editCpf.clear();
        editPedido.clear();
        editData.clear();
        editCodLivro.clear();
        editQuant.clear();
        editValorItens.clear();

    }

    @FXML
    private void acaoExcluir(ActionEvent event) {
        ItemAgendaPedido itemSelecionado = tabela.getSelectionModel().getSelectedItem();

        for (int i = 0; i < ListaAgenda.size(); i++) {
            ItemAgendaPedido itemLista = ListaAgenda.get(i);
            if (itemLista.id == itemSelecionado.id) {
                ListaAgenda.remove(i);
                break;
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

            editValor.setText(itemSelecionado.valor);
            editCpf.setText(itemSelecionado.cpf);
            editPedido.setText(itemSelecionado.numeroPedido);
            editData.setText(itemSelecionado.data);
            editCodLivro.setText(itemSelecionado.livro);
            editQuant.setText(itemSelecionado.quantidade);
            editValorItens.setText(itemSelecionado.valorItens);
        }

    }

    @FXML
    private void acaoPesquisar(ActionEvent event) {
        if (tabela != ListaAgenda) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Verificando o armazenamento ...");
            alert.setHeaderText("");
            alert.setContentText("Aguarde um momento!");
            alert.showAndWait();
            tabela.setItems(FXCollections.observableArrayList(ListaAgenda));

        } else if (ListaAgenda == tabela) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Verificando o armazenamento ...");
            alert.setHeaderText("");
            alert.setContentText("Nome não encontrado!");
            alert.showAndWait();
        }
    }

    @FXML
    private void acaoSair(ActionEvent event) {
        System.exit(0);
    }
}
