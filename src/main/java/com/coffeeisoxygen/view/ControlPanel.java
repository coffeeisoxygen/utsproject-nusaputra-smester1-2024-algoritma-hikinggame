package com.coffeeisoxygen.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.coffeeisoxygen.viewmodel.BoardViewModel;

public class ControlPanel extends JPanel {
    private final JButton generateMapButton;
    private final JButton shuffleTileButton;
    private final JButton playerSetButton;
    private final JButton startButton;
    private final JButton resetButton;
    private BoardViewModel viewModel;

    public ControlPanel(BoardViewModel viewModel) {
        this.viewModel = viewModel;
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

        generateMapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addInputPrompt();
            }
        });
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
        return button;
    }

    private void addInputPrompt() {
        String widthStr = JOptionPane.showInputDialog(this, "Enter board width:", "5");
        String heightStr = JOptionPane.showInputDialog(this, "Enter board height:", "8");

        try {
            int width = Integer.parseInt(widthStr);
            int height = Integer.parseInt(heightStr);
            viewModel.initializeBoard(width, height);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid integers for width and height.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
