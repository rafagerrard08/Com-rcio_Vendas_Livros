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
import registros.ItemAgenda;

/**
 * FXML Controller class
 *
 * @author Developer
 */
public class TelaInicialFXMLController implements Initializable {

    @FXML
    private AnchorPane editPesq;
    @FXML
    private TextField editNome;
    @FXML
    private TextField editCodBarras;
    @FXML
    private TextField editDesc;
    @FXML
    private TextField editAutor;
    @FXML
    private TextField editEdit;
    @FXML
    private TextField editValor;
    @FXML
    private TextField editQuant;
    @FXML
    private TextField editNomePesquisar;

    @FXML
    private TableView<ItemAgenda> tabela;
    @FXML
    private TableColumn<ItemAgenda, String> colunaNome;
    @FXML
    private TableColumn<ItemAgenda, String> colunaBarras;
     @FXML
    private TableColumn<ItemAgenda, String> colunaDescricao;
    @FXML
    private TableColumn<ItemAgenda, String> colunaAutor;
    @FXML
    private TableColumn<ItemAgenda, String> colunaValor;
    @FXML
    private TableColumn<ItemAgenda, String> colunaQuant;
    @FXML
    private TableColumn<ItemAgenda, String> colunaEditora;
   
    List<ItemAgenda> ListaAgenda = new ArrayList();
    int totalItens = 0;
    boolean modoEdicao = false;
    ItemAgenda itemAgendaEdicao = null;
    

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaBarras.setCellValueFactory(new PropertyValueFactory("codbarras"));
        colunaAutor.setCellValueFactory(new PropertyValueFactory("autor"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        colunaValor.setCellValueFactory(new PropertyValueFactory("valor"));
        colunaQuant.setCellValueFactory(new PropertyValueFactory("quantidade"));
        colunaEditora.setCellValueFactory(new PropertyValueFactory("editora"));

    }

    @FXML
    private void editSalvar(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validação");
        alert.setHeaderText("");
        alert.setContentText("Salvo com sucesso!");
        alert.showAndWait();

        ItemAgenda item = new ItemAgenda();
        int idItem = 1;
        if (idItem == 1) {
            idItem++;
        }
        item.id = idItem;
        item.nome = editNome.getText();
        item.codbarras = editCodBarras.getText();
        item.autor = editAutor.getText();
        item.descricao = editDesc.getText();
        item.quantidade = editQuant.getText();
        item.editora = editEdit.getText();
        item.valor = editValor.getText();

        item.id = totalItens;

        totalItens++;

        ListaAgenda.add(item);
    }

    @FXML
    private void editLimpar(ActionEvent event) {
        editNome.setText("");
        editCodBarras.setText("");
        editQuant.setText("");
        editDesc.setText("");
        editEdit.setText("");
        editValor.setText("");
        editAutor.setText("");
        
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Excluir");
        alert.setHeaderText("");
        alert.setContentText("Apagado com sucesso!");
        alert.showAndWait();
    }

    @FXML
    private void editPesquisar(ActionEvent event) {
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
    private void editEditar(ActionEvent event) {
        ItemAgenda itemSelecionado = tabela.getSelectionModel().getSelectedItem();

        if (itemSelecionado != null) {

            modoEdicao = true;

            itemAgendaEdicao = itemSelecionado;

            editNome.setText(itemSelecionado.nome);
            editCodBarras.setText(itemSelecionado.codbarras);
            editAutor.setText(itemSelecionado.autor);
            editDesc.setText(itemSelecionado.descricao);
            editEdit.setText(itemSelecionado.editora);
            editQuant.setText(itemSelecionado.quantidade);
            editValor.setText(itemSelecionado.valor);

        }
    }

    @FXML
    private void editExcluir(ActionEvent event) {
        ItemAgenda itemSelecionado = tabela.getSelectionModel().getSelectedItem();

        for (int i = 0; i < ListaAgenda.size(); i++) {
            ItemAgenda itemLista = ListaAgenda.get(i);
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
    private void editSair(ActionEvent event) {
        System.exit(0);
    }

    }


