package view.heater;

import core.ViewHandler;
import external.thermometer.Temperature;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class HeaterViewController {

    public Button btnHeatUp;
    public Button btnCoolDown;
    public Label labelValue;
    public Label labelHeater;
    public Button btnNext;
    public Label labelReset;
    private ViewHandler viewHandler;
    private HeaterViewModel model;
    private Region root;

    public void init(ViewHandler viewHandler, HeaterViewModel model, Region root)
    {
        this.viewHandler = viewHandler;
        this.model = model;
        this.root = root;
    }
    public void setBtnHeatUp(){
        this.btnHeatUp = btnHeatUp;
    }
    public void setBtnNext(Button btnNext) {
        this.btnNext = btnNext;
    }
    public void setLabelHeater(Label labelHeater) {
        this.labelHeater = labelHeater;
    }

    public void setBtnCoolDown(Button btnCoolDown) {
        this.btnCoolDown = btnCoolDown;
    }
    public void setLabelReset()
    {
        // empty
    }

    public javafx.scene.layout.Region getRoot()
    {
        return root;
    }

    @FXML
    private void LabelReset()
    {
        StringProperty t = model.getPower();
        if (t != null)
        {
            labelValue.setText(t.toString());
        }
        else
        {
            labelValue.setText("0");
        }
    }

}
