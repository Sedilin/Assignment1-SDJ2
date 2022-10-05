package external;

import external.heater.Heater;
import model.TemperatureListModel;
import model.TemperatureListModelManager;

public class Thermometer implements Runnable{

    private String id;
    private double t;
    private int d;
    TemperatureListModel temperatureModel;
    private Heater heater;
    private int p;

    public Thermometer(String id, double t, int d, Heater heater){
        this.heater = heater;
        this.id = id;
        this.t = t;
        this.d = d;
        p = heater.getPower();
    }
    // internal temperature method
    public double temperature(double t, int p, int d, double t0, int s){
        double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
        tMax = Math.max(Math.max(t, tMax), t0);
        double heaterTerm = 0;
        if (p > 0)
        {
            double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
            heaterTerm = 30 * s * Math.abs(tMax - t) / den;
        }
        double outdoorTerm = (t - t0) * s / 250.0;
        t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
        return t;
    }

    @Override
    public void run() {
        while (true) {
            p = heater.getPower();
            t = temperature(t, p, d, 0, 6);
            System.out.println("Temperature: " + t + ", ID: " + id);
            System.out.println(p);
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
