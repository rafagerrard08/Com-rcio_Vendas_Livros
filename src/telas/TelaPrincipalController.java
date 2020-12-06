package telas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class TelaPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void acaoCadastro(ActionEvent event) throws Exception {
        URL url = getClass().getResource("/telas/TelaInicial_Cadastro.fxml");

        Parent tela = FXMLLoader.load(url);

        Scene cena = new Scene(tela);
        Stage stage = new Stage();
        stage.setScene(cena);

        stage.show();
    }

    @FXML
    private void acaoProduto(ActionEvent event) throws Exception {
        URL url = getClass().getResource("/telas/TelaInicialProduto.fxml");

        Parent tela = FXMLLoader.load(url);

        Scene cena = new Scene(tela);
        Stage stage = new Stage();
        stage.setScene(cena);

        stage.show();
    }

    @FXML
    private void acaoPedido(ActionEvent event) throws Exception {
        URL url = getClass().getResource("/telas/TelaInicialPedido.fxml");

        Parent tela = FXMLLoader.load(url);

        Scene cena = new Scene(tela);

        Stage stage = new Stage();

        stage.setScene(cena);

        stage.show();
    }

}
