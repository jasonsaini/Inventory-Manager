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

public class NameSearchController {
    @FXML
    ObservableList<InventoryItem>  searchList = FXCollections.observableArrayList();
    @FXML
    TableView nameSearchTable;
    @FXML
    TableColumn nameSearchNameColumn, nameSearchValueColumn, nameSearchSNColumn;
    @FXML
    TextField nameSearchTextField;
    public void nameSearchItemButtonClicked(ActionEvent actionEvent) {
        nameSearchTable.getItems().clear();
        searchList.clear();
        Node node = (Node)actionEvent.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        ObservableList<InventoryItem> fullInventoryList = (ObservableList<InventoryItem>) stage.getUserData();

        String nameSearchKey = nameSearchTextField.getText();
        for(int i = 0; i < fullInventoryList.size(); i++)
        {
            if(fullInventoryList.get(i).name.toLowerCase().contains(nameSearchKey.toLowerCase()))
            {
                searchList.add(fullInventoryList.get(i));
            }
        }
        // set cell value factories
        nameSearchNameColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("name"));
        nameSearchValueColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("dollarVal"));
        nameSearchSNColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("serialNum"));

        nameSearchTable.setItems(searchList);
        nameSearchTable.refresh();

    }
}
