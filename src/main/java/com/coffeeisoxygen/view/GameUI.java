package com.coffeeisoxygen.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.coffeeisoxygen.viewmodel.BoardViewModel;

public class GameUI {
    public static void initialize() {
        // Initialize the board with tiles using the factory method
        BoardViewModel viewModel = BoardViewModel.create(5, 8);

        // Create UI components
        MainFrame mainFrame = new MainFrame();
        MapPanel mapPanel = new MapPanel(viewModel);
        ControlPanel controlPanel = new ControlPanel(viewModel);
        StatusPanel statusPanel = new StatusPanel();
        LegendPanel legendPanel = new LegendPanel();

        // Create a panel to hold status and control panels
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(statusPanel, BorderLayout.NORTH);
        rightPanel.add(controlPanel, BorderLayout.SOUTH);

        // Arrange components in the main frame
        JSplitPane topSplitPane = mainFrame.getTopSplitPane();
        topSplitPane.setLeftComponent(mapPanel);
        topSplitPane.setRightComponent(rightPanel);
        topSplitPane.setDividerLocation(600); // Set initial divider location

        JPanel bottomPanel = mainFrame.getBottomPanel();
        bottomPanel.add(legendPanel, BorderLayout.CENTER);

        // Set frame properties
        mainFrame.setSize(800, 600);
        mainFrame.setMinimumSize(new Dimension(400, 300)); // Set minimum resize dimensions
        mainFrame.setVisible(true);

        // Add observer to refresh the map panel when the board changes
        viewModel.setBoardObserver(mapPanel::refresh);
    }

    public static void main(String[] args) {
        initialize();
    }
}