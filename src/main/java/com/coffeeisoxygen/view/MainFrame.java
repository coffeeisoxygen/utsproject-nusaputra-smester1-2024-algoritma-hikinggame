package com.coffeeisoxygen.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class MainFrame extends JFrame {
    private JSplitPane topSplitPane;
    private JPanel bottomPanel;

    public MainFrame() {
        setTitle("Game UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        topSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        bottomPanel = new JPanel(new BorderLayout());

        add(topSplitPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public JSplitPane getTopSplitPane() {
        return topSplitPane;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }
}