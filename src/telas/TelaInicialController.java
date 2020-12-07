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
import JDBC.ItemAgendaDAO;
import java.util.Optional;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import registros_Cadastro.ItemAgendaCadastro;

/**
 * FXML Controller class
 *
 * @author rafag
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
    private TableView<ItemAgendaCadastro> tabela;
    @FXML
    private TableColumn<ItemAgendaCadastro, String> colunaNome;
    @FXML
    private TableColumn<ItemAgendaCadastro, String> colunaCpf;
    @FXML
    private TableColumn<ItemAgendaCadastro, String> colunaRg;
    @FXML
    private TableColumn<ItemAgendaCadastro, String> colunaDat;
    @FXML
    private TableColumn<ItemAgendaCadastro, String> colunaEnd;
    @FXML
    private TableColumn<ItemAgendaCadastro, String> colunaNum;
    @FXML
    private TableColumn<ItemAgendaCadastro, String> colunaCompleme;
    @FXML
    private TableColumn<ItemAgendaCadastro, String> colunaBairro;
    @FXML
    private TableColumn<ItemAgendaCadastro, String> colunaCep;
    @FXML
    private TableColumn<ItemAgendaCadastro, String> colunaCidade;
    @FXML
    private TableColumn<ItemAgendaCadastro, String> colunaCelular;
    @FXML
    private TableColumn<ItemAgendaCadastro, String> colunaEmail;

    List<ItemAgendaCadastro> ListaAgenda = new ArrayList();
    int totalItens = 0;
    boolean modoEdicao = false;
    ItemAgendaCadastro itemAgendaEdicao = null;

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
    private void acaoSalvar(ActionEvent event) throws Exception {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validação");
        alert.setHeaderText("");
        alert.setContentText("Salvo com sucesso!");
        alert.showAndWait();

        ItemAgendaCadastro item = new ItemAgendaCadastro();
        
        item.numero = Integer.parseInt(editNum.getText());
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
        
        if(modoEdicao == false){
        ItemAgendaDAO.inserirCliente(item);
        }else{
        ItemAgendaDAO.editarCliente(item);
        }
        /*int idItem = 1;
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

        ListaAgenda.add(item);*/
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
    private void acaoPesquisar(ActionEvent event) throws Exception {
        if (editNomePesquisar.getText().equals("")) {
            try {
                List<ItemAgendaCadastro> resultado = ItemAgendaDAO.listarCliente();
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
                List<ItemAgendaCadastro> resultado = ItemAgendaDAO.pesquisarCliente(editNomePesquisar.getText());
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
    private void acaoEditar(ActionEvent event) {
        ItemAgendaCadastro itemSelecionado = tabela.getSelectionModel().getSelectedItem();
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
            editNum.setText(itemSelecionado.numero.toString());// Integer.parseInt(editNum.getText())
            
            
            
           /* try{
                ItemAgendaDAO.editarCliente(itemSelecionado);
                
            }catch(Exception e){
                e.printStackTrace();
            }
*/
        }
    }

    @FXML
    private void acaoExcluir(ActionEvent event) throws Exception{
        ItemAgendaCadastro itemSelecionado = tabela.getSelectionModel().getSelectedItem();

        if(itemSelecionado != null){
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirma remoção");
            alert.setHeaderText("Confirmação de remoção ");
            alert.setContentText("Remover o item" + itemSelecionado.nome);
            Optional<ButtonType> resultado = alert.showAndWait();
            if(resultado.get() == ButtonType.OK){
                try{
                ItemAgendaDAO.excluirCliente(itemSelecionado.cpf);
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
    private void acaoSair(ActionEvent event) {
        System.exit(0);
    }

}
