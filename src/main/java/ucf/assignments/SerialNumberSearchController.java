/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SerialNumberSearchController {
    @FXML
    ObservableList<InventoryItem> searchList = FXCollections.observableArrayList();

    @FXML
    TableView SNSearchTable;

    @FXML
    TableColumn SNSearchNameColumn, SNValueColumn, SNSearchSNColumn;

    @FXML
    TextField searchSNTextField;

    public void serialNumberSearchItemButtonClicked(ActionEvent actionEvent) {
        SNSearchTable.getItems().clear();
        searchList.clear();
        Node node = (Node)actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        ObservableList<InventoryItem> fullInventoryList = (ObservableList<InventoryItem>) stage.getUserData();

        String serialNumberSearchKey = searchSNTextField.getText().toUpperCase();
        for(int i = 0; i < fullInventoryList.size(); i++)
        {
            if(fullInventoryList.get(i).serialNum.contains(serialNumberSearchKey))
            {
                searchList.add(fullInventoryList.get(i));
            }
        }

        // set cell value factories
        SNSearchNameColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("name"));
        SNValueColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("dollarVal"));
        SNSearchSNColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("serialNum"));

        SNSearchTable.setItems(searchList);
        SNSearchTable.refresh();
    }
}
