/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class editSerialNumberController {
    @FXML
    TextField editSNTextField;

    public void changeItemSNButtonClicked(ActionEvent actionEvent) {
        // get user data from main window controller
        Node node = (Node)actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        InventoryItem cur = (InventoryItem) stage.getUserData();
        // change serial number
        changeSerialNumber(cur);
        stage.close();
    }

    public void changeSerialNumber(InventoryItem cur)
    {
        String newSerialNumber = editSNTextField.getText();
        if(newSerialNumber.length() != 10 || new InventoryItem().hasInvalidCharacters(newSerialNumber))
        {
            SceneManager sm = new SceneManager();
            sm.loadAll();
            sm.setupDialogStage("SN Format Error Dialog", "Invalid Format", false);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        else
        {
            cur.setSerialNum(newSerialNumber);
        }

    }

}
