public class TemperatureFahrenheit implements TemperatureInterface{
    private String meaning;
    @Override
    public double fahrenheit(double temperature) {
        meaning=" Ф";
        return (Double)temperature;
    }

    @Override
    public double kelvin(double temperature) {
        meaning=" K";
        return (Double) (5*(temperature - 32)/9 + 273.15);
    }

    @Override
    public double celsius(double temperature) {
        meaning=" C";
        return (Double)(9*(temperature + 32)/5);
    }

    @Override
    public String formate() {
        return meaning;
    }
}
