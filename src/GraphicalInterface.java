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
    private JButton kelvin;
    private JButton celsius;
    private JButton fahrenheit;
    private JLabel result;
    private JTextField countLabel;
    private JLabel text;
    private JPanel panel;
    private JPanel panelIsTemperature;
    double Null=0;

    private JButton isFahrenheit;
    private JButton isKelvin;
    private JButton isCelsius;

    public GraphicalInterface() {
        super("Перевод температуры");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Null=0;
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

        celsius.addActionListener(t -> {
            try {
                number = Double.parseDouble(countLabel.getText());
                resultTemperature = temperatureInterface.celsius(number);
                resultCount(" C");
            } catch (NumberFormatException c) {
                errorConsole();
                number=Null;
            }
        });

        kelvin.addActionListener(t -> {
            try {
                number = Double.parseDouble(countLabel.getText());
                resultTemperature = temperatureInterface.kelvin(number);
                resultCount(" K");
            } catch (NumberFormatException c) {
                errorConsole();
                number=Null;
            }
        });

        fahrenheit.addActionListener(t -> {
            try {
                number = Double.parseDouble(countLabel.getText());
                resultTemperature = temperatureInterface.fahrenheit(number);
                resultCount(" Ф");
            } catch (NumberFormatException y) {
                errorConsole();
                number=Null;
            }
        });
    }

    private void setIsKelvin() {
        temperatureInterface = new TemperatureKelvin();

        celsius.addActionListener(t -> {
            try {
                number = Double.parseDouble(countLabel.getText());
                resultTemperature = temperatureInterface.celsius(number);
                resultCount(" C");
            } catch (NumberFormatException c) {
                errorConsole();
                number=Null;
            }
        });

        kelvin.addActionListener(t -> {
            try {
                number = Double.parseDouble(countLabel.getText());
                resultTemperature = temperatureInterface.kelvin(number);
                resultCount(" K");
            } catch (NumberFormatException c) {
                errorConsole();
                number=Null;
            }
        });

        fahrenheit.addActionListener(t -> {
            try {
                number = Double.parseDouble(countLabel.getText());
                resultTemperature = temperatureInterface.fahrenheit(number);
                resultCount(" Ф");
            } catch (NumberFormatException y) {
                errorConsole();
                number=Null;
            }
        });
    }

    private void setIsFahrenheit() {
        temperatureInterface = new TemperatureFahrenheit();

        celsius.addActionListener(t -> {
            try {
                number = Double.parseDouble(countLabel.getText());
                resultTemperature = temperatureInterface.celsius(number);
                resultCount(" C");
            } catch (NumberFormatException c) {
                errorConsole();
                number=Null;
            }
        });

        kelvin.addActionListener(t -> {
            try {
                number = Double.parseDouble(countLabel.getText());
                resultTemperature = temperatureInterface.kelvin(number);
                resultCount(" K");
            } catch (NumberFormatException c) {
                errorConsole();
                number=Null;
            }
        });

        fahrenheit.addActionListener(t -> {
            try {
                number = Double.parseDouble(countLabel.getText());
                resultTemperature = temperatureInterface.fahrenheit(number);
                resultCount(" Ф");
            } catch (NumberFormatException y) {
                errorConsole();
                number=Null;
            }
        });
    }

    private void resultCount(String measurementSystem) {
        result.setText("Результат: " + resultTemperature + measurementSystem);
    }

    private void errorConsole() {
        System.out.println("ошибка");
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
