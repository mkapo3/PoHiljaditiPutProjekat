package ba.unsa.etf.rpr;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class Controller {
    public TextField fieldUsername;

    @FXML
    public void initilaze(){
        fieldUsername.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (fieldUsername.getText().isEmpty()) {
                    fieldUsername.getStyleClass().add("poljeNijeIspravno");
                } else {
                    fieldUsername.getStyleClass().add("poljeJeIspravno");
                }
            }
        });
    }

    public void buttonClick(ActionEvent actionEvent) throws IOException {
        if(fieldUsername.getText().isEmpty()){
            return;
        }
        Stage stage=new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/noviprozor.fxml"));
        Parent root = loader.load();
        Noviprozor noviprozor = loader.getController();
        noviprozor.labela.setText(noviprozor.labela.getText() + fieldUsername.getText());
        stage.setTitle("Prijava");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
    }
}
