package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NameFormatDialogController {
    @FXML
    GridPane NameFormatGridPane;

    public void NFDialogOKClicked(ActionEvent actionEvent) {
        Stage curStage = (Stage)NameFormatGridPane.getScene().getWindow();
        curStage.close();
    }
}
