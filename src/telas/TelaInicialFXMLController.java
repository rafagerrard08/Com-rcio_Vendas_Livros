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
import registros_Cadastro.ItemAgendaCadastro;

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
    private TextField editCodLivro;
   
    @FXML
    private TextField editCodBarras;
    @FXML
    private TextField editCategoria;
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
    private TextField editDesc;
    
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
       @FXML
    private TableColumn<ItemAgenda, String> colunaCategoria;
       
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
         colunaCategoria.setCellValueFactory(new PropertyValueFactory("categoria"));
    }

    @FXML
    private void editInserir(ActionEvent event) throws Exception{
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Validação");
        alert.setHeaderText("");
        alert.setContentText("Inserido com sucesso!");
        alert.showAndWait();

        ItemAgenda item = new ItemAgenda();
        
        
        item.nome = editNome.getText();
        item.codbarras = editCodBarras.getText();
        item.autor = editAutor.getText();
        item.categoria = editCategoria.getText();
        item.quantidade = Integer.parseInt(editQuant.getText());
        item.editora = editEdit.getText();
        item.valor =  Double.parseDouble( editValor.getText());
         item.descricao = editDesc.getText();
        
         
        
         if(modoEdicao == true){
             item.codlivro = Integer.parseInt(editCodLivro.getText()); 
             ItemAgendaDAO.editarLivro(item);
         }else{
          ItemAgendaDAO.inserirLivro(item);
         }
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
         editCategoria.setText("");
         editCodLivro.setText("");
        
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Excluir");
        alert.setHeaderText("");
        alert.setContentText("Apagado com sucesso!");
        alert.showAndWait();
    }

    @FXML
    private void editPesquisar(ActionEvent event) {
        if (editNomePesquisar.getText().equals("")) {
            try {
                List<ItemAgenda> resultado = ItemAgendaDAO.listarLivro();
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
                List<ItemAgenda> resultado = ItemAgendaDAO.pesquisarLivro(editNomePesquisar.getText());
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
    private void editEditar(ActionEvent event) {
        ItemAgenda itemSelecionado = tabela.getSelectionModel().getSelectedItem();

        if (itemSelecionado != null) {

            modoEdicao = true;

            itemAgendaEdicao = itemSelecionado;

            editNome.setText(itemSelecionado.nome);
            editCodBarras.setText(itemSelecionado.codbarras);
            editCodLivro.setText(itemSelecionado.codlivro.toString());
            editAutor.setText(itemSelecionado.autor);
            editDesc.setText(itemSelecionado.descricao);
            editEdit.setText(itemSelecionado.editora);
            editQuant.setText(itemSelecionado.quantidade.toString());
            editValor.setText(itemSelecionado.valor.toString());
            editCategoria.setText(itemSelecionado.categoria);
        }
    }

    @FXML
    private void editExcluir(ActionEvent event) throws Exception{
        ItemAgenda itemSelecionado = tabela.getSelectionModel().getSelectedItem();

        if(itemSelecionado != null){
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirma remoção");
            alert.setHeaderText("Confirmação de remoção ");
            alert.setContentText("Remover o item" + itemSelecionado.nome);
            Optional<ButtonType> resultado = alert.showAndWait();
            if(resultado.get() == ButtonType.OK){
                try{
                ItemAgendaDAO.excluirLivro(itemSelecionado.codlivro);
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
       

    }

    @FXML
    private void editSair(ActionEvent event) {
        System.exit(0);
    }

    }


