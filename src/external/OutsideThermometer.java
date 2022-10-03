package external;

public class OutsideThermometer implements Runnable{

    String id;
    private double t0;
    private double max;
    private double min;

    public OutsideThermometer(String id, double t0, double min, double max)
    {
        this.id = id;
        this.t0 = t0;
        this.max = max;
        this.min = min;
    }

    public double externalTemperature(double t0, double min, double max)
    {
        double left = t0 - min;
        double right = max - t0;
        int sign = Math.random() * (left + right) > left ? 1 : -1;
        t0 += sign * Math.random();
        return t0;
    }
    @Override
    public void run() {
        while (true) {
            t0 = externalTemperature(t0, min, max);
            System.out.println("Temperature: " + t0 + ", ID: " + id);
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
