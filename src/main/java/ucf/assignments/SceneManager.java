/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainWindow = new Scene(mainRoot);
        SNFormatDialogWindow = new Scene(SNFormatDialogRoot);
        nameFormatErrorDialogWindow = new Scene(nameFormatDialogRoot);
        valueFormatErrorDialogWindow = new Scene(valueFormatDialogRoot);
    }

    public Scene getScene(String key)
    {
        switch(key)
        {
            case "Main Window":
                return mainWindow;
            case "Edit Name":
                return editNameWindow;
            case "Edit Serial Number":
                return editSerialNumberWindow;
            case "Edit Value":
                return editValueWindow;
            case "Name Format Error Dialog":
                return nameFormatErrorDialogWindow;
            case "SN Format Error Dialog":
                return SNFormatDialogWindow;
            case "Value Format Error Dialog":
                return valueFormatErrorDialogWindow;
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



}
