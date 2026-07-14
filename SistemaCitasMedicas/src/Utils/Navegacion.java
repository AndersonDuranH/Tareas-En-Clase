package Utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
public class Navegacion {
    
    public <T> T abrirVentana(String rutaFXML, String titulo){
        try{
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource(rutaFXML)
        );
        Stage stage = new Stage();
        Scene scene = new Scene(loader.load());
        stage.setTitle(titulo);
        stage.setScene(scene);
        stage.show();
        return loader.getController();
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }
}
}
