public class TemperatureKelvin implements TemperatureInterface{
    @Override
    public double fahrenheit(double temperature) {
        return (Double)1.8*(temperature-273.15)+32;
    }

    @Override
    public double kelvin(double temperature) {
        return (Double)temperature;
    }

    @Override
    public double celsius(double temperature) {
        return (Double)temperature+273.15;
    }
}
