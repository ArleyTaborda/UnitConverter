package main.WinViews;

import javax.swing.*;

public class MainWindow {
    public static void main(String[] args) {
        Window window = new Window();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setSize(600, 400);

        window.setTitle("Conversor de unidades");


    }

}
