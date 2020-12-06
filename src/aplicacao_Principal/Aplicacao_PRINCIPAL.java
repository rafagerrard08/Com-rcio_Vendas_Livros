package aplicacao_Principal;

import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacao_PRINCIPAL extends Application {

   
   
    public static void main(String[] args) {
        launch (args);
         
    }
    @Override
    public void start(Stage stage) throws Exception  {
        URL Tela  =  getClass().getResource ("/telas/TelaPrincipal.fxml");
        Parent tela = FXMLLoader.load(Tela);
        Scene cena = new Scene (tela);
        stage.setScene (cena);
        stage.show();
    }
}









