import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class MyApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Model
        ModelFactory model = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);

        // View

        //View handler to be implemented
        ViewHandler view = new ViewHandler(model, viewModelFactory);
        view.start(stage);


//        Thread t1 = new Thread(new Thermometer("t1", 15, 1, model.getModel().getHeater()));
//        Thread t2 = new Thread(new Thermometer("t2", 15, 7, model.getModel().getHeater()));
//        t1.start();
//        t2.start();


    }
}
