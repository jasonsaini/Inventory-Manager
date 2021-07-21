/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.text.DecimalFormat;

public class MainWindowController {

    @FXML
    TextField serialNumberTextfield, nameTextfield, valueTextfield;

    @FXML
    ObservableList<InventoryItem> itemDataList = FXCollections.observableArrayList();

    @FXML
    TableView inventoryTable;

    @FXML
    TableColumn <InventoryItem, String> serialNumberColumn, nameColumn, valueColumn;

    DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    public void addItemButtonClicked(ActionEvent actionEvent) {
        addItem();
    }

    public void loadButtonClicked(ActionEvent actionEvent) {
        loadFile();
    }

    public void saveAsTSVButtonClicked(ActionEvent actionEvent) {
        saveTSV();
    }

    public void saveAsHTMLButtonClicked(ActionEvent actionEvent) {
        saveHTML();
    }

    public void saveAsJSONButtonClicked(ActionEvent actionEvent) {
        saveJSON();
    }

    public void searchByNameClicked(ActionEvent actionEvent) {
        searchByName();
    }

    public void searchBySerialNumClicked(ActionEvent actionEvent) {
        searchBySerialNum();
    }

    public void removeItemButtonClicked(ActionEvent actionEvent) {
        removeItem();
    }

    public void editNameButtonClicked(ActionEvent actionEvent) {
        editName();
    }

    public void editValueButtonClicked(ActionEvent actionEvent) {
        editValue();
    }

    public void editSerialNumberButtonClicked(ActionEvent actionEvent) {
        editSerialNumber();
    }


    private void addItem()
    {
        // initialize scenemanager
        SceneManager sceneManager = new SceneManager();
        sceneManager.load();
        // create inventory item object
        InventoryItem newItem = new InventoryItem();

        // get item name from name textfield
        String curName = nameTextfield.getText();
            // if item name  is not between 2 and 256 characters
                if(curName.length() < 2 || curName.length() > 256)
                {
                    // show invalid format popup!
                    nameTextfield.clear();
                }
                else
                {
                    newItem.setName(curName);
                }

        // get value from value textfield
            String curValString = valueTextfield.getText();
            double curVal = 0;
            try {
                // try formatting string to double
                curVal = Double.parseDouble(curValString);
                newItem.setDollarVal("$" + decimalFormat.format(curVal));
            }
            catch(Exception e) {
                e.printStackTrace();
                // show invalid format popup!
            }
             // get serial number from SN textfield
            String serialString = serialNumberTextfield.getText();
            // if serial number is not exactly 10 digits
            if(serialString.length() == 10) {
                if(!newItem.hasInvalidCharacters(serialString)){
                    if(itemDataList.size() >= 2) {
                        if(serialNumberAlreadyExists(serialString))
                        {
                            // pre-existing serial number popup!
                            System.out.println("Exists already");

                        }
                    }
            }
            else {
                // invalid format popup!
                    System.out.println("Invalid format");
            }
        newItem.setSerialNum(serialString);
        System.out.println(newItem.getDollarVal() + newItem.getSerialNum() + newItem.getName());
        nameColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("name"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("dollarVal"));
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("serialNum"));
                itemDataList.add(newItem);
                inventoryTable.setItems(itemDataList);

    }


        // create a new item
        // add it to observable list
        // update table view
    }
    private boolean serialNumberAlreadyExists(String serialString)
    {
        for(int i = 0; i < itemDataList.size(); i++)
        {
            if(itemDataList.get(i).getSerialNum().equals(serialString))
            {
                return true;
            }
        }
        return false;
    }

    private void removeItem()
    {
        // get the index of selected item in tableview
        // remove item at index from observable list
        // update tableview

    }

    private void editName()
    {
        // store index of selected item
        // open popup window
        // collect new name from text field
        // set new name in observable list
        // update tableview
        // close popup
    }

    private void editValue()
    {
        // store index of selected item
        // open popup window
        // collect new value from text field
        // set new value in observable list
        // update tableview
        // close popup
    }

    private void editSerialNumber()
    {
        // store index of selected item
        // open popup window
        // collect new Serial number from text field
        // set new serial number in observable list
        // update tableview
        // close popup
    }


    private void loadFile()
    {
        // find file via file chooser

        // if file is TSV
            // call load TSV function
        // if file is HTML
            // call load HTML function
        // if file is JSON
            // call load JSON function
    }

    private void loadTSV()
    {
        
    }
    
    private void loadHTML()
    {

    }

    private void loadJSON()
    {

    }

    private void saveTSV()
    {

    }

    private void saveHTML()
    {

    }

    private void saveJSON()
    {

    }

    private void searchByName()
    {
        // create a temp list of inventory items
        // iterate through entire list
            // if search key is a substring of an item's name
                // add item to temp list
        // update search tableview
    }

    private void searchBySerialNum()
    {
        // create a temp list of inventory items
        // iterate through entire list
            // if search key matches item's serial number
                // add item to temp list
        // update search tableview with temp list
    }



}
