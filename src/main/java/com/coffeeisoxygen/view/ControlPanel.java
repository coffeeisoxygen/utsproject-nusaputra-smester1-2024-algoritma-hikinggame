package com.coffeeisoxygen.view;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
    private final JButton generateMapButton;
    private final JButton shuffleTileButton;
    private final JButton playerSetButton;
    private final JButton startButton;
    private final JButton resetButton;

    public ControlPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        generateMapButton = createButton("Generate Map");
        shuffleTileButton = createButton("Shuffle Tiles");
        playerSetButton = createButton("Player Settings");
        startButton = createButton("Start");
        resetButton = createButton("Reset");

        add(generateMapButton);
        add(shuffleTileButton);
        add(playerSetButton);
        add(startButton);
        add(resetButton);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
        return button;
    }
}
