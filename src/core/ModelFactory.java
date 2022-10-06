package core;

import external.Model;
import external.ModelManager;

public class ModelFactory {
    Model model;
    public ModelFactory()
    {
        model = new ModelManager();
    }

    public Model getModel() {
        return model;
    }
}
