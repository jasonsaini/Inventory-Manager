/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ValueFormatDialogController {
    @FXML
    Button ValueOkButton;
    public void VFOKDialogClicked(ActionEvent actionEvent) {
        Stage curStage = (Stage)ValueOkButton.getScene().getWindow();
        curStage.close();
    }
}
