import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class GraphicalInterface extends JFrame {
    private TemperatureInterface temperatureInterface;
    private Double resultTemperature;
    private Double number;
    private final JButton kelvin;
    private final JButton celsius;
    private final JButton fahrenheit;
    private final JLabel result;
    private final JTextField countLabel;
    private final JLabel text;
    private final JPanel panel;
    private final JPanel panelIsTemperature;
    double Null = 0;

    private final JButton isFahrenheit;
    private final JButton isKelvin;
    private final JButton isCelsius;

    public GraphicalInterface() {
        super("Перевод температуры");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Null = 0;
        text = new JLabel("Перевод в");
        countLabel = new JTextField(15);

        kelvin = new JButton("Кельвин");
        celsius = new JButton("Цельсий");
        fahrenheit = new JButton("Фаренгейт");

        result = new JLabel("Результат: " + 0 + " C");

        isFahrenheit = new JButton("в Фаренгейт");
        isKelvin = new JButton("в Кельвин");
        isCelsius = new JButton("в Цельсий");
        panel = new JPanel(new FlowLayout());
        panelIsTemperature = new JPanel(new FlowLayout());

        setIconImage(new ImageIcon("C:\\Users\\ben70\\IdeaProjects\\Popitka\\src\\termo.png").getImage());

        isCelsius.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIsCelsius();
            }
        });

        isKelvin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIsKelvin();
            }
        });

        isFahrenheit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setIsFahrenheit();
            }
        });

        panelIsTemperature.add(isCelsius);
        panelIsTemperature.add(isKelvin);
        panelIsTemperature.add(isFahrenheit);

        add(panelIsTemperature, BorderLayout.PAGE_START);

        panel.add(countLabel, BorderLayout.CENTER);
        panel.add(text);

        panel.add(celsius);
        panel.add(kelvin);
        panel.add(fahrenheit);

        add(result, BorderLayout.PAGE_END);
        add(panel, BorderLayout.CENTER);
    }

    private JDialog createDialog(String title, boolean modal) {
        JDialog dialog = new JDialog(this, title, modal);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(180, 90);
        return dialog;
    }

    private void setIsCelsius() {
        temperatureInterface = new TemperatureCelsius();

        try {
            number = Double.parseDouble(countLabel.getText());

            celsius.addActionListener(t -> {
                resultTemperature = temperatureInterface.celsius(number);
                resultCount(" C");

            });

            kelvin.addActionListener(t -> {
                resultTemperature = temperatureInterface.kelvin(number);
                resultCount(" K");

            });

            fahrenheit.addActionListener(t -> {
                resultTemperature = temperatureInterface.fahrenheit(number);
                resultCount(" Ф");

            });
        } catch (NumberFormatException y) {
            errorConsole();

        }
    }

    private void setIsKelvin() {
        temperatureInterface = new TemperatureKelvin();
        try {
            number = Double.parseDouble(countLabel.getText());

            celsius.addActionListener(t -> {
                resultTemperature = temperatureInterface.celsius(number);
                resultCount(" C");
            });

            kelvin.addActionListener(t -> {
                resultTemperature = temperatureInterface.kelvin(number);
                resultCount(" K");

            });

            fahrenheit.addActionListener(t -> {
                resultTemperature = temperatureInterface.fahrenheit(number);
                resultCount(" Ф");

            });
        } catch (Exception e) {
            errorConsole();
        }
    }

    private void setIsFahrenheit() {
        temperatureInterface = new TemperatureFahrenheit();

        try {
            number = Double.parseDouble(countLabel.getText());

            celsius.addActionListener(t -> {
                resultTemperature = temperatureInterface.celsius(number);
                resultCount(" C");

            });

            kelvin.addActionListener(t -> {
                resultTemperature = temperatureInterface.kelvin(number);
                resultCount(" K");

            });

            fahrenheit.addActionListener(t -> {
                resultTemperature = temperatureInterface.fahrenheit(number);
                resultCount(" Ф");
            });
        } catch (Exception n) {
            errorConsole();
        }
    }

    private void resultCount(String measurementSystem) {
        result.setText("Результат: " + resultTemperature + measurementSystem);
    }

    private void errorConsole() {
        JDialog dialog = createDialog("Ошибка", true);
        dialog.setLocationRelativeTo(null);

        JLabel l = new JLabel("     Не верное значение");
        JButton b = new JButton("ок");

        dialog.add(l, BorderLayout.NORTH);

        b.addActionListener(e -> {
            dialog.setVisible(false);
        });

        b.setSize(20, 10);
        dialog.add(b, BorderLayout.SOUTH);
        dialog.setVisible(true);

    }

    public static void main(String[] args) {
        GraphicalInterface h = new GraphicalInterface();
        h.setVisible(true);
        h.pack();
    }

}
