package com.coffeeisoxygen.view;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.coffeeisoxygen.model.tiles.TileType;
import com.coffeeisoxygen.viewmodel.BoardViewModel;

public class LegendPanel extends JPanel {
    private final JLabel startTileLabel;
    private final JLabel finishTileLabel;
    private final JLabel safeTileLabel;
    private final JLabel dangerTileLabel;
    private final JLabel routeTileLabel;

    private final BoardViewModel viewModel;

    public LegendPanel(BoardViewModel viewModel) {
        this.viewModel = viewModel;
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

        updateLegendImages();
    }

    private void updateLegendImages() {
        startTileLabel.setIcon(new ImageIcon(viewModel.getImage(TileType.STARTTILE)));
        finishTileLabel.setIcon(new ImageIcon(viewModel.getImage(TileType.FINISHTILE)));
        safeTileLabel.setIcon(new ImageIcon(viewModel.getImage(TileType.SAFETILE)));
        dangerTileLabel.setIcon(new ImageIcon(viewModel.getImage(TileType.DANGERTILE)));
        routeTileLabel.setIcon(new ImageIcon(viewModel.getImage(TileType.ROUTETILE)));
    }
}