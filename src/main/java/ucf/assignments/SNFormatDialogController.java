package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SNFormatDialogController {
    @FXML
    GridPane outerGridPane;
    public void clearSerialNumberField(ActionEvent actionEvent) {
        Stage curStage = (Stage)outerGridPane.getScene().getWindow();
        curStage.close();
    }
}
