package view.thermometer;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class ThermometerViewController
{
  public Label labelThermometer1Value;
  public Label labelThermometer2Value;
  public Button btnBack;
  public Button updateButton;
  public Label warningLabel;
  private ViewHandler viewHandler;
  public Label tempState;
  private ThermometerViewModel modelManager;
  private Region root;

  public void init(ViewHandler viewHandler, ThermometerViewModel modelManager,
      Region root)
  {
    this.viewHandler = viewHandler;
    this.modelManager = modelManager;
    this.root = root;

    labelThermometer1Value.textProperty().bind(modelManager.getT1());
    labelThermometer2Value.textProperty().bind(modelManager.getT2());
  }

  public Region getRoot()
  {
    return root;
  }

  public void OnPressButton(ActionEvent event)
  {
    if (event.getSource() == btnBack)
    {
      viewHandler.openView("heater");
    }
    else if (event.getSource() == updateButton)
    {
      modelManager.updateT1();
      String temp = modelManager.getT1().getValue();
      if(Double.parseDouble(temp) < 15)
      {
        warningLabel.setText("Temperature is LOW");
      }else if(Double.parseDouble(temp) > 25)
      {
        warningLabel.setText("Temperature is HIGH");
      }
      else{
        warningLabel.setText("Temperature is fine");
      }
      modelManager.updateT2();
    }
  }
}
