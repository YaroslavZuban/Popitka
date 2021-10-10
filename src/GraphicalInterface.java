import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

public class GraphicalInterface extends JFrame {
    private TemperatureCelsius c;
    private TemperatureKelvin k;
    private TemperatureFahrenheit f;
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

    private JButton isFahrenheit;
    private JButton isKelvin;
    private JButton isCelsius;

    public GraphicalInterface() {
        super("Перевод температуры");

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = new TemperatureCelsius();
        f = new TemperatureFahrenheit();
        k = new TemperatureKelvin();

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
                celsius.addActionListener(t -> {
                    try {
                        number = Double.parseDouble(countLabel.getText());
                        resultTemperature = c.celsius(number);
                        resultCount(" C");
                    } catch (Exception c) {
                        errorConsole();
                    }
                });

                kelvin.addActionListener(t -> {
                    try {
                        number = Double.parseDouble(countLabel.getText());
                        resultTemperature = c.kelvin(number);
                        resultCount(" K");
                    } catch (Exception c) {
                        errorConsole();
                    }
                });

                fahrenheit.addActionListener(t -> {
                    try {
                        number = Double.parseDouble(countLabel.getText());
                        resultTemperature = c.fahrenheit(number);
                        resultCount(" Ф");
                    } catch (Exception y) {
                        errorConsole();
                    }
                });

            }
        });

        isKelvin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                celsius.addActionListener(t -> {
                    try {
                        number = Double.parseDouble(countLabel.getText());
                        resultTemperature = k.celsius(number);
                        resultCount(" C");
                    } catch (Exception c) {
                        errorConsole();
                    }
                });

                kelvin.addActionListener(t -> {
                    try {
                        number = Double.parseDouble(countLabel.getText());
                        resultTemperature = k.kelvin(number);
                        resultCount(" K");
                    } catch (Exception c) {
                        errorConsole();
                    }
                });

                fahrenheit.addActionListener(t -> {
                    try {
                        number = Double.parseDouble(countLabel.getText());
                        resultTemperature = k.fahrenheit(number);
                        resultCount(" Ф");
                    } catch (Exception y) {
                        errorConsole();
                    }
                });
            }
        });

        isFahrenheit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                celsius.addActionListener(t -> {
                    try {
                        number = Double.parseDouble(countLabel.getText());
                        resultTemperature = c.celsius(number);
                        resultCount(" C");
                    } catch (Exception c) {
                        errorConsole();
                    }
                });

                kelvin.addActionListener(t -> {
                    try {
                        number = Double.parseDouble(countLabel.getText());
                        resultTemperature = c.kelvin(number);
                        resultCount(" K");
                    } catch (Exception c) {
                        errorConsole();
                    }
                });

                fahrenheit.addActionListener(t -> {
                    try {
                        number = Double.parseDouble(countLabel.getText());
                        resultTemperature = f.fahrenheit(number);
                        resultCount(" Ф");
                    } catch (Exception y) {
                        errorConsole();
                    }
                });
            }
        });

        panelIsTemperature.add(isCelsius);
        panelIsTemperature.add(isKelvin);
        panelIsTemperature.add(isFahrenheit);

        add(panelIsTemperature, BorderLayout.PAGE_START);

        panel.add(countLabel, BorderLayout.CENTER);
        panel.add(text);

/*        celsius.addActionListener(e -> {
            try {
                number = Double.parseDouble(countLabel.getText());
                resultTemperature = f.celsius(number);
                resultCount(" C");
            } catch (Exception c) {
                errorConsole();
            }
        });

        kelvin.addActionListener(e -> {
            try {
                number = Double.parseDouble(countLabel.getText());
                resultTemperature = f.kelvin(number);
                resultCount(" K");
            } catch (Exception c) {
                errorConsole();
            }
        });

        fahrenheit.addActionListener(e -> {
            try {
                number = Double.parseDouble(countLabel.getText());
                resultTemperature = c.fahrenheit(number);
                resultCount(" Ф");
            } catch (Exception y) {
                errorConsole();
            }
        });*/

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
            ;
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
