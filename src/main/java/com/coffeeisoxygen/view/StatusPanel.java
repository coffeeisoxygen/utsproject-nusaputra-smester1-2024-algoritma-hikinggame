package com.coffeeisoxygen.view;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StatusPanel extends JPanel {
    private JTextField playerField;
    private JTextField energyField;
    private JTextField scoreField;
    private JTextField movementPlanField;
    private JTextField positionField;

    public StatusPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel playerLabel = new JLabel("Player:");
        playerField = new JTextField("John");
        playerField.setEditable(false);

        JLabel energyLabel = new JLabel("Energy:");
        energyField = new JTextField("100");
        energyField.setEditable(false);

        JLabel scoreLabel = new JLabel("Score:");
        scoreField = new JTextField("0");
        scoreField.setEditable(false);

        JLabel movementPlanLabel = new JLabel("Movement Plan:");
        movementPlanField = new JTextField(formatMovementPlan("llluuurrrrdddssss"));
        movementPlanField.setEditable(false);

        JLabel positionLabel = new JLabel("Position:");
        positionField = new JTextField("[x,y]");
        positionField.setEditable(false);

        add(playerLabel);
        add(playerField);
        add(energyLabel);
        add(energyField);
        add(scoreLabel);
        add(scoreField);
        add(movementPlanLabel);
        add(movementPlanField);
        add(positionLabel);
        add(positionField);
    }

    private String formatMovementPlan(String plan) {
        return plan.replaceAll("(.)", "$1-").replaceAll("-$", "");
    }
}
