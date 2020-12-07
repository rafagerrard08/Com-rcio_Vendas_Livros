package telas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
  */

public class TelaRelatorioController implements Initializable {

    @FXML
    private TableColumn<?, ?> colunaNomeCliente;
    @FXML
    private TableColumn<?, ?> colunaData;
    @FXML
    private TableColumn<?, ?> colunaQuant;
    @FXML
    private TableColumn<?, ?> colunaValor;
    @FXML
    private Label numerosVendas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    
    
}
