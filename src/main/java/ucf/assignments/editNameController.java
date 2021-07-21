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



public class editNameController {
    @FXML
    TextField editNameTextField;
    public void changeItemNameButtonClicked(ActionEvent actionEvent) {
        Node node = (Node)actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        InventoryItem cur = (InventoryItem)stage.getUserData();
        setNewName(cur);
        stage.close();
    }
    public void setNewName(InventoryItem cur)
    {
        String newName = editNameTextField.getText();
        // open invalid name dialog if name is invalid
        if(newName.length() > 256 || newName.length() < 2)
        {
            SceneManager sm = new SceneManager();
            sm.load();
            sm.setupDialogStage("Name Format Error Dialog", "Invalid Format", false);
            try {
                wait();
            } catch (InterruptedException e) {
                // do nothing, user will have to reopen window
            }
        }
        else
        {
            cur.name = newName;
        }
    }

}
