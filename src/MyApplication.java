import core.ModelFactory;
import core.ViewHandler;
import external.Thermometer;
import external.heater.Heater;
import javafx.application.Application;
import javafx.stage.Stage;
import model.TemperatureListModel;
import model.TemperatureListModelManager;

public class MyApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Model

        TemperatureListModel temperatureListModel = new TemperatureListModelManager();
        Heater heater = new Heater();
        ModelFactory model = new ModelFactory(temperatureListModel, heater);

        // View

        //View handler to be implemented
        ViewHandler view = new ViewHandler(model);
        view.start();


        Thread t1 = new Thread(new Thermometer("t1", 15, 1, model.getHeater(), model.getTemperatureList()));
        Thread t2 = new Thread(new Thermometer("t2", 15, 7, model.getHeater(), model.getTemperatureList()));
        t1.start();
        t2.start();


    }
}
