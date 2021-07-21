/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SNFormatDialogController {
    @FXML
    GridPane outerGridPane;

    public void SNFormatOKButtonClicked(ActionEvent actionEvent) {
        Stage curStage = (Stage)outerGridPane.getScene().getWindow();
        curStage.close();
    }
}
