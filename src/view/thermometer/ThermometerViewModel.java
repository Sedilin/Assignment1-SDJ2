package view.thermometer;

import javafx.beans.property.StringProperty;

public class ThermometerViewModel {

  private StringProperty thermometer1;
  private StringProperty thermometer2;
  private StringProperty alert;
  private StringProperty outsideThermometer;

  public StringProperty getThermometer1() {
    return thermometer1;
  }
  public StringProperty getThermometer2() {
   return thermometer2;
  }
  public StringProperty getOutsideThermometer(){return outsideThermometer;}

  public StringProperty getAlert() {
    return alert;
  }
}
