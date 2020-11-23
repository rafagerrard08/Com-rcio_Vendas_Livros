package telas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author rafag
 */
public class TelaInicialController implements Initializable {

    @FXML
    private AnchorPane editPesquisar;
    @FXML
    private TextField editCod;
    @FXML
    private TextField editNome;
    @FXML
    private TextField editCpf;
    @FXML
    private TextField editRg;
    @FXML
    private DatePicker editData;
    @FXML
    private TextField editEnd;
    @FXML
    private TextField editNum;
    @FXML
    private TextField editComplem;
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
    private TableView<?> tabela;
    @FXML
    private TableColumn<?, ?> colunaCodigo;
    @FXML
    private TableColumn<?, ?> colunaNome;
    @FXML
    private TableColumn<?, ?> colunaCpf;
    @FXML
    private TableColumn<?, ?> colunaRg;
    @FXML
    private TableColumn<?, ?> colunaData;
    @FXML
    private TableColumn<?, ?> colunaEnd;
    @FXML
    private TableColumn<?, ?> colunaNum;
    @FXML
    private TableColumn<?, ?> colunaComplem;
    @FXML
    private TableColumn<?, ?> colunaBairro;
    @FXML
    private TableColumn<?, ?> colunaCep;
    @FXML
    private TableColumn<?, ?> colunaCidade;
    @FXML
    private TableColumn<?, ?> colunaCelular;
    @FXML
    private TableColumn<?, ?> colunaEmail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void acaoSalvar(ActionEvent event) {
    }

    @FXML
    private void acaoCancelar(ActionEvent event) {
    }

    @FXML
    private void acaoPesquisar(ActionEvent event) {
    }

    @FXML
    private void acaoEditar(ActionEvent event) {
    }

    @FXML
    private void acaoExcluir(ActionEvent event) {
    }

    @FXML
    private void acaoSair(ActionEvent event) {
          System.exit(0);
    }
    
}
