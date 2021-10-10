public class TemperatureCelsius implements TemperatureInterface {
    public double celsius(double temperature) {
        return (Double) temperature;
    }

    public double fahrenheit(double temperature) {
        return (Double) (temperature * 9 / 5 + 32);
    }

    public double kelvin(double temperature) {
        return (Double) (temperature - 273.1);
    }
}
