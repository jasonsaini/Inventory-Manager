package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ExistingSNPopupController {
    @FXML
    Button SNPopupOKButton;
    public void SNPopupButtonClicked(ActionEvent actionEvent) {
        Stage curStage = (Stage)SNPopupOKButton.getScene().getWindow();
        curStage.close();
    }
}
