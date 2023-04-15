package main.WinViews;

import main.controllers.CurrencyController;
import main.models.enums.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class Window extends JFrame {
    private String selectedType;
    private String fromSelection;
    private String toSelection;
    private float inValue;
    private float outVlaue;
    String fromUnitKey;
    String toUnitKey;
    private JPanel contentPane;
    private JPanel conversionPane;
    private JPanel unitsPanel;
    private JPanel fromPanel;
    private JPanel toPanel;
    private JTextArea fromTextArea;
    private JComboBox fromUnitBox;
    private JPanel resultsPanel;
    private JTextArea toTextArea;
    private JComboBox toUnitBox;
    private JComboBox ConversionType;
    private JPanel buttonsPane;
    private JButton btnConvertir;
    private JButton btnSalir;

    Color azul = new Color(49,37,202);
    Color violeta = new Color(65,12,130);
    Color violetaClaro = new Color(148,110,255);
    Color dorado = new Color(186,169,39);
    Color doradoClaro = new Color(255, 241, 121);

    public Window() {
        /*----------------------WINDOW----------------------*/
        setBackground(violeta);
        setType(Type.UTILITY);
        setTitle("Conversor de Unidades");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBackground(violeta);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        /*----------------------CONTENT PANEL----------------------*/
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(violeta);
        panel.setBounds(10, 10, 570, 350);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel ConvLabel = new JLabel();
        ConvLabel.setText("Por favor selecciones un método de conversión");
        ConvLabel.setBounds(12, 15, 290, 22);
        ConvLabel.setForeground(Color.white);
        panel.add(ConvLabel);

        JComboBox<String> ConversionType = new JComboBox<>();
        ConversionType.setModel(new DefaultComboBoxModel<>(new String[]{"Divisas", "Temperatura", "Longitud", "Area", "Peso"}));
        ConversionType.setSelectedIndex(-1);
        ConversionType.setToolTipText("");
        ConversionType.setBounds(340, 15, 220, 22);
        panel.add(ConversionType);



        /* ----------------------CONVERSION PANEL----------------------*/
        JPanel conversionPane = new JPanel();
        conversionPane.setBounds(0,55,570,240);
        conversionPane.setBackground(violeta);
        conversionPane.setLayout(new GridLayout(1,0,0,0));
        panel.add(conversionPane);

        /*-----------------------UNITS PANEL-----------------------*/
        JPanel unitsPanel = new JPanel();
        unitsPanel.setBounds(0, 0, 570, 240);
        unitsPanel.setBackground(violeta);
        unitsPanel.setLayout(new GridLayout(1, 2, 0,0));
        conversionPane.add(unitsPanel);
        /*-----------------------FROM PANEL-----------------------*/
        JPanel fromPanel = new JPanel();
        fromPanel.setBackground(violeta);
        fromPanel.setLayout(null);
        unitsPanel.add(fromPanel);

        JLabel fromLabel = new JLabel();
        fromLabel.setText("De:");
        fromLabel.setBounds(138,25,40,22);
        fromLabel.setForeground(Color.white);
        fromPanel.add(fromLabel);

        JComboBox<String> fromUnitBox = new JComboBox<String>();
        fromUnitBox.setBounds(12,70,260,24);
        fromPanel.add(fromUnitBox);

        JTextField fromTextArea = new JTextField();
        fromTextArea.setBackground(Color.darkGray);
        fromTextArea.setForeground(Color.white);
        fromTextArea.setBounds(12,110,260,120);
        fromTextArea.setFont(new Font("Arial", Font.BOLD,28));
        fromTextArea.setHorizontalAlignment(SwingConstants.CENTER);
        fromPanel.add(fromTextArea);

        /*-----------------------TO PANEL-----------------------*/
        JPanel toPanel = new JPanel();
        toPanel.setBackground(violeta);
        toPanel.setLayout(null);
        unitsPanel.add(toPanel);

        JLabel toLabel = new JLabel();
        toLabel.setText("A:");
        toLabel.setBounds(138,25,40,22);
        toLabel.setForeground(Color.white);
        toPanel.add(toLabel);

        JComboBox<String> toUnitBox = new JComboBox<String>();
        toUnitBox.setBounds(12,70,260,24);
        toPanel.add(toUnitBox);

        JTextField toTextArea = new JTextField();
        toTextArea.setBackground(Color.darkGray);
        toTextArea.setForeground(Color.white);
        toTextArea.setBounds(12,110,260,120);
        toTextArea.setFont(new Font("Arial", Font.BOLD,28));
        toTextArea.setHorizontalAlignment(SwingConstants.CENTER);
        toPanel.add(toTextArea);


        /* ----------------------BUTTON SECTION----------------------*/
        JPanel buttonsPane = new JPanel();
        buttonsPane.setBackground(new Color(51, 0, 80));
        buttonsPane.setBorder(null);
        buttonsPane.setBounds(0, 308, 570, 42);
        panel.add(buttonsPane);
        buttonsPane.setLayout(new GridLayout(0, 2, 0, 0));

        JButton btnConvertir = new JButton("Convertir");
        btnConvertir.setBackground(azul);
        btnConvertir.setForeground(doradoClaro);
        btnConvertir.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
        btnConvertir.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                btnConvertir.setBackground(dorado);
                btnConvertir.setForeground(new Color(60,10,60));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnConvertir.setBackground(azul);
                btnConvertir.setForeground(doradoClaro);
            }
        });
        buttonsPane.add(btnConvertir);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBackground(azul);
        btnSalir.setForeground(doradoClaro);
        btnSalir.setFont(new Font("Liberation Sans", Font.PLAIN, 14));
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonsPane.add(btnSalir);


        ConversionType.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) ConversionType.getSelectedItem();
                String fromKey = "";

                ArrayList<String> nombreUnidades = new ArrayList<String>();

                switch (Objects.requireNonNull(selectedType)) {
                    case "Divisas" -> {

                        for (Units unidad : Units.values()) {
                            nombreUnidades.add(unidad.getNombre());
                        }
                        fromUnitBox.setModel(new DefaultComboBoxModel<>(nombreUnidades.toArray(new String[0])));
                        toUnitBox.setModel(new DefaultComboBoxModel<>(nombreUnidades.toArray(new String[0])));
                        fromUnitBox.setSelectedIndex(0);
                        toUnitBox.setSelectedIndex(0);
                    }
                    case "Temperatura" -> {
                        for (Temperatures unidad : Temperatures.values()) {
                            nombreUnidades.add(unidad.getNombre());
                        }
                        fromUnitBox.setModel(new DefaultComboBoxModel<>(nombreUnidades.toArray(new String[0])));
                        toUnitBox.setModel(new DefaultComboBoxModel<>(nombreUnidades.toArray(new String[0])));
                        fromUnitBox.setSelectedIndex(0);
                        toUnitBox.setSelectedIndex(0);
                    }
                    case "Longitud" -> {
                        for (Longitudes unidad : Longitudes.values()) {
                            nombreUnidades.add(unidad.getNombre());
                        }
                        fromUnitBox.setModel(new DefaultComboBoxModel<>(nombreUnidades.toArray(new String[0])));
                        toUnitBox.setModel(new DefaultComboBoxModel<>(nombreUnidades.toArray(new String[0])));
                        fromUnitBox.setSelectedIndex(0);
                        toUnitBox.setSelectedIndex(0);
                    }
                    case "Area" -> {
                        for (Areas unidad : Areas.values()) {
                            nombreUnidades.add(unidad.getNombre());
                        }
                        fromUnitBox.setModel(new DefaultComboBoxModel<>(nombreUnidades.toArray(new String[0])));
                        toUnitBox.setModel(new DefaultComboBoxModel<>(nombreUnidades.toArray(new String[0])));
                        fromUnitBox.setSelectedIndex(0);
                        toUnitBox.setSelectedIndex(0);
                    }
                    case "Peso" -> {
                        for (Pesos unidad : Pesos.values()) {
                            nombreUnidades.add(unidad.getNombre());
                        }
                        fromUnitBox.setModel(new DefaultComboBoxModel<>(nombreUnidades.toArray(new String[0])));
                        toUnitBox.setModel(new DefaultComboBoxModel<>(nombreUnidades.toArray(new String[0])));
                        fromUnitBox.setSelectedIndex(0);
                        toUnitBox.setSelectedIndex(0);
                    }
                    default -> {

                    }
                }
            }
        });


        fromUnitBox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String fromSelectedUnit = (String) fromUnitBox.getSelectedItem();
                selectedType = (String) ConversionType.getSelectedItem();

                switch (Objects.requireNonNull(selectedType)) {
                    case "Divisas" -> {
                        for (Units unidad : Units.values()) {
                            if (unidad.getNombre().equals(fromSelectedUnit)) {
                                fromUnitKey = unidad.name();
                            }
                        }
                    }
                    case "Temperatura" -> {
                        for (Temperatures unidad : Temperatures.values()) {
                            if (unidad.getNombre().equals(fromSelectedUnit)) {
                                fromUnitKey = unidad.name();
                            }
                        }
                    }
                    case "Longitud" -> {
                        for (Longitudes unidad : Longitudes.values()) {
                            if (unidad.getNombre().equals(fromSelectedUnit)) {
                                fromUnitKey = unidad.name();
                            }
                        }
                    }
                    case "Area" -> {
                        for (Areas unidad : Areas.values()) {
                            if (unidad.getNombre().equals(fromSelectedUnit)) {
                                fromUnitKey = unidad.name();
                            }
                        }
                    }
                    case "Peso" -> {
                        for (Pesos unidad : Pesos.values()) {
                            if (unidad.getNombre().equals(fromSelectedUnit)) {
                                fromUnitKey = unidad.name();
                            }
                        }
                    }

                }
                }
        });

        toUnitBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String toSeletedUnit = (String) toUnitBox.getSelectedItem();
                selectedType = (String) ConversionType.getSelectedItem();


                switch (Objects.requireNonNull(selectedType)) {
                    case "Divisas" -> {
                        for (Units unidad : Units.values()) {
                            if (unidad.getNombre().equals(toSeletedUnit)) {
                                toUnitKey = unidad.name();
                            }
                        }
                    }
                    case "Temperatura" -> {
                        for (Temperatures unidad : Temperatures.values()) {
                            if (unidad.getNombre().equals(toSeletedUnit)) {
                                toUnitKey = unidad.name();
                            }
                        }
                    }
                    case "Longitud" -> {
                        for (Longitudes unidad : Longitudes.values()) {
                            if (unidad.getNombre().equals(toSeletedUnit)) {
                                toUnitKey = unidad.name();
                            }
                        }
                    }
                    case "Area" -> {
                        for (Areas unidad : Areas.values()) {
                            if (unidad.getNombre().equals(toSeletedUnit)) {
                                toUnitKey = unidad.name();
                            }
                        }
                    }
                    case "Peso" -> {
                        for (Pesos unidad : Pesos.values()) {
                            if (unidad.getNombre().equals(toSeletedUnit)) {
                                toUnitKey = unidad.name();
                            }
                        }
                    }
                }
            }
        });
        btnConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //DecimalFormat df = new DecimalFormat("###,###.##");
                fromSelection = fromUnitKey;
                toSelection = toUnitKey;
                inValue = Float.parseFloat(fromTextArea.getText());

                outVlaue = (float) CurrencyController.convert(selectedType, inValue, fromSelection, toSelection);
                //outVlaue = Float.parseFloat((String) df.format(outVlaue));
                toTextArea.setText(String.valueOf(outVlaue));

            }
        });
    }
}
