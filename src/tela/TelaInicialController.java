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
 * @author rafael_Ferraz
 */
public class TelaInicialController implements Initializable {

    @FXML
    private AnchorPane editPesquisar;
    @FXML
    private TextField editNome;
    @FXML
    private TextField editCpf;
    @FXML
    private TextField editRg;
    @FXML
    private TextField editData;
    @FXML
    private TextField editEnd;
    @FXML
    private TextField editNum;
    @FXML
    private TextField editCompleme;
    @FXML
    private TextField editBairro;
    @FXML
    private TextField editCep;
    @FXML
    private TextField editCidade;
    @FXML
    private TextField editCel;
    @FXML
    private TextField editEmail;
    @FXML
    private TextField editNomePesquisar;
    
    @FXML
    private TableView<ItemAgenda> tabela;
    @FXML
    private TableColumn<ItemAgenda, String> colunaNome;
    @FXML
    private TableColumn<ItemAgenda, String> colunaCpf;
    @FXML
    private TableColumn<ItemAgenda, String> colunaRg;
    @FXML
    private TableColumn<ItemAgenda, String> colunaDat;
    @FXML
    private TableColumn<ItemAgenda, String> colunaEnd;
    @FXML
    private TableColumn<ItemAgenda, String> colunaNum;
    @FXML
    private TableColumn<ItemAgenda, String> colunaCompleme;
    @FXML
    private TableColumn<ItemAgenda, String> colunaBairro;
    @FXML
    private TableColumn<ItemAgenda, String> colunaCep;
    @FXML
    private TableColumn<ItemAgenda, String> colunaCidade;
    @FXML
    private TableColumn<ItemAgenda, String> colunaCelular;
    @FXML
    private TableColumn<ItemAgenda, String> colunaEmail;
   
    List<ItemAgenda> ListaAgenda = new ArrayList(); 
    int totalItens = 0;
    boolean modoEdicao = false;
    ItemAgenda itemAgendaEdicao = null;
      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      colunaNome.setCellValueFactory(new PropertyValueFactory("nome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory("cpf"));
        colunaRg.setCellValueFactory(new PropertyValueFactory("rg"));
       colunaDat.setCellValueFactory(new PropertyValueFactory("data"));
        colunaEnd.setCellValueFactory(new PropertyValueFactory("endereco"));
        colunaNum.setCellValueFactory(new PropertyValueFactory("numero"));
        colunaCompleme.setCellValueFactory(new PropertyValueFactory("complemento"));
        colunaBairro.setCellValueFactory(new PropertyValueFactory("bairro"));
        colunaCep.setCellValueFactory(new PropertyValueFactory("cep"));
        colunaCidade.setCellValueFactory(new PropertyValueFactory("cidade"));
        colunaCelular.setCellValueFactory(new PropertyValueFactory("celular"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory("email"));
    }    

    @FXML
    private void acaoSalvar(ActionEvent event) {
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
        item.numero = editNum.getText();
        item.nome = editNome.getText();
        item.cpf = editCpf.getText();
        item.rg = editRg.getText();
        item.endereco = editEnd.getText();
        item.complemento = editCompleme.getText();
        item.bairro = editBairro.getText();
        item.cep = editCep.getText();
        item.cidade = editCidade.getText();
        item.celular = editCel.getText();
        item.email = editEmail.getText();
        item.data = editData.getText();
        item.id = totalItens;

        totalItens++;

        ListaAgenda.add(item);
    }

    @FXML
    private void acaoCancelar(ActionEvent event) {
        editNome.clear();
        editCpf.clear();
        editRg.clear();
        editEnd.clear();
        editNum.clear();
        editCompleme.clear();
        editBairro.clear();
        editCep.clear();
        editCidade.clear();
        editCel.clear();
        editEmail.clear();
        editData.clear();
		    

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Cancelamento");
        alert.setHeaderText("");
        alert.setContentText("Cancelado com sucesso!");
        alert.showAndWait();
    }

    @FXML
    private void acaoPesquisar(ActionEvent event) {
                if ( tabela != ListaAgenda  ){

        Alert alert = new Alert(Alert.AlertType.WARNING);  
        alert.setTitle("Verificando o armazenamento ...");
        alert.setHeaderText("");
        alert.setContentText("Aguarde um momento!");
        alert.showAndWait();
    tabela.setItems(FXCollections.observableArrayList(ListaAgenda));
          
        
        } else if ( ListaAgenda== tabela  ){
         Alert alert = new Alert(Alert.AlertType.INFORMATION); 
        alert.setTitle("Verificando o armazenamento ...");
        alert.setHeaderText("");
        alert.setContentText("Nome não encontrado!");
        alert.showAndWait();
        }
    }

    @FXML
    private void acaoEditar(ActionEvent event) {
         ItemAgenda itemSelecionado = tabela.getSelectionModel().getSelectedItem();
           Alert alert = new Alert(Alert.AlertType.INFORMATION);   
        alert.setTitle("Pesquisando ...");
        alert.setHeaderText("Comece a edição! ");
        alert.showAndWait();
        if (itemSelecionado != null) {

            modoEdicao = true;

            itemAgendaEdicao = itemSelecionado;

            editNome.setText(itemSelecionado.nome);
            editCpf.setText(itemSelecionado.cpf);
             editRg.setText(itemSelecionado.rg);
            editCel.setText(itemSelecionado.celular);
            editEnd.setText(itemSelecionado.endereco);
            editEmail.setText(itemSelecionado.email);
            editCompleme.setText(itemSelecionado.complemento);
            editBairro.setText(itemSelecionado.bairro);
            editCep.setText(itemSelecionado.cep);
            editCidade.setText(itemSelecionado.cidade);
            editData.setText(itemSelecionado.data);
            editNum.setText(itemSelecionado.numero);
   
            }
    }

    @FXML
    private void acaoExcluir(ActionEvent event) {
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
    private void acaoSair(ActionEvent event) {       
          System.exit(0);
    }
    
}
