package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import view.heater.HeaterViewController;
import view.heater.HeaterViewModel;

public class ViewHandler {
    private Stage primaryStage;
    private Scene currentScene;
    private ModelFactory model;

    private HeaterViewController heaterViewController;
    private HeaterViewModel heaterModel;

    public ViewHandler(ModelFactory model)
    {
        this.model = model;
    }

    public void start()
    {
        this.currentScene = new Scene(new Region());
        openView("temperature");
    }
    public void openView(String id)
    {
        Region root = null;
        switch (id)
        {
            case "temperature":
                root = loadTemperatureView("ThermometerView.fxml");
                break;
        }
        currentScene.setRoot(root);

        String title = "";
        if (root.getUserData() != null)
        {
            title += root.getUserData();
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    private Region loadTemperatureView(String fxmlFile)
    {
        if (heaterViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                heaterViewController = loader.getController();
                heaterViewController.init(this, heaterModel, root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            heaterViewController.reset();
        }
        return heaterViewController.getRoot();
    }
}
