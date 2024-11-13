package com.coffeeisoxygen.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LegendPanel extends JPanel {
    public LegendPanel() {
        add(new JLabel("Legend:"));
        add(new JLabel("Start Tile: Green"));
        add(new JLabel("Finish Tile: Red"));
        add(new JLabel("Safe Tile: White"));
        add(new JLabel("Danger Tile: Orange"));
        add(new JLabel("Route Tile: Gray"));
    }
}
