package com.coffeeisoxygen.view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LegendPanel extends JPanel {
    private final JLabel startTileLabel;
    private final JLabel finishTileLabel;
    private final JLabel safeTileLabel;
    private final JLabel dangerTileLabel;
    private final JLabel routeTileLabel;

    private Color startTileColor = Color.GREEN;
    private Color finishTileColor = Color.RED;
    private Color safeTileColor = Color.WHITE;
    private Color dangerTileColor = Color.ORANGE;
    private Color routeTileColor = Color.GRAY;

    public LegendPanel() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(new JLabel("Legend:"));

        startTileLabel = new JLabel("Start Tile: ");
        finishTileLabel = new JLabel("Finish Tile: ");
        safeTileLabel = new JLabel("Safe Tile: ");
        dangerTileLabel = new JLabel("Danger Tile: ");
        routeTileLabel = new JLabel("Route Tile: ");

        add(startTileLabel);
        add(finishTileLabel);
        add(safeTileLabel);
        add(dangerTileLabel);
        add(routeTileLabel);

        // Menambahkan tombol untuk color picker
        addColorPickerButton(startTileLabel, "Start Tile", Color.GREEN);
        addColorPickerButton(finishTileLabel, "Finish Tile", Color.RED);
        addColorPickerButton(safeTileLabel, "Safe Tile", Color.WHITE);
        addColorPickerButton(dangerTileLabel, "Danger Tile", Color.ORANGE);
        addColorPickerButton(routeTileLabel, "Route Tile", Color.GRAY);
    }

    private void addColorPickerButton(JLabel label, String tileType, Color defaultColor) {
        JButton colorPickerButton = new JButton("Pick Color");
        colorPickerButton.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(this, "Select Color for " + tileType, defaultColor);
            if (newColor != null) {
                updateTileColor(tileType, newColor);
            }
        });
        add(colorPickerButton);
    }

    private void updateTileColor(String tileType, Color color) {
        switch (tileType) {
            case "Start Tile" -> startTileColor = color;
            case "Finish Tile" -> finishTileColor = color;
            case "Safe Tile" -> safeTileColor = color;
            case "Danger Tile" -> dangerTileColor = color;
            case "Route Tile" -> routeTileColor = color;
        }

        // Mengupdate warna background di label legenda
        updateLegendColors();
    }

    private void updateLegendColors() {
        startTileLabel.setBackground(startTileColor);
        finishTileLabel.setBackground(finishTileColor);
        safeTileLabel.setBackground(safeTileColor);
        dangerTileLabel.setBackground(dangerTileColor);
        routeTileLabel.setBackground(routeTileColor);

        // Menjadikan label opaque agar warna terlihat
        startTileLabel.setOpaque(true);
        finishTileLabel.setOpaque(true);
        safeTileLabel.setOpaque(true);
        dangerTileLabel.setOpaque(true);
        routeTileLabel.setOpaque(true);
    }

    // Method untuk mendapatkan warna terbaru
    public Color getStartTileColor() {
        return startTileColor;
    }

    public Color getFinishTileColor() {
        return finishTileColor;
    }

    public Color getSafeTileColor() {
        return safeTileColor;
    }

    public Color getDangerTileColor() {
        return dangerTileColor;
    }

    public Color getRouteTileColor() {
        return routeTileColor;
    }
}
