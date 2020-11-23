/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Developer
 */
public class TelaVendasController implements Initializable {
    @FXML
    private AnchorPane Ecommerce;
    @FXML
    private TextField editCodRef;
    @FXML
    private TextField editDataEmissao;
    @FXML
    private TextField editValor;
    @FXML
    private TextField editProduto;

    @FXML
    private TextField editObs;
    @FXML
    private TextField editNomePesquisar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
   
    }    

    @FXML
    private void editSalvar(ActionEvent event) {
        
    }

    @FXML
    private void editLimpar(ActionEvent event) {
          editCodRef.setText("");
        editDataEmissao.setText("");
        editValor.setText("");
        editProduto.setText("");
        editObs.setText("");
    }

    @FXML
    private void editPesquisar(ActionEvent event) {
    }

    @FXML
    private void edirEditar(ActionEvent event) {
    }

    @FXML
    private void editExcluir(ActionEvent event) {
    }

    @FXML
    private void editSair(ActionEvent event) {
             System.exit(0);
    }
}
