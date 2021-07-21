/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    public Scene mainWindow, editNameWindow, editSerialNumberWindow, editValueWindow,SNFormatDialogWindow, nameFormatErrorDialogWindow,
    valueFormatErrorDialogWindow;

    public void load(){

        Parent mainRoot = null;
        Parent editNameRoot = null;
        Parent editSNRoot = null;
        Parent editValueRoot = null;
        Parent nameFormatDialogRoot = null;
        Parent SNFormatDialogRoot = null;
        Parent valueFormatDialogRoot = null;
        try {
            mainRoot = FXMLLoader.load(getClass().getResource("inventoryManager.fxml"));
            SNFormatDialogRoot = FXMLLoader.load(getClass().getResource("invalidSNFormat.fxml"));
            nameFormatDialogRoot = FXMLLoader.load(getClass().getResource("invalidNameFormat.fxml"));
            valueFormatDialogRoot = FXMLLoader.load(getClass().getResource("invalidValueFormat.fxml"));
            editNameRoot = FXMLLoader.load(getClass().getResource("editName.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainWindow = new Scene(mainRoot);
        SNFormatDialogWindow = new Scene(SNFormatDialogRoot);
        nameFormatErrorDialogWindow = new Scene(nameFormatDialogRoot);
        valueFormatErrorDialogWindow = new Scene(valueFormatDialogRoot);
        editNameWindow = new Scene(editNameRoot);

    }

    public Scene getScene(String key)
    {
        switch(key)
        {
            case "Main Window":
                return mainWindow;
            case "Edit Serial Number Dialog":
                return editSerialNumberWindow;
            case "Edit Value Dialog":
                return editValueWindow;
            case "Name Format Error Dialog":
                return nameFormatErrorDialogWindow;
            case "SN Format Error Dialog":
                return SNFormatDialogWindow;
            case "Value Format Error Dialog":
                return valueFormatErrorDialogWindow;
            case "Edit Name Dialog":
                return editNameWindow;
        }
        return null;
    }

    public void setupDialogStage(String sceneName, String title, boolean resizable)
    {
        Scene curScene = getScene(sceneName);
        Stage curStage = new Stage();
        curStage.setScene(curScene);
        curStage.setTitle(title);
        curStage.setResizable(resizable);
        curStage.initModality(Modality.APPLICATION_MODAL);
        curStage.showAndWait();
    }

    public void setupDialogStageWithSingleItem(String sceneName, String title, boolean resizable, InventoryItem userData)
    {
        Scene curScene = getScene(sceneName);
        Stage curStage = new Stage();
        curStage.setScene(curScene);
        curStage.setTitle(title);
        curStage.setResizable(resizable);
        curStage.setUserData(userData);
        curStage.initModality(Modality.APPLICATION_MODAL);
        curStage.showAndWait();
    }

    public void setupDialogStageWithList(String sceneName, String title, boolean resizable, ObservableList<InventoryItem> userData)
    {
        Scene curScene = getScene(sceneName);
        Stage curStage = new Stage();
        curStage.setScene(curScene);
        curStage.setTitle(title);
        curStage.setResizable(resizable);
        curStage.setUserData(userData);
        curStage.initModality(Modality.APPLICATION_MODAL);
        curStage.showAndWait();
    }

}
