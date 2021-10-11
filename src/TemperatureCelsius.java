public class TemperatureCelsius implements TemperatureInterface {
    private String meaning;

    public double celsius(double temperature) {
        meaning=" C";
        return (Double) temperature;
    }

    @Override
    public String formate() {
        return meaning;
    }

    public double fahrenheit(double temperature) {
        meaning=" Ф";
        return (Double) (temperature * 9 / 5 + 32);
    }

    public double kelvin(double temperature) {
        meaning=" K";
        return (Double) (temperature - 273.1);
    }
}
