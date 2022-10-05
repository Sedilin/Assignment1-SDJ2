package view.thermometer;

import external.Model;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ThermometerViewModel implements PropertyChangeListener {

  private Model model;
  private StringProperty t1;
  private StringProperty t2;

  public StringProperty getT1()
  {
    return t1;
  }
  public StringProperty getT2()
  {
    return t2;
  }

  public void updateT1()
  {
    model.updateT1();
  }
  public void updateT2()
  {
    model.updateT2();
  }
  public ThermometerViewModel(Model model)
  {
    this.model = model;

    t1 = new SimpleStringProperty(String.valueOf(model.returnTemp1()));
    t2 = new SimpleStringProperty(String.valueOf(model.returnTemp2()));

    model.addListener("T1Change", this);
    model.addListener("T2Change", this);
  }


  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    Platform.runLater(() -> t1.setValue(evt.getNewValue().toString()));
    Platform.runLater(() -> t2.setValue(evt.getNewValue().toString()));
  }
}
