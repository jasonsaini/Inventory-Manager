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

import java.text.DecimalFormat;

public class editValueController {
    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    @FXML
    TextField editValueTextField;
    public void changeItemValueButtonClicked(ActionEvent actionEvent) {
        Node node = (Node)actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        InventoryItem cur = (InventoryItem) stage.getUserData();
        setNewValue(cur);
        stage.close();
    }
    public void setNewValue(InventoryItem cur)
    {
        String curValString = editValueTextField.getText();
        double curVal = 0;
        try
        {
            curVal = Double.parseDouble(curValString);
        }
        catch(Exception e)
        {
            SceneManager sm = new SceneManager();
            sm.load();
            sm.setupDialogStage("Value Format Error Dialog", "Invalid format!", false);
            try {
                wait();
            } catch (InterruptedException interruptedException) {
                // do nothing
            }
        }

        cur.setDollarVal("$" + decimalFormat.format(curVal));
    }

}
