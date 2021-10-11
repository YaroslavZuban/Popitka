public class TemperatureKelvin implements TemperatureInterface{
    private String meaning;
    @Override
    public double fahrenheit(double temperature) {
        meaning=" Ф";
        return (Double)1.8*(temperature-273.15)+32;
    }

    @Override
    public double kelvin(double temperature) {
        meaning=" K";
        return (Double)temperature;
    }

    @Override
    public double celsius(double temperature) {
        meaning=" C";
        return (Double)temperature+273.15;
    }

    @Override
    public String formate() {
        return meaning;
    }
}
