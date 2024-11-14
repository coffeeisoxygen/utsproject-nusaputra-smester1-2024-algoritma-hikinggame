package com.coffeeisoxygen.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.coffeeisoxygen.model.tiles.TileType;
import com.coffeeisoxygen.viewmodel.BoardViewModel;

public class LegendPanel extends JPanel {

    private BoardViewModel viewModel;

    public LegendPanel(BoardViewModel viewModel) {
        this.viewModel = viewModel;
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridLayout(1, TileType.values().length));
        for (TileType tileType : TileType.values()) {
            add(createLegendItem(tileType));
        }
    }

    private JPanel createLegendItem(TileType tileType) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel(tileType.name(), SwingConstants.CENTER);

        Image resizedImage = ImageManager.getResizedImage(tileType, 30, 30); // Resize to 30x30 pixels
        JLabel iconLabel = new JLabel(new ImageIcon(resizedImage));

        panel.add(iconLabel, BorderLayout.CENTER);
        panel.add(label, BorderLayout.SOUTH);

        return panel;
    }
}