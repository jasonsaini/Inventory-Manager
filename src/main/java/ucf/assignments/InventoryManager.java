/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Jason Saini
 */
package ucf.assignments;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class InventoryManager extends Application{
    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        SceneManager sceneManager = new SceneManager();
        sceneManager.load();
        Scene scene = sceneManager.getScene("Main Window");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jason's Inventory Manager");
        primaryStage.show();

    }




}
