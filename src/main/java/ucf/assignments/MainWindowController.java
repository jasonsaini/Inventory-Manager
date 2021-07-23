/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Scanner;

public class MainWindowController {

    @FXML
    TextField serialNumberTextfield, nameTextfield, valueTextfield;

    @FXML
    ObservableList<InventoryItem> itemDataList = FXCollections.observableArrayList();

    @FXML
    TableView inventoryTable;

    @FXML
    TableColumn <InventoryItem, String> serialNumberColumn, nameColumn, valueColumn;

    @FXML
    ContextMenu rightClickMenu;

    DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    SceneManager sceneManager = new SceneManager();
    public void addItemButtonClicked(ActionEvent actionEvent) {
        addItem();
    }

    public void loadButtonClicked(ActionEvent actionEvent) {
        loadFile();
    }

    public void saveAsTSVButtonClicked(ActionEvent actionEvent) {
        saveTSV();
    }

    public void saveAsHTMLButtonClicked(ActionEvent actionEvent) { saveHTML(); }

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

        sceneManager.loadAll();
        // create inventory item object
        InventoryItem newItem = new InventoryItem("","","");

        // get item name from name textfield
        String curName = nameTextfield.getText();
            // if item name  is not between 2 and 256 characters
                if(curName.length() < 2 || curName.length() > 256)
                {
                    // show invalid format popup!
                    nameTextfield.clear();
                    sceneManager.setupDialogStage("Name Format Error Dialog", "Invalid Format!", false);
                    return;
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
                // show invalid format popup!
                sceneManager.setupDialogStage("Value Format Error Dialog", "Invalid Format!", false);
                return;
            }
             // get serial number from SN textfield
            String serialString = serialNumberTextfield.getText();
            // if serial number is not exactly 10 digits
            if(serialString.length() != 10 || newItem.hasInvalidCharacters(serialString)) {
                // ERROR DIALOG for invalid serial number format!
                sceneManager.setupDialogStage("SN Format Error Dialog", "Invalid Format!", false);
                return;
            }
            else if(itemDataList.size() > 0 && serialNumberAlreadyExists(serialString)) {
                sceneManager.setupDialogStage("Existing SN", "Duplicate Serial Number!", false);
                return;
            }
            else {
                newItem.setSerialNum(serialString);
            }
        // set cell value factories
        nameColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("name"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("dollarVal"));
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("serialNum"));

        // add new item to back list
        itemDataList.add(newItem);

        // update tabelview to new list
        inventoryTable.setItems(itemDataList);

        // clear textfields for next entry
        nameTextfield.clear();
        serialNumberTextfield.clear();
        valueTextfield.clear();
    }

    public boolean serialNumberAlreadyExists(String serialString)
    {
        // iterate over back list
        for(int i = 0; i < itemDataList.size(); i++)
        {
            // if any of the serial numbers match the passed in string
            if(itemDataList.get(i).getSerialNum().equals(serialString))
            {
                return true;
            }
        }
        return false;
    }

    private void removeItem()
    {
        try {
            // get the index of selected item in tableview
            int selectedIndex = inventoryTable.getSelectionModel().getSelectedIndex();
            // remove item at index from observable list
            InventoryItem toRemove = itemDataList.get(selectedIndex);
            itemDataList.remove(toRemove);
            inventoryTable.setItems(itemDataList);
            // update tableview
        }
        catch(Exception e)
        {
            // do nothing on catch
        }
    }

    private void editName()
    {
        // store index of selected item
        int selectedIndex = inventoryTable.getSelectionModel().getSelectedIndex();
        // store item to edit
        InventoryItem toSend =  itemDataList.get(selectedIndex);
        // open popup window
        sceneManager.setupDialogStageWithSingleItem("Edit Name Dialog", "Edit", false,toSend);
        // clear selected index
        inventoryTable.getSelectionModel().clearSelection();
        // update tableview
        inventoryTable.setItems(itemDataList);
        inventoryTable.refresh();
        // close popup
    }

    private void editValue()
    {
        // store index of selected item
        int selectedIndex = inventoryTable.getSelectionModel().getSelectedIndex();
        // store item to edit
        InventoryItem toSend = itemDataList.get(selectedIndex);
        // open popup window
        sceneManager.setupDialogStageWithSingleItem("Edit Value Dialog", "Edit", false, toSend);
        // clear selected index
        inventoryTable.getSelectionModel().clearSelection();
        // update tableview
        inventoryTable.setItems(itemDataList);
        inventoryTable.refresh();
    }

    private void editSerialNumber()
    {
        // store index of selected item
        int selectedIndex = inventoryTable.getSelectionModel().getSelectedIndex();
        // store item to edit
        InventoryItem toSend = itemDataList.get(selectedIndex);
        // open popup window
        sceneManager.setupDialogStageWithSingleItem("Edit SN Dialog", "Edit", false, toSend);
        // clear selected index
        inventoryTable.getSelectionModel().clearSelection();
        // update tableview
        inventoryTable.setItems(itemDataList);
        inventoryTable.refresh();
    }


    private void loadFile()
    {
        nameColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("name"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("dollarVal"));
        serialNumberColumn.setCellValueFactory(new PropertyValueFactory<InventoryItem,String>("serialNum"));

        itemDataList.clear();
        // find file via file chooser
        FileChooser chooser = new FileChooser();
        File toLoad = chooser.showOpenDialog(new Stage());

        chooser.getExtensionFilters().addAll();
        // get file extension
        String filename = toLoad.getName();
        String fileExtension = filename.substring(filename.indexOf(".") + 1, filename.length());
        // if file is TSV
            if(fileExtension.equals("tsv"))
            {
                // load TSV
                loadTSV(toLoad);
            }
            else if(fileExtension.equals("html"))
            {
                // load HTML
            }
            else if(fileExtension.equals("json")) {
                loadJSON(toLoad);
            }

    }

    private void loadTSV(File toLoad)
    {
        itemDataList.clear();
        System.out.println("Loading tsv...");
        try {
            Scanner fileScanner = new Scanner(toLoad);
            while(fileScanner.hasNextLine())
            {

                String toParse = fileScanner.nextLine();
                String[] arrayToParse = toParse.split("\t");
                itemDataList.add(new InventoryItem(arrayToParse[0], arrayToParse[1], arrayToParse[2]));
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        inventoryTable.setItems(itemDataList);
        inventoryTable.refresh();
    }
    
    private void loadHTML()
    {

    }

    private void loadJSON(File toLoad)
    {
        try {
            Object obj = new JSONParser().parse(new FileReader(toLoad));
            JSONObject object = (JSONObject) obj;
            JSONArray itemArray =(JSONArray)object.get("inventory");
            itemDataList.clear();
            Iterator i = itemArray.iterator();
            while(i.hasNext())
            {
                JSONObject curObject = (JSONObject) i.next();
                String curSN = (String) curObject.get("serialNum");
                String curName = (String)curObject.get("name");
                String curVal = (String) curObject.get("value");
                InventoryItem temp = new InventoryItem(curVal, curSN, curName);
                itemDataList.add(temp);
            }
            inventoryTable.setItems(itemDataList);
            inventoryTable.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    private void saveTSV()
    {
        FileChooser chooser = new FileChooser();

        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TSV file (*.tsv)", "*.tsv");
        chooser.getExtensionFilters().add(extensionFilter);
        File toSave = chooser.showSaveDialog(new Stage());
        try {
            FileWriter writer = new FileWriter(toSave);
            for(int i = 0; i < itemDataList.size(); i++)
            {
                InventoryItem curItem = itemDataList.get(i);
                String curLine= curItem.getDollarVal() + "\t" + curItem.getSerialNum() + "\t" + curItem.getName() + "\n";
                writer.append(curLine);
            }
            writer.close();
        } catch (IOException e) {

        }


    }

    private void saveHTML()
    {

    }

    private void saveJSON()
    {
        JSONObject dataObj= new JSONObject();
        JSONArray inventoryArray = new JSONArray();
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON file (*.json)", "*.json");
        fileChooser.getExtensionFilters().add(extFilter);
        File saveJSONFile = fileChooser.showSaveDialog(new Stage());
        for(int i = 0; i < itemDataList.size(); i++)
        {
            JSONObject temp = new JSONObject();
            temp.put("value" , itemDataList.get(i).getDollarVal());
            temp.put("serialNum", itemDataList.get(i).getSerialNum());
            temp.put("name", itemDataList.get(i).getName());
            inventoryArray.add(temp);
        }
        dataObj.put("inventory", inventoryArray);
        try
        {
            FileWriter writer = new FileWriter(saveJSONFile);
            writer.write(dataObj.toString());
            writer.close();
        }
        catch(Exception e)
        {

        }
    }

    private void searchByName()
    {
        // send back list to new window
        // do not open if inventory is not populated
        if(itemDataList.size() > 0)
        {
            sceneManager.setupDialogStageWithList("Name Search", "Search", false, itemDataList);
        }

    }

    private void searchBySerialNum()
    {
        // send back list to new search window
        // do not open if inventory is not populated
        if(itemDataList.size() > 0)
        {
            sceneManager.setupDialogStageWithList("SN Search", "Search", false, itemDataList);
        }

    }

}
