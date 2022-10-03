import core.ViewHandler;
import external.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;
import model.TemperatureListModel;
import model.TemperatureListModelManager;

public class MyApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Model
        TemperatureListModel model = new TemperatureListModelManager();

        // View

        //View handler to be implemented
//        ViewHandler view = new ViewHandler(model);
//        view.start(primaryStage);


        Thread t1 = new Thread(new Thermometer("t1", 15, 1, model));
        Thread t2 = new Thread(new Thermometer("t2", 15, 7, model));
        t1.start();
        t2.start();


    }
}
