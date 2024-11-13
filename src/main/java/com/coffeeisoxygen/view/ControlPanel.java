package com.coffeeisoxygen.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.coffeeisoxygen.viewmodel.BoardViewModel;

public class ControlPanel extends JPanel {

    private final JButton generateMapButton;
    private final JButton randomizeMapTiles;
    private final JButton playerSetButton;
    private final JButton resetTilesButton;
    private final JButton startButton;
    private final JButton resetButton;
    private final BoardViewModel viewModel;

    public ControlPanel(BoardViewModel viewModel) {
        this.viewModel = viewModel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        generateMapButton = createButton("Generate Map", this::handleGenerateMap);
        randomizeMapTiles = createButton("Randomize Tiles", this::RandomizeTiles);
        resetTilesButton = createButton("Reset Tiles", this::handleResetTiles);
        playerSetButton = createButton("Player Settings", this::handlePlayerSettings);
        startButton = createButton("Start", this::handleStart);
        resetButton = createButton("Reset", this::handleReset);

        add(generateMapButton);
        add(randomizeMapTiles);
        add(resetTilesButton);
        add(playerSetButton);
        add(startButton);
        add(resetButton);
    }

    private JButton createButton(String text, java.awt.event.ActionListener action) {
        JButton button = new JButton(text);
        button.setAlignmentX(JButton.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
        button.addActionListener(action);
        return button;
    }

    private void handleGenerateMap(ActionEvent e) {
        promptBoardDimensions();
    }

    private void promptBoardDimensions() {
        String widthStr = JOptionPane.showInputDialog(this, "Enter board width:", viewModel.getBoardWidth());
        String heightStr = JOptionPane.showInputDialog(this, "Enter board height:", viewModel.getBoardHeight());

        if (widthStr != null && heightStr != null) {
            try {
                int width = Integer.parseInt(widthStr);
                int height = Integer.parseInt(heightStr);
                if (viewModel.validateBoardDimensions(width, height)) {
                    viewModel.updateBoardDimensions(width, height);
                } else {
                    showErrorDialog("Invalid dimensions. Width must be between 1 and " + viewModel.getMaxWidth() +
                            ", and height must be between 1 and " + viewModel.getMaxHeight() + ".");
                }
            } catch (NumberFormatException ex) {
                showErrorDialog("Invalid input. Please enter valid integers for width and height.");
            }
        }
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void RandomizeTiles(ActionEvent e) {
        viewModel.randomizeTiles();
    }

    private void handleResetTiles(ActionEvent e) {
        viewModel.resetMapTiles();
    }

    private void handlePlayerSettings(ActionEvent e) {
        // Implement player settings action here
    }

    private void handleStart(ActionEvent e) {
        // Implement start action here
    }

    private void handleReset(ActionEvent e) {
        // Implement reset action here
    }
}
