package com.coffeeisoxygen.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusPanel extends JPanel {
    private JLabel statusLabel;

    public StatusPanel() {
        statusLabel = new JLabel("Status: Ready");
        add(statusLabel);
    }

    public void setStatus(String status) {
        statusLabel.setText("Status: " + status);
    }
}
