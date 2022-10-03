package external.thermometer;

public class Temperature {
    private double value;
    private String id;

    public Temperature(String id, double value)
    {
        this.id = id;
        this.value = value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }
    public double getValue()
    {
        return value;
    }
    public String getId() {
        return id;
    }
}
