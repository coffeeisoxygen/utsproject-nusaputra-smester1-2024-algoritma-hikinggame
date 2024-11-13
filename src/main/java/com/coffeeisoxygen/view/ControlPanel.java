package com.coffeeisoxygen.view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
    public ControlPanel() {
        setLayout(new FlowLayout());

        JButton startButton = new JButton("Start");
        JButton resetButton = new JButton("Reset");

        add(startButton);
        add(resetButton);
    }
}
