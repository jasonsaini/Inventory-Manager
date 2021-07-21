package ucf.assignments;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneManager {
    public Scene mainWindow, editNameWindow, editSerialNumberWindow, editValueWindow, formatErrorDialog;

    public void load(){

        Parent mainRoot = null;
        Parent editNameRoot = null;
        Parent editSNRoot = null;
        Parent editValueRoot = null;
        Parent formatDialogRoot = null;
        try {
            mainRoot = FXMLLoader.load(getClass().getResource("inventoryManager.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainWindow = new Scene(mainRoot);
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
        }
        return null;
    }


}
