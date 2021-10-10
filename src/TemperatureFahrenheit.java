public class TemperatureFahrenheit implements TemperatureInterface{
    @Override
    public double fahrenheit(double temperature) {
        return (Double)temperature;
    }

    @Override
    public double kelvin(double temperature) {
        return (Double) (5*(temperature - 32)/9 + 273.15);
    }

    @Override
    public double celsius(double temperature) {
        return (Double)(9*(temperature + 32)/5);
    }
}
