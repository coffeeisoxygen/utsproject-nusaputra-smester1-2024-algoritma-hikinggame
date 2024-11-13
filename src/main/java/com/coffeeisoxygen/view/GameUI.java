package com.coffeeisoxygen.view;

import javax.swing.JSplitPane;

import com.coffeeisoxygen.model.tiles.Board;
import com.coffeeisoxygen.viewmodel.BoardViewModel;

public class GameUI {
    public static void main(String[] args) {
        // Initialize the board with tiles
        Board board = new Board(5, 8);
        BoardViewModel viewModel = new BoardViewModel(board);

        // Create UI components
        MainFrame mainFrame = new MainFrame();
        MapPanel mapPanel = new MapPanel(viewModel);
        ControlPanel controlPanel = new ControlPanel();
        StatusPanel statusPanel = new StatusPanel();
        LegendPanel legendPanel = new LegendPanel();

        // Arrange components in the main frame
        JSplitPane mainSplitPane = mainFrame.getMainSplitPane();
        mainSplitPane.setLeftComponent(mapPanel);
        mainSplitPane.setRightComponent(mainFrame.getSideSplitPane());

        // Set frame properties
        mainFrame.setSize(800, 600);
        mainFrame.setMinimumSize(new java.awt.Dimension(400, 300)); // Set minimum resize dimensions
        mainFrame.setVisible(true);
    }
}