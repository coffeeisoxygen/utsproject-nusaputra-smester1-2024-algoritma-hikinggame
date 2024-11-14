package com.coffeeisoxygen.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.coffeeisoxygen.model.tiles.TileType;
import com.coffeeisoxygen.utils.ImageUtils;
import com.coffeeisoxygen.viewmodel.BoardViewModel;

public class MapPanel extends JPanel {
    private BoardViewModel viewModel;
    private JButton[][] buttons;

    public MapPanel(BoardViewModel viewModel) {
        this.viewModel = viewModel;
        initializeButtons();
        initializeUI();
    }

    private void initializeButtons() {
        int width = viewModel.getBoardWidth();
        int height = viewModel.getBoardHeight();
        this.buttons = new JButton[width][height];

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                JButton button = createButton(i, j);
                buttons[i][j] = button;
                gbc.gridx = i;
                gbc.gridy = j;
                add(button, gbc);
            }
        }
    }

    private JButton createButton(int i, int j) {
        JButton button = new JButton();
        TileType tileType = viewModel.getTile(i, j).getTileType();
        Image resizedImage = ImageManager.getResizedImage(tileType, 50, 50); // Resize to 50x50 pixels
        button.setIcon(new ImageIcon(resizedImage));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                shuffleTileType(i, j);
            }
        });
        return button;
    }

    private void initializeUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        for (int i = 0; i < viewModel.getBoardWidth(); i++) {
            for (int j = 0; j < viewModel.getBoardHeight(); j++) {
                gbc.gridx = i;
                gbc.gridy = j;
                add(buttons[i][j], gbc);
            }
        }
    }

    private void shuffleTileType(int x, int y) {
        // Handle tile type shuffling logic here
        // For example, you can change the tile type and update the button icon
        TileType newTileType = randomizeTileType();
        viewModel.setTile(x, y, newTileType);
        BufferedImage newImage = ImageManager.getImage(newTileType);
        Image resizedImage = ImageUtils.resizeImage(newImage, 50, 50); // Resize to 50x50 pixels
        buttons[x][y].setIcon(new ImageIcon(resizedImage));
    }

    private TileType randomizeTileType() {
        // Implement logic to randomize and return a new TileType
        TileType[] tileTypes = TileType.values();
        return tileTypes[(int) (Math.random() * tileTypes.length)];
    }

    public void refresh() {
        removeAll();
        initializeButtons();
        revalidate();
        repaint();
    }
}
