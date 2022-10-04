package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import view.heater.HeaterViewController;
import view.heater.HeaterViewModel;
import view.thermometer.ThermometerViewController;
import view.thermometer.ThermometerViewModel;

public class ViewHandler {
    private Stage primaryStage;
    private Scene currentScene;
    private ModelFactory model;

    private HeaterViewController heaterViewController;
    private HeaterViewModel heaterModel;

    private ThermometerViewController thermometerViewController;
    private ThermometerViewModel thermometerModel;

    public ViewHandler(ModelFactory model)
    {
        this.model = model;
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.currentScene = new Scene(new Region());
        openView("heater");
    }
    public void openView(String id)
    {
        Region root = null;
        switch (id)
        {
            case "heater":
                root = loadHeaterView("../view/heater/HeaterView.fxml");
                break;
            case "thermometer" :
                root = loadTemperatureView("../view/thermometer/ThermometerView.fxml");
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

    private Region loadHeaterView(String fxmlFile)
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
    private Region loadTemperatureView(String fxmlFile)
    {
        if (thermometerViewController == null)
        {
            try
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                thermometerViewController = loader.getController();
                thermometerViewController.init(this, thermometerModel, root);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return thermometerViewController.getRoot();
    }
}
