package main.WinViews;

import main.models.enums.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Window extends JFrame {
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

    public Window() {
        /*----------------------WINDOW----------------------*/
        setBackground(new Color(51, 0, 102));
        setType(Type.UTILITY);
        setTitle("Conversor de Unidades");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(51, 0, 102));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        /*----------------------CONTENT PANEL----------------------*/
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(51, 0, 53));
        panel.setBounds(10, 10, 570, 350);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel ConvLabel = new JLabel();
        ConvLabel.setText("Por favor selecciones un método de conversión");
        ConvLabel.setBounds(12, 15, 290, 22);
        ConvLabel.setForeground(Color.white);
        panel.add(ConvLabel);

        JComboBox ConversionType = new JComboBox();
        ConversionType.setModel(new DefaultComboBoxModel(new String[]{"Divisas", "Temperatura", "Longitud", "Area", "Peso"}));
        ConversionType.setSelectedIndex(-1);
        ConversionType.setToolTipText("");
        ConversionType.setBounds(340, 15, 220, 22);
        panel.add(ConversionType);



        /* ----------------------CONVERSION PANEL----------------------*/
        JPanel conversionPane = new JPanel();
        conversionPane.setBounds(0,55,570,240);
        conversionPane.setBackground(new Color(60,0,70));
        conversionPane.setLayout(new GridLayout(1,0,0,0));
        panel.add(conversionPane);

        /*-----------------------UNITS PANEL-----------------------*/
        JPanel unitsPanel = new JPanel();
        unitsPanel.setBounds(0, 0, 570, 240);
        unitsPanel.setBackground(new Color(100,40, 100));
        unitsPanel.setLayout(new GridLayout(1, 2, 0,0));
        conversionPane.add(unitsPanel);
        /*-----------------------FROM PANEL-----------------------*/
        JPanel fromPanel = new JPanel();
        fromPanel.setBackground(new Color(40,40,80));
        fromPanel.setLayout(null);
        unitsPanel.add(fromPanel);

        JLabel fromLabel = new JLabel();
        fromLabel.setText("De:");
        fromLabel.setBounds(138,25,40,22);
        fromLabel.setForeground(Color.white);
        fromPanel.add(fromLabel);

        JComboBox fromUnitBox = new JComboBox();
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
        toPanel.setBackground(new Color(80,40,40));
        toPanel.setLayout(null);
        unitsPanel.add(toPanel);

        JLabel toLabel = new JLabel();
        toLabel.setText("A:");
        toLabel.setBounds(138,25,40,22);
        toLabel.setForeground(Color.white);
        toPanel.add(toLabel);

        JComboBox toUnitBox = new JComboBox();
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
        btnConvertir.setBackground(new Color(0, 0, 0));
        btnConvertir.setForeground(new Color(51, 0, 102));
        btnConvertir.setFont(new Font("Liberation Sans", Font.PLAIN, 14));

        buttonsPane.add(btnConvertir);

        JButton btnSalir = new JButton("Salir");
        btnSalir.setBackground(new Color(0, 0, 0));
        btnSalir.setForeground(new Color(51, 0, 102));
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

                switch (selectedType){
                    case "Divisas":
                        ArrayList<String> nombreUnidades = new ArrayList<String>();
                        for (Units unidad : Units.values()){
                            nombreUnidades.add(unidad.getNombre());
                        }
                        fromUnitBox.setModel(new DefaultComboBoxModel(nombreUnidades.toArray(new String[0])));
                        toUnitBox.setModel(new DefaultComboBoxModel(nombreUnidades.toArray(new String[0])));
                        break;
                    case "Temperatura":
                        ArrayList<String> nombreTemp = new ArrayList<String>();
                        for (Temperatures unidad : Temperatures.values()){
                            nombreTemp.add(unidad.getNombre());
                        }
                        fromUnitBox.setModel(new DefaultComboBoxModel(nombreTemp.toArray(new String[0])));
                        toUnitBox.setModel(new DefaultComboBoxModel(nombreTemp.toArray(new String[0])));
                        break;
                    case "Longitud":
                        ArrayList<String> nombreLongitud = new ArrayList<String>();
                        for (Longitudes unidad : Longitudes.values()){
                            nombreLongitud.add(unidad.getNombre());
                        }
                        fromUnitBox.setModel(new DefaultComboBoxModel(nombreLongitud.toArray(new String[0])));
                        toUnitBox.setModel(new DefaultComboBoxModel(nombreLongitud.toArray(new String[0])));
                        break;
                    case "Area":
                        ArrayList<String> nombreArea = new ArrayList<String>();
                        for (Areas unidad : Areas.values()){
                            nombreArea.add(unidad.getNombre());
                        }
                        fromUnitBox.setModel(new DefaultComboBoxModel(nombreArea.toArray(new String[0])));
                        toUnitBox.setModel(new DefaultComboBoxModel(nombreArea.toArray(new String[0])));
                        break;
                    case "Peso":
                        ArrayList<String> nombrePeso = new ArrayList<String>();
                        for (Pesos unidad : Pesos.values()){
                            nombrePeso.add(unidad.getNombre());
                        }
                        fromUnitBox.setModel(new DefaultComboBoxModel(nombrePeso.toArray(new String[0])));
                        toUnitBox.setModel(new DefaultComboBoxModel(nombrePeso.toArray(new String[0])));
                        break;

                }

            }
        });

        fromUnitBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
