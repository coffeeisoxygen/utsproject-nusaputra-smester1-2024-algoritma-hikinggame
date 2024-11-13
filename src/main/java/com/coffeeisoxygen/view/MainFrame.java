package com.coffeeisoxygen.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class MainFrame extends JFrame {
    private JSplitPane mainSplitPane;
    private JSplitPane sideSplitPane;

    public MainFrame() {
        setTitle("Game UI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        mainSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        sideSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

        add(mainSplitPane, BorderLayout.CENTER);
    }

    public JSplitPane getMainSplitPane() {
        return mainSplitPane;
    }

    public JSplitPane getSideSplitPane() {
        return sideSplitPane;
    }
}