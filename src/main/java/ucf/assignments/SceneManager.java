package ucf.assignments;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneManager {
    public Scene mainWindow, editNameWindow, editSerialNumberWindow, editValueWindow,SNFormatDialogWindow, formatErrorDialog;

    public void load(){

        Parent mainRoot = null;
        Parent editNameRoot = null;
        Parent editSNRoot = null;
        Parent editValueRoot = null;
        Parent SNFormatDialogRoot = null;
        try {
            mainRoot = FXMLLoader.load(getClass().getResource("inventoryManager.fxml"));
            SNFormatDialogRoot = FXMLLoader.load(getClass().getResource("invalidSNFormat.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainWindow = new Scene(mainRoot);
        SNFormatDialogWindow = new Scene(SNFormatDialogRoot);
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
            case "Format Error":
                return formatErrorDialog;
            case "SN Format Error Dialog":
                return SNFormatDialogWindow;
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
