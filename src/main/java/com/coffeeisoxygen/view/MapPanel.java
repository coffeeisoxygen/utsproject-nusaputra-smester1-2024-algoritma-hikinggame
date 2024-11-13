package com.coffeeisoxygen.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.coffeeisoxygen.model.tiles.Tile;
import com.coffeeisoxygen.viewmodel.BoardViewModel;

public class MapPanel extends JPanel {
    private BoardViewModel viewModel;
    private JButton[][] buttons;

    public MapPanel(BoardViewModel viewModel) {
        this.viewModel = viewModel;
        initializeButtons();
    }

    private void initializeButtons() {
        int width = viewModel.getBoardWidth();
        int height = viewModel.getBoardHeight();
        this.buttons = new JButton[width][height];

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                JButton button = new JButton(i + "," + j);
                button.setBackground(getTileColor(viewModel.getTile(i, j)));
                buttons[i][j] = button;

                gbc.gridx = i;
                gbc.gridy = j;
                add(button, gbc);
            }
        }
    }

    private Color getTileColor(Tile tile) {
        if (tile == null) {
            return Color.WHITE;
        }
        return switch (tile.getTileType()) {
            case STARTTILE -> Color.GREEN;
            case FINISHTILE -> Color.RED;
            case SAFETILE -> Color.BLUE;
            case DANGERTILE -> Color.ORANGE;
            case ROUTETILE -> Color.GRAY;
        };
    }

    public void refresh() {
        for (int i = 0; i < viewModel.getBoardWidth(); i++) {
            for (int j = 0; j < viewModel.getBoardHeight(); j++) {
                buttons[i][j].setBackground(getTileColor(viewModel.getTile(i, j)));
            }
        }
        revalidate();
        repaint();
    }
}